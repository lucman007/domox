package Modelo.Dao;

import Modelo.Dto.DtoCategoria;
import Modelo.Dto.DtoInventario;
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
 * @author Li
 */
public class DaoProducto {

    private Conexion conex = new Conexion();
    private Connection cn = conex.conectar();
    private String sentencia = "";
    private String sentencia2 = "";
    private String sentencia3 = "";
    public Integer total_registros;

    public DefaultTableModel mostrar(String buscar, String limit) {

        DefaultTableModel modelo;

        String[] titulos = {"ID", "Código", "Nombre", "Características", "Categoría", "Precio", "Por mayor", "Costo", "Stock", "Stock_bajo", "Imagen"};
        String[] registro = new String[11];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select p.idproducto, p.cod_producto, p.nombre, p.presentacion, p.precio, p.costo, p.stock_bajo,"
                + " p.imagen, (select SUM(cantidad) from inventario where idproducto=p.idproducto) as cantidad,"
                + " (select monto_desc from descuentos where idproducto=p.idproducto"
                + " order by cantidad_min desc limit 1) as monto_desc,(select nombre from categorias where"
                + " idcategoria=p.idcategoria) as categoria from productos p where (p.nombre like '%" + buscar + "%'"
                + " or p.cod_producto like '%" + buscar + "%') and eliminado=0 order by p.nombre " + limit;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("idproducto");
                registro[1] = rs.getString("cod_producto");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("presentacion");
                registro[4] = rs.getString("categoria");
                registro[5] = rs.getString("precio");
                registro[6] = rs.getString("monto_desc");
                registro[7] = rs.getString("costo");
                registro[8] = rs.getString("cantidad");
                registro[9] = rs.getString("stock_bajo");
                registro[10] = rs.getString("imagen");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public String[][] mostrar_descuento(int id) {

        String[][] registro = new String[6][2];

        sentencia = "select cantidad_min, monto_desc from descuentos d inner join productos p on p.idproducto=d.idproducto"
                + " where p.idproducto=" + id + " order by monto_desc desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            int i = 0;
            while (rs.next()) {
                registro[i][0] = rs.getString("cantidad_min");
                registro[i][1] = rs.getString("monto_desc");
                i++;
            }
            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public boolean insertar(DtoInventario datos) {

        sentencia = "insert into productos (nombre,precio,cod_producto,presentacion,eliminado,"
                + "idcategoria,imagen,costo,stock_bajo) values(?,?,?,?,?,?,?,?,?)";
        sentencia2 = " insert into inventario (idproducto,cantidad,idempleado,operacion,descripcion)"
                + " values((select idproducto from productos order by idproducto desc limit 1),?,?,?,?)";
        sentencia3 = "insert into descuentos (idproducto,cantidad_min,monto_desc) values((select idproducto"
                + " from productos order by idproducto desc limit 1),?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sentencia);
            PreparedStatement pst2 = cn.prepareStatement(sentencia2);
            PreparedStatement pst3 = cn.prepareStatement(sentencia3);
            pst.setString(1, datos.getNombre());
            pst.setDouble(2, datos.getPrecio());
            pst.setString(3, datos.getCod_producto());
            pst.setString(4, datos.getPresentacion());
            pst.setInt(5, datos.getEliminado());
            if (datos.getCategoria() == -1) {
                pst.setNull(6, java.sql.Types.INTEGER);
            } else {
                pst.setInt(6, datos.getCategoria());
            }

            pst.setString(7, datos.getImagen());
            pst.setDouble(8, datos.getCosto());
            pst.setInt(9, datos.getStock_bajo());

            pst2.setInt(1, datos.getCantidad());
            pst2.setInt(2, datos.getIdempleado());
            pst2.setString(3, "Registro de nuevo producto");
            pst2.setString(4, datos.getDescripcion());

            int n = 0;

            if (pst.executeUpdate() != 0) {
                n = pst2.executeUpdate();
                Double[][] desc = datos.getDescuentos();
                for (Double[] desc1 : desc) {
                    for (int j = 0; j < 1; j++) {
                        if (desc1[j] != null || desc1[j + 1] != null) {
                            if (!(desc1[j] == 0.0 && desc1[j + 1] == 0.0)) {
                                pst3.setInt(1, (desc1[j]).intValue());
                                pst3.setDouble(2, desc1[j + 1]);
                                pst3.executeUpdate();
                            }
                        }
                    }
                }
            }

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean editar(DtoInventario datos) {
        sentencia = "update productos set nombre=?,precio=?,cod_producto=?, presentacion=?,costo=?,idcategoria=?,"
                + " imagen=?, stock_bajo=? where idproducto=? and eliminado=0";
        sentencia2 = " insert into inventario (idproducto,cantidad,idempleado,operacion,descripcion)"
                + " values(?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            PreparedStatement pst2 = cn.prepareStatement(sentencia2);

            pst.setString(1, datos.getNombre());
            pst.setDouble(2, datos.getPrecio());
            pst.setString(3, datos.getCod_producto());
            pst.setString(4, datos.getPresentacion());
            pst.setDouble(5, datos.getCosto());
            if (datos.getCategoria() == -1) {
                pst.setNull(6, java.sql.Types.INTEGER);
            } else {
                pst.setInt(6, datos.getCategoria());
            }
            pst.setString(7, datos.getImagen());
            pst.setInt(8, datos.getStock_bajo());
            pst.setInt(9, datos.getIdproducto());

            pst2.setInt(1, datos.getIdproducto());
            pst2.setInt(2, datos.getCantidad());
            pst2.setInt(3, datos.getIdempleado());
            pst2.setString(4, "Edición manual");
            pst2.setString(5, datos.getDescripcion());

            boolean n = false;
            if (pst.executeUpdate() != 0) {
                if (datos.getCantidad() == 0) {
                    n = editar_descuentos(datos);
                } else {
                    if (pst2.executeUpdate() != 0) {
                        n = editar_descuentos(datos);
                    }
                }

            }
            return n;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean editar_descuentos(DtoInventario datos) {

        sentencia = "delete from descuentos where idproducto=?";
        sentencia2 = "insert into descuentos(cantidad_min,monto_desc,idproducto) values(?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            PreparedStatement pst2 = cn.prepareStatement(sentencia2);
            pst.setInt(1, datos.getIdproducto());
            pst.executeUpdate();
            int n = 0;
            Double[][] descuentos = datos.getDescuentos();
            for (int k = 0; k < 6; k++) {
                if (descuentos[k][0] != null || descuentos[k][1] != null) {
                    if (!(descuentos[k][0] == 0.0 && descuentos[k][1] == 0.0)) {
                        pst2.setInt(1, (descuentos[k][0]).intValue());
                        pst2.setDouble(2, descuentos[k][1]);
                        pst2.setInt(3, datos.getIdproducto());
                        pst2.executeUpdate();
                    }
                }
            }
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean eliminar(int idproducto) {
        sentencia = "update productos set eliminado=1 where idproducto=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setInt(1, idproducto);

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean restaurar_eliminado(int idproducto) {
        sentencia = "update productos set eliminado=0 where idproducto=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setInt(1, idproducto);

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public DefaultTableModel inventario(int idproducto) {

        DefaultTableModel modelo;

        String[] titulos = {"Fecha", "Empleado", "Cantidad", "Operación", "Observación"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select date_format(fecha,\"%d-%m-%Y %h:%i%p\") as fecha, (select nombre from persona where idpersona=idempleado) as empleado, cantidad, operacion, descripcion from inventario where idproducto=" + idproducto;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("fecha");
                registro[1] = rs.getString("empleado");
                registro[2] = rs.getString("cantidad");
                registro[3] = rs.getString("operacion");
                registro[4] = rs.getString("descripcion");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel papelera() {

        DefaultTableModel modelo;

        String[] titulos = {"Id", "Código", "Nombre", "Precio", "Stock"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select p.idproducto, p.cod_producto, p.nombre,  p.precio, "
                + "(select SUM(cantidad) from inventario where idproducto=p.idproducto) as cantidad"
                + " from productos p where p.eliminado=1 order by p.nombre";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("idproducto");
                registro[1] = rs.getString("cod_producto");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("precio");
                registro[4] = rs.getString("cantidad");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public ArrayList<String> lista_categorias() {

        ArrayList<String> registro = new ArrayList();

        sentencia = "select nombre, idcategoria from categorias order by nombre";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {
                registro.add(rs.getString("idcategoria"));
                registro.add(rs.getString("nombre"));
            }
            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel mostrar_tabla_categorias(String buscar) {

        DefaultTableModel modelo;

        String[] titulos = {"Idcategoría", "Nombre"};
        String[] registro = new String[10];

        modelo = new DefaultTableModel(null, titulos);
        sentencia = "select idcategoria, nombre from categorias order by nombre";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);

            while (rs.next()) {

                registro[0] = rs.getString("idcategoria");
                registro[1] = rs.getString("nombre");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public int getIdCategoria(String nombre) {

        int registro;

        sentencia = "select idcategoria from categorias where nombre='" + nombre + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            rs.next();
            registro = rs.getInt("idcategoria");
            return registro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return 0;
        }

    }

    public boolean existe_categoria(String nombre) {

        sentencia = "select nombre from categorias where nombre='" + nombre + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean insertar_categoria(DtoCategoria datos) {

        sentencia = "insert into categorias (nombre,descripcion) values(?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setString(1, datos.getNombre());
            pst.setString(2, datos.getDescripcion());

            int n = pst.executeUpdate();
            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

    public boolean eliminar_categoria(int idcategoria) {
        sentencia = "delete from categorias where idcategoria=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            pst.setInt(1, idcategoria);

            int n = pst.executeUpdate();

            return n != 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }

}
