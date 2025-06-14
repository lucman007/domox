package Controlador;

import comun.Interface_agregar_cliente;
import comun.Interface_main_functions;
import comun.Helper_numeroTexto;
import comun.Helper_impresion;
import comun.Common;
import Modelo.Dao.DaoPedido;
import Modelo.Dao.DaoVentas;
import Modelo.Dto.DtoCliente;
import Modelo.Dto.DtoImpresion;
import Modelo.Dto.DtoVenta;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_ventas;

/**
 *
 * @author Luciano Ces
 */
public class ControladorVentas implements Interface_agregar_cliente, Interface_main_functions {

    private int idcliente;
    private int idvendedor;
    private int idpreventa;
    private int idpedido;
    private int fila_pedido;
    private Vista_ventas vista_ventas;
    private DaoVentas daoVentas;
    private DefaultTableModel pedidos_model;

    public ControladorVentas() {

    }

    @Override
    public void iniciar() {
        this.vista_ventas = new Vista_ventas(this);
        this.daoVentas = new DaoVentas();
        FUNCIONES.abrir_ventana(vista_ventas);
        mostrar(null);
        ocultar_columnas_detalle();
        vista_ventas.panelComp.setVisible(false);
    }

    @Override
    public void mostrar(String texto) {
        //Mostrar pedidos pendientes
        try {
            pedidos_model = daoVentas.mostrar();
            vista_ventas.tablaPendientes.setModel(pedidos_model);
            ocultar_columnas_pedidos_pendientes();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void borrar_item() {
        //Anular venta pendiente
        seleccionar_item();
        if (fila_pedido != -1) {
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro de anular el pedido?") == 0) {
                DaoPedido daoPedido = new DaoPedido();
                daoPedido.actualizarEstado(idpedido, -1, 2);
                limpiar();
            }
        }
    }

    @Override
    public void editar_item() {
        //Editar venta pendiente
        seleccionar_item();
        if (fila_pedido == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un pedido para editar");
        } else {
            FUNCIONES.cerrar_ventana_previa("Vista_pedido");
            ControladorPedido controladorPedido = new ControladorPedido();
            controladorPedido.editar_pedido(idpedido);
            controladorPedido.actualizar_estado_pedido(idpedido, -1, 5);
        }
    }

    @Override
    public void seleccionar_item() {
        fila_pedido = vista_ventas.tablaPendientes.getSelectedRow();
        if (fila_pedido == -1) {
            idpedido = -1;
        } else {
            idpedido = Integer.parseInt(vista_ventas.tablaPendientes.getValueAt(fila_pedido, 0).toString());
        }
    }

    private void mostrar_detalle() {
        try {
            DefaultTableModel modelo;
            DaoPedido func = new DaoPedido();
            modelo = func.mostrar_detalle(idpedido);
            vista_ventas.tablaDetalle.setModel(modelo);
            ocultar_columnas_detalle();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void abrir_pedido() {
        seleccionar_item();
        idcliente = Integer.parseInt(vista_ventas.tablaPendientes.getValueAt(fila_pedido, 6).toString());
        idvendedor = Integer.parseInt(vista_ventas.tablaPendientes.getValueAt(fila_pedido, 7).toString());
        idpreventa = Integer.parseInt(vista_ventas.tablaPendientes.getValueAt(fila_pedido, 9).toString());

        String comprobante = (String) vista_ventas.tablaPendientes.getValueAt(fila_pedido, 5);
        String codigo = vista_ventas.tablaPendientes.getValueAt(fila_pedido, 8) == null ? "" : vista_ventas.tablaPendientes.getValueAt(fila_pedido, 8).toString();
        String cliente = vista_ventas.tablaPendientes.getValueAt(fila_pedido, 3) == null ? "" : vista_ventas.tablaPendientes.getValueAt(fila_pedido, 3).toString();

        vista_ventas.txtCodigo.setText(codigo);
        vista_ventas.txtCliente.setText(cliente);
        vista_ventas.cboPago.setSelectedIndex(0);
        vista_ventas.rdoBoleta.setSelected(true);
        vista_ventas.lblPedido.setText(String.valueOf(idpedido));
        vista_ventas.panelComp.setVisible(true);
        vista_ventas.panelComp.setBackground(new Color(0, 153, 153));
        vista_ventas.lblComp.setText(comprobante.toUpperCase());
        vista_ventas.txtPaga.setText("");
        vista_ventas.lblVuelto.setText("");

        if (comprobante.equalsIgnoreCase("Factura")) {
            vista_ventas.rdoFactura.setSelected(true);
            vista_ventas.panelComp.setBackground(new Color(255, 102, 51));
        }
        mostrar_detalle();
        calcular_total();
        habilitar_componentes();
    }

    private void habilitar_componentes() {
        vista_ventas.rdoBoleta.setEnabled(true);
        vista_ventas.rdoFactura.setEnabled(true);
        vista_ventas.rdoNinguno.setEnabled(true);
        vista_ventas.btnBorrar_cliente1.setEnabled(true);
        vista_ventas.btnEditar_cliente.setEnabled(true);
        vista_ventas.cboPago.setEnabled(true);
    }

    private void deshabilitar_componentes() {
        vista_ventas.rdoBoleta.setEnabled(false);
        vista_ventas.rdoFactura.setEnabled(false);
        vista_ventas.rdoNinguno.setEnabled(false);
        vista_ventas.btnBorrar_cliente1.setEnabled(false);
        vista_ventas.btnEditar_cliente.setEnabled(false);
        vista_ventas.cboPago.setEnabled(false);
    }

    private void ocultar_columnas_pedidos_pendientes() {
        Integer[] cols = {1, 6, 7, 8, 9};
        FUNCIONES.ocultar_columnas(cols, vista_ventas.tablaPendientes);
        vista_ventas.tablaPendientes.getColumnModel().getColumn(0).setPreferredWidth(70);
        vista_ventas.tablaPendientes.getColumnModel().getColumn(3).setPreferredWidth(250);

    }

    public void calcular_vuelto() {
        double paga = vista_ventas.txtPaga.getText().isEmpty() ? 0.0 : Double.parseDouble(vista_ventas.txtPaga.getText());
        double total = Double.parseDouble(vista_ventas.lblTotal_orden.getText());
        double vuelto = paga - total;
        vista_ventas.lblVuelto.setText(Common.aDecimal(vuelto));
    }

    private void ocultar_columnas_detalle() {
        Integer[] cols = {0};
        FUNCIONES.ocultar_columnas(cols, vista_ventas.tablaDetalle);
        vista_ventas.tablaDetalle.getColumnModel().getColumn(2).setPreferredWidth(280);
    }

    private void calcular_total() {

        double total = Double.parseDouble(vista_ventas.tablaPendientes.getValueAt(fila_pedido, 4).toString());
        double subtotal;
        double igv;
        subtotal = total / 1.18;
        igv = total - subtotal;
        vista_ventas.lblTotal_orden.setText(Common.aDecimal(total));
        vista_ventas.lblSubtotal.setText(Common.aDecimal(subtotal));
        vista_ventas.lblIgv.setText(Common.aDecimal(igv));

    }

    public void limpiar() {
        idpedido = -1;
        idcliente = -1;
        idpreventa = -1;
        mostrar_detalle();
        mostrar(null);
        vista_ventas.lblTotal_orden.setText("0.00");
        vista_ventas.lblSubtotal.setText("0.00");
        vista_ventas.lblIgv.setText("0.00");
        vista_ventas.txtCodigo.setText("");
        vista_ventas.txtCliente.setText("");
        vista_ventas.rdoBoleta.setSelected(true);
        vista_ventas.cboPago.setSelectedItem("Efectivo");
        vista_ventas.txtNum_comprobante.setText("");
        vista_ventas.txtPaga.setText("");
        vista_ventas.lblVuelto.setText("");
        vista_ventas.panelComp.setVisible(false);
        vista_ventas.lblPedido.setText("-");
        deshabilitar_componentes();
    }

    public void anular() {
        borrar_item();
    }

    public void borrar_cliente() {
        vista_ventas.txtCodigo.setText("");
        vista_ventas.txtCliente.setText("");
        idcliente = -1;
    }

    public void nuevo_pedido() {
        ControladorPedido controladorPedido = new ControladorPedido();
        controladorPedido.iniciar();
    }

    public void editar_pedido() {
        editar_item();
    }

    public void completar() {
        if (vista_ventas.tablaDetalle.getRowCount() != 0) {

            DtoVenta entidad = new DtoVenta();
            int comprobante = 1;
            int cantidad;
            int idproducto;
            Double monto;
            ArrayList items = new ArrayList();
            for (int i = 0; i < vista_ventas.tablaDetalle.getRowCount(); i++) {
                idproducto = Integer.parseInt(vista_ventas.tablaDetalle.getValueAt(i, 0).toString());
                cantidad = Integer.parseInt(vista_ventas.tablaDetalle.getValueAt(i, 4).toString());
                monto = Double.parseDouble(vista_ventas.tablaDetalle.getValueAt(i, 3).toString());
                items.add(idproducto);
                items.add(cantidad);
                items.add(monto);
            }
            if (vista_ventas.rdoFactura.isSelected()) {
                comprobante = 2;
            }
            if (vista_ventas.rdoNinguno.isSelected()) {
                comprobante = 3;
            }
            int seleccionado = vista_ventas.cboPago.getSelectedIndex();
            int num_comprobante = vista_ventas.txtNum_comprobante.getText().isEmpty() ? 0 : Integer.parseInt(vista_ventas.txtNum_comprobante.getText());
            entidad.setTipo_pago(seleccionado);
            entidad.setCajero(Common.idempleado);
            entidad.setComprobante(comprobante);
            entidad.setIdcliente(idcliente);
            entidad.setIdvendedor(idvendedor);
            entidad.setIdpreventa(idpreventa);
            entidad.setTotal_venta(Double.parseDouble(vista_ventas.lblTotal_orden.getText()));
            entidad.setItems(items);
            entidad.setNum_comprobante(num_comprobante);
            entidad.setNum_pedido(idpedido);
            entidad.setOculto(0);
            DaoPedido daoPedido = new DaoPedido();
            if (daoVentas.insertar(entidad)) {
                int idventa = daoVentas.getIdventa();
                //Actualizar estado a "Procesado" y guardar el id de venta
                daoPedido.actualizarEstado(idpedido, idventa, 1);
                String tipo_comprobante;
                Helper_numeroTexto num = new Helper_numeroTexto();
                String soles = num.convertirLetras(vista_ventas.lblTotal_orden.getText(), true, "SOLES");
                if (comprobante == 1) {
                    tipo_comprobante = "Boleta";
                } else {
                    tipo_comprobante = "Factura";
                }

                limpiar();
                if (comprobante != 3) {
                    DtoImpresion dts = new DtoImpresion();
                    dts.setIdventa(idventa);
                    dts.setComprobante(tipo_comprobante);
                    dts.setSoles(soles);
                    dts.setPreview(Common.PREVIEW_REPORT_VENTAS);
                    dts.setImprimir(Common.PRINT_VENTAS);
                    dts.setDialogo_impresion(Common.DIALOG_VENTAS);
                    new Helper_impresion(dts).start();
                }
                JOptionPane.showMessageDialog(null, "La venta se ingresó correctamente");

            } else {
                JOptionPane.showMessageDialog(null, "No se puede procesar la venta");
            }
        }
    }
//Diálogo agregar cliente

    public void dialogo_agregar_cliente() {
        ControladorCliente lc = new ControladorCliente(this);
    }

    @Override
    public void agregar_cliente(DtoCliente entidad) {
        this.idcliente = entidad.getIdcliente();
        vista_ventas.txtCodigo.setText(entidad.getCod_cliente());
        vista_ventas.txtCliente.setText(entidad.getNombre());
    }

}
