package test;

import clasesBasicas.CicloEmbarazo;
import clasesBasicas.UsuarioImpl;
import utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class CicloEmbarazoTest {
    public static void main(String[] args) {
        UsuarioImpl usuario = new UsuarioImpl("usuariaEmbarazo", "123456789");
        CicloEmbarazo miEmbarazo = new CicloEmbarazo(usuario, new GregorianCalendar());
        GregorianCalendar fechaPrueba = new GregorianCalendar();
        Utilidades utilidades = new Utilidades();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = " ";
        // fecha = sdf.format(miEmbarazo.getFechaInicio().getTime());
        System.out.println("Te has quedado embarazada el dia: " + utilidades.formatearFecha(miEmbarazo.getFechaInicio()));
        //fecha = sdf.format(miEmbarazo.getFechaFinEstimada().getTime());
        System.out.println("Tu embarazo deberia finalizar alrededor del dia: " + utilidades.formatearFecha(miEmbarazo.getFechaFinEstimada()));

        System.out.println("is finalizado: "+miEmbarazo.isFinalizado());

        System.out.println("Usuaria embarazada: " + miEmbarazo.getUsuario().getNick());

        fechaPrueba.set(GregorianCalendar.YEAR, 2019);
        fechaPrueba.set(GregorianCalendar.MONTH, 5);
        fechaPrueba.set(GregorianCalendar.DATE, 15);

        miEmbarazo.setFechaInicio(fechaPrueba);
        System.out.println("Fecha inicio: " + utilidades.formatearFecha(fechaPrueba));
        System.out.println("Fecha fin estimada: " +utilidades.formatearFecha(miEmbarazo.getFechaFinEstimada()) );
        //System.out.println("Dias restantes estimados: " + miEmbarazo.getDiasRestantesEstimados()); //no funciona

    }

}
