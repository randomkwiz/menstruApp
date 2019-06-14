/*
* Nombre: Usuario
* Propiedades:
*   Basicas:
*       String nombre   consultable y modificable
*       String nick     consultable y modificable
*       String password consultable y modificable
*       double peso     consultable y modificable
*       GregorianCalendar fechaNacimiento   consultable y modificable   //por si acaso se confunden al ponerla
*
*   Derivadas:
*       int edad    deriva de fechaNacimiento
*   Compartidas:
* Restricciones:    el nick tendrá entre 3 y 25 caracteres
*                   el nombre tendra maximo 50 caracteres
*                   la contraseña tendra entre 8 y 50 caracteres
*                   el peso debera ser positivo
*                   la fecha de nacimiento no podra ser anterior al año actual menos 120 años.
*
*
*
* Metodos añadidos:
*
* Metodos interface:
    public String getNombre()

    public void setNombre(String nombre)

    public String getNick()

    public void setNick(String nick)

    public String getPassword()

    public void setPassword(String password)

    public double getPeso()

    public void setPeso(double peso)

    public GregorianCalendar getFechaNacimiento()

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento)
*
* Metodos Object y otros:
*   toString()
*
*
*
* */
package clasesBasicas;

import interfaces.Usuario;

import java.util.GregorianCalendar;

public class UsuarioImpl implements Usuario {
    private String nombre;
    private String nick;
    private String password;
    private double peso;
    private GregorianCalendar fechaNacimiento;


    //Constructores

    //sin parametros

    /**
     * Constructor por defecto
     */
    public UsuarioImpl() {
        this.nombre = "";
        this.nick = "";
        this.password = "";
        this.peso = 0.0;
        this.fechaNacimiento = null;


    }

    //con todos los parametros

    /**
     * Constructor con parametros
     * @param nombre nombre del usuario
     * @param nick nick del usuario
     * @param password contraseña del usuario
     * @param peso peso del usuario
     * @param fechaNacimiento fecha de nacimiento del usuario
     */
    public UsuarioImpl(String nombre, String nick, String password, double peso, GregorianCalendar fechaNacimiento) {
        this.nombre = nombre;
        this.nick = nick;
        this.password = password;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;

    }

    //con menos parametros

    /**
     * Constructor con parametros
     * @param nick nick del usuario
     * @param password contraseña del usuario
     */
    public UsuarioImpl(String nick, String password) {
        this.nick = nick;
        this.password = password;
        this.nombre = null;
        this.peso = 0;
        this.fechaNacimiento = null;
    }

    //metodos interface


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "UsuarioImpl{" +
                "nombre='" + nombre + '\'' +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", peso=" + peso +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    @Override
    /*Criterio de igualdad: dos usuarios son iguales si tienen mismo nick y contraseña*/
    public boolean equals (Object obj) {
        boolean igual = false;
        if (this == obj) {
            igual = true;
        } else {
            if (obj != null && obj instanceof UsuarioImpl) {
                UsuarioImpl otro = (UsuarioImpl) obj;
                if (this.getNick().equals(otro.getNick()) &&
                        this.getPassword().equals(otro.getPassword())
                ) {
                    igual = true;
                }
            }
        }
        return igual;
    }

}
