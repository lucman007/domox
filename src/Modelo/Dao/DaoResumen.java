package Modelo.Dao;

import Modelo.Dto.DtoResumen;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import comun.Common;
import comun.Conexion;

/**
 *
 * @author Li
 */
public class DaoResumen {

    private final Conexion conex = new Conexion();
    private Connection cn = conex.conectar();
    private String sentencia = "";

    public DefaultTableModel mostrar(String buscar, String condicion, Date fecha_in, Date fecha_out) {

        DefaultTableModel modelo;
        String comprobante = "";
        String tipo_pago = "";
        String[] titulos = {"Venta N°", "Fecha/Hora", "Cliente", "Importe", "Tipo de pago", "Comprobante", "Idcliente", "Idpreventa", "N° Comp."};
        String[] registro = new String[9];

        String where_condicion = "";
        if (condicion.equals("resumen")) {
            where_condicion = "tipo_pago!=2";
        } else {
            where_condicion = "tipo_pago=2";
        }

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select v.idventa, v.idcliente, v.idpreventa, date_format(v.fecha,\"%d-%m-%Y %h:%i %p\") as fecha,"
                + " v.total_venta, v.comprobante,v.num_comprobante, v.tipo_pago, (select nombre from persona where idpersona=v.idcliente)as cliente from ventas v"
                + " where fecha between '" + fecha_in + " 00:00:00' and '" + fecha_out + " 23:59:59'"
                + " and (v.idventa like '%" + buscar + "%') and " + where_condicion + " order by v.idventa";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                switch (rs.getString("tipo_pago")) {
                    case "0":
                        tipo_pago = "Efectivo";
                        break;
                    case "1":
                        tipo_pago = "Tarjeta";
                        break;
                    default:
                        tipo_pago = "Crédito";
                        break;
                }

                switch (rs.getString("comprobante")) {
                    case "1":
                        comprobante = "Boleta";
                        break;
                    case "2":
                        comprobante = "Factura";
                        break;
                    default:
                        comprobante = "Ninguno";
                        break;
                }
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("cliente");
                registro[3] = rs.getString("total_venta");
                registro[4] = tipo_pago;
                registro[5] = comprobante;
                registro[6] = rs.getString("idcliente");
                registro[7] = rs.getString("idpreventa");
                registro[8] = rs.getString("num_comprobante");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean editar(DtoResumen datos) {
        sentencia = "update ventas set fecha=?,idcliente=?,idempleado=?,comprobante=?,tipo_pago=?,num_comprobante=? where idventa=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setString(1, datos.getFecha().toString());
            if (datos.getIdcliente() == -1) {
                pst.setNull(2, java.sql.Types.INTEGER);
            } else {
                pst.setInt(2, datos.getIdcliente());
            }
            pst.setInt(3, datos.getIdempleado());
            pst.setInt(4, datos.getComprobante());
            pst.setInt(5, datos.getTipo_pago());
            pst.setInt(6, datos.getNum_comprobante());
            pst.setInt(7, datos.getIdventa());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(int idventa) {
        retornar_a_inventario(idventa);
        sentencia = "delete from ventas where idventa=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setInt(1, idventa);

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean retornar_a_inventario(int idventa) {
        ArrayList productos = detalle_venta(idventa);

        sentencia = "insert into inventario (idproducto,idempleado,cantidad,operacion) values(?,?,?,?)";
        try {
            int n = 0;
            PreparedStatement pst = cn.prepareStatement(sentencia);
            for (int i = 0; i < productos.size(); i += 2) {
                pst.setInt(1, Integer.parseInt(productos.get(i).toString()));
                pst.setInt(2, Common.idempleado);
                pst.setInt(3, Integer.parseInt(productos.get(i + 1).toString()));
                pst.setString(4, "Anulación de venta N°" + idventa);
                n = pst.executeUpdate();
            }

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public ArrayList detalle_venta(int idventa) {
        ArrayList<String> productos = new ArrayList();
        sentencia = "select idproducto, cantidad from ventas_detalle where idventa=" + idventa;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            while (rs.next()) {
                productos.add(rs.getString("idproducto"));
                productos.add(rs.getString("cantidad"));
            }
            return productos;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrar_detalle(int idventa) {

        DefaultTableModel modelo;
        String[] titulos = {"Código", "Producto", "Cantidad", "Precio", "Importe"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select p.cod_producto,p.nombre,d.cantidad, d.monto, d.cantidad*d.monto as importe from ventas_detalle d inner"
                + " join productos p on p.idproducto=d.idproducto where d.idventa=" + idventa;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {
                registro[0] = rs.getString("cod_producto");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("cantidad");
                registro[3] = rs.getString("monto");
                registro[4] = rs.getString("importe");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public String[] mostrar_detalle_datos(int idventa) {

        String[] registro = new String[3];

        sentencia = "select (select concat(p.nombre,' ',p.apellidos) from persona p where p.idpersona=v.idpreventa )"
                + " as preventa, concat(x.nombre,' ',x.apellidos) as cajero, concat(y.nombre,' ',y.apellidos)"
                + " as vendedor from ventas v inner join persona x on v.idcajero=x.idpersona inner join persona y"
                + " on v.idempleado=y.idpersona  where v.idventa=" + idventa;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            rs.next();
            registro[0] = rs.getString("preventa");
            registro[1] = rs.getString("cajero");
            registro[2] = rs.getString("vendedor");

            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public String getDireccion(int idventa) {
        sentencia = "select (select direccion from persona where idpersona=v.idcliente)"
                + " as dir from ventas v where idventa=" + idventa;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            rs.next();
            return rs.getString("dir");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }

    }

    public DefaultTableModel papelera() {

        DefaultTableModel modelo;

        String[] titulos = {"Venta N°", "Fecha/Hora", "Importe", "Comprobante"};
        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select v.idventa, date_format(v.fecha,\"%d-%m-%Y %h:%i%p\") as fecha,"
                + " v.total_venta, v.comprobante from ventas v";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("total_venta");
                registro[3] = rs.getString("comprobante");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

}
