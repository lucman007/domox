package Controlador;

import comun.Interface_main_functions;
import comun.Common;
import Modelo.Dao.DaoEgresos;
import Modelo.Dto.DtoEgresos;
import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_ventas_egresos;

/**
 *
 * @author Luciano Ces
 */
public class ControladorVentasEgresos implements Interface_main_functions {

    private final DaoEgresos datos_egresos = new DaoEgresos();
    private Vista_ventas_egresos vista_egresos;
    private ArrayList lista_empleados;
    private int fila_egresos;
    private int idegreso;

    public ControladorVentasEgresos() {

    }

    @Override
    public void iniciar() {
        abrir_dialogo_egresos();
    }

    @Override
    public void mostrar(String texto) {
        try {
            DefaultTableModel modelo;
            boolean[] filtro = {vista_egresos.chkEgreso.isSelected(), vista_egresos.chkIngreso.isSelected()};
            modelo = datos_egresos.mostrar(fecha_in(), fecha_out(), filtro);
            vista_egresos.tablaGastos.setModel(modelo);
            ocultar_columnas_egresos();
            total_resumen();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void borrar_item() {
        seleccionar_item();
        if (fila_egresos == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un item");
        } else {
            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?") == 0) {
                if (!datos_egresos.eliminar(idegreso)) {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                }
                mostrar(null);
            }
        }

    }

    @Override
    public void editar_item() {
    }

    @Override
    public void seleccionar_item() {
        fila_egresos = vista_egresos.tablaGastos.getSelectedRow();
        if (fila_egresos == -1) {
            idegreso = -1;
        } else {
            idegreso = Integer.parseInt(vista_egresos.tablaGastos.getValueAt(fila_egresos, 0).toString());
        }
    }

    private void abrir_dialogo_egresos() {
        Frame f = JOptionPane.getFrameForComponent(null);
        vista_egresos = new Vista_ventas_egresos(f, true, this);
        iniciar_dateChooser();
        mostrar(null);
        ocultar_columnas_egresos();
        mostrar_empleados();
        seleccionar_item();
        FUNCIONES.abrir_dialogo(vista_egresos);
    }

    private void total_resumen() {
        Double egresos = 0.0;
        Double ingresos = 0.0;
        for (int i = 0; i < vista_egresos.tablaGastos.getRowCount(); i++) {
            if (vista_egresos.tablaGastos.getValueAt(i, 3).equals("Egreso")) {
                egresos += Double.parseDouble(vista_egresos.tablaGastos.getValueAt(i, 5).toString());
            }
            if (vista_egresos.tablaGastos.getValueAt(i, 3).equals("Ingreso")) {
                ingresos += Double.parseDouble(vista_egresos.tablaGastos.getValueAt(i, 5).toString());
            }
        }

        vista_egresos.lblIngresos.setText(Common.aDecimal(ingresos));
        vista_egresos.lblEgresos.setText(Common.aDecimal(egresos));
    }

    private void iniciar_dateChooser() {
        Common.configurar_calendario(vista_egresos.fechaInicial);
        Common.configurar_calendario(vista_egresos.fechaFinal);

        vista_egresos.fechaInicial.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("date")) {
                    mostrar(null);
                }
            }
        });

        vista_egresos.fechaFinal.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("date")) {
                    mostrar(null);
                }
            }
        });
    }

    private Date fecha_in() {
        Date fecha_in = new Date(vista_egresos.fechaInicial.getDate().getTime());
        return fecha_in;
    }

    private Date fecha_out() {
        Date fecha_out = new Date(vista_egresos.fechaFinal.getDate().getTime());
        return fecha_out;
    }

    private void ocultar_columnas_egresos() {
        Integer[] cols = {0};
        FUNCIONES.ocultar_columnas(cols, vista_egresos.tablaGastos);
        vista_egresos.tablaGastos.getColumnModel().getColumn(4).setPreferredWidth(150);
        vista_egresos.tablaGastos.getColumnModel().getColumn(5).setPreferredWidth(60);
        vista_egresos.tablaGastos.getColumnModel().getColumn(6).setPreferredWidth(150);
    }

    private void mostrar_empleados() {
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
        lista_empleados = controladorEmpleado.obtener_lista_empleados(-1);
        for (int i = 0; i < lista_empleados.size(); i++) {
            if (i % 2 != 0) {
                vista_egresos.cboEmpleado.addItem(lista_empleados.get(i).toString());
            }
        }

    }

    private void limpiar() {
        vista_egresos.rdoEgreso.setSelected(true);
        vista_egresos.txtMonto.setText("");
        vista_egresos.txtDescripcion.setText("");
    }

    public void agregar() {
        if (vista_egresos.txtMonto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa un monto");
            vista_egresos.txtMonto.requestFocus();
            return;
        }
        DtoEgresos entidad = new DtoEgresos();
        String tipo = vista_egresos.cboTipo.getSelectedItem().toString();
        String operacion = vista_egresos.rdoEgreso.getText();
        String descripcion = vista_egresos.txtDescripcion.getText();
        Double monto = Double.parseDouble(vista_egresos.txtMonto.getText());

        if (vista_egresos.rdoIngreso.isSelected()) {
            tipo = "Ingreso extra";
        }

        if (vista_egresos.rdoIngreso.isSelected()) {
            operacion = vista_egresos.rdoIngreso.getText();
        }

        int idempleado = 0;
        for (int i = 0; i < lista_empleados.size(); i++) {
            if (vista_egresos.cboEmpleado.getSelectedItem().equals(lista_empleados.get(i).toString())) {
                idempleado = Integer.parseInt(lista_empleados.get(i - 1).toString());
            }
        }

        entidad.setOperacion(operacion);
        entidad.setTipo(tipo);
        entidad.setMonto(monto);
        entidad.setDescripcion(descripcion);
        entidad.setIdempleado(idempleado);

        if (datos_egresos.insertar(entidad)) {
            mostrar(null);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Se produjo un error, intenta nuevamente");
        }
    }

    public Double[] total_gastos() {
        return datos_egresos.obtener_gastos();
    }
}
