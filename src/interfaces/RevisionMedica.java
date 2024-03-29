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
 *       String ID
 *
 *   Derivadas
 *   Compartidas
 * Requisitos:
 * Los atributos como el peso, la cintura y cadera no pueden ser negativos.
 *
 * Metodos interface
 *
    public CicloEmbarazo getEmbarazo();

    public void setEmbarazo(CicloEmbarazo embarazo) ;


    double getPeso();

    void setPeso(double peso);

    double getCintura();

    void setCintura(double cintura);

    double getCadera();

    void setCadera(double cadera);

    String getEstadoFeto();

    void setEstadoFeto(String estadoFeto);


    String getObservaciones();

    void setObservaciones(String observaciones);

    GregorianCalendar getFechaCitaActual();

    void setFechaCitaActual(GregorianCalendar fechaCitaActual);

    GregorianCalendar getFechaSiguienteCita();

    void setFechaSiguienteCita(GregorianCalendar fechaSiguienteCita);
 * Metodos añadidos
 * Metodos object y otros:
 * */
package interfaces;

import clasesBasicas.CicloEmbarazo;

import java.util.GregorianCalendar;

public interface RevisionMedica {

    //public CicloEmbarazo getEmbarazo(); ->Patron delegacion
    //public void setEmbarazo(CicloEmbarazo embarazo);



    public CicloEmbarazo getEmbarazo();

    public void setEmbarazo(CicloEmbarazo embarazo) ;


    double getPeso();

    void setPeso(double peso);

    double getCintura();

    void setCintura(double cintura);

    double getCadera();

    void setCadera(double cadera);

    String getEstadoFeto();

    void setEstadoFeto(String estadoFeto);


    String getObservaciones();

    void setObservaciones(String observaciones);

    GregorianCalendar getFechaCitaActual();

    void setFechaCitaActual(GregorianCalendar fechaCitaActual);

    GregorianCalendar getFechaSiguienteCita();

    void setFechaSiguienteCita(GregorianCalendar fechaSiguienteCita);
    public String getID();

    public void setID(String ID);
}
