package test;

import clasesBasicas.Ciclo;
import clasesBasicas.UsuarioImpl;
import gestion.Gestion;

import java.util.GregorianCalendar;

public class ConductorInsertarCiclo {
    public static void main(String[] args) {
        UsuarioImpl usuario = new UsuarioImpl("randomkwiz", "123456789");

        Gestion gestion = new Gestion();
        Ciclo miCiclo = gestion.obtenerCicloActual(usuario);
        // gestion.insertarCiclo(miCiclo);


        gestion.actualizarFechaFinCiclo(miCiclo, new GregorianCalendar());
    }
}
