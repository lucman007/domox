package Controlador;

import comun.Common;
import comun.Interface_main_functions;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_muestras;

/**
 *
 * @author Luciano Ces
 */
public class ControladorMuestras implements Interface_main_functions {

    private Vista_muestras vista_muestras;
    ControladorPedido controladorPedido;
    private int fila_muestra;
    private int idmuestra;
    private int idcliente;
    private int idempleado;

    public ControladorMuestras() {
    }

    @Override
    public void iniciar() {
        this.vista_muestras = new Vista_muestras(this);
        this.controladorPedido = new ControladorPedido();
        FUNCIONES.abrir_ventana(vista_muestras);
        mostrar("");
        mostrar_detalle();
    }

    @Override
    public void mostrar(String texto) {
        //Visualizar muestras registradas
        try {

            DefaultTableModel modelo;
            modelo = controladorPedido.ver_muestras();
            vista_muestras.tablaMuestras.setModel(modelo);
            ocultar_columnas_muestras();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void borrar_item() {
        seleccionar_item();
        if (fila_muestra == -1) {
            JOptionPane.showMessageDialog(null, "No has selecciona un item");
        } else {

        }
    }

    @Override
    public void editar_item() {
        seleccionar_item();
        if (fila_muestra == -1) {
            JOptionPane.showMessageDialog(null, "No has selecciona un item");
        } else {
            FUNCIONES.cerrar_ventana_previa("Vista_pedido");
            controladorPedido.editar_pedido(idmuestra);
            limpiar();
        }
    }

    @Override
    public void seleccionar_item() {
        fila_muestra = vista_muestras.tablaMuestras.getSelectedRow();
        if (fila_muestra == -1) {
            idmuestra = -1;
        } else {
            idmuestra = Integer.parseInt(vista_muestras.tablaMuestras.getValueAt(fila_muestra, 0).toString());
        }
    }

    public void mostrar_detalle() {
        try {
            DefaultTableModel modelo;
            modelo = controladorPedido.mostrar_detalle_muestras(idmuestra);
            vista_muestras.tablaDetalle.setModel(modelo);
            ocultar_columnas_detalle();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void ocultar_columnas_detalle() {
        Integer[] cols = {0};
        FUNCIONES.ocultar_columnas(cols, vista_muestras.tablaDetalle);
        vista_muestras.tablaDetalle.getColumnModel().getColumn(2).setPreferredWidth(280);
    }

    private void ocultar_columnas_muestras() {
        Integer[] cols = {0, 5, 6, 7, 8};
        FUNCIONES.ocultar_columnas(cols, vista_muestras.tablaMuestras);
    }

    public void calcular_total() {
        double total = Double.parseDouble(vista_muestras.tablaMuestras.getValueAt(fila_muestra, 4).toString());
        vista_muestras.lblTotal_orden.setText(Common.aDecimal(total));
    }

    public void abrir_muestra() {
        seleccionar_item();
        idcliente = Integer.parseInt(vista_muestras.tablaMuestras.getValueAt(fila_muestra, 6).toString());
        idempleado = Integer.parseInt(vista_muestras.tablaMuestras.getValueAt(fila_muestra, 7).toString());
        String cliente = vista_muestras.tablaMuestras.getValueAt(fila_muestra, 3) == null ? "" : vista_muestras.tablaMuestras.getValueAt(fila_muestra, 3).toString();
        mostrar_detalle();
        vista_muestras.lblCliente.setText(cliente);

        calcular_total();
    }

    public void limpiar() {
        mostrar("");
        seleccionar_item();
        mostrar_detalle();
        vista_muestras.lblTotal_orden.setText("0.00");
        vista_muestras.lblCliente.setText("");
    }

    public void imprimir() {

    }
}
