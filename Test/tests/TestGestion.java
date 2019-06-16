package tests;


import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import org.junit.jupiter.api.Test;
import utilidades.Utilidades;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGestion {
    @Test
    void testObtenerEdad() {
        Gestion g = new Gestion();
        Utilidades u = new Utilidades();
        UsuarioImpl usuario = u.cargarUsuario("randomkwiz", "123456789");
        int edad = g.obtenerEdad(usuario);

        assertTrue(edad == 1);
    }

}
