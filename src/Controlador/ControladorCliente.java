package Controlador;

import comun.Interface_agregar_cliente;
import comun.Interface_main_functions;
import Modelo.Dao.DaoCliente;
import Modelo.Dto.DtoCliente;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_cliente_agregar;
import Vista.Vista_cliente;
import Vista.Vista_cliente_nuevo;

/**
 *
 * @author Luciano Ces
 */
public class ControladorCliente implements Interface_main_functions {

    private String accion;
    private String codcliente;
    private String formulario_origen;
    private int fila_clientes;
    private int idcliente;
    private Vista_cliente vista_cliente;
    private Vista_cliente_nuevo nuevo_cliente;
    private Vista_cliente_agregar agregar_cliente;
    private final DaoCliente datos_cliente = new DaoCliente();
    private Interface_agregar_cliente i_agregar_cliente;

    public ControladorCliente() {

    }

    public ControladorCliente(Interface_agregar_cliente ia) {
        i_agregar_cliente = ia;
        dialogo_agregar_cliente();
    }

    @Override
    public void iniciar() {
        this.vista_cliente = new Vista_cliente(this);
        FUNCIONES.abrir_ventana(vista_cliente);
        mostrar("");
    }

    @Override
    public void mostrar(String texto) {
        try {
            DefaultTableModel modelo;
            modelo = datos_cliente.mostrar(texto);
            vista_cliente.tablaClientes.setModel(modelo);
            ocultar_columnas_cliente();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void borrar_item() {
        seleccionar_item();
        if (fila_clientes == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para borrar");
        } else {

            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este cliente?") == 0) {
                if (!datos_cliente.eliminar(idcliente)) {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar, inténtalo de nuevo");
                }
                mostrar("");
            }
        }
    }

    @Override
    public void editar_item() {
        seleccionar_item();
        if (fila_clientes == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para editar");
        } else {

            Frame f = JOptionPane.getFrameForComponent(null);
            nuevo_cliente = new Vista_cliente_nuevo(f, true, this);
            String cod_cliente = (String) vista_cliente.tablaClientes.getValueAt(fila_clientes, 1);
            String nombre = (String) vista_cliente.tablaClientes.getValueAt(fila_clientes, 2);
            String ruc = (String) vista_cliente.tablaClientes.getValueAt(fila_clientes, 3);
            String direccion = (String) vista_cliente.tablaClientes.getValueAt(fila_clientes, 4);
            String telefono = (String) vista_cliente.tablaClientes.getValueAt(fila_clientes, 5);
            accion = "editar";
            codcliente = cod_cliente;
            nuevo_cliente.txtCod_cliente.setText(cod_cliente);
            nuevo_cliente.txtNombre.setText(nombre);
            nuevo_cliente.txtDireccion.setText(direccion);
            nuevo_cliente.txtRuc.setText(ruc);
            nuevo_cliente.txtTelefono.setText(telefono);
            FUNCIONES.abrir_dialogo(nuevo_cliente);
        }
    }

    @Override
    public void seleccionar_item() {
        fila_clientes = vista_cliente.tablaClientes.getSelectedRow();
        if (fila_clientes == -1) {
            idcliente = -1;
        } else {
            idcliente = Integer.parseInt(vista_cliente.tablaClientes.getValueAt(fila_clientes, 0).toString());
        }
    }

    public void ocultar_columnas_cliente() {
        Integer[] cols = {0};
        FUNCIONES.ocultar_columnas(cols, vista_cliente.tablaClientes);
    }

    //Diálogo nuevo cliente
    public void dialogo_nuevo_cliente(String formulario_origen) {
        this.formulario_origen = formulario_origen;
        accion = "insertar";
        Frame f = JOptionPane.getFrameForComponent(null);
        nuevo_cliente = new Vista_cliente_nuevo(f, true, this);
        generar_codigo();
        FUNCIONES.abrir_dialogo(nuevo_cliente);
    }

    private void generar_codigo() {
        DaoCliente func = new DaoCliente();
        String codigo = func.getCodigo();
        nuevo_cliente.txtCod_cliente.setText(codigo);
    }

    public boolean guardar_cliente_nuevo() {
        DtoCliente datos = new DtoCliente();
        if (nuevo_cliente.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa el nombre o razón social del cliente");
            nuevo_cliente.txtNombre.requestFocus();
            return false;
        }

        datos.setNombre(nuevo_cliente.txtNombre.getText());
        datos.setCod_cliente(nuevo_cliente.txtCod_cliente.getText());
        datos.setCorreo(nuevo_cliente.txtCorreo.getText());
        datos.setDireccion(nuevo_cliente.txtDireccion.getText());
        datos.setNum_ruc(nuevo_cliente.txtRuc.getText());
        datos.setTelefono(nuevo_cliente.txtTelefono.getText());
        datos.setEliminado(0);

        if (accion.equals("insertar")) {
            if (datos_cliente.existe_codigo(nuevo_cliente.txtCod_cliente.getText()) && !nuevo_cliente.txtCod_cliente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El código ya existe, intenta con otro");
                nuevo_cliente.txtCod_cliente.requestFocus();
                return false;
            }
            if (datos_cliente.existe_ruc(nuevo_cliente.txtRuc.getText()) && !nuevo_cliente.txtRuc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El cliente ya existe en la base de datos");
                nuevo_cliente.txtRuc.requestFocus();
                return false;
            }
            if (!datos_cliente.insertar(datos)) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el producto");
                return true;
            }
        } else if (accion.equals("editar")) {
            if (datos_cliente.existe_codigo(nuevo_cliente.txtCod_cliente.getText()) && !codcliente.equalsIgnoreCase(nuevo_cliente.txtCod_cliente.getText())) {
                JOptionPane.showMessageDialog(null, "El código ya existe, intenta con otro");
                nuevo_cliente.txtCod_cliente.requestFocus();
                return false;
            }
            datos.setIdpersona(idcliente);
            if (!datos_cliente.editar(datos)) {
                JOptionPane.showMessageDialog(null, "No se pudo editar el producto");
                return true;
            }
        }
        if (formulario_origen.equals("Vista_cliente")) {
            mostrar(vista_cliente.txtBuscar.getText());
            ocultar_columnas_cliente();
        } else {
            mostrar_clientes_dialogo("");
            ocultar_columnas_dialogo_clientes();
        }
        return true;
    }

// Diálogo agregar cliente
    private void dialogo_agregar_cliente() {
        Frame f = JOptionPane.getFrameForComponent(null);
        agregar_cliente = new Vista_cliente_agregar(f, true, this);
        mostrar_clientes_dialogo("");
        FUNCIONES.abrir_dialogo(agregar_cliente);
    }

    public void agregar() {
        int fila = agregar_cliente.tablaClientes.getSelectedRow();
        Integer idcliente = Integer.parseInt(agregar_cliente.tablaClientes.getValueAt(fila, 0).toString());
        String codigo = agregar_cliente.tablaClientes.getValueAt(fila, 1).toString();
        String cliente = agregar_cliente.tablaClientes.getValueAt(fila, 2).toString();

        DtoCliente entidad = new DtoCliente();
        entidad.setIdcliente(idcliente);
        entidad.setCod_cliente(codigo);
        entidad.setNombre(cliente);
        i_agregar_cliente.agregar_cliente(entidad);

    }

    private void ocultar_columnas_dialogo_clientes() {
        Integer[] cols = {0};
        FUNCIONES.ocultar_columnas(cols, agregar_cliente.tablaClientes);
    }

    public void mostrar_clientes_dialogo(String buscar) {

        try {
            DefaultTableModel modelo;
            DaoCliente func = new DaoCliente();
            modelo = func.mostrar(buscar);
            agregar_cliente.tablaClientes.setModel(modelo);
            ocultar_columnas_dialogo_clientes();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
