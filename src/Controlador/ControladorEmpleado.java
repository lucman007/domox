package Controlador;

import comun.Interface_main_functions;
import Modelo.Dao.DaoEmpleado;
import Modelo.Dto.DtoEmpleado;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_empleado_agregar;
import Vista.Vista_empleado;

/**
 *
 * @author Li
 */
public class ControladorEmpleado implements Interface_main_functions {

    private final DaoEmpleado daoEmpleado = new DaoEmpleado();
    private Vista_empleado vista_empleados;
    private Vista_empleado_agregar empleado_agregar;
    private int fila_empleado;
    private int idempleado;
    private String accion;
    private String nombre_usuario_seleccionado;

    public ControladorEmpleado() {

    }

    @Override
    public void iniciar() {
        this.vista_empleados = new Vista_empleado(this);
        FUNCIONES.abrir_ventana(vista_empleados);
        mostrar("");
    }

    @Override
    public void mostrar(String texto) {
        try {
            DefaultTableModel modelo;
            modelo = daoEmpleado.mostrar(texto);
            vista_empleados.tablaEmpleado.setModel(modelo);
            ocultar_columnas_empleados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void borrar_item() {
        seleccionar_item();
        if (fila_empleado == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para borrar");
        } else {
            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este trabajador?") == 0) {
                if (!daoEmpleado.eliminar(idempleado)) {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar, inténtalo de nuevo");
                }
                mostrar("");
            }
        }
    }

    @Override
    public void seleccionar_item() {
        fila_empleado = vista_empleados.tablaEmpleado.getSelectedRow();
        if (fila_empleado == -1) {
            idempleado = -1;
        } else {
            idempleado = Integer.parseInt(vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 0).toString());
        }
    }

    private void ocultar_columnas_empleados() {
        Integer[] cols = {0, 7, 8};
        FUNCIONES.ocultar_columnas(cols, vista_empleados.tablaEmpleado);
        vista_empleados.tablaEmpleado.getColumnModel().getColumn(8).setPreferredWidth(0);
    }

    public ArrayList obtener_lista_empleados(int cargo) {
        ArrayList empleados = daoEmpleado.lista_empleados(cargo);
        return empleados;
    }

    // Abrir diálogo nuevo empleado:
    public void dialogo_nuevo_empleado() {
        accion = "insertar";
        Frame f = JOptionPane.getFrameForComponent(null);
        empleado_agregar = new Vista_empleado_agregar(f, true, this);
        FUNCIONES.abrir_dialogo(empleado_agregar);
    }

    public boolean guardar_empleado() {
        DtoEmpleado entidad = new DtoEmpleado();
        if (empleado_agregar.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa el nombre del trabajador");
            empleado_agregar.txtNombre.requestFocus();
            return false;

        }
        if (empleado_agregar.txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un usuario");
            empleado_agregar.txtUsuario.requestFocus();
            return false;

        }
        if (empleado_agregar.txtClave.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Ingresa una contraseña");
            empleado_agregar.txtClave.requestFocus();
            return false;

        }

        entidad.setNombre(empleado_agregar.txtNombre.getText());
        entidad.setApellidos(empleado_agregar.txtApellidos.getText());
        entidad.setCiudad(empleado_agregar.txtCiudad.getText());
        entidad.setCorreo(empleado_agregar.txtCorreo.getText());
        entidad.setDireccion(empleado_agregar.txtDireccion.getText());
        entidad.setTelefono(empleado_agregar.txtTelefono.getText());
        entidad.setEliminado(0);
        entidad.setUsuario(empleado_agregar.txtUsuario.getText());
        entidad.setClave(String.valueOf(empleado_agregar.txtClave.getPassword()));
        entidad.setAcceso(empleado_agregar.cboAcceso.getSelectedIndex());
        entidad.setEliminado(0);

        if (accion.equals("insertar")) {
            if (daoEmpleado.existe_usuario(empleado_agregar.txtUsuario.getText())) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe, elija otro");
                empleado_agregar.txtUsuario.requestFocus();
                return false;
            }
            if (!daoEmpleado.insertar(entidad)) {
                JOptionPane.showMessageDialog(null, "No se pudo registrar el empleado");
                return true;
            }
        } else if (accion.equals("editar")) {
            if (daoEmpleado.existe_usuario(empleado_agregar.txtUsuario.getText()) && !nombre_usuario_seleccionado.equalsIgnoreCase(empleado_agregar.txtUsuario.getText())) {
                JOptionPane.showMessageDialog(null, "El usuario ya existe, elija otro");
                empleado_agregar.txtUsuario.requestFocus();
                return false;
            }
            entidad.setIdpersona(idempleado);
            if (!daoEmpleado.editar(entidad)) {
                JOptionPane.showMessageDialog(null, "No se pudo editar el empleado");
                return true;
            }
        }
        mostrar(vista_empleados.txtBuscar.getText());
        ocultar_columnas_empleados();
        return true;

    }

    @Override
    public void editar_item() {
        seleccionar_item();
        accion = "editar";
        if (fila_empleado == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item para editar");
        } else {

            Frame f = JOptionPane.getFrameForComponent(null);
            empleado_agregar = new Vista_empleado_agregar(f, true, this);

            String nombre = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 1);
            String apellidos = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 2);
            String direccion = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 3);
            String ciudad = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 4);
            String telefono = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 5);
            String correo = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 6);
            String usuario = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 7);
            String pass = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 8);
            String acceso = (String) vista_empleados.tablaEmpleado.getValueAt(fila_empleado, 9);

            empleado_agregar.txtApellidos.setText(apellidos);
            empleado_agregar.txtNombre.setText(nombre);
            empleado_agregar.txtDireccion.setText(direccion);
            empleado_agregar.txtCiudad.setText(ciudad);
            empleado_agregar.txtTelefono.setText(telefono);
            empleado_agregar.txtCorreo.setText(correo);
            empleado_agregar.txtUsuario.setText(usuario);
            empleado_agregar.txtClave.setText(pass);
            empleado_agregar.cboAcceso.setSelectedItem(acceso);
            nombre_usuario_seleccionado = usuario;
            FUNCIONES.abrir_dialogo(empleado_agregar);

        }
    }

    public String getEmpleado(int idempleado) {
        return daoEmpleado.getEmpleado(idempleado);
    }
}
