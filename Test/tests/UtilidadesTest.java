package tests;

import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import org.junit.jupiter.api.Test;
import utilidades.Utilidades;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadesTest {

    @Test
    void cargarUsuario() {
        Gestion g = new Gestion();
        Utilidades u = new Utilidades();
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.set(GregorianCalendar.YEAR, 2003);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        UsuarioImpl usuarioPrueba = new UsuarioImpl("NombrePrueba", "NickPrueba", "123456789",55.5, fecha);
        g.insertarUsuarioEnBBDD(usuarioPrueba);
        UsuarioImpl usuarioTesteo = u.cargarUsuario("NickPrueba", "123456789");

        assertEquals("NickPrueba", usuarioPrueba.getNick());
        assertEquals("NombrePrueba", usuarioPrueba.getNombre());
        assertEquals(55.5, usuarioPrueba.getPeso() );
        assertEquals(fecha, usuarioPrueba.getFechaNacimiento());
    }


}