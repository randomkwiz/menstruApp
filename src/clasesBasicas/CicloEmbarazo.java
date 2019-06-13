/*
 * Nombre: CicloEmbarazo
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

public class CicloEmbarazo extends Ciclo {

    //Constructores


    /**
     * Constructor por defecto
     */
    public CicloEmbarazo() {
        super();
    }

    /**
     * Constructor con parametros
     * @param usuario usuario al que pertenece el ciclo
     * @param fechaInicio fecha de inicio del ciclo
     * @param fechaFinReal fecha de fin real del ciclo
     */
    public CicloEmbarazo(UsuarioImpl usuario, GregorianCalendar fechaInicio, GregorianCalendar fechaFinReal) {
        super(usuario, fechaInicio, fechaFinReal);
    }
    /**
     * Constructor con parametros sin fecha de finalizacion
     * @param usuario usuario al que pertenece el ciclo
     * @param fechaInicio fecha de inicio del ciclo
     */
    public CicloEmbarazo(UsuarioImpl usuario, GregorianCalendar fechaInicio) {
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
    Postcondiciones: asociado al nombre devolvera la fecha de fin estimada, que sera 260 dias posterior a la fecha
                     de inicio del ciclo, o null si no hay fecha de inicio.
 */

    /**
     * Comentario: Método que devuelve la fecha de fin estimada del ciclo.
     * @return asociado al nombre devolvera la fecha de fin estimada, que sera 260 dias posterior a la fecha
     *         de inicio del ciclo, o null si no hay fecha de inicio.
     */
    public GregorianCalendar getFechaFinEstimada() {
        GregorianCalendar fechaFinEstimada = null;

        if(getFechaInicio() != null){
            fechaFinEstimada = getFechaInicio();
            fechaFinEstimada.add(Calendar.DAY_OF_MONTH, 260);
        }

        return fechaFinEstimada;
    }

}
