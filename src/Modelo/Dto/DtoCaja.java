/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dto;

import java.util.Date;

/**
 *
 * @author Luciano Ces
 */
public class DtoCaja {

    private int idcaja;
    private int idempleado;
    private Date fecha_a;
    private Double apertura;
    private Double cierre;
    private Double efectivo;
    private Double tarjeta;
    private Double credito;
    private Double extras;
    private Double gastos;
    private String comentario_a;
    private String comentario_c;
    private Date fecha_c;

    public DtoCaja() {
    }

    public DtoCaja(int idcaja, int idempleado, Date fecha_a, Double apertura, Double cierre, Double efectivo, Double tarjeta, Double credito, Double extras, Double gastos, String comentario_a, String comentario_c, Date fecha_c) {
        this.idcaja = idcaja;
        this.idempleado = idempleado;
        this.fecha_a = fecha_a;
        this.apertura = apertura;
        this.cierre = cierre;
        this.efectivo = efectivo;
        this.tarjeta = tarjeta;
        this.credito = credito;
        this.extras = extras;
        this.gastos = gastos;
        this.comentario_a = comentario_a;
        this.comentario_c = comentario_c;
        this.fecha_c = fecha_c;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    public Double getApertura() {
        return apertura;
    }

    public void setApertura(Double apertura) {
        this.apertura = apertura;
    }

    public String getComentario_a() {
        return comentario_a;
    }

    public void setComentario_a(String comentario_a) {
        this.comentario_a = comentario_a;
    }

    public String getComentario_c() {
        return comentario_c;
    }

    public void setComentario_c(String comentario_c) {
        this.comentario_c = comentario_c;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public Date getFecha_a() {
        return fecha_a;
    }

    public void setFecha_a(Date fecha_a) {
        this.fecha_a = fecha_a;
    }

    public Double getCierre() {
        return cierre;
    }

    public void setCierre(Double cierre) {
        this.cierre = cierre;
    }

    public Double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Double efectivo) {
        this.efectivo = efectivo;
    }

    public Double getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Double tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public Double getExtras() {
        return extras;
    }

    public void setExtras(Double extras) {
        this.extras = extras;
    }

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }

    public Date getFecha_c() {
        return fecha_c;
    }

    public void setFecha_c(Date fecha_c) {
        this.fecha_c = fecha_c;
    }

}
