package test;

import clasesBasicas.UsuarioImpl;
import gestion.Gestion;

import java.util.GregorianCalendar;

public class GestionTest {
    public static void main(String[] args) {

        Gestion gestion = new Gestion();
        //String nombre, String nick, String password, double peso, GregorianCalendar fechaNacimiento
        UsuarioImpl usuario = new UsuarioImpl("Pepe","superPepe","1234", 78, new GregorianCalendar());

        GregorianCalendar fechaCumple = new GregorianCalendar();
        fechaCumple.set(GregorianCalendar.YEAR, 1997);
        fechaCumple.set(GregorianCalendar.MONTH, 6);    //va de 0 a 11
        fechaCumple.set(GregorianCalendar.DATE, 23);

        UsuarioImpl usuario2 = new UsuarioImpl("Tuca2","ratitaPower3","1234", 95,fechaCumple);

        fechaCumple.set(GregorianCalendar.YEAR, 1992);
        fechaCumple.set(GregorianCalendar.MONTH, 0);    //va de 0 a 11
        fechaCumple.set(GregorianCalendar.DATE, 12);
        UsuarioImpl usuarioDeBo = new UsuarioImpl("Angel", "Swo", "12345", 0,fechaCumple );

        UsuarioImpl user = new UsuarioImpl("ROCKETMAN", "12345");



        //gestion.insertarUsuarioEnBBDD(usuario);
        gestion.insertarUsuarioEnBBDD(user);
    }
}
