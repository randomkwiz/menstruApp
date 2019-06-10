package test;

import clasesBasicas.Ciclo;
import clasesBasicas.UsuarioImpl;
import gestion.Gestion;

import java.util.GregorianCalendar;

public class ConductorActualizarFechaFinCiclo {

    public static void main(String[] args) {

        Gestion gestion = new Gestion();
        UsuarioImpl usuario = new UsuarioImpl("randomkwiz","123456789");
        Ciclo miCiclo = gestion.obtenerCicloActual(usuario);
        gestion.actualizarFechaFinCiclo(miCiclo, new GregorianCalendar());
    }
}
