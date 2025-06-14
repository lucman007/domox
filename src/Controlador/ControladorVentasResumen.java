package Controlador;

import comun.Interface_agregar_cliente;
import comun.Interface_main_functions;
import comun.Helper_numeroTexto;
import comun.Helper_impresion;
import comun.Common;
import Modelo.Dao.DaoResumen;
import Modelo.Dto.DtoCliente;
import Modelo.Dto.DtoImpresion;
import Modelo.Dto.DtoResumen;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_ventas_editar;
import Vista.Vista_ventas_resumen;
import Vista.Vista_ventas_detalle;
import Vista.Vista_ventas_direccion;

/**
 *
 * @author Luciano Ces
 */
public class ControladorVentasResumen implements Interface_agregar_cliente, Interface_main_functions {

    private int idventa;
    private int fila_ventas;
    private String direccion;
    private int idcliente;
    private ArrayList lista_empleados;
    private Vista_ventas_resumen vista_resumen;
    private Vista_ventas_detalle vista_detalle;
    private Vista_ventas_editar vista_editar;
    private DaoResumen daoResumen;
    private ControladorEmpleado controladorEmpleado;

    public ControladorVentasResumen() {

    }

    @Override
    public void iniciar() {
        this.vista_resumen = new Vista_ventas_resumen(this);
        this.daoResumen = new DaoResumen();
        FUNCIONES.abrir_ventana(vista_resumen);
        this.fila_ventas = -1;
        iniciar_dateChooser();
        mostrar("");
    }

