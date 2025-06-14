/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import comun.Common;
import Modelo.Dao.DaoEmpleado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Vista.Vista_principal;

/**
 *
 * @author Luciano Ces
 */
public class ControladorLogin {

    private String user;
    private char[] password;

    public ControladorLogin(String user, char[] password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public int validar() {
        //0: Acceso correcto
        //1: Campo de usuario vacío
        //2: Campo de contraseña vacío

        if (this.user.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa tu nombre de usuario",
                    "Acceso al sistema", JOptionPane.INFORMATION_MESSAGE);
            return 1;
        }
        if (this.password.length == 0) {
            JOptionPane.showMessageDialog(null, "Ingresa tu contraseña",
                    "Acceso al sistema", JOptionPane.INFORMATION_MESSAGE);
            return 2;
        }
        return 0;
    }

    public boolean acceder() {

        DaoEmpleado func = new DaoEmpleado();
        ArrayList listaSesion = func.login(this.user, String.valueOf(this.password));
        if (!listaSesion.isEmpty()) {
            Vista_principal inicio = new Vista_principal();
            inicio.setTitle("Domox v2.0 - " + listaSesion.get(1) + " " + listaSesion.get(2));
            inicio.setVisible(true);
            inicio.toFront();
            inicio.txtSesion.setText(listaSesion.get(1) + " " + listaSesion.get(2));
            Common funciones = new Common();
            funciones.configuracion_inicial();
            Common.idempleado = Integer.parseInt(listaSesion.get(0).toString());
            Common.sesion = listaSesion.get(1) + " " + listaSesion.get(2);
            int acceso = Integer.parseInt(listaSesion.get(3).toString());
            switch (acceso) {
                case 2:
                    Vista_principal.empleados.setEnabled(false);
                    Vista_principal.productos.setEnabled(false);
                    Vista_principal.menuConfiguracion.setEnabled(false);
                    Vista_principal.vendedores.setEnabled(false);
                    break;
                case 3:
                    Vista_principal.menuVentas.setEnabled(false);
                    Vista_principal.empleados.setEnabled(false);
                    Vista_principal.productos.setEnabled(false);
                    Vista_principal.menuConfiguracion.setEnabled(false);
                    Vista_principal.vendedores.setEnabled(false);
                    break;
                case 4:
                    Vista_principal.menuVentas.setEnabled(false);
                    Vista_principal.empleados.setEnabled(false);
                    Vista_principal.productos.setEnabled(false);
                    Vista_principal.menuConfiguracion.setEnabled(false);
                    Vista_principal.vendedores.setEnabled(false);
                    break;
                case 5:
                    Vista_principal.menuVentas.setEnabled(false);
                    Vista_principal.empleados.setEnabled(false);
                    Vista_principal.productos.setEnabled(false);
                    Vista_principal.menuConfiguracion.setEnabled(false);
                    Vista_principal.vendedores.setEnabled(false);
                    break;
            }

            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Acceso denegado", "Acceso al sistema", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

}
