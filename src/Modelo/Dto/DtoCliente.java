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
public class DtoCliente extends DtoPersona {

    private int idcliente;
    private String cod_cliente;
    private String num_ruc;
    private int eliminado;

    public DtoCliente() {
    }

    public DtoCliente(int idcliente, String cod_cliente, String num_ruc) {
        this.idcliente = idcliente;
        this.cod_cliente = cod_cliente;
        this.num_ruc = num_ruc;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getNum_ruc() {
        return num_ruc;
    }

    public void setNum_ruc(String num_ruc) {
        this.num_ruc = num_ruc;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
