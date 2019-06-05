package interfaces;

import java.util.GregorianCalendar;

public interface Medicamento {
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
}
