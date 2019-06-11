package interfaces;

import java.util.GregorianCalendar;

public interface Usuario {
    String getNombre();

    void setNombre(String nombre);

    String getNick();

    void setNick(String nick);

    String getPassword();

    void setPassword(String password);

    double getPeso();

    void setPeso(double peso);

    GregorianCalendar getFechaNacimiento();

    void setFechaNacimiento(GregorianCalendar fechaNacimiento);
}
