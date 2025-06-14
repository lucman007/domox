package Controlador;

import comun.Interface_main_functions;
import comun.Common;
import Modelo.Dao.DaoProducto;
import Modelo.Dto.DtoInventario;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_producto;
import Vista.Vista_producto_descuentos;
import Vista.Vista_producto_editar_cant;
import Vista.Vista_producto_nuevo;
import Vista.Vista_producto_kardex;
import Vista.Vista_producto_papelera;

/**
 *
 * @author Luciano Ces
 */
public class ControladorProducto implements Interface_main_functions {

    private Vista_producto vista_producto;
    private Vista_producto_nuevo vista_nuevo;
    private Vista_producto_kardex vista_kardex;
    private Vista_producto_papelera vista_papelera;
    private Vista_producto_descuentos vista_descuentos;
    private Vista_producto_editar_cant vista_cantidad;
    private DaoProducto daoProducto;
    private File archivo;
    private int fila_productos;
    private int fila_papelera;
    private int idproducto;
    private String accion;
    private String nombre_imagen = "";
    private String motivo;
    private String cantidad_inicial;
    private Double[][] listaDescuentos;
    private ArrayList<javax.swing.JTextField> text;

    public ControladorProducto() {

    }

    @Override
    public void iniciar() {
        this.vista_producto = new Vista_producto(this);
        this.daoProducto = new DaoProducto();
        FUNCIONES.abrir_ventana(vista_producto);
        mostrar("");
        seleccionar_item();
    }

    @Override
    public void mostrar(String texto) {
        try {
            DefaultTableModel modelo;
            modelo = daoProducto.mostrar(vista_producto.txtBuscar.getText(), "");
            vista_producto.tablaProductos.setModel(modelo);
            ocultar_columnas_productos();
            seleccionar_item();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    @Override
    public void borrar_item() {
        if (fila_productos == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para borrar");
        } else {
            String nombre = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 2);

            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar " + nombre + "?") == 0) {

                if (!nombre_imagen.equals("no-image.jpg")) {
                    File f = new File("src/recursos/product_images/" + nombre_imagen);
                    f.delete();
                }

                if (!daoProducto.eliminar(idproducto)) {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
                }
                mostrar(vista_producto.txtBuscar.getText());
            }
        }
    }

    @Override
    public void seleccionar_item() {
        fila_productos = vista_producto.tablaProductos.getSelectedRow();
        if (fila_productos == -1) {
            idproducto = -1;
        } else {
            idproducto = Integer.parseInt(vista_producto.tablaProductos.getValueAt(fila_productos, 0).toString());
        }
    }

