package Modelo.Dao;

import Modelo.Dto.DtoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import comun.Conexion;

/**
 *
 * @author Luciano Ces
 */
public class DaoEmpleado {

    private Conexion conex = new Conexion();
    private Connection cn = conex.conectar();
    private String sentencia = "";
    private String sentencia2 = "";
    public Integer total_registros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellidos", "Dirección", "Ciudad", "Teléfono", "Email", "Usuario", "Clave", "Cargo"};
        String[] registro = new String[10];
        String cargo = "";

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select t.idempleado, t.usuario, t.clave,t.acceso, p.nombre, p.apellidos,p.direccion, p.telefono, p.correo, p.ciudad"
                + " from persona p inner join empleado t on p.idpersona=t.idempleado where"
                + " nombre like '%" + buscar + "%' and eliminado=0 order by p.idpersona limit 25";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            while (rs.next()) {

                registro[0] = rs.getString("idempleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("direccion");
                registro[4] = rs.getString("ciudad");
                registro[5] = rs.getString("telefono");
                registro[6] = rs.getString("correo");
                registro[7] = rs.getString("usuario");
                registro[8] = rs.getString("clave");

                switch (rs.getString("acceso")) {
                    case "0":
                        cargo = "Gerencia";
                        break;
                    case "1":
                        cargo = "Administración";
                        break;
                    case "2":
                        cargo = "Caja";
                        break;
                    case "3":
                        cargo = "Ventas";
                        break;
                    case "4":
                        cargo = "Pre-venta";
                        break;
                    case "5":
                        cargo = "Otros";
                        break;
                }
                registro[9] = cargo;

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean insertar(DtoEmpleado datos) {

        sentencia = "insert into persona (nombre,apellidos,direccion,telefono,correo,ciudad) values(?,?,?,?,?,?)";
        sentencia2 = "insert into empleado (idempleado,usuario,clave, acceso, eliminado) values((select idpersona"
                + " from persona order by idpersona desc limit 1),?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            PreparedStatement pst2 = cn.prepareStatement(sentencia2);
            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getApellidos());
            pst.setString(3, datos.getDireccion());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getCorreo());
            pst.setString(6, datos.getCiudad());

            pst2.setString(1, datos.getUsuario());
            pst2.setString(2, datos.getClave());
            pst2.setInt(3, datos.getAcceso());
            pst2.setInt(4, datos.getEliminado());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                return n2 != 0;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean editar(DtoEmpleado datos) {
        sentencia = "update persona p inner join empleado t on p.idpersona=t.idempleado"
                + " set nombre=?,apellidos=?,direccion=?,telefono=?,correo=?,ciudad=?,usuario=?,clave=?, acceso=?, eliminado=?  where p.idpersona=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getApellidos());
            pst.setString(3, datos.getDireccion());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getCorreo());
            pst.setString(6, datos.getCiudad());
            pst.setString(7, datos.getUsuario());
            pst.setString(8, datos.getClave());
            pst.setInt(9, datos.getAcceso());
            pst.setInt(10, datos.getEliminado());
            pst.setInt(11, datos.getIdpersona());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(int cliente) {
        sentencia = "update empleado set eliminado=1 where idempleado=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setInt(1, cliente);

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean existe_usuario(String user) {
        sentencia = "select usuario from empleado where usuario='" + user + "'";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public ArrayList login(String usuario, String pass) {

        ArrayList<String> listado = new ArrayList();

        sentencia = "select t.idempleado, t.usuario, t.acceso, t.clave, t.eliminado, p.nombre, p.apellidos"
                + " from persona p inner join empleado t on p.idpersona=t.idempleado where"
                + " t.usuario='" + usuario + "' and t.clave='" + pass + "' and t.eliminado=0";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            while (rs.next()) {

                listado.add(rs.getString("idempleado"));
                listado.add(rs.getString("nombre"));
                listado.add(rs.getString("apellidos"));
                listado.add(rs.getString("acceso"));
                listado.add(rs.getString("usuario"));
                listado.add(rs.getString("clave"));
                listado.add(rs.getString("eliminado"));
            }

            return listado;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public ArrayList lista_empleados(int cargo) {

        //Cargos:
        //-1: Mostrar todo
        //0: Gerencia
        //1: Admisnitración
        //2: Caja
        //3: Ventas
        //4: Pre-venta
        //5: Otros
        String where_condition = "";
        if (cargo != -1) {
            where_condition = "where e.acceso=" + cargo;
        }

        ArrayList registro = new ArrayList();
        sentencia = "select p.nombre,p.apellidos,p.idpersona from empleado e inner join persona p on p.idpersona=e.idempleado "
                + where_condition + " and eliminado=0 order by p.nombre";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {
                registro.add(rs.getString("idpersona"));
                registro.add(rs.getString("nombre") + " " + rs.getString("apellidos"));
            }
            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public String getEmpleado(int idempleado) {

        String registro;

        sentencia = "select nombre from persona where idpersona=" + idempleado;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            rs.next();
            registro = rs.getString("nombre");
            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
}
