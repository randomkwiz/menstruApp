package interfaces;

import java.util.GregorianCalendar;

public interface Usuario {
    public String getNombre();
    public void setNombre(String nombre);
    public String getNick();
    public void setNick(String nick);
    public String getPassword();
    public void setPassword(String password);
    public double getPeso();
    public void setPeso(double peso);
    public GregorianCalendar getFechaNacimiento();
    public void setFechaNacimiento(GregorianCalendar fechaNacimiento);
}
