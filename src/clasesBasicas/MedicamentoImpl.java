/*
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
package clasesBasicas;

import java.util.GregorianCalendar;

public class MedicamentoImpl {
    private String nombre;
    private boolean isRecetado;
    private GregorianCalendar fechaInicio;
    private GregorianCalendar fechaFin;
    private String cantidad;

    //Constructores
    public MedicamentoImpl(String nombre, boolean isRecetado, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, String cantidad) {
        this.nombre = nombre;
        this.isRecetado = isRecetado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
    }

    public MedicamentoImpl(String nombre, boolean isRecetado, String cantidad) {
        this.nombre = nombre;
        this.isRecetado = isRecetado;
        this.cantidad = cantidad;
        this.fechaInicio = null;
        this.fechaFin = null;
    }

//getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRecetado() {
        return isRecetado;
    }

    public void setRecetado(boolean recetado) {
        isRecetado = recetado;
    }

    public GregorianCalendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(GregorianCalendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public GregorianCalendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(GregorianCalendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isTratamientoFinalizado(){
        boolean finalized = false;
        if (getFechaFin() != null){
            finalized = true;
        }
        return finalized;
    }
}
