package interfaces;

import java.util.GregorianCalendar;

public interface RevisionMedica {

    //public CicloEmbarazo getEmbarazo(); ->Patron delegacion
    //public void setEmbarazo(CicloEmbarazo embarazo);


    GregorianCalendar getEmbarazoFechaInicio();

    GregorianCalendar getEmbarazoFechaFinReal();

    void setEmbarazoFechaInicio(GregorianCalendar fechaInicio);

    void setEmbarazoFechaFinReal(GregorianCalendar fechaFinReal);


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
}
