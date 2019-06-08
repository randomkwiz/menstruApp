package interfaces;

import clasesBasicas.CicloEmbarazo;

import java.util.GregorianCalendar;

public interface RevisionMedica {

    //public CicloEmbarazo getEmbarazo(); ->Patron delegacion
    //public void setEmbarazo(CicloEmbarazo embarazo);


    public GregorianCalendar getEmbarazoFechaInicio();
    public GregorianCalendar getEmbarazoFechaFinReal();
    public void setEmbarazoFechaInicio(GregorianCalendar fechaInicio);
    public void setEmbarazoFechaFinReal(GregorianCalendar fechaFinReal);



    public double getPeso();

    public void setPeso(double peso);

    public double getCintura();

    public void setCintura(double cintura);

    public double getCadera();

    public void setCadera(double cadera);

    public String getEstadoFeto();

    public void setEstadoFeto(String estadoFeto) ;


    public String getObservaciones();

    public void setObservaciones(String observaciones);

    public GregorianCalendar getFechaCitaActual();

    public void setFechaCitaActual(GregorianCalendar fechaCitaActual);

    public GregorianCalendar getFechaSiguienteCita();

    public void setFechaSiguienteCita(GregorianCalendar fechaSiguienteCita);
}
