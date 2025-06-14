/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comun;

/**
 *
 * @author Luciano Ces
 */
public class Ejemplo_inicializacion {

    static {
        add(2);
    }

    static void add(int num) {
        System.out.println(num + " ");
    }

    public Ejemplo_inicializacion() {
        System.out.println("Constructor!");
    }

    static {
        add(4);
    }

    {
        add(6);
    }

    static {
        new Ejemplo_inicializacion();
    }

    {
        add(8);
    }

    public static void main(String[] args) {
        System.out.println("Método main!");
    }

    {
        add(11);
    }

    static {
        add(12);
    }
}
