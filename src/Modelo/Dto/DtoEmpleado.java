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
public class DtoEmpleado extends DtoPersona {

    private int idempleado;
    private String usuario;
    private String clave;
    private int acceso;
    private int eliminado;

    public DtoEmpleado() {
    }

    public DtoEmpleado(int idempleado, String usuario, String contraseña, int acceso, int estado) {
        this.idempleado = idempleado;
        this.usuario = usuario;
        this.clave = contraseña;
        this.acceso = acceso;
        this.eliminado = estado;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String contraseña) {
        this.clave = contraseña;
    }

    public int getAcceso() {
        return acceso;
    }

    public void setAcceso(int acceso) {
        this.acceso = acceso;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
