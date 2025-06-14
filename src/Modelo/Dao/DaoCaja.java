/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Dto.DtoCaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import comun.Conexion;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Li
 */
public class DaoCaja {

    private final Conexion conex = new Conexion();
    private final Connection cn = conex.conectar();
    private String sentencia = "";

    public ArrayList mostrar() {

        ArrayList<String> registro = new ArrayList();

        sentencia = "select total_venta as venta,tipo_pago from ventas where DATE(`fecha`) = DATE(CURDATE())";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            int i = 0;
            while (rs.next()) {
                registro.add(rs.getString("venta"));
                registro.add(rs.getString("tipo_pago"));
                i++;
            }
            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean abrir_caja(DtoCaja datos) {

        sentencia = "insert into caja (idempleado,apertura,comentario) values(?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setDouble(1, datos.getIdempleado());
            pst.setDouble(2, datos.getApertura());
            pst.setString(3, datos.getComentario_a());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean cerrar_caja(DtoCaja datos) {
        sentencia = "update caja set cierre=?,efectivo=?, tarjeta=?,credito=?,extras=?,gastos=?, comentario=?,"
                + " fecha_c=NOW() where DATE(`fecha_a`) = DATE(CURDATE()) order by fecha_a desc limit 1";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setDouble(1, datos.getCierre());
            pst.setDouble(2, datos.getEfectivo());
            pst.setDouble(3, datos.getTarjeta());
            pst.setDouble(4, datos.getCredito());
            pst.setDouble(5, datos.getExtras());
            pst.setDouble(6, datos.getGastos());
            pst.setString(7, datos.getComentario_c());
            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean editar_cierre(DtoCaja datos) {
        sentencia = "update caja set cierre=?,efectivo=?, tarjeta=?,credito=?,extras=?,gastos=?, apertura=?, comentario=?"
                + "  where idcaja=? order by fecha_a desc limit 1";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setDouble(1, datos.getCierre());
            pst.setDouble(2, datos.getEfectivo());
            pst.setDouble(3, datos.getTarjeta());
            pst.setDouble(4, datos.getCredito());
            pst.setDouble(5, datos.getExtras());
            pst.setDouble(6, datos.getGastos());
            pst.setDouble(7, datos.getApertura());
            pst.setString(8, datos.getComentario_c());
            pst.setInt(9, datos.getIdcaja());
            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public Double getApertura() {

        Double registro = 0.0;

        sentencia = "select apertura from caja where DATE(`fecha_a`) = DATE(CURDATE()) order by fecha_a desc limit 1";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            if (rs.next()) {
                registro = rs.getDouble("apertura");
            }
            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public Double getCredito() {

        Double registro = 0.0;

        sentencia = "select SUM(total_venta) as total from ventas where DATE(`fecha`) = DATE(CURDATE()) and tipo_pago=2";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            if (rs.next()) {
                registro = rs.getDouble("total");
            }

            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel ver_operaciones_diarias(Date fecha_in, Date fecha_out) {
        DefaultTableModel modelo;
        String[] titulos = {"Idcaja", "Fecha", "Empleado", "Apertura", "Cierre", "Efectivo", "Tarjeta", "Crédito", "Egresos", "Ingresos extra", "Comentario"};
        String[] registro = new String[11];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select idcaja,fecha_a,(select nombre from persona where idpersona=idempleado)as empleado,"
                + " apertura,efectivo,tarjeta, credito, gastos, extras, cierre, comentario from caja where fecha_a between '" + fecha_in + " 00:00:00' and '" + fecha_out + " 23:59:59'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("idcaja");
                registro[1] = rs.getString("fecha_a");
                registro[2] = rs.getString("empleado");
                registro[3] = rs.getString("apertura");
                registro[4] = rs.getString("cierre");
                registro[5] = rs.getString("efectivo");
                registro[6] = rs.getString("tarjeta");
                registro[7] = rs.getString("credito");
                registro[8] = rs.getString("gastos");
                registro[9] = rs.getString("extras");
                registro[10] = rs.getString("comentario");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

}
