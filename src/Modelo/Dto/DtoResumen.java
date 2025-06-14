/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dto;

import java.sql.Timestamp;

/**
 *
 * @author Li
 */
public class DtoResumen {

    private int idventa;
    private Timestamp fecha;
    private int idempleado;
    private int idcliente;
    private int idcajero;
    private int comprobante;
    private int num_comprobante;
    private int tipo_pago;
    private String moneda;
    private String factura;
    private String guia;
    private String orden;

    public DtoResumen() {
    }

    public DtoResumen(int idventa, Timestamp fecha, int idempleado, int idcliente, int idcajero, int comprobante, int tipo_pago, String moneda, String factura, String guia, String orden) {
        this.idventa = idventa;
        this.fecha = fecha;
        this.idempleado = idempleado;
        this.idcliente = idcliente;
        this.idcajero = idcajero;
        this.comprobante = comprobante;
        this.tipo_pago = tipo_pago;
        this.moneda = moneda;
        this.factura = factura;
        this.guia = guia;
        this.orden = orden;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdcajero() {
        return idcajero;
    }

    public void setIdcajero(int idcajero) {
        this.idcajero = idcajero;
    }

    public int getComprobante() {
        return comprobante;
    }

    public void setComprobante(int comprobante) {
        this.comprobante = comprobante;
    }

    public int getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(int tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public int getNum_comprobante() {
        return num_comprobante;
    }

    public void setNum_comprobante(int num_comprobante) {
        this.num_comprobante = num_comprobante;
    }

}
