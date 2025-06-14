/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dto;

/**
 *
 * @author Li
 */
public class DtoProducto {

    private int idproducto;
    private String nombre;
    private int categoria;
    private Double precio;
    private String cod_producto;
    private String presentacion;
    private int id_descuento;
    private Double[][] descuentos;
    private int eliminado;
    private String imagen;
    private Double costo;
    private int stock_bajo;

    public DtoProducto() {
    }

    public DtoProducto(int idproducto, String nombre, int categoria, Double precio, String cod_producto, String presentacion, int id_descuento, Double[][] descuentos, int eliminado, String imagen, Double costo, int stock_bajo) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cod_producto = cod_producto;
        this.presentacion = presentacion;
        this.id_descuento = id_descuento;
        this.descuentos = descuentos;
        this.eliminado = eliminado;
        this.imagen = imagen;
        this.costo = costo;
        this.stock_bajo = stock_bajo;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double[][] getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Double[][] descuentos) {
        this.descuentos = descuentos;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public int getStock_bajo() {
        return stock_bajo;
    }

    public void setStock_bajo(int stock_bajo) {
        this.stock_bajo = stock_bajo;
    }

}
