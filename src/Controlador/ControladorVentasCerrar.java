package Controlador;

import comun.Helper_impresion;
import comun.Common;
import Modelo.Dao.DaoCaja;
import Modelo.Dto.DtoCaja;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Vista.Vista_ventas_cerrar;

/**
 *
 * @author Luciano Ces
 */
public class ControladorVentasCerrar {

    private Vista_ventas_cerrar vista_cierre;
    private DaoCaja datos_caja;
    private Common funciones;

    public ControladorVentasCerrar() {

    }

    public void iniciar() {
        this.vista_cierre = new Vista_ventas_cerrar(this);
        this.datos_caja = new DaoCaja();
        datos_cierre();
        this.funciones = new Common();
        funciones.abrir_ventana(vista_cierre);
    }
//Cierre de caja

    private void datos_cierre() {
        ArrayList<String> datos = datos_caja.mostrar();
        Double t = 0.0;
        Double e = 0.0;
        if (datos != null) {
            for (int i = 0; i < datos.size(); i++) {
                if (i % 2 != 0) {
                    if (datos.get(i).equals("0")) {
                        e += Double.parseDouble(datos.get(i - 1));
                    } else if (datos.get(i).equals("1")) {
                        t += Double.parseDouble(datos.get(i - 1));
                    }
                }
            }
        }

        Double[] total_gastos = new ControladorVentasEgresos().total_gastos();
        Double apertura = datos_caja.getApertura();
        Double credito = datos_caja.getCredito();
        vista_cierre.txtEfectivo.setText(Common.aDecimal(e));
        vista_cierre.txtTarjeta.setText(Common.aDecimal(t));
        vista_cierre.txtAbrir.setText(Common.aDecimal(apertura));
        vista_cierre.txtExtras.setText(Common.aDecimal(total_gastos[0]));
        vista_cierre.txtGastos.setText(Common.aDecimal(total_gastos[1]));
        vista_cierre.txtCredito.setText(Common.aDecimal(credito));
        sumar();
    }

    public void sumar() {
        Double total = 0.0;
        for (int i = 0; i < vista_cierre.panel_cierre.getComponentCount(); i++) {
            if (vista_cierre.panel_cierre.getComponent(i) instanceof javax.swing.JTextField) {
                javax.swing.JTextField text = (javax.swing.JTextField) vista_cierre.panel_cierre.getComponent(i);
                total += Double.parseDouble(text.getText());
            }
        }
        //Debido a que se han sumado todos los inputs text, se debe restar a continuación:
        Double gastos = Double.parseDouble(vista_cierre.txtGastos.getText()) * 2;
        Double credito = Double.parseDouble(vista_cierre.txtCredito.getText());

        Double _total = total - credito - gastos;
        vista_cierre.lblTotal_orden.setText(Common.aDecimal(_total));
    }

    public void procesar() {

        DtoCaja entidad = new DtoCaja();
        entidad.setFecha_c(new java.util.Date());
        entidad.setApertura(Double.parseDouble(vista_cierre.txtAbrir.getText()));
        entidad.setExtras(Double.parseDouble(vista_cierre.txtExtras.getText()));
        entidad.setEfectivo(Double.parseDouble(vista_cierre.txtEfectivo.getText()));
        entidad.setTarjeta(Double.parseDouble(vista_cierre.txtTarjeta.getText()));
        entidad.setGastos(Double.parseDouble(vista_cierre.txtGastos.getText()));
        entidad.setCierre(Double.parseDouble(vista_cierre.lblTotal_orden.getText()));
        entidad.setCredito(Double.parseDouble(vista_cierre.txtCredito.getText()));
        entidad.setComentario_c(vista_cierre.txtComentario.getText());
        if (datos_caja.cerrar_caja(entidad)) {
            JOptionPane.showMessageDialog(null, "Se cerró caja correctamente");
            new Helper_impresion(entidad).start();
        } else {
            JOptionPane.showMessageDialog(null, "No se puede cerrar caja, intente nuevamente");
        }
    }

}
