/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import comun.Interface_main_functions;
import Modelo.Dao.DaoProducto;
import Modelo.Dto.DtoCategoria;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_producto_categorias;

/**
 *
 * @author Luciano Ces
 */
public class ControladorProductoCategorias implements Interface_main_functions {

    private Vista_producto_categorias vista_categoria;
    private DaoProducto daoProducto;
    private int fila_categoria;
    private int idcategoria;

    public ControladorProductoCategorias() {

    }

    @Override
    public void iniciar() {
        this.vista_categoria = new Vista_producto_categorias(this);
        this.daoProducto = new DaoProducto();
        FUNCIONES.abrir_ventana(vista_categoria);
        mostrar("");
        seleccionar_item();
    }

    @Override
    public void mostrar(String texto) {
        try {
            DefaultTableModel modelo;
            modelo = daoProducto.mostrar_tabla_categorias(texto);
            vista_categoria.tablaCategorias.setModel(modelo);
            ocultar_columnas_categorias();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void borrar_item() {
        seleccionar_item();
        if (fila_categoria == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para borrar");
        } else {

            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar esta categoría?") == 0) {
                if (!daoProducto.eliminar_categoria(idcategoria)) {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
                }
                mostrar("");
            }
        }
    }

    @Override
    public void editar_item() {
    }

    @Override
    public void seleccionar_item() {
        fila_categoria = vista_categoria.tablaCategorias.getSelectedRow();
        if (fila_categoria == -1) {
            idcategoria = -1;
        } else {
            idcategoria = Integer.parseInt(vista_categoria.tablaCategorias.getValueAt(fila_categoria, 0).toString());
        }
    }

    private void ocultar_columnas_categorias() {
        Integer[] cols = {0};
        FUNCIONES.ocultar_columnas(cols, vista_categoria.tablaCategorias);
    }

    public void guardar_categoria() {
        DtoCategoria entidad = new DtoCategoria();
        String nombre = vista_categoria.txtNombre.getText();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa nombre de categoría");
            vista_categoria.txtNombre.requestFocus();
            return;
        }
        if (daoProducto.existe_categoria(nombre)) {
            JOptionPane.showMessageDialog(null, "Ya existe una categoría con ese nombre");
            vista_categoria.txtNombre.requestFocus();
            return;
        }

        entidad.setNombre(nombre);
        entidad.setDescripcion(vista_categoria.txtDescripcion.getText());
        if (!daoProducto.insertar_categoria(entidad)) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la categoría");
        } else {
            vista_categoria.txtNombre.setText("");
            vista_categoria.txtDescripcion.setText("");
            vista_categoria.txtNombre.requestFocus();
            mostrar("");
        }

    }
}