    @Override
    public void mostrar(String texto) {
        try {
            DefaultTableModel modelo;
            modelo = daoResumen.mostrar(texto, "resumen", fecha_in(), fecha_out());
            vista_resumen.tablaVentas.setModel(modelo);
            total_resumen();
            ocultar_columnas_ventas();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void iniciar_dateChooser() {
        Common.configurar_calendario(vista_resumen.fechaInicial);
        Common.configurar_calendario(vista_resumen.fechaFinal);

        vista_resumen.fechaInicial.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("date")) {
                    mostrar("");
                }
            }
        });

        vista_resumen.fechaFinal.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("date")) {
                    mostrar("");
                }
            }
        });
    }

    private Date fecha_in() {
        Date fecha_in = new Date(vista_resumen.fechaInicial.getDate().getTime());
        return fecha_in;
    }

    private Date fecha_out() {
        Date fecha_out = new Date(vista_resumen.fechaFinal.getDate().getTime());
        return fecha_out;
    }

    protected void ocultar_columnas_ventas() {
        Integer[] cols = {6, 7};
        FUNCIONES.ocultar_columnas(cols, vista_resumen.tablaVentas);
        vista_resumen.tablaVentas.getColumnModel().getColumn(1).setPreferredWidth(150);
        vista_resumen.tablaVentas.getColumnModel().getColumn(2).setPreferredWidth(300);
    }

    protected void total_resumen() {
        double total_soles = 0.0;
        Double efectivo = 0.0;
        Double tarjeta = 0.0;
        for (int i = 0; i < vista_resumen.tablaVentas.getRowCount(); i++) {
            total_soles += Double.parseDouble(vista_resumen.tablaVentas.getValueAt(i, 3).toString());
            if (vista_resumen.tablaVentas.getValueAt(i, 4).equals("Efectivo")) {
                efectivo += Double.parseDouble(vista_resumen.tablaVentas.getValueAt(i, 3).toString());
            }
            if (vista_resumen.tablaVentas.getValueAt(i, 4).equals("Tarjeta")) {
                tarjeta += Double.parseDouble(vista_resumen.tablaVentas.getValueAt(i, 3).toString());
            }
        }

        vista_resumen.lblTotal_soles.setText(Common.aDecimal(total_soles));
        vista_resumen.lblTarjeta.setText(Common.aDecimal(tarjeta));
        vista_resumen.lblEfectivo.setText(Common.aDecimal(efectivo));
    }

    @Override
    public void borrar_item() {
        seleccionar_item();
        if (fila_ventas == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para borrar");
        } else {
            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar esta venta?") == 0) {

                if (daoResumen.eliminar(idventa)) {
                    ControladorPedido controladorPedido = new ControladorPedido();
                    //Actualizar estado de pedido a "Eliminado"
                    controladorPedido.actualizar_estado_pedido(-1, idventa, 4);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar la venta");
                }
                mostrar("");
            }
        }
    }

    @Override
    public void seleccionar_item() {
        fila_ventas = vista_resumen.tablaVentas.getSelectedRow();
        if (fila_ventas == -1) {
            idventa = -1;
        } else {
            idventa = Integer.parseInt(vista_resumen.tablaVentas.getValueAt(fila_ventas, 0).toString());
        }
    }

    //Dialogo editar venta
    @Override
    public void editar_item() {
        seleccionar_item();
        if (fila_ventas == -1) {
            JOptionPane.showMessageDialog(null, "No has seleccionado una venta");
        } else {
            try {
                Frame f = JOptionPane.getFrameForComponent(null);
                vista_editar = new Vista_ventas_editar(f, true, this, null);
                String[] datos = daoResumen.mostrar_detalle_datos(idventa);

                String numero = obtener_dato_de_tabla(0);
                String vendedor = datos[2];
                String preventa = datos[0];
                String cliente = obtener_dato_de_tabla(2);
                String tipo_pago = obtener_dato_de_tabla(4);
                String comprobante = obtener_dato_de_tabla(5);
                String num_doc = obtener_dato_de_tabla(8);
                idcliente = vista_resumen.tablaVentas.getValueAt(fila_ventas, 6) != null ? Integer.parseInt(vista_resumen.tablaVentas.getValueAt(fila_ventas, 6).toString()) : -1;
                mostrar_empleados();
                Common.configurar_calendario(vista_editar.fechaInicial);

                String fc = vista_resumen.tablaVentas.getValueAt(fila_ventas, 1).toString();
                String[] fecha = fc.split(" ");
                java.util.Date date = new SimpleDateFormat("d-M-yyyy hh:mm:ss").parse(fecha[0] + " " + fecha[1] + ":00 " + fecha[2]);
                vista_editar.fechaInicial.setDate(date);
                vista_editar.lblNumero.setText(numero);
                vista_editar.txtCliente.setText(cliente);
                vista_editar.cboEmpleado.setSelectedItem(vendedor);
                vista_editar.cboPago.setSelectedItem(tipo_pago);
                vista_editar.cboComprobante.setSelectedItem(comprobante);
                vista_editar.txtNumdoc.setText(num_doc);
                FUNCIONES.abrir_dialogo(vista_editar);

            } catch (HeadlessException e) {
                JOptionPane.showConfirmDialog(null, e);
            } catch (ParseException ex) {
                Logger.getLogger(ControladorVentasResumen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void agregar_cliente() {
        ControladorCliente controladorCliente = new ControladorCliente(this);
    }

    @Override
    public void agregar_cliente(DtoCliente entidad) {
        this.idcliente = entidad.getIdcliente();
        vista_editar.txtCliente.setText(entidad.getNombre());
    }

    public void guardar_cambios() {
        DtoResumen entidad = new DtoResumen();
        int idempleado = 0;
        int comprobante = 1;
        for (int i = 0; i < lista_empleados.size(); i++) {
            if (vista_editar.cboEmpleado.getSelectedItem().equals(lista_empleados.get(i).toString())) {
                idempleado = Integer.parseInt(lista_empleados.get(i - 1).toString());
            }
        }
        if (vista_editar.cboComprobante.getSelectedItem().equals("Factura")) {
            comprobante = 2;
        } else if (vista_editar.cboComprobante.getSelectedItem().equals("Ninguno")) {
            comprobante = 3;
        }
        entidad.setFecha(new Timestamp(vista_editar.fechaInicial.getDate().getTime()));
        entidad.setIdcliente(idcliente);
        entidad.setIdempleado(idempleado);
        entidad.setTipo_pago(vista_editar.cboPago.getSelectedIndex());
        entidad.setIdventa(Integer.parseInt(vista_editar.lblNumero.getText()));
        entidad.setComprobante(comprobante);
        entidad.setNum_comprobante(Integer.parseInt(vista_editar.txtNumdoc.getText()));

        if (daoResumen.editar(entidad)) {
            mostrar("");
            ocultar_columnas_ventas();
            total_resumen();
            fila_ventas = -1;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo editar la venta");
        }
    }

    private void mostrar_empleados() {
        controladorEmpleado = new ControladorEmpleado();
        lista_empleados = controladorEmpleado.obtener_lista_empleados(-1);
        for (int i = 0; i < lista_empleados.size(); i++) {
            if (i % 2 != 0) {
                vista_editar.cboEmpleado.addItem(lista_empleados.get(i).toString());
            }
        }

    }

//Diálogo ver detalle
    public void abrir_dialogo_detalle() {
        seleccionar_item();
        if (fila_ventas == -1) {
            JOptionPane.showMessageDialog(null, "No has seleccionado una venta");
        } else {
            try {
                Frame f = JOptionPane.getFrameForComponent(null);
                vista_detalle = new Vista_ventas_detalle(f, true, this, null);

                DefaultTableModel modelo;
                modelo = daoResumen.mostrar_detalle(idventa);
                String[] datos = daoResumen.mostrar_detalle_datos(idventa);
                vista_detalle.tablaDetalle.setModel(modelo);
                vista_detalle.lblNumero.setText("" + idventa);
                vista_detalle.txtPreventa.setText(datos[0]);
                vista_detalle.txtCaja.setText(datos[1]);
                vista_detalle.txtVenta.setText(datos[2]);
                ocultar_columnas_detalle();
                calcular_total(fila_ventas);
                obtener_direccion();
                FUNCIONES.abrir_dialogo(vista_detalle);

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private String obtener_dato_de_tabla(int col) {
        return vista_resumen.tablaVentas.getValueAt(fila_ventas, col) != null ? vista_resumen.tablaVentas.getValueAt(fila_ventas, col).toString() : "";
    }

    public void calcular_total(int fila) {
        double total = Double.parseDouble(vista_resumen.tablaVentas.getValueAt(fila, 3).toString());
        double subtotal;
        double igv;
        subtotal = total / 1.18;
        igv = total - subtotal;
        vista_detalle.lblTotal.setText(Common.aDecimal(total));
        vista_detalle.lblSubtotal.setText(Common.aDecimal(subtotal));
        vista_detalle.lblIgv.setText(Common.aDecimal(igv));
    }

    public String obtener_direccion() {
        return daoResumen.getDireccion(idventa);
    }

    public void setDireccion() {
        direccion = Vista_ventas_direccion.txtDescripcion.getText();
    }

    public void dialogo_cambiar_direccion() {
        Frame f = JOptionPane.getFrameForComponent(null);
        Vista_ventas_direccion vista_direccion = new Vista_ventas_direccion(f, true, this, null);

        FUNCIONES.abrir_dialogo(vista_direccion);
    }

    private void ocultar_columnas_detalle() {
        vista_detalle.tablaDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    public void imprimir_venta() {
        String comprobante;
        if (vista_detalle.cboComprobante.getSelectedItem().equals("Factura")) {
            comprobante = "Factura";
        } else if (vista_detalle.cboComprobante.getSelectedItem().equals("Guía")) {
            comprobante = "Guia";
        } else {
            comprobante = "Boleta";
        }
        Helper_numeroTexto numero_texto = new Helper_numeroTexto();
        String soles = numero_texto.convertirLetras(vista_detalle.lblTotal.getText(), true, "SOLES");

        DtoImpresion entidad = new DtoImpresion();
        entidad.setIdventa(idventa);
        entidad.setComprobante(comprobante);
        entidad.setSoles(soles);
        entidad.setDireccion(direccion);
        entidad.setPreview(false);
        entidad.setImprimir(true);
        entidad.setDialogo_impresion(false);
        new Helper_impresion(entidad).start();
    }

}
