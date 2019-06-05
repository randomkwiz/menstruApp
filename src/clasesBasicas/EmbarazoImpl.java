/*
 * Nombre: EmbarazoImpl
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
import interfaces.Ciclo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmbarazoImpl extends Ciclo {
    GregorianCalendar fechaInicio;
    GregorianCalendar fechaFinReal;

    //Constructores
    public EmbarazoImpl() {
        super.setFechaInicio(null);
        super.setFechaFinReal(null);
    }

    public EmbarazoImpl(GregorianCalendar fechaInicio) {
        super.setFechaInicio(fechaInicio);
    }

    public EmbarazoImpl(GregorianCalendar fechaInicio, GregorianCalendar fechaFinReal) {
        super.setFechaInicio(fechaInicio);
        super.setFechaFinReal(fechaFinReal);
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
        fechaFinEstimada.add(Calendar.DAY_OF_MONTH, 260);
        return fechaFinEstimada;
    }

}
