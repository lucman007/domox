package Modelo.Dao;

import Modelo.Dto.DtoPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import comun.Conexion;

/**
 *
 * @author Li
 */
public class DaoPedido {

    //Estado de pedidos:
    //0:En cola
    //1:Procesado
    //2:Anulado
    //3:Muestra
    //4:Eliminado
    //5:Editando
    private final Conexion conex = new Conexion();
    private final Connection cn = conex.conectar();
    private String sentencia = "";
    private String sentencia2 = "";
    private String sentencia3 = "";

    public DefaultTableModel mostrar_detalle(int idpedido) {

        DefaultTableModel modelo;

        String[] titulos = {"Idproducto", "Código", "Nombre", "Precio", "Cantidad", "Total"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select p.idproducto, p.cod_producto, p.nombre as producto, dp.cantidad, dp.monto,"
                + " dp.monto*dp.cantidad as monto_total from pedidos_detalle dp"
                + " inner join pedidos ped on dp.idpedido=ped.idpedido"
                + " inner join productos p on p.idproducto=dp.idproducto"
                + " where dp.idpedido=" + idpedido + " order by dp.idproducto";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("idproducto");
                registro[1] = rs.getString("cod_producto");
                registro[2] = rs.getString("producto");
                registro[3] = rs.getString("monto");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("monto_total");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean insertar(DtoPedido datos) {

        sentencia = "insert into pedidos (idempleado,idcliente,idpreventa,total_venta,comprobante,estado) values(?,?,?,?,?,?)";
        sentencia2 = "insert into pedidos_detalle (idpedido,idproducto,cantidad,monto) values((select idpedido"
                + " from pedidos order by idpedido desc limit 1),?,?,?)";
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
            pst.setInt(6, datos.getEstado());
            int n = pst.executeUpdate();
            int n2 = 0;
            if (n != 0) {
                int recorrido = datos.getItems().size();
                for (int i = 0; i < recorrido; i += 3) {
                    pst2.setInt(1, (int) datos.getItems().get(i));
                    pst2.setInt(2, (int) datos.getItems().get(i + 1));
                    pst2.setDouble(3, (Double) datos.getItems().get(i + 2));
                    n2 = pst2.executeUpdate();
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

    public boolean editar(DtoPedido datos) {
        sentencia = "update pedidos set idempleado=?,idcliente=?,idpreventa=?,total_venta=?,comprobante=?,estado=? where idpedido=?";
        sentencia2 = "delete from pedidos_detalle where idpedido=?";
        sentencia3 = "insert into pedidos_detalle (idpedido,idproducto,cantidad,monto) values(?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            PreparedStatement pst2 = cn.prepareStatement(sentencia2);
            PreparedStatement pst3 = cn.prepareStatement(sentencia3);

            pst.setInt(1, datos.getIdvendedor());
            if (datos.getIdcliente() == -1) {
                pst.setNull(2, java.sql.Types.INTEGER);
            } else {
                pst.setInt(2, datos.getIdcliente());
            }
            pst.setInt(3, datos.getIdpreventa());
            pst.setDouble(4, datos.getTotal_venta());
            pst.setInt(5, datos.getComprobante());
            pst.setInt(6, datos.getEstado());
            pst.setInt(7, datos.getIdpedido());

            pst.executeUpdate();

            pst2.setInt(1, datos.getIdpedido());
            int n2 = pst2.executeUpdate();
            if (n2 != 0) {
                int n3 = 0;
                int recorrido = datos.getItems().size();
                for (int i = 0; i < recorrido; i += 3) {
                    pst3.setInt(1, datos.getIdpedido());
                    pst3.setInt(2, (int) datos.getItems().get(i));
                    pst3.setInt(3, (int) datos.getItems().get(i + 1));
                    pst3.setDouble(4, (Double) datos.getItems().get(i + 2));
                    n3 = pst3.executeUpdate();
                }
                return n3 != 0;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public String[] info_pedido() {

        String[] registro = new String[3];
        sentencia = "select idpedido,total_venta, estado, comprobante from pedidos order by idpedido desc limit 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            rs.next();
            registro[0] = rs.getString("idpedido");
            registro[1] = rs.getString("total_venta");
            registro[2] = rs.getString("comprobante");

            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public int getIdpedido() {
        sentencia = "select idpedido from pedidos order by idpedido desc limit 1";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            rs.next();
            return Integer.parseInt(rs.getString("idpedido"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return -1;
        }

    }

    public void eliminar_historial() {
        sentencia = "delete from pedidos where DATE(`fecha`) != DATE(CURDATE()) AND estado!=3";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public DefaultTableModel mostrar_historial() {

        DefaultTableModel modelo;

        String[] titulos = {"N° pedido", "Fecha", "Vendedor", "Cliente", "Importe", "Comprobante", "idcliente",
            "idempleado", "Estado", "Código", "idventa"};
        String[] registro = new String[11];
        String comprobante;
        modelo = new DefaultTableModel(null, titulos);

        sentencia = "select p.idpedido, p.idempleado, p.idcliente, date_format(p.fecha,\"%d-%m-%Y %h:%i%p\") as fecha_venta,"
                + " p.total_venta, p.comprobante,p.estado, p.temp_idventa,(select nombre from persona where idpersona=p.idcliente)"
                + " as cliente,(select cod_cliente from cliente where idcliente=p.idcliente) as codigo, t.nombre as vendedor from pedidos p"
                + " inner join persona t on p.idempleado=t.idpersona"
                + " where estado!=5 and estado!=3 order by p.fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            String idcliente;
            String estado;

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
                switch (rs.getString("estado")) {
                    case "0":
                        estado = "En cola";
                        break;
                    case "1":
                        estado = "Procesado";
                        break;
                    case "2":
                        estado = "Anulado";
                        break;
                    case "3":
                        estado = "Muestra";
                        break;
                    case "4":
                        estado = "Eliminado";
                        break;
                    default:
                        estado = "Editando...";
                        break;
                }

                registro[0] = rs.getString("idpedido");
                registro[1] = rs.getString("fecha_venta");
                registro[2] = rs.getString("vendedor");
                registro[3] = rs.getString("cliente");
                registro[4] = rs.getString("total_venta");
                registro[5] = comprobante;
                registro[6] = idcliente;
                registro[7] = rs.getString("idempleado");
                registro[8] = estado;
                registro[9] = rs.getString("codigo");
                registro[10] = rs.getString("temp_idventa");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public String[] abrir_pedido(int idpedido) {
        String registro[] = new String[4];
        sentencia = "select p.idcliente,p.comprobante,"
                + "(select cod_cliente from cliente c where p.idcliente=c.idcliente) as codigo,"
                + "(select nombre from persona pe where pe.idpersona=p.idcliente) as cliente "
                + "from pedidos p where p.idpedido=" + idpedido;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {
                registro[0] = rs.getString("idcliente");
                registro[1] = rs.getString("comprobante");
                registro[2] = rs.getString("codigo");
                registro[3] = rs.getString("cliente");
            }

            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel abrir_pedido_detalle(int idpedido) {

        DefaultTableModel modelo;
        String[] titulos = {"idproducto", "Código", "Nombre", "Precio", "Cantidad", "Total", "Stock", "Stock_min", "Descuentos"};
        String[] registro = new String[9];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select p.idproducto, p.cod_producto, p.nombre as producto, (select SUM(cantidad) from inventario"
                + " where idproducto=p.idproducto) as stock,p.stock_bajo,(select monto_desc from descuentos where idproducto=p.idproducto"
                + " order by cantidad_min desc limit 1) as monto_desc, dp.cantidad, dp.monto,"
                + " dp.monto*dp.cantidad as monto_total from pedidos_detalle dp"
                + " inner join pedidos ped on dp.idpedido=ped.idpedido"
                + " inner join productos p on p.idproducto=dp.idproducto"
                + " where dp.idpedido=" + idpedido + " order by dp.idproducto";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("idproducto");
                registro[1] = rs.getString("cod_producto");
                registro[2] = rs.getString("producto");
                registro[3] = rs.getString("monto");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("monto_total");
                registro[6] = rs.getString("stock");
                registro[7] = rs.getString("stock_bajo");
                registro[8] = rs.getString("monto_desc");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean actualizarEstado(int idpedido, int idventa, int estado) {
        //Actualizar estado a "Eliminado (4)" al borrar una venta del resumen diario
        sentencia = "update pedidos set estado=? where temp_idventa=?";

        //Actualizar estado a "Procesado (1)" al completar una venta pendiente
        if (estado != 4) {
            sentencia = "update pedidos set estado=?,temp_idventa=? where idpedido=?";
        }

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setInt(1, estado);
            pst.setString(2, String.valueOf(idventa));
            if (estado != 4) {
                pst.setString(3, String.valueOf(idpedido));
            }

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public DefaultTableModel obtener_muestras() {

        DefaultTableModel modelo;

        String[] titulos = {"N° pedido", "Fecha", "Despacho", "Preventa", "Importe", "Comprobante", "idcliente", "idempleado", "cod_cliente"};
        String[] registro = new String[9];
        String comprobante = "";
        String idcliente;
        modelo = new DefaultTableModel(null, titulos);

        sentencia = "select p.idpedido, p.idempleado, p.idcliente, (select cod_cliente from cliente where"
                + " idcliente=p.idcliente) as codigo,(select nombre from persona where idpersona=p.idcliente) as cliente,"
                + " date_format(p.fecha,\"%d-%m-%Y %h:%i%p\") as fecha_venta, p.total_venta, p.comprobante, t.nombre"
                + " as vendedor from pedidos p inner join persona t on p.idempleado=t.idpersona"
                + " where p.estado=3 order by p.fecha desc";

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

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

}
