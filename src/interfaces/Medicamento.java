/*
*
* Nombre: Medicamento
* Propiedades:
*   Basicas:
*       String nombre   consultable y modificable
*       boolean isRecetado  consultable y modificable
*       GregorianCalendar fechaInicio consultable y modificable
*       GregorianCalendar fechaFin consultable y modificable
*       String cantidad consultable y modificable       //la cantidad hace referencia a las indicaciones de uso (Ej: "Una pastilla cada tres horas") por eso es un String
*
*   Derivadas:
*       isTratamientoFinalizado deriva de fechaFin
*
*   Compartidas:
*
* Metodos interface
    public String getNombre();
    public void setNombre(String nombre);
    public boolean isRecetado() ;
    public void setRecetado(boolean recetado) ;
    public GregorianCalendar getFechaInicio() ;
    public void setFechaInicio(GregorianCalendar fechaInicio);
    public GregorianCalendar getFechaFin() ;
    public void setFechaFin(GregorianCalendar fechaFin) ;
    public String getCantidad();
    public void setCantidad(String cantidad) ;
*
* */
package interfaces;

import java.util.GregorianCalendar;

public interface Medicamento {
    String getNombre();

    void setNombre(String nombre);

    boolean isRecetado();

    void setRecetado(boolean recetado);

    GregorianCalendar getFechaInicio();

    void setFechaInicio(GregorianCalendar fechaInicio);

    GregorianCalendar getFechaFin();

    void setFechaFin(GregorianCalendar fechaFin);

    String getCantidad();

    void setCantidad(String cantidad);
}
