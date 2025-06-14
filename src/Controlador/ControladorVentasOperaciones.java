package Controlador;

import comun.Common;
import comun.Helper_impresion;
import comun.Interface_main_functions;
import Modelo.Dao.DaoCaja;
import Modelo.Dto.DtoCaja;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Vista.Vista_ventas_operaciones;

/**
 *
 * @author Luciano Ces
 */
public class ControladorVentasOperaciones implements Interface_main_functions {

    private Vista_ventas_operaciones vista_operaciones;
    private DaoCaja datos_caja;
    private int fila_operacion;
    private int idoperacion;

    public ControladorVentasOperaciones() {
    }

    @Override
    public void iniciar() {
        this.vista_operaciones = new Vista_ventas_operaciones(this);
        this.datos_caja = new DaoCaja();
        FUNCIONES.abrir_ventana(vista_operaciones);
        iniciar_dateChooser();
        mostrar("");

    }

    @Override
    public void mostrar(String texto) {
        DefaultTableModel modelo;
        modelo = datos_caja.ver_operaciones_diarias(fecha_in(), fecha_out());
        vista_operaciones.tablaVentas.setModel(modelo);
        ocultar_columnas();
    }

    private void iniciar_dateChooser() {
        Common.configurar_calendario(vista_operaciones.fechaInicial);
        Common.configurar_calendario(vista_operaciones.fechaFinal);

        vista_operaciones.fechaInicial.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("date")) {
                    mostrar("");
                }
            }
        });

        vista_operaciones.fechaFinal.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("date")) {
                    mostrar("");
                }
            }
        });
    }

    private Date fecha_in() {
        Date fecha_in = new Date(vista_operaciones.fechaInicial.getDate().getTime());
        return fecha_in;
    }

    private Date fecha_out() {
        Date fecha_out = new Date(vista_operaciones.fechaFinal.getDate().getTime());
        return fecha_out;
    }

    private void ocultar_columnas() {
        Integer[] cols = {0, 5, 6, 7, 8, 9, 10};
        FUNCIONES.ocultar_columnas(cols, vista_operaciones.tablaVentas);
    }

    @Override
    public void borrar_item() {
    }

    @Override
    public void editar_item() {
        editar();
    }

    @Override
    public void seleccionar_item() {
        fila_operacion = vista_operaciones.tablaVentas.getSelectedRow();
        if (fila_operacion == -1) {
            idoperacion = -1;
        } else {
            idoperacion = Integer.parseInt(vista_operaciones.tablaVentas.getValueAt(fila_operacion, 0).toString());
        }
        ver_item();
    }

    private void ver_item() {
        vista_operaciones.txtAbrir.setText(obtener_dato_de_tabla(3));
        vista_operaciones.txtCredito.setText(obtener_dato_de_tabla(7));
        vista_operaciones.txtEfectivo.setText(obtener_dato_de_tabla(5));
        vista_operaciones.txtTarjeta.setText(obtener_dato_de_tabla(6));
        vista_operaciones.txtGastos.setText(obtener_dato_de_tabla(8));
        vista_operaciones.txtExtras.setText(obtener_dato_de_tabla(9));
        vista_operaciones.txtComentario.setText(obtener_dato_de_tabla(10));
    }

    private String obtener_dato_de_tabla(int col) {
        return vista_operaciones.tablaVentas.getValueAt(fila_operacion, col) != null ? vista_operaciones.tablaVentas.getValueAt(fila_operacion, col).toString() : "";
    }

    public void habilitar() {
        vista_operaciones.txtAbrir.setEnabled(true);
        vista_operaciones.txtCredito.setEnabled(true);
        vista_operaciones.txtEfectivo.setEnabled(true);
        vista_operaciones.txtTarjeta.setEnabled(true);
        vista_operaciones.txtGastos.setEnabled(true);
        vista_operaciones.txtExtras.setEnabled(true);
        vista_operaciones.txtComentario.setEnabled(true);
    }

    public void inhabilitar() {
        vista_operaciones.txtAbrir.setEnabled(false);
        vista_operaciones.txtCredito.setEnabled(false);
        vista_operaciones.txtEfectivo.setEnabled(false);
        vista_operaciones.txtTarjeta.setEnabled(false);
        vista_operaciones.txtGastos.setEnabled(false);
        vista_operaciones.txtExtras.setEnabled(false);
        vista_operaciones.txtComentario.setEnabled(false);
    }

    private void editar() {

        DtoCaja entidad = new DtoCaja();

        entidad.setApertura(Double.parseDouble(vista_operaciones.txtAbrir.getText()));
        entidad.setCredito(Double.parseDouble(vista_operaciones.txtCredito.getText()));
        entidad.setEfectivo(Double.parseDouble(vista_operaciones.txtEfectivo.getText()));
        entidad.setTarjeta(Double.parseDouble(vista_operaciones.txtTarjeta.getText()));
        entidad.setGastos(Double.parseDouble(vista_operaciones.txtGastos.getText()));
        entidad.setExtras(Double.parseDouble(vista_operaciones.txtExtras.getText()));
        entidad.setComentario_c(vista_operaciones.txtComentario.getText());
        entidad.setCierre(entidad.getEfectivo() + entidad.getApertura() + entidad.getExtras() - entidad.getGastos());
        entidad.setIdcaja(idoperacion);

        if (datos_caja.editar_cierre(entidad)) {
            mostrar("");
        }
    }

    public void imprimir() {

        DtoCaja entidad = new DtoCaja();

        entidad.setApertura(Double.parseDouble(vista_operaciones.txtAbrir.getText()));
        entidad.setCredito(Double.parseDouble(vista_operaciones.txtCredito.getText()));
        entidad.setEfectivo(Double.parseDouble(vista_operaciones.txtEfectivo.getText()));
        entidad.setTarjeta(Double.parseDouble(vista_operaciones.txtTarjeta.getText()));
        entidad.setGastos(Double.parseDouble(vista_operaciones.txtGastos.getText()));
        entidad.setExtras(Double.parseDouble(vista_operaciones.txtExtras.getText()));
        entidad.setComentario_c(vista_operaciones.txtComentario.getText());
        String cierre = Common.aDecimal(entidad.getEfectivo() + entidad.getApertura() + entidad.getExtras() - entidad.getGastos());
        entidad.setCierre(Double.parseDouble(cierre));
        SimpleDateFormat stringToDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            entidad.setFecha_c(stringToDate.parse(obtener_dato_de_tabla(1)));
        } catch (ParseException ex) {
            Logger.getLogger(ControladorVentasOperaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Helper_impresion(entidad).start();

    }

    public void limpiar() {
        vista_operaciones.txtAbrir.setText("0.0");
        vista_operaciones.txtCredito.setText("0.0");
        vista_operaciones.txtEfectivo.setText("0.0");
        vista_operaciones.txtTarjeta.setText("0.0");
        vista_operaciones.txtGastos.setText("0.0");
        vista_operaciones.txtExtras.setText("0.0");
        vista_operaciones.txtComentario.setText("");
        idoperacion = -1;
    }
}
