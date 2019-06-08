/*
* Nombre: RevisionMedicaImpl
* Propiedades
*   Basicas
*       CicloEmbarazo embarazo
*       double peso
*       double cintura
*       double cadera
*       String estadoFeto
*       String observaciones
*       GregorianCalendar fechaCitaActual
*       GregorianCalendar fechaSiguienteCita
*
*   Derivadas
*   Compartidas
* Requisitos:
*
* Metodos interface
* Metodos añadidos
* Metodos object y otros:
* */
package clasesBasicas;

import interfaces.RevisionMedica;

import java.util.GregorianCalendar;

public class RevisionMedicaImpl implements RevisionMedica {
    CicloEmbarazo embarazo;
    private double peso;
    private double cintura;
    private double cadera;
    private String estadoFeto;
    private String observaciones;
    private GregorianCalendar fechaCitaActual;
    private GregorianCalendar fechaSiguienteCita;

    //Constructores

    public RevisionMedicaImpl(CicloEmbarazo embarazo, double peso, double cintura, double cadera, String estadoFeto, String observaciones, GregorianCalendar fechaCitaActual, GregorianCalendar fechaSiguienteCita) {
        this.embarazo = embarazo;
        this.peso = peso;
        this.cintura = cintura;
        this.cadera = cadera;
        this.estadoFeto = estadoFeto;
        this.observaciones = observaciones;
        this.fechaCitaActual = fechaCitaActual;
        this.fechaSiguienteCita = fechaSiguienteCita;
    }

    //setters y getters

   // public CicloEmbarazo getEmbarazo() { return embarazo;    }

    // public void setEmbarazo(CicloEmbarazo embarazo) {      this.embarazo = embarazo;    }

    /*Patron delegacion*/
    public GregorianCalendar getEmbarazoFechaInicio(){embarazo.getFechaInicio()}
    public GregorianCalendar getEmbarazoFechaFinReal(){embarazo.getFechaFinReal()}
    public void setEmbarazoFechaInicio(GregorianCalendar fechaInicio){embarazo.setFechaInicio(fechaInicio);};
    public void setEmbarazoFechaFinReal(GregorianCalendar fechaFinReal){embarazo.setFechaFinReal(fechaFinReal);};


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getCadera() {
        return cadera;
    }

    public void setCadera(double cadera) {
        this.cadera = cadera;
    }

    public String getEstadoFeto() {
        return estadoFeto;
    }

    public void setEstadoFeto(String estadoFeto) {
        this.estadoFeto = estadoFeto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public GregorianCalendar getFechaCitaActual() {
        return fechaCitaActual;
    }

    public void setFechaCitaActual(GregorianCalendar fechaCitaActual) {
        this.fechaCitaActual = fechaCitaActual;
    }

    public GregorianCalendar getFechaSiguienteCita() {
        return fechaSiguienteCita;
    }

    public void setFechaSiguienteCita(GregorianCalendar fechaSiguienteCita) {
        this.fechaSiguienteCita = fechaSiguienteCita;
    }


}
