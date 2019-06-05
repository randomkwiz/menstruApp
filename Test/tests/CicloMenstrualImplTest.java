package tests;

import clasesBasicas.CicloMenstrualImpl;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CicloMenstrualImplTest {

    @Test
    void getFechaInicio() {
    }

    @Test
    void setFechaInicio() {
    }

    @Test
    void getFechaFinEstimada() {
        CicloMenstrualImpl miCiclo = new CicloMenstrualImpl(new GregorianCalendar());
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

        CicloMenstrualImpl miCiclo = new CicloMenstrualImpl(new GregorianCalendar());
        //assertEquals(4,miCiclo.getDiasRestantesEstimados());

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.YEAR, 2019);
        gc.set(GregorianCalendar.MONTH, 5); //5 es el mes Junio porque empiezan en 0
        gc.set(GregorianCalendar.DATE, 4);

        CicloMenstrualImpl miCiclo2 = new CicloMenstrualImpl(gc);

        assertEquals(3,miCiclo2.getDiasRestantesEstimados());
    }


}