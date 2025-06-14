package Modelo.Dao;

import Modelo.Dto.DtoVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import comun.Conexion;
import comun.Common;
import comun.Helper_numeroTexto;

/**
 *
 * @author Li
 */
public class DaoVentas {

    private final Conexion conex = new Conexion();
    private final Connection cn = conex.conectar();
    private String sentencia = "";
    private String sentencia2 = "";

    public DefaultTableModel mostrar() {

        DefaultTableModel modelo;

        String[] titulos = {"N° pedido", "Fecha", "Vendedor", "Cliente", "Importe", "Comprobante", "idcliente", "idempleado", "cod_cliente", "idpreventa"};
        String[] registro = new String[10];
        String comprobante = "";
        String idcliente;
        modelo = new DefaultTableModel(null, titulos);

        sentencia = "select p.idpedido, p.idempleado, p.idcliente,p.idpreventa, (select cod_cliente from cliente where"
                + " idcliente=p.idcliente) as codigo,(select nombre from persona where idpersona=p.idcliente) as cliente,"
                + " date_format(p.fecha,\"%d-%m-%Y %h:%i%p\") as fecha_venta, p.total_venta, p.comprobante, t.nombre"
                + " as vendedor from pedidos p inner join persona t on p.idempleado=t.idpersona"
                + " where p.estado=0 order by p.fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                if (rs.getString("comprobante").equals("1")) {
                    comprobante = "Boleta";
                } else {
                    comprobante = "Factura";
                }
                if (rs.getString("idcliente") == null) {
                    idcliente = "-1";
                } else {
                    idcliente = rs.getString("idcliente");
                }

                registro[0] = rs.getString("idpedido");
                registro[1] = rs.getString("fecha_venta");
                registro[2] = rs.getString("vendedor");
                registro[3] = rs.getString("cliente");
                registro[4] = rs.getString("total_venta");
                registro[5] = comprobante;
                registro[6] = idcliente;
                registro[7] = rs.getString("idempleado");
                registro[8] = rs.getString("codigo");
                registro[9] = rs.getString("idpreventa");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean insertar(DtoVenta datos) {

        sentencia = "insert into ventas (idempleado,idcliente,idpreventa,total_venta,comprobante,"
                + "idcajero,tipo_pago,num_comprobante,num_pedido,oculto) values(?,?,?,?,?,?,?,?,?,?)";
        sentencia2 = "insert into ventas_detalle (idventa,idproducto,cantidad,monto) values((select idventa"
                + " from ventas order by idventa desc limit 1),?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            PreparedStatement pst2 = cn.prepareStatement(sentencia2);
            pst.setInt(1, datos.getIdvendedor());
            if (datos.getIdcliente() == -1) {
                pst.setNull(2, java.sql.Types.INTEGER);
            } else {
                pst.setInt(2, datos.getIdcliente());
            }
            pst.setInt(3, datos.getIdpreventa());
            pst.setDouble(4, datos.getTotal_venta());
            pst.setInt(5, datos.getComprobante());
            pst.setInt(6, datos.getCajero());
            pst.setInt(7, datos.getTipo_pago());
            pst.setInt(8, datos.getNum_comprobante());
            pst.setInt(9, datos.getNum_pedido());
            pst.setInt(10, datos.getOculto());

            int n = pst.executeUpdate();
            int n2 = 0;
            if (n != 0) {
                int recorrido = datos.getItems().size();
                for (int i = 0; i < recorrido; i += 3) {
                    int idproducto = (int) datos.getItems().get(i);
                    int cantidad = (int) datos.getItems().get(i + 1);
                    Double precio = (Double) datos.getItems().get(i + 2);
                    pst2.setInt(1, idproducto);
                    pst2.setInt(2, cantidad);
                    pst2.setDouble(3, precio);
                    n2 = pst2.executeUpdate();
                    descontar(idproducto, cantidad, datos.getCajero());
                }

                return n2 != 0;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean descontar(int idproducto, int cantidad, int empleado) {
        sentencia = "insert into inventario (idproducto, cantidad, idempleado, operacion)"
                + " values(?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setInt(1, idproducto);
            pst.setInt(2, -1 * cantidad);
            pst.setInt(3, empleado);
            pst.setString(4, "Venta N°" + getIdventa());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public ArrayList<String> datos_imprimir() {

        Helper_numeroTexto num = new Helper_numeroTexto();
        ArrayList registro = new ArrayList();
        Integer num_reg;
        ArrayList items = new ArrayList();
        String comprobante;

        sentencia = "select date_format(v.fecha,\"%d-%m-%Y\") as fecha,(select nombre from persona"
                + " where idpersona=v.idcliente) as cliente,(select num_ruc from cliente where idcliente=v.idcliente) as ruc,"
                + " (select direccion from persona where idpersona=v.idcliente) as direccion,"
                + " v.total_venta, v.comprobante,(SELECT COUNT(idventa) FROM `ventas_detalle` where idventa=v.idventa)"
                + " as registros from ventas v order by idventa desc limit 1";
        sentencia2 = "select p.cod_producto, p.nombre,p.presentacion, vd.cantidad, vd.monto,"
                + " vd.monto * vd.cantidad as importe from ventas_detalle vd inner join productos p on"
                + " p.idproducto=vd.idproducto where vd.idventa=(SELECT idventa from ventas order by idventa desc limit 1) order by vd.idproducto";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sentencia2);

            while (rs.next()) {

                if (rs.getString("comprobante").equals("1")) {
                    comprobante = "Boleta";
                } else {
                    comprobante = "Factura";
                }
                Double total = Double.parseDouble(rs.getString("total_venta"));
                Double subtotal = total / 1.18;
                Double igv = total - subtotal;

                registro.add(rs.getString("fecha"));
                registro.add(rs.getString("cliente"));
                registro.add(rs.getString("ruc"));
                registro.add(rs.getString("direccion"));
                registro.add(Common.aDecimal(subtotal));
                registro.add(Common.aDecimal(igv));
                registro.add(Common.aDecimal(total));
                registro.add(comprobante);
                registro.add(num.convertirLetras(Common.aDecimal(total), true, "SOLES"));
                num_reg = Integer.parseInt(rs.getString("registros"));
                String[][] detalle = new String[num_reg][5];
                int i = 0;
                while (rs2.next()) {
                    detalle[i][0] = rs2.getString("cantidad");
                    detalle[i][1] = "UND";
                    detalle[i][2] = rs2.getString("cod_producto")
                            + " " + rs2.getString("nombre") + " " + rs2.getString("presentacion");
                    detalle[i][3] = rs2.getString("monto");
                    detalle[i][4] = rs2.getString("importe");
                    i++;
                }
                registro.add(detalle);

            }

            return registro;

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public int getIdventa() {
        sentencia = "select idventa from ventas order by idventa desc limit 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            rs.next();
            return Integer.parseInt(rs.getString("idventa"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return -1;
        }

    }

}
