package test;

import clasesBasicas.UsuarioImpl;
import utilidades.Utilidades;
import validaciones.Validar;

import java.util.GregorianCalendar;

public class UtilidadesTest {
    public static void main(String[] args) {
        Utilidades util = new Utilidades();
/*
        System.out.println(util.formatearFecha(new GregorianCalendar()));
        System.out.println(util.formatearFecha(null));
        System.out.println(util.formatearFecha(null));

 */
        Validar validar = new Validar();
        System.out.println(validar.combinacionInicioSesion("randomkwiz", "123456789"));

        UsuarioImpl u = util.toObject("randomkwiz", "123456789");

        System.out.println(u.toString());

    }
}
