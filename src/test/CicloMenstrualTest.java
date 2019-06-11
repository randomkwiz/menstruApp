package test;

import clasesBasicas.CicloMenstrual;
import clasesBasicas.UsuarioImpl;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class CicloMenstrualTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar inicioPeriodo = new GregorianCalendar();
        inicioPeriodo.set(GregorianCalendar.YEAR, 2019);
        inicioPeriodo.set(GregorianCalendar.MONTH, 5);
        inicioPeriodo.set(GregorianCalendar.DATE, 4);
        String fechaInicio = sdf.format(inicioPeriodo.getTime());
        String fechaFinEstimada = " ";
        System.out.println(fechaInicio);
        CicloMenstrual miCiclo = new CicloMenstrual(new UsuarioImpl(), inicioPeriodo);

        fechaFinEstimada = sdf.format(miCiclo.getFechaFinEstimada().getTime());


        System.out.println(fechaFinEstimada);


    }
}
