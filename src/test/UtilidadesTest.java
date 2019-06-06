package test;

import utilidades.Utilidades;

import java.util.GregorianCalendar;

public class UtilidadesTest {
    public static void main(String[] args) {
        Utilidades util = new Utilidades();

        System.out.println(util.formatearFecha(new GregorianCalendar()));
        System.out.println(util.formatearFecha(null));
        System.out.println(util.formatearFecha(null));
    }
}
