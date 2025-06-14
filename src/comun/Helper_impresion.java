/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

import Modelo.Dto.DtoCaja;
import Modelo.Dto.DtoImpresion;
import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Luciano Ces
 */
public class Helper_impresion extends Thread {

    private final Connection connection = new Conexion().conectar();
    private int idventa;
    private String comprobante;
    private String direccion;
    private String soles;
    private boolean previewReport;
    private boolean dialogo_impresion;
    private boolean imprimir;

    //campos para impresión de cierre
    private String accion;
    private String empleado;
    private Double apertura;
    private Double extras;
    private Double efectivo;
    private Double tarjeta;
    private Double gastos;
    private Double cierre;
    private Double credito;
    private Double ventas;
    private String comentario;
    private Date fecha;

    public Helper_impresion(DtoImpresion datos) {
        this.idventa = datos.getIdventa();
        this.comprobante = datos.getComprobante();
        this.direccion = datos.getDireccion();
        this.soles = datos.getSoles();
        this.accion = "Imprimir";
        this.previewReport = datos.isPreview();
        this.dialogo_impresion = datos.isDialogo_impresion();
        this.imprimir = datos.isImprimir();
    }

    public Helper_impresion(DtoCaja datos) {
        this.accion = "Cierre";
        this.previewReport = false;
        this.imprimir = true;
        this.empleado = Common.sesion;
        this.apertura = datos.getApertura();
        this.extras = datos.getExtras();
        this.efectivo = datos.getCierre() - datos.getTarjeta();
        this.tarjeta = datos.getTarjeta();
        this.gastos = datos.getGastos();
        this.cierre = datos.getCierre();
        this.credito = datos.getCredito();
        this.comentario = datos.getComentario_c();
        this.comprobante = "Cierre";
        this.ventas = datos.getTarjeta() + datos.getEfectivo();
        this.fecha = datos.getFecha_c();
    }

    @Override
    public void run() {
        HashMap<String, Object> p = new HashMap<>();

        if (this.accion.equals("Imprimir")) {
            p.put("idventa", idventa);
            p.put("num_text", soles);
            if (comprobante.equals("Guia")) {
                p.put("dir", direccion);
            }
        } else if (this.accion.equals("Cierre")) {
            p.put("fecha", fecha);
            p.put("empleado", String.valueOf(empleado));
            p.put("apertura", apertura);
            p.put("extras", extras);
            p.put("efectivo", efectivo);
            p.put("tarjeta", tarjeta);
            p.put("gastos", gastos);
            p.put("cierre", cierre);
            p.put("credito", credito);
            p.put("comentario", comentario);
            p.put("ventas", ventas);
        }
        String reporte = new File("").getAbsolutePath() + "/src/recursos/" + comprobante + ".jasper";
        try {
            JasperPrint j = JasperFillManager.fillReport(reporte, p, connection);
            if (imprimir) {
                if (!previewReport) {
                    JasperPrintManager.printReport(j, dialogo_impresion);
                } else {
                    JasperViewer jasperViewer = new JasperViewer(j, false);
                    jasperViewer.setVisible(true);
                    jasperViewer.setTitle(comprobante);
                    jasperViewer.toFront();
                    jasperViewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
