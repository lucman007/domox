/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dto;

import java.util.ArrayList;

/**
 *
 * @author Li
 */
public class DtoPedido {

    private int idpedido;
    private int idvendedor;
    private int idcliente;
    private int idpreventa;

    public int getIdpreventa() {
        return idpreventa;
    }

    public void setIdpreventa(int idpreventa) {
        this.idpreventa = idpreventa;
    }
    private String fecha;
    private Double total_venta;
    private int comprobante;
    private int estado;
    private ArrayList items;

    public DtoPedido() {
    }

    public DtoPedido(int idpedido, int idvendedor, int idcliente, String fecha, Double total_venta, int comprobante, int estado, ArrayList items) {
        this.idpedido = idpedido;
        this.idvendedor = idvendedor;
        this.idcliente = idcliente;
        this.fecha = fecha;
        this.total_venta = total_venta;
        this.comprobante = comprobante;
        this.estado = estado;
        this.items = items;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public int getComprobante() {
        return comprobante;
    }

    public void setComprobante(int comprobante) {
        this.comprobante = comprobante;
    }

    public ArrayList getItems() {
        return items;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
