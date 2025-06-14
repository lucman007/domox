package Controlador;

import comun.Common;
import Modelo.Dao.DaoCaja;
import Modelo.Dto.DtoCaja;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Vista.Vista_ventas_abrir;

/**
 *
 * @author Luciano Ces
 */
public class ControladorVentasAbrir {

    private Vista_ventas_abrir vista_abrir;
    private DaoCaja datos_caja;
    private ArrayList<JTextField> inputs;
    private Common funciones;

    public ControladorVentasAbrir() {

    }

    public void iniciar() {
        this.vista_abrir = new Vista_ventas_abrir(this);
        this.datos_caja = new DaoCaja();
        this.funciones = new Common();
        this.inputs = new ArrayList<>();
        crear_lista_inputs();
        funciones.abrir_ventana(vista_abrir);
    }
//Apertura de caja

    public void sumar() {
        Double moneda = 0.0;
        int cantidad;
        Double total = 0.0;
        for (int i = 0; i < inputs.size() - 1; i++) {
            switch (i) {
                case 0:
                    moneda = 0.1;
                    break;
                case 1:
                    moneda = 0.2;
                    break;
                case 2:
                    moneda = 0.5;
                    break;
                case 3:
                    moneda = 1.0;
                    break;
                case 4:
                    moneda = 2.0;
                    break;
                case 5:
                    moneda = 5.0;
                    break;
                case 6:
                    moneda = 10.0;
                    break;
                case 7:
                    moneda = 20.0;
                    break;
                case 8:
                    moneda = 50.0;
                    break;
                case 9:
                    moneda = 100.0;
                    break;
                case 10:
                    moneda = 200.0;
                    break;
            }
            cantidad = Integer.parseInt(inputs.get(i).getText());
            total += moneda * cantidad;
        }
        vista_abrir.lblTotal.setText(Common.aDecimal(total));
    }

    private void crear_lista_inputs() {
        for (int i = 0; i < vista_abrir.panel.getComponentCount(); i++) {
            if (vista_abrir.panel.getComponent(i) instanceof javax.swing.JTextField) {
                javax.swing.JTextField t = (javax.swing.JTextField) vista_abrir.panel.getComponent(i);
                inputs.add(t);
            }
        }
    }

    public void procesar() {
        Double total = Double.parseDouble(vista_abrir.lblTotal.getText());
        String comentario = vista_abrir.txtComentario.getText();
        DtoCaja entidad = new DtoCaja();

        entidad.setIdempleado(Common.idempleado);
        entidad.setComentario_a(comentario);
        entidad.setApertura(total);
        if (datos_caja.abrir_caja(entidad)) {
            JOptionPane.showMessageDialog(null, "Se aperturó caja correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede aperturar caja, intente nuevamente");
        }
    }

    public void check_ingresar_monto_directo(java.awt.event.ItemEvent evt) {
        boolean habilitar;
        if (evt.getStateChange() == 1) {
            vista_abrir.txtDirecto.setEnabled(true);
            vista_abrir.txtDirecto.requestFocus();
            habilitar = false;
        } else {
            vista_abrir.txtDirecto.setEnabled(false);
            habilitar = true;
        }
        for (int i = 0; i < inputs.size() - 1; i++) {
            inputs.get(i).setEnabled(habilitar);
        }
    }

    public void ingresar_monto_directo() {
        String monto = vista_abrir.txtDirecto.getText();
        vista_abrir.lblTotal.setText(Common.aDecimal(Double.valueOf(monto.isEmpty() ? "0" : monto)));
    }

    public void limpiar() {
        for (int i = 0; i < inputs.size() - 1; i++) {
            inputs.get(i).setText("0");
        }
        sumar();
    }
}
