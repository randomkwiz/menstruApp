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
