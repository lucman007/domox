package Controlador;

import comun.Interface_agregar_cliente;
import comun.Interface_main_functions;
import comun.Helper_impresion;
import comun.Common;
import Modelo.Dao.DaoPedido;
import Modelo.Dao.DaoProducto;
import Modelo.Dto.DtoCliente;
import Modelo.Dto.DtoImpresion;
import Modelo.Dto.DtoPedido;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_historial;
import Vista.Vista_historial_detalle;
import Vista.Vista_pedido_descuentos;
import Vista.Vista_pedido;

/**
 *
 * @author Luciano Ces
 */
public class ControladorPedido implements Interface_agregar_cliente, Interface_main_functions {

    private int fila_pedidos;
    private int fila_productos;
    private int fila_historial;
    private int idcliente;
    private int idproducto;
    private int idpedido;
    private int idpedido_historial;
    private String accion;
    private DefaultTableModel pedidos_model;
    private ArrayList<JLabel> labels;
    private ArrayList<JRadioButton> rdbuttons;
    private ArrayList<String> valores;
    private ArrayList lista_empleados;
    private Vista_pedido vista_pedido;
    private final DaoPedido daoPedido = new DaoPedido();
    private Vista_historial vista_historial;
    private Vista_historial_detalle vista_his_detalle;

    public ControladorPedido() {

    }

    @Override
    public void iniciar() {
        this.accion = "Insertar";
        this.idcliente = -1;
        this.vista_pedido = new Vista_pedido(this);
        this.pedidos_model = (DefaultTableModel) vista_pedido.tablaPedido.getModel();
        FUNCIONES.abrir_ventana(vista_pedido);
        ocultar_columnas_pedido();
        ocultar_columnas_productos();
        obtener_lista_preventas();
    }

    private void obtener_lista_preventas() {
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
        lista_empleados = controladorEmpleado.obtener_lista_empleados(4);
        for (int i = 0; i < lista_empleados.size(); i++) {
            if (i == 0) {
                vista_pedido.cboEmpleado.addItem("Ninguno");
            }
            if (i % 2 != 0) {
                vista_pedido.cboEmpleado.addItem(lista_empleados.get(i).toString());
            }
        }
    }