    private void ocultar_columnas_productos() {
        Integer[] cols = {0, 9, 10};
        FUNCIONES.ocultar_columnas(cols, vista_producto.tablaProductos);
        vista_producto.tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(200);
        vista_producto.tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(200);
        vista_producto.tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    //Diálogo nuevo/editar producto
    @Override
    public void editar_item() {
        seleccionar_item();
        accion = "editar";
        if (fila_productos == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para editar");
        } else {

            Frame f = JOptionPane.getFrameForComponent(null);
            vista_nuevo = new Vista_producto_nuevo(f, true, this);

            String cod_producto = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 1);
            String nombre = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 2);
            String presentacion = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 3);
            String categoria = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 4);
            String precio = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 5);
            String costo = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 7);
            String cantidad = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 8);
            String stock_bajo = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 9);
            nombre_imagen = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 10);

            mostrar_categoria();
            cantidad_inicial = (cantidad);
            vista_nuevo.txtCod_producto.setText(cod_producto);
            vista_nuevo.txtNombre.setText(nombre);
            vista_nuevo.txtPresentacion.setText(presentacion);
            vista_nuevo.cboCategoria.setSelectedItem(categoria);
            vista_nuevo.txtPrecio.setText(precio);
            vista_nuevo.txtCosto.setText(costo);
            vista_nuevo.txtCantidad.setText(cantidad);
            vista_nuevo.txtCantidad.setEnabled(false);
            vista_nuevo.txtStockBajo.setText(stock_bajo);
            vista_nuevo.btnDesc.setText("Editar descuentos de producto");
            Image imagen = new ImageIcon("src/recursos/product_images/" + nombre_imagen).getImage();
            imagen.getScaledInstance(185, -1, Image.SCALE_DEFAULT);
            ImageIcon avatar = new ImageIcon(imagen);
            vista_nuevo.lblImagen.setIcon(avatar);
            vista_nuevo.txtImagen.setText(nombre_imagen);
            vista_nuevo.txtImagen.setEnabled(false);

            descuentos_producto();
            FUNCIONES.abrir_dialogo(vista_nuevo);
        }

    }

    public void nuevo_producto() {
        accion = "insertar";
        Frame f = JOptionPane.getFrameForComponent(null);
        vista_nuevo = new Vista_producto_nuevo(f, true, this);
        listaDescuentos = new Double[6][2];
        vista_nuevo.btnEdit.setVisible(false);
        mostrar_categoria();
        motivo = "";
        FUNCIONES.abrir_dialogo(vista_nuevo);
    }

    public boolean guardar_producto() {
        if (vista_nuevo.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa el nombre del producto");
            vista_nuevo.txtNombre.requestFocus();
            return false;
        }
        if (vista_nuevo.txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa la cantidad en almacén");
            vista_nuevo.txtCantidad.requestFocus();
            return false;
        }
        if (vista_nuevo.txtCosto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa el costo, te ayudará luego en el cálculo de utilidades");
            vista_nuevo.txtCosto.requestFocus();
            return false;
        }
        if (vista_nuevo.txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa el precio del producto");
            vista_nuevo.txtPrecio.requestFocus();
            return false;
        }
        if (vista_nuevo.txtStockBajo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa una cantidad mínima para que se te notifique antes de quedarte sin stock");
            vista_nuevo.txtStockBajo.requestFocus();
            return false;
        }

        DtoInventario entidad = new DtoInventario();

        int idcategoria = -1;
        ArrayList lista_categorias = daoProducto.lista_categorias();
        for (int i = 0; i < lista_categorias.size(); i++) {
            if (vista_nuevo.cboCategoria.getSelectedItem().equals(lista_categorias.get(i).toString())) {
                idcategoria = Integer.parseInt(lista_categorias.get(i - 1).toString());
            }
        }

        entidad.setNombre(vista_nuevo.txtNombre.getText());
        entidad.setCantidad(Integer.parseInt(vista_nuevo.txtCantidad.getText()));
        entidad.setPrecio(Double.parseDouble(vista_nuevo.txtPrecio.getText()));
        entidad.setCod_producto(vista_nuevo.txtCod_producto.getText());
        entidad.setPresentacion(vista_nuevo.txtPresentacion.getText());
        entidad.setCosto(Double.parseDouble(vista_nuevo.txtCosto.getText()));
        entidad.setStock_bajo(Integer.parseInt(vista_nuevo.txtStockBajo.getText()));
        entidad.setEliminado(0);
        entidad.setCategoria(idcategoria);
        entidad.setImagen(subir_imagen());
        entidad.setDescuentos(listaDescuentos);
        entidad.setIdempleado(Common.idempleado);
        entidad.setDescripcion(motivo);
        if (accion.equals("insertar")) {
            if (!daoProducto.insertar(entidad)) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el producto");
            }
        } else if (accion.equals("editar")) {
            entidad.setIdproducto(idproducto);
            entidad.setCantidad(Integer.parseInt(vista_nuevo.txtCantidad.getText()) - Integer.parseInt(cantidad_inicial));
            if (!daoProducto.editar(entidad)) {
                JOptionPane.showMessageDialog(null, "No se pudo editar el producto");
            }
        }
        DefaultTableModel modelo;
        modelo = daoProducto.mostrar(vista_producto.txtBuscar.getText(), "");
        vista_producto.tablaProductos.setModel(modelo);
        ocultar_columnas_productos();
        borrar_imagen();
        return true;
    }

    public void seleccionar_imagen() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        archivo = chooser.getSelectedFile();
        String ext = extension(archivo.getName());
        if (ext.equals(".jpg") || ext.equals(".png")) {
            vista_nuevo.txtImagen.setText(archivo.getName());
            Image imagen = new ImageIcon(archivo.getAbsolutePath()).getImage();
            imagen.getScaledInstance(185, -1, Image.SCALE_DEFAULT);
            ImageIcon icono = new ImageIcon(imagen);
            vista_nuevo.lblImagen.setIcon(icono);
        } else {
            JOptionPane.showMessageDialog(null, "Sólo se permiten imágenes con estensión .jpg o .png");
            archivo = null;
            vista_nuevo.txtImagen.setText("");
        }
    }

    private void descuentos_producto() {
        String[][] descuentos = daoProducto.mostrar_descuento(idproducto);
        listaDescuentos = new Double[6][2];
        for (int k = 0; k < 6; k++) {
            if (descuentos[k][0] != null || descuentos[k][1] != null) {
                listaDescuentos[k][0] = Double.parseDouble(descuentos[k][0]);
                listaDescuentos[k][1] = Double.parseDouble(descuentos[k][1]);
            }
        }
    }

    private void mostrar_categoria() {
        ArrayList lista_categorias = daoProducto.lista_categorias();
        for (int i = 0; i < lista_categorias.size(); i++) {
            if (i % 2 != 0) {
                vista_nuevo.cboCategoria.addItem(lista_categorias.get(i).toString());
            }
        }

    }

    private String nombre_imagen() {
        Calendar cal = Calendar.getInstance();
        int d, m, a, h, mi, s;
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR);
        h = cal.get(Calendar.HOUR);
        mi = cal.get(Calendar.MINUTE);
        s = cal.get(Calendar.SECOND);

        return (d + "" + m + "" + a + "" + h + "" + mi + "" + s);
    }

    private String extension(String file) {
        String ext = "";
        int i = file.lastIndexOf('.');
        if (i > 0) {
            ext = file.substring(i);
        }
        return ext;
    }

    private String subir_imagen() {
        if (accion.equals("insertar")) {
            return "no-image.jpg";
        } else {
            if (!nombre_imagen.equals(vista_nuevo.txtImagen.getText())) {
                String nombre_archivo = archivo.getAbsolutePath();
                String img_name = nombre_imagen() + extension(nombre_archivo);
                File origen = new File(nombre_archivo);
                File destino = new File("src/recursos/product_images/" + img_name);
                try {
                    InputStream in = new FileInputStream(origen);
                    OutputStream out = new FileOutputStream(destino);

                    byte[] buf = new byte[1024];
                    int len;

                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    in.close();
                    out.close();
                    return img_name;
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(null, ioe);
                    return "no-image.jpg";
                }
            } else {
                return vista_nuevo.txtImagen.getText();
            }

        }

    }

    private void borrar_imagen() {
        if (accion.equals("editar")) {
            archivo = new File("src/recursos/product_images/" + nombre_imagen);
        } else {
            archivo = new File("");
        }
        if (!nombre_imagen.equals(vista_nuevo.txtImagen.getText())) {
            if (!archivo.getName().equals("no-image.jpg")) {
                archivo.delete();
            }
        }
    }

    //Dialogo kardex productos
    public void abrir_dialogo_kardex() {
        seleccionar_item();
        if (fila_productos == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item");
        } else {
            Frame f = JOptionPane.getFrameForComponent(null);
            vista_kardex = new Vista_producto_kardex(f, true);
            String nombre = (String) vista_producto.tablaProductos.getValueAt(fila_productos, 2);
            vista_kardex.txtProducto.setText(nombre);
            mostrar_kardex(idproducto);
            FUNCIONES.abrir_dialogo(vista_kardex);
        }
    }

    private void mostrar_kardex(int idproducto) {
        try {
            DefaultTableModel model = daoProducto.inventario(idproducto);
            vista_kardex.tablaInventario.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Dialogo papelera
    public void abrir_dialogo_papelera() {
        Frame f = JOptionPane.getFrameForComponent(null);
        vista_papelera = new Vista_producto_papelera(f, true, this);
        mostrar_papelera();
        ocultar_columnas_papelera();
        FUNCIONES.abrir_dialogo(vista_papelera);
    }

    private void mostrar_papelera() {
        try {
            DefaultTableModel model = daoProducto.papelera();
            vista_papelera.tablaPapelera.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ocultar_columnas_papelera();
    }

    private void ocultar_columnas_papelera() {
        Integer[] cols = {0};
        FUNCIONES.ocultar_columnas(cols, vista_papelera.tablaPapelera);
    }

    public void seleccionar_item_papelera() {
        fila_papelera = vista_papelera.tablaPapelera.getSelectedRow();
        idproducto = Integer.parseInt(vista_papelera.tablaPapelera.getValueAt(fila_papelera, 0).toString());
    }

    public void restaurar() {
        try {
            daoProducto.restaurar_eliminado(idproducto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        mostrar_papelera();
        mostrar(vista_producto.txtBuscar.getText());
    }

    // Diálog descuentos de producto
    public void abrir_dialogo_descuentos() {
        Frame f = JOptionPane.getFrameForComponent(null);
        vista_descuentos = new Vista_producto_descuentos(f, true, this);
        crear_textField_data();
        FUNCIONES.abrir_dialogo(vista_descuentos);
    }

    private void crear_textField_data() {
        text = new ArrayList();
        //Crear inputs dinámicamente
        int y = 55;
        for (int i = 0; i < 12; i++) {

            text.add(new javax.swing.JTextField());
            text.get(i).setVisible(true);
            text.get(i).setSize(90, 30);
            text.get(i).setText("");
            if (i % 2 == 0) {
                text.get(i).setLocation(130, y);
            } else {
                text.get(i).setLocation(250, y);
                y += 43;
            }
            vista_descuentos.panel_descuentos.add(text.get(i));

        }
        //Llenar inputs con valores de descuento si producto está en modo edición
        if (accion.equals("editar")) {

            int i = 0;

            for (int k = 0; k < 6; k++) {
                if (listaDescuentos[k][0] != null || listaDescuentos[k][1] != null) {
                    text.get(i).setText(listaDescuentos[k][0].toString());
                    text.get(i + 1).setText(listaDescuentos[k][1].toString());
                    i += 2;
                }
            }
        }
    }

    public void guardar_descuentos() {
        int i = 0;
        for (int k = 0; k < 6; k++) {
            if (text.get(i).getText().isEmpty() || text.get(i + 1).getText().isEmpty()) {
                listaDescuentos[k][0] = null;
                listaDescuentos[k][1] = null;
            } else {
                listaDescuentos[k][0] = Double.parseDouble(text.get(i).getText());
                listaDescuentos[k][1] = Double.parseDouble(text.get(i + 1).getText());
            }
            i += 2;
        }
    }

    //Diálogo editar cantidad
    public void abrir_dialogo_editar_cantidad() {
        Frame f = JOptionPane.getFrameForComponent(null);
        vista_cantidad = new Vista_producto_editar_cant(f, true, this);
        FUNCIONES.abrir_dialogo(vista_cantidad);
    }

    public boolean guardar_cantidad() {
        String cantidad = vista_cantidad.txtCantidad.getText();
        String _motivo = vista_cantidad.txtMotivo.getText();
        if (cantidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa una nueva cantidad");
            vista_cantidad.txtCantidad.requestFocus();
            return false;
        }
        if (_motivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa el motivo de la edición de cantidad");
            vista_cantidad.txtMotivo.requestFocus();
            return false;
        }

        vista_nuevo.txtCantidad.setText(cantidad);
        motivo = _motivo;
        return true;
    }

}
