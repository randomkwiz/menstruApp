package tests;


import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import org.junit.jupiter.api.Test;
import utilidades.Utilidades;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGestion {
    @Test
    void testObtenerEdad() {
        Gestion g = new Gestion();
        Utilidades u = new Utilidades();
        GregorianCalendar fecha = new GregorianCalendar();
        UsuarioImpl usuario = u.cargarUsuario("randomkwiz", "123456789");
        int edad = g.obtenerEdad(usuario);
        assertEquals(22,edad);

        fecha.set(GregorianCalendar.YEAR, 2003);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        usuario.setFechaNacimiento(fecha);

        edad = g.obtenerEdad(usuario);
        assertEquals(15,edad);


        fecha.set(GregorianCalendar.YEAR, 2050);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        usuario.setFechaNacimiento(fecha);

        edad = g.obtenerEdad(usuario);
        assertEquals(0,edad);
    }

}
