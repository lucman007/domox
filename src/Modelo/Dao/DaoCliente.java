/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Dto.DtoCliente;
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
public class DaoCliente {

    private Conexion conex = new Conexion();
    private Connection cn = conex.conectar();
    private String sentencia = "";
    private String sentencia2 = "";
    public Integer total_registros;

    public DefaultTableModel mostrar(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"ID", "Código", "Nombre", "RUC", "Dirección", "Teléfono"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select p.idpersona, p.nombre, p.direccion, p.telefono, c.cod_cliente, c.num_ruc from persona p inner join cliente c on p.idpersona=c.idcliente where"
                + " (p.nombre like '%" + buscar + "%' or c.num_ruc like '%" + buscar + "%' or c.cod_cliente like '%" + buscar + "%') and c.eliminado=0 order by p.idpersona limit 20";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            while (rs.next()) {

                registro[0] = rs.getString("idpersona");
                registro[1] = rs.getString("cod_cliente");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("num_ruc");
                registro[4] = rs.getString("direccion");
                registro[5] = rs.getString("telefono");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean insertar(DtoCliente datos) {

        sentencia = "insert into persona (nombre,apellidos,direccion,telefono,correo,ciudad) values(?,?,?,?,?,?)";
        sentencia2 = "insert into cliente (idcliente,cod_cliente,num_ruc,eliminado) values((select idpersona"
                + " from persona order by idpersona desc limit 1),?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            PreparedStatement pst2 = cn.prepareStatement(sentencia2);
            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getApellidos());
            pst.setString(3, datos.getDireccion());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getCorreo());
            pst.setString(6, datos.getCiudad());

            pst2.setString(1, datos.getCod_cliente());
            pst2.setString(2, datos.getNum_ruc());
            pst2.setInt(3, datos.getEliminado());

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

    public boolean editar(DtoCliente datos) {
        sentencia = "update persona p inner join cliente c on p.idpersona=c.idcliente"
                + " set nombre=?,apellidos=?,direccion=?,telefono=?,correo=?,ciudad=?,cod_cliente=?,num_ruc=?  where p.idpersona=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getApellidos());
            pst.setString(3, datos.getDireccion());
            pst.setString(4, datos.getTelefono());
            pst.setString(5, datos.getCorreo());
            pst.setString(6, datos.getCiudad());
            pst.setString(7, datos.getCod_cliente());
            pst.setString(8, datos.getNum_ruc());
            pst.setInt(9, datos.getIdpersona());

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(int cliente) {
        sentencia = "update cliente set eliminado=1 where idcliente=?";
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

    public String getCodigo() {
        sentencia = "select lpad(idcliente+1,5,'0') as cliente from cliente order by idcliente desc limit 1";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            if (rs.next()) {
                return "CLI" + rs.getString("cliente");
            } else {
                return "CLI00001";
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return "";
        }

    }

    public boolean existe_codigo(String cod) {
        sentencia = "select cod_cliente from cliente where cod_cliente='" + cod + "'";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean existe_ruc(String ruc) {
        sentencia = "select num_ruc from cliente where eliminado = 0 and num_ruc='" + ruc + "'";
        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

}
