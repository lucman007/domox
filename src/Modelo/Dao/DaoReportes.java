package Modelo.Dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import comun.Common;
import comun.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DaoReportes {

    private Conexion conex = new Conexion();
    private Connection cn = conex.conectar();
    private String sentencia = "";
    private String sentencia2 = "";

    public void importar(String file) throws InvalidFormatException {

        sentencia = "INSERT INTO productos (cod_producto,nombre,presentacion,"
                + " stock_bajo,precio,costo,eliminado,imagen,idcategoria) VALUES(?,?,?,?,?,?,?,?,?)";
        sentencia2 = "INSERT INTO inventario (idproducto,idempleado,cantidad, operacion) "
                + "VALUES((select idproducto from productos order by idproducto desc limit 1 ),?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sentencia);
            PreparedStatement pst2 = cn.prepareStatement(sentencia2);
            FileInputStream input = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;

            DaoProducto categoria = new DaoProducto();
            ArrayList catg = categoria.lista_categorias();

            int n = 0;
            int idcategoria = -1;
            boolean existe_nueva_categoria;

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i + 1);
                existe_nueva_categoria = true;
                //obtener idcategoria:
                for (int j = 0; j < catg.size(); j++) {
                    String row_categoria = row.getCell(3).getStringCellValue().toUpperCase();
                    if (catg.get(j).equals(row_categoria)) {
                        idcategoria = Integer.parseInt(catg.get(j - 1).toString());
                        existe_nueva_categoria = false;
                    }
                }

                if (existe_nueva_categoria) {
                    JOptionPane.showMessageDialog(null, "El archivo contiene categorías que no existen en sistema");
                    return;
                }

                pst.setString(1, row.getCell(0).getStringCellValue().toUpperCase());
                pst.setString(2, row.getCell(1).getStringCellValue().toUpperCase());
                pst.setString(3, row.getCell(2) == null ? "" : row.getCell(2).getStringCellValue().toUpperCase());
                pst.setInt(4, (int) row.getCell(5).getNumericCellValue());
                pst.setDouble(5, (Double) row.getCell(6).getNumericCellValue());
                pst.setDouble(6, row.getCell(7).getNumericCellValue());
                pst.setInt(7, 0);
                pst.setString(8, "no-image.jpg");
                pst.setInt(9, idcategoria);

                pst2.setInt(1, Common.idempleado);
                pst2.setInt(2, (int) row.getCell(4).getNumericCellValue());
                pst2.setString(3, "Importación desde excel");

                if (pst.executeUpdate() != 0) {
                    n = pst2.executeUpdate();
                }
            }
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Se ingresó a la base datos correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error, inténtalo nuevamente");
            }

        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public ArrayList<String[]> reporte_inventario() {

        ArrayList<String[]> datos = new ArrayList<>();

        sentencia = "select p.cod_producto, p.nombre,p.precio, p.presentacion,(select SUM(cantidad) from inventario "
                + "where idproducto=p.idproducto) as cantidad,"
                + " (select monto_desc from descuentos where idproducto=p.idproducto"
                + " order by cantidad_min desc limit 1) as monto_desc,(select nombre from categorias where"
                + " idcategoria=p.idcategoria) as categoria from productos p where eliminado=0 order by p.nombre";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            int i = 0;
            while (rs.next()) {

                datos.add(new String[]{
                    rs.getString("cod_producto"),
                    rs.getString("nombre"),
                    rs.getString("presentacion"),
                    rs.getString("categoria"),
                    rs.getString("precio"),
                    rs.getString("monto_desc"),
                    rs.getString("cantidad")
                });
            }
            return datos;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public ArrayList<String[]> reporte_ventas() {

        ArrayList<String[]> datos = new ArrayList<>();
        String comprobante = "";
        String tipo_pago = "";

        sentencia = "select v.idventa, date_format(v.fecha,\"%d-%m-%Y %h:%i %p\") as fecha,"
                + " v.total_venta, v.comprobante,v.num_comprobante, v.tipo_pago, (select nombre from persona where idpersona=v.idcliente)as cliente from ventas v"
                + " where fecha between '2018-01-01 00:00:00' and CURDATE()"
                + " and tipo_pago!=2 order by v.idventa";

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
                datos.add(new String[]{
                    rs.getString("idventa"),
                    rs.getString("fecha"),
                    rs.getString("cliente"),
                    rs.getString("total_venta"),
                    tipo_pago,
                    comprobante,
                    rs.getString("num_comprobante")}
                );

            }

            return datos;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

}
