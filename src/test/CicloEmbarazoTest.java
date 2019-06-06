package test;

import clasesBasicas.CicloEmbarazo;
import utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class CicloEmbarazoTest {
    public static void main(String[] args) {
        CicloEmbarazo miEmbarazo = new CicloEmbarazo(new GregorianCalendar());
        Utilidades utilidades = new Utilidades();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = " ";
       // fecha = sdf.format(miEmbarazo.getFechaInicio().getTime());
        System.out.println("Te has quedado embarazada el dia: "+ utilidades.formatearFecha(miEmbarazo.getFechaInicio()));
        //fecha = sdf.format(miEmbarazo.getFechaFinEstimada().getTime());
        System.out.println("Tu embarazo deberia finalizar alrededor del dia: "+utilidades.formatearFecha(miEmbarazo.getFechaFinEstimada()));
    }

}
