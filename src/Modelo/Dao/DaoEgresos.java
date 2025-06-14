package Modelo.Dao;

import Modelo.Dto.DtoEgresos;
import java.sql.Connection;
import java.sql.Date;
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
public class DaoEgresos {

    private final Conexion conex = new Conexion();
    private final Connection cn = conex.conectar();
    private String sentencia = "";

    public DefaultTableModel mostrar(Date fecha_in, Date fecha_out, boolean[] filtro) {

        DefaultTableModel modelo;
        String[] titulos = {"Idegreso", "Fecha", "Empleado", "Operación", "Tipo", "Monto", "Descripcion"};
        String[] registro = new String[7];
        String where_condition;
        if (!filtro[0] && filtro[1]) {
            where_condition = "and g.operacion = 'Ingreso'";
        } else if (filtro[0] && !filtro[1]) {
            where_condition = "and g.operacion = 'Egreso'";
        } else if (filtro[0] && filtro[1]) {
            where_condition = "";
        } else {
            where_condition = "and g.operacion = 'none'";
        }

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select g.idgasto, date_format(g.fecha,\"%d-%m-%Y\") as fecha,"
                + " (select nombre from persona where idpersona=g.idempleado) as empleado,"
                + " g.operacion, g.tipo, g.monto, g.descripcion from gastos g"
                + " where fecha between '" + fecha_in + " 00:00:00' and '" + fecha_out + " 23:59:59' "
                + where_condition + " order by g.fecha";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("idgasto");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("empleado");
                registro[3] = rs.getString("operacion");
                registro[4] = rs.getString("tipo");
                registro[5] = rs.getString("monto");
                registro[6] = rs.getString("descripcion");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public Double[] obtener_gastos() {

        Double[] registro = new Double[2];
        Double total_ingreso = 0.0;
        Double total_egreso = 0.0;

        sentencia = "select monto, operacion from gastos where DATE(`fecha`) = DATE(CURDATE())";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {
                if (rs.getString("operacion").equals("Ingreso")) {
                    total_ingreso += rs.getDouble("monto");
                } else {
                    total_egreso += rs.getDouble("monto");
                }
            }
            registro[0] = total_ingreso;
            registro[1] = total_egreso;

            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean insertar(DtoEgresos datos) {

        sentencia = "insert into gastos (idempleado,monto,descripcion,tipo, operacion) values(?,?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setInt(1, datos.getIdempleado());
            pst.setDouble(2, datos.getMonto());
            pst.setString(3, datos.getDescripcion());
            pst.setString(4, datos.getTipo());
            pst.setString(5, datos.getOperacion());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(int id) {
        sentencia = "delete from gastos where idgasto=" + id;
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            int n = pst.executeUpdate();
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

}
