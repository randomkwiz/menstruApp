/*
 * Nombre: Ciclo
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
 *
 * */
package clasesBasicas;

import java.util.GregorianCalendar;


public abstract class Ciclo {

    private UsuarioImpl usuario;
    private String ID;
    private GregorianCalendar fechaInicio;
    private GregorianCalendar fechaFinReal;

    /**
     * Constructor con parametros
     *
     * @param usuario      usuario al que pertenece el ciclo
     * @param fechaInicio  fecha de inicio del ciclo
     * @param fechaFinReal fecha de fin real del ciclo
     */
    public Ciclo(UsuarioImpl usuario, GregorianCalendar fechaInicio, GregorianCalendar fechaFinReal) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFinReal = fechaFinReal;
    }

    /**
     * Constructor por defecto
     */
    public Ciclo() {
        this.usuario = null;
        this.fechaInicio = null;
        this.fechaFinReal = null;

    }

    /**
     * Constructor con parametros sin fecha de finalizacion
     *
     * @param usuario     usuario al que pertenece el ciclo
     * @param fechaInicio fecha de inicio del ciclo
     */
    public Ciclo(UsuarioImpl usuario, GregorianCalendar fechaInicio) {
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
    }


    //Getters y setters


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public UsuarioImpl getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioImpl usuario) {
        this.usuario = usuario;
    }

    public GregorianCalendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(GregorianCalendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    public GregorianCalendar getFechaFinReal() {
        return fechaFinReal;
    }

    public void setFechaFinReal(GregorianCalendar fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }


    //Metodos añadidos
    public abstract GregorianCalendar getFechaFinEstimada();
        /*
        INTERFAZ
        Comentario: Método que devuelve la cantidad de días restantes estimados que quedan del ciclo.
        Signatura: public int getDiasRestantesEstimados()
        Precondiciones:
        Entradas:
        Salidas: entero que es la cantidad de dias restantes estimados que quedan
        Postcondiciones: asociado al nombre devolvera la cantidad de dias restantes del ciclo.
                         O bien, un numero negativo con los dias que han pasado desde la fecha de fin estimada si esa fecha ya pasó.
     */

    /**
     * Método que devuelve la cantidad de días restantes estimados que quedan del ciclo.
     *
     * @return asociado al nombre devolvera la cantidad de dias restantes del ciclo.
     * O bien, un numero negativo con los dias que han pasado desde la fecha de fin estimada si esa fecha ya pasó.
     */
    public int getDiasRestantesEstimados() {
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
        GregorianCalendar fechaActual = new GregorianCalendar();
        GregorianCalendar fechaFinalEstimada = getFechaFinEstimada();

        long diasRestantes = (fechaFinalEstimada.getTimeInMillis() - fechaActual.getTimeInMillis()) / MILLSECS_PER_DAY;
        return (int) diasRestantes;
    }

    /*
    INTERFAZ
    Comentario: Método que devuelve la duracion real del ciclo en dias.
    Signatura: public int getDuracionReal()
    Precondiciones:
    Entradas:
    Salidas: entero que es la cantidad de dias que duro el ciclo realmente
    Postcondiciones: asociado al nombre devolvera la cantidad de dias reales que duro el ciclo, o -1 si el ciclo no termino aun o hubo algun error.
    */

    /**
     * Método que devuelve la duracion real del ciclo en dias.
     *
     * @return asociado al nombre devolvera la cantidad de dias reales que duro el ciclo, o -1 si el ciclo no termino aun o hubo algun error.
     */
    public int getDuracionReal() {
        long duracionRealEnDias = -1;
        if (getFechaFinReal() != null) {
            GregorianCalendar fechaInicio = getFechaInicio();
            GregorianCalendar fechaFin = getFechaFinReal();

            duracionRealEnDias = (fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis());
        }
        return (int) duracionRealEnDias;
    }

    /*
    INTERFAZ
    Comentario: Método que devuelve si el ciclo está finalizado o no.
    Signatura:  public boolean isFinalizado()
    Precondiciones:
    Entradas:
    Salidas: boolean
    Postcondiciones: asociado al nombre devolvera un boolean que sera true si el ciclo ha finalizado o false si aun no tiene fecha de fin real.
    */

    /**
     * Método que devuelve si el ciclo está finalizado o no.
     *
     * @return asociado al nombre devolvera un boolean que sera true si el ciclo ha finalizado o false si aun no tiene fecha de fin real.
     */
    public boolean isFinalizado() {
        boolean finalizado = false;
        if (getFechaFinReal() != null) {
            finalizado = true;
        }
        return finalizado;
    }
}
