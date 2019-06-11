/*
 * Nombre: CicloMenstrual
 * Propiedades:
 *   Basicas:
 *       GregorianCalendar fechaInicio
 *       GregorianCalendar fechaFinReal
 *   Derivadas:
 *       fechaFinEstimada
 *       diasRestantesEstimados
 *       duracionReal
 *       isFinalizado
 *
 *   Compartidas:
 * Metodos añadidos:
 *   getFechaFinEstimada
 *   getDiasRestantesEstimados
 *   getDuracionReal
 *   isFinalizado
 * Metodos interface:
 *
 *
 * */
package clasesBasicas;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CicloMenstrual extends Ciclo {

    //Constructores
    public CicloMenstrual() {
        super();
    }

    public CicloMenstrual(UsuarioImpl usuario, GregorianCalendar fechaInicio, GregorianCalendar fechaFinReal) {
        super(usuario, fechaInicio, fechaFinReal);
    }

    public CicloMenstrual(UsuarioImpl usuario, GregorianCalendar fechaInicio) {
        super(usuario, fechaInicio);
    }


    //Metodos añadidos

    /*
    INTERFAZ
    Comentario: Método que devuelve la fecha de fin estimada del ciclo.
    Signatura: public GregorianCalendar getFechaFinEstimada()
    Precondiciones:
    Entradas:
    Salidas: objeto GregorianCalendar que es la fecha de fin estimada
    Postcondiciones: asociado al nombre devolvera la fecha de fin estimada, que sera 4 dias posterior a la fecha
                     de inicio del ciclo.
 */
    public GregorianCalendar getFechaFinEstimada() {
        GregorianCalendar fechaFinEstimada = getFechaInicio();
        fechaFinEstimada.add(Calendar.DAY_OF_MONTH, 4);
        return fechaFinEstimada;
    }

    /*
    INTERFAZ
    Comentario: Método que devuelve la fecha estimada de comienzo del siguiente periodo.
    Signatura: public GregorianCalendar getFechaComienzoEstimadaSiguientePeriodo()
    Precondiciones:
    Entradas:
    Salidas: objeto GregorianCalendar que es la fecha de comienzo estimada
    Postcondiciones: asociado al nombre devolvera la fecha de comienzo estimada, que sera 28 dias posterior a la fecha
                     de inicio del ciclo actual (el vigesimo octavo dia del ciclo actual seria el primer dia del siguiente ciclo).
    */
    public GregorianCalendar getFechaComienzoEstimadaSiguientePeriodo() {
        GregorianCalendar fechaComienzoSiguienteCicloEstimada = getFechaInicio();
        fechaComienzoSiguienteCicloEstimada.add(Calendar.DAY_OF_MONTH, 28);
        return fechaComienzoSiguienteCicloEstimada;
    }


}
