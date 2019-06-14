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

    int duracionCicloMenstrual;

    //Constructores

    /**
     * Constructor por defecto
     */
    public CicloMenstrual() {
        super();
        this.duracionCicloMenstrual = 28;
    }

    /**
     * Constructor con parametros
     * @param usuario usuario al que pertenece el ciclo
     * @param fechaInicio fecha de inicio del ciclo
     * @param fechaFinReal fecha de fin real del ciclo
     */
    public CicloMenstrual(UsuarioImpl usuario, GregorianCalendar fechaInicio, GregorianCalendar fechaFinReal) {
        super(usuario, fechaInicio, fechaFinReal);
        this.duracionCicloMenstrual = 28;
    }

    /**
     * Constructor con parametros sin fecha de finalizacion
     * @param usuario usuario al que pertenece el ciclo
     * @param fechaInicio fecha de inicio del ciclo
     */
    public CicloMenstrual(UsuarioImpl usuario, GregorianCalendar fechaInicio) {

        super(usuario, fechaInicio);
        this.duracionCicloMenstrual = 28;
    }


    //getters y setters

    public int getDuracionCicloMenstrual() {
        return duracionCicloMenstrual;
    }

    public void setDuracionCicloMenstrual(int duracionCicloMenstrual) {
        this.duracionCicloMenstrual = duracionCicloMenstrual;
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

    /**
     * Método que devuelve la fecha de fin estimada del ciclo.
     * @return asociado al nombre devolvera la fecha de fin estimada, que sera 4 dias posterior a la fecha
     *         de inicio del ciclo, o null si no hay fecha de inicio.
     */
    public GregorianCalendar getFechaFinEstimada() {
        GregorianCalendar fechaFinEstimada = null;
        if(getFechaInicio() != null){
            fechaFinEstimada = getFechaInicio();
            fechaFinEstimada.add(Calendar.DAY_OF_MONTH, 4);
        }

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

    /**
     *  Método que devuelve la fecha estimada de comienzo del siguiente periodo.
     * @return asociado al nombre devolvera la fecha de comienzo estimada del siguiente ciclo, que sera 28 dias posterior a la fecha
     *         de inicio del ultimo ciclo menstrual sin cierre actual (el vigesimo octavo dia del ciclo actual seria el primer dia del siguiente ciclo).
     *
     */
    public GregorianCalendar getFechaComienzoEstimadaSiguientePeriodo() {
        GregorianCalendar fechaComienzoSiguienteCicloEstimada = getFechaInicio();
        fechaComienzoSiguienteCicloEstimada.add(Calendar.DAY_OF_MONTH, getDuracionCicloMenstrual());
        return fechaComienzoSiguienteCicloEstimada;
    }


}
