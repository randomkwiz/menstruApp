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

import java.util.GregorianCalendar;

public class RevisionMedicaImpl {
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

    
}