    @Override
    public void mostrar(String texto) {
        //Mostrar productos
        try {
            DefaultTableModel modelo;
            DaoProducto daoProducto = new DaoProducto();
            modelo = daoProducto.mostrar(texto, "limit 20");
            vista_pedido.tablaProductos.setModel(modelo);
            ocultar_columnas_productos();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    @Override
    public void editar_item() {
    }

    @Override
    public void seleccionar_item() {
        fila_pedidos = vista_pedido.tablaPedido.getSelectedRow();
        if (fila_pedidos == -1) {
            idproducto = -1;
        } else {
            idproducto = Integer.parseInt(vista_pedido.tablaPedido.getValueAt(fila_pedidos, 0).toString());
        }
    }

    private void ocultar_columnas_productos() {
        Integer[] cols = {0, 4, 7, 9, 10};
        FUNCIONES.ocultar_columnas(cols, vista_pedido.tablaProductos);
        vista_pedido.tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(300);
        vista_pedido.tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(300);

    }

    private void ocultar_columnas_pedido() {
        Integer[] cols = {0, 6, 7, 8};
        FUNCIONES.ocultar_columnas(cols, vista_pedido.tablaPedido);
        vista_pedido.tablaPedido.getColumnModel().getColumn(2).setPreferredWidth(280);
    }

    public void calcular() {
        int cantidad = vista_pedido.txtCantidad.getText().isEmpty() ? 0 : Integer.parseInt(vista_pedido.txtCantidad.getText());
        Double precio = vista_pedido.txtPrecio.getText().isEmpty() ? 0 : Double.parseDouble(vista_pedido.txtPrecio.getText());
        Double total = cantidad * precio;
        vista_pedido.tablaPedido.setValueAt(Common.aDecimal(precio), fila_pedidos, 3);
        vista_pedido.tablaPedido.setValueAt(cantidad, fila_pedidos, 4);
        vista_pedido.tablaPedido.setValueAt(Common.aDecimal(total), fila_pedidos, 5);
        calcular_total();
    }

    private void calcular_total() {
        double total = 0.0;
        double subtotal;
        double igv;
        for (int i = 0; i < vista_pedido.tablaPedido.getRowCount(); i++) {
            total += Double.parseDouble(vista_pedido.tablaPedido.getValueAt(i, 5).toString());
        }
        subtotal = total / 1.18;
        igv = total - subtotal;
        vista_pedido.lblTotal_orden.setText(Common.aDecimal(total));
        vista_pedido.lblSubtotal.setText(Common.aDecimal(subtotal));
        vista_pedido.lblIgv.setText(Common.aDecimal(igv));

    }

    public void buscar() {
        if (vista_pedido.txtBuscar_producto.getText().isEmpty()) {
            vista_pedido.tablaProductos.setVisible(false);
        } else {
            vista_pedido.tablaProductos.setVisible(true);
            mostrar(vista_pedido.txtBuscar_producto.getText());
        }
    }

    private void limpiar() {
        vista_pedido.lblTotal_orden.setText("0.00");
        vista_pedido.lblSubtotal.setText("0.00");
        vista_pedido.lblIgv.setText("0.00");
        vista_pedido.txtBuscar_producto.setText("");
        vista_pedido.txtBuscar_producto.requestFocus();
        vista_pedido.txtPrecio.setText("0.00");
        vista_pedido.txtCantidad.setText("0");
        vista_pedido.chkMayor.setEnabled(true);
        vista_pedido.chkMayor.setSelected(false);
        vista_pedido.lblCliente.setText("");
        vista_pedido.lblCodigo.setText("");
        vista_pedido.rdoBoleta.setSelected(true);
        vista_pedido.advertencia.setVisible(false);
        vista_pedido.btnDescuentos.setEnabled(false);
        vista_pedido.btnGenerar.setText("Generar pedido");
        vista_pedido.cboOperacion.setSelectedItem("Venta");
        vista_pedido.cboEmpleado.setSelectedItem("Ninguno");
        mostrar(null);
        pedidos_model = new DefaultTableModel(null, new String[]{"Idproducto", "Código", "Nombre", "Precio", "Cantidad", "Total", "Stock", "Stock_min", "Descuentos"});
        vista_pedido.tablaPedido.setModel(pedidos_model);
        ocultar_columnas_pedido();
        idcliente = -1;
        idpedido = -1;
        idpedido_historial = -1;
        accion = "Insertar";
    }

    public void anular_pedido() {
        if (idpedido != -1) {
            actualizar_estado_pedido(idpedido, -1, 2);
            limpiar();
        } else {
            limpiar();
        }
    }

    public void borrar_cliente() {
        vista_pedido.lblCodigo.setText("");
        vista_pedido.lblCliente.setText("");
        idcliente = -1;
    }

    public void verificar_stock(int cantidad_producto_agregado, Double precio_producto_agregado) {

        int stock = Integer.parseInt(vista_pedido.tablaProductos.getValueAt(fila_productos, 8).toString());
        if (cantidad_producto_agregado > stock) {
            vista_pedido.advertencia.setVisible(true);
            vista_pedido.advertencia.setBackground(Color.red);
            vista_pedido.lblAdvertencia.setForeground(Color.yellow);
            vista_pedido.lblAdvertencia.setText("Has superado el stock. Sólo tienes y puedes vender " + stock
                    + " unidades del producto.");
            vista_pedido.txtCantidad.setText(String.valueOf(stock));
            vista_pedido.txtPrecio.setText(String.valueOf(precio_producto_agregado));
            vista_pedido.tablaPedido.setValueAt(stock, fila_pedidos, 4);
            vista_pedido.tablaPedido.setValueAt(Common.aDecimal(stock * precio_producto_agregado), fila_pedidos, 5);
            calcular_total();
            return;
        }

        int stock_min = Integer.parseInt(vista_pedido.tablaProductos.getValueAt(fila_productos, 9).toString());

        if (cantidad_producto_agregado > (stock - stock_min)) {
            vista_pedido.advertencia.setVisible(true);
            vista_pedido.advertencia.setBackground(Color.orange);
            vista_pedido.lblAdvertencia.setForeground(Color.black);
            vista_pedido.lblAdvertencia.setText("¡El producto seleccionado está por agotarse!");
            return;
        }

        vista_pedido.advertencia.setVisible(false);
    }

    public void agregar() {
        reset();
        fila_productos = vista_pedido.tablaProductos.getSelectedRow();
        idproducto = Integer.parseInt(vista_pedido.tablaProductos.getValueAt(fila_productos, 0).toString());
        String cod_producto = (String) vista_pedido.tablaProductos.getValueAt(fila_productos, 1);
        String nombre = (String) vista_pedido.tablaProductos.getValueAt(fila_productos, 2);
        String descuento = String.valueOf(vista_pedido.tablaProductos.getValueAt(fila_productos, 6));
        int stock = Integer.parseInt(vista_pedido.tablaProductos.getValueAt(fila_productos, 8).toString());
        int stock_min = Integer.parseInt(vista_pedido.tablaProductos.getValueAt(fila_productos, 9).toString());
        Double precio;
        if (vista_pedido.chkMayor.isSelected()) {
            precio = vista_pedido.tablaProductos.getValueAt(fila_productos, 6) == null ? Double.parseDouble(vista_pedido.tablaProductos.getValueAt(fila_productos, 5)
                    .toString()) : Double.parseDouble(vista_pedido.tablaProductos.getValueAt(fila_productos, 6).toString());
        } else {
            precio = Double.parseDouble(vista_pedido.tablaProductos.getValueAt(fila_productos, 5).toString());
        }

        if (stock <= 0) {
            JOptionPane.showMessageDialog(null, "El producto está fuera de stock.\n"
                    + "No podrás venderlo hasta que verifiques tus existencias.");
        } else {
            int cantidad = 1;
            String precio_total;
            int valor;
            //Verificamos si producto ya está agregado para sólo incrementar cantidad
            for (int i = 0; i < vista_pedido.tablaPedido.getRowCount(); i++) {
                valor = Integer.parseInt(vista_pedido.tablaPedido.getValueAt(i, 0).toString());
                if (idproducto == valor) {
                    fila_pedidos = i;
                    cantidad = Integer.parseInt(vista_pedido.tablaPedido.getValueAt(i, 4).toString());
                    precio = Double.parseDouble(vista_pedido.tablaPedido.getValueAt(i, 3).toString());
                    cantidad += 1;
                    precio_total = Common.aDecimal(precio * cantidad);
                    vista_pedido.tablaPedido.setValueAt(cantidad, i, 4);
                    vista_pedido.tablaPedido.setValueAt(precio_total, i, 5);
                    calcular_total();
                    verificar_stock(cantidad, precio);
                    return;
                }
            }

            if (vista_pedido.tablaPedido.getRowCount() >= 11) {
                JOptionPane.showMessageDialog(null, "Sólo puedes agregar 11 productos.\n"
                        + "Crea un nuevo pedido.");
                return;
            }

            precio_total = Common.aDecimal(precio);
            String[] registro = new String[9];
            registro[0] = String.valueOf(idproducto);
            registro[1] = cod_producto;
            registro[2] = nombre;
            registro[3] = String.valueOf(precio_total);
            registro[4] = String.valueOf(cantidad);
            registro[5] = String.valueOf(precio_total);
            registro[6] = String.valueOf(stock);
            registro[7] = String.valueOf(stock_min);
            registro[8] = descuento;
            pedidos_model.insertRow(0, registro);
            vista_pedido.tablaPedido.setModel(pedidos_model);
            ocultar_columnas_pedido();
            calcular_total();
        }
    }

    public void generar_pedido() {
        if (vista_pedido.cboOperacion.getSelectedItem().equals("Muestras")) {
            insertar(3);
        } else {
            insertar(0);
            int idpedido_generado = daoPedido.getIdpedido();

            if (Vista_pedido.chkImpresion_rapida.isSelected()) {
                DtoImpresion entidad = new DtoImpresion();
                entidad.setIdventa(idpedido_generado);
                entidad.setComprobante("Ticket");
                entidad.setPreview(false);
                entidad.setImprimir(true);
                entidad.setDialogo_impresion(false);
                new Helper_impresion(entidad).start();
            }
        }
    }

    private void insertar(int estado) {
        if (vista_pedido.tablaPedido.getRowCount() != 0) {

            DtoPedido entidad = new DtoPedido();
            int comprobante = 1;
            int cantidad;
            Double monto;
            int idproducto_agregado;
            ArrayList items = new ArrayList();
            for (int i = 0; i < vista_pedido.tablaPedido.getRowCount(); i++) {
                idproducto_agregado = Integer.parseInt(vista_pedido.tablaPedido.getValueAt(i, 0).toString());
                cantidad = Integer.parseInt(vista_pedido.tablaPedido.getValueAt(i, 4).toString());
                monto = Double.parseDouble(vista_pedido.tablaPedido.getValueAt(i, 3).toString());
                items.add(idproducto_agregado);
                items.add(cantidad);
                items.add(monto);
            }

            if (vista_pedido.rdoFactura.isSelected()) {
                comprobante = 2;
            }

            int idpreventa = -1;
            for (int i = 0; i < lista_empleados.size(); i++) {
                if (vista_pedido.cboEmpleado.getSelectedItem().equals(lista_empleados.get(i).toString())) {
                    idpreventa = Integer.parseInt(lista_empleados.get(i - 1).toString());
                }
            }
            entidad.setComprobante(comprobante);
            entidad.setIdcliente(idcliente);
            entidad.setIdvendedor(Common.idempleado);
            entidad.setTotal_venta(Double.parseDouble(vista_pedido.lblTotal_orden.getText()));
            entidad.setItems(items);
            entidad.setEstado(estado);
            entidad.setIdpedido(idpedido);
            entidad.setIdpreventa(idpreventa);

            switch (accion) {
                case "Insertar":
                    if (daoPedido.insertar(entidad)) {
                        String[] datos = daoPedido.info_pedido();
                        String cmp = datos[2].equals(1) ? "BOLETA" : "FACTURA";
                        JOptionPane.showMessageDialog(null, "N° PEDIDO: " + datos[0] + " \r\nIMPORTE: S/."
                                + datos[1] + " \r\n" + cmp);
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo generar el pedido");
                    }
                    break;
                case "Editar":
                    if (daoPedido.editar(entidad)) {
                        JOptionPane.showMessageDialog(null, "El pedido N° " + idpedido + " se editó correctamente");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo editar el pedido");
                    }
                    break;
                case "Editar_muestras":
                    if (daoPedido.editar(entidad)) {
                        JOptionPane.showMessageDialog(null, "Se registraron correctamente las muestras");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo editar");
                    }
                    break;

            }
        }
    }

    public void editar_pedido(int idpedido) {
        iniciar();
        pedidos_model = daoPedido.abrir_pedido_detalle(idpedido);
        String[] datos = daoPedido.abrir_pedido(idpedido);
        this.accion = "Editar";
        this.idpedido = idpedido;
        this.idcliente = datos[0] == null ? -1 : Integer.parseInt(datos[0]);
        vista_pedido.lblCodigo.setText(datos[2] == null ? "" : datos[2]);
        vista_pedido.lblCliente.setText(datos[3] == null ? "" : datos[3]);
        vista_pedido.tablaPedido.setModel(pedidos_model);
        vista_pedido.btnGenerar.setText("Editar pedido");
        if (datos[1].equals("2")) {
            vista_pedido.rdoFactura.setSelected(true);
        }
        //reset(); falta crear campo por mayor para poder setear si es venta por mayor al editar un pedido
        calcular_total();
        ocultar_columnas_pedido();
        actualizar_estado_pedido(idpedido, -1, 5);
    }

    @Override
    public void borrar_item() {
        seleccionar_item();
        if (fila_pedidos == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para eliminar");
        } else {
            if (vista_pedido.tablaPedido.getRowCount() == 1) {
                limpiar();
            } else {
                pedidos_model.removeRow(fila_pedidos);
                calcular_total();
                fila_pedidos = -1;
            }

        }
    }

    public void seleccionar_producto_agregado() {
        seleccionar_item();
        vista_pedido.txtCantidad.setEnabled(true);
        vista_pedido.txtPrecio.setEnabled(true);
        vista_pedido.txtCantidad.setText(String.valueOf(vista_pedido.tablaPedido.getValueAt(fila_pedidos, 4)));
        vista_pedido.txtPrecio.setText(String.valueOf(vista_pedido.tablaPedido.getValueAt(fila_pedidos, 3)));
        vista_pedido.txtCantidad.requestFocus();
        vista_pedido.txtCantidad.selectAll();
        vista_pedido.tablaProductos.clearSelection();
        vista_pedido.advertencia.setVisible(false);
        if (String.valueOf(vista_pedido.tablaPedido.getValueAt(fila_pedidos, 8)).equals("null")) {
            vista_pedido.btnDescuentos.setEnabled(false);
        } else {
            vista_pedido.btnDescuentos.setEnabled(true);
        }
    }

    public void reset() {
        vista_pedido.tablaPedido.clearSelection();
        vista_pedido.txtCantidad.setText("0");
        vista_pedido.txtPrecio.setText("0.00");
        vista_pedido.txtCantidad.setEnabled(false);
        vista_pedido.txtPrecio.setEnabled(false);
        vista_pedido.chkMayor.setEnabled(false);
        vista_pedido.btnDescuentos.setEnabled(false);
    }

    public void actualizar_estado_pedido(int idpedido_seleccionado, int idventa_seleccionada, int estado) {
        daoPedido.actualizarEstado(idpedido_seleccionado, idventa_seleccionada, estado);
    }

//Diálogo descuentos
    public void dialogo_descuentos() {
        if (fila_pedidos == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para aplicar un descuento");
        } else {
            Frame f = JOptionPane.getFrameForComponent(null);
            Vista_pedido_descuentos descuentos = new Vista_pedido_descuentos(f, true, this);
            mostrar_descuentos();
            FUNCIONES.abrir_dialogo(descuentos);
        }
    }

    private void mostrar_descuentos() {
        labels = new ArrayList();
        rdbuttons = new ArrayList();
        valores = new ArrayList();
        DaoProducto func = new DaoProducto();
        String[][] descuentos = func.mostrar_descuento(idproducto);
        int i = 0;
        int y = 20;
        for (String[] descuento : descuentos) {
            for (int j = 0; j < 2; j++) {

                if (descuento[j] != null) {
                    if (j == 0) {
                        labels.add(new JLabel());
                        labels.get(i).setText("Más de " + descuento[j] + " unidades: ");
                        labels.get(i).setVisible(true);
                        labels.get(i).setSize(150, 45);
                        labels.get(i).setLocation(50, y);
                        labels.get(i).setForeground(new java.awt.Color(255, 255, 255));
                        Vista_pedido_descuentos.panel.add(labels.get(i));
                    } else {
                        rdbuttons.add(new JRadioButton());
                        rdbuttons.get(i).setText(descuento[j]);
                        rdbuttons.get(i).setVisible(true);
                        rdbuttons.get(i).setSize(150, 45);
                        rdbuttons.get(i).setLocation(200, y);
                        rdbuttons.get(i).setForeground(new java.awt.Color(255, 255, 255));
                        Vista_pedido_descuentos.btnGroup.add(rdbuttons.get(i));
                        Vista_pedido_descuentos.panel.add(rdbuttons.get(i));
                        valores.add(descuento[j]);
                    }
                }

            }
            i++;
            y += 40;
        }
    }

    public void aplicar_descuentos() {
        for (int i = 0; i < 12; i++) {
            if (rdbuttons.get(i).isSelected()) {
                Double cantidad = Double.parseDouble(vista_pedido.tablaPedido.getValueAt(fila_pedidos, 4).toString());
                Double precio = Double.parseDouble(valores.get(i));
                Double total = cantidad * precio;
                vista_pedido.tablaPedido.setValueAt(Common.aDecimal(precio), fila_pedidos, 3);
                vista_pedido.tablaPedido.setValueAt(Common.aDecimal(total), fila_pedidos, 5);
                vista_pedido.txtPrecio.setText(Common.aDecimal(precio));
                calcular_total();
                return;
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
        vista_pedido.lblCodigo.setText(entidad.getCod_cliente());
        vista_pedido.lblCliente.setText(entidad.getNombre());
    }

//Metodos para historial
    public void iniciar_historial() {
        this.vista_historial = new Vista_historial(this);
        FUNCIONES.abrir_ventana(vista_historial);
        mostrar_historial();
    }

    public void seleccionar_item_historial() {
        fila_historial = vista_historial.tablaHistorial.getSelectedRow();
        idpedido_historial = Integer.parseInt(vista_historial.tablaHistorial.getValueAt(fila_historial, 0).toString());
    }

    private void mostrar_historial() {

        try {
            DefaultTableModel modelo;
            modelo = daoPedido.mostrar_historial();
            vista_historial.tablaHistorial.setModel(modelo);
            ocultar_columnas_historial();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    private void ocultar_columnas_historial() {
        Integer[] cols = {6, 7, 9, 10};
        FUNCIONES.ocultar_columnas(cols, vista_historial.tablaHistorial);
        vista_historial.tablaHistorial.getColumnModel().getColumn(0).setPreferredWidth(80);
        vista_historial.tablaHistorial.getColumnModel().getColumn(1).setPreferredWidth(140);
        vista_historial.tablaHistorial.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    public void imprimir_historial(String tipo_documento) {
        DtoImpresion entidad = new DtoImpresion();
        if (tipo_documento.equals("Historial")) {
            if (JOptionPane.showConfirmDialog(null, "¿Seguro de imprimir el historial? Recuerda el ahorro de papel") == 0) {
                entidad.setComprobante("Historial");
                entidad.setPreview(true);
                entidad.setImprimir(true);
                entidad.setDialogo_impresion(true);
            }
        } else {
            if (fila_historial != -1) {
                int idpedido_historial = Integer.parseInt(vista_historial.tablaHistorial.getValueAt(fila_historial, 0).toString());
                entidad.setIdventa(idpedido_historial);
                entidad.setComprobante("Ticket");
                entidad.setPreview(Common.PREVIEW_REPORT_PEDIDOS);
                entidad.setImprimir(Common.PRINT_PEDIDOS);
                entidad.setDialogo_impresion(Common.DIALOG_PEDIDOS);
            }

        }
        new Helper_impresion(entidad).start();
    }

    public void ver_detalle_historial() {
        if (fila_historial == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item");
        } else {
            try {
                Frame f = JOptionPane.getFrameForComponent(null);
                vista_his_detalle = new Vista_historial_detalle(f, true);
                DefaultTableModel modelo;
                modelo = daoPedido.mostrar_detalle(idpedido_historial);
                vista_his_detalle.tablaDetalle.setModel(modelo);
                vista_his_detalle.lblNumero.setText(String.valueOf(idpedido_historial));
                ocultar_columnas_historial_detalle();
                FUNCIONES.abrir_dialogo(vista_his_detalle);

            } catch (HeadlessException e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        }
    }

    public void editar_pedido_historial() {
        if (fila_historial == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un pedido para editar");
        } else {
            FUNCIONES.cerrar_ventana_previa("Vista_pedido");
            editar_pedido(idpedido_historial);
            vista_historial.dispose();
        }
    }

    private void ocultar_columnas_historial_detalle() {
        Integer[] cols = {0};
        FUNCIONES.ocultar_columnas(cols, vista_his_detalle.tablaDetalle);
        vista_his_detalle.tablaDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    public void habilitar_edicion() {
        if (vista_historial.tablaHistorial.getValueAt(fila_historial, 8).equals("En cola")) {
            vista_historial.btnEditar.setEnabled(true);
        } else {
            vista_historial.btnEditar.setEnabled(false);
        }
    }

    //Obtener las muestras registradas
    public DefaultTableModel ver_muestras() {
        return daoPedido.obtener_muestras();
    }

    public DefaultTableModel mostrar_detalle_muestras(int idmuestra) {
        return daoPedido.mostrar_detalle(idmuestra);
    }
}
