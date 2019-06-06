package tests;

import clasesBasicas.CicloMenstrual;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CicloMenstrualTest {

    @Test
    void getFechaInicio() {
    }

    @Test
    void setFechaInicio() {
    }

    @Test
    void getFechaFinEstimada() {
        CicloMenstrual miCiclo = new CicloMenstrual(new GregorianCalendar());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(miCiclo.getFechaFinEstimada().getTime());
        assertEquals("09/06/2019",fecha );
    }

    @Test
    void setFechaFinEstimada() {
    }

    @Test
    void getFechaFinReal() {
    }

    @Test
    void setFechaFinReal() {
    }

    @Test
    void getDiasRestantesEstimados() {

        CicloMenstrual miCiclo = new CicloMenstrual(new GregorianCalendar());
        //assertEquals(4,miCiclo.getDiasRestantesEstimados());

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.YEAR, 2019);
        gc.set(GregorianCalendar.MONTH, 5); //5 es el mes Junio porque empiezan en 0
        gc.set(GregorianCalendar.DATE, 4);

        CicloMenstrual miCiclo2 = new CicloMenstrual(gc);

        assertEquals(3,miCiclo2.getDiasRestantesEstimados());
    }


}