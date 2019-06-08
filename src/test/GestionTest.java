package test;

import clasesBasicas.CicloMenstrual;
import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import utilidades.Utilidades;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GestionTest {
    public static void main(String[] args) {

        Gestion gestion = new Gestion();
        //String nombre, String nick, String password, double peso, GregorianCalendar fechaNacimiento
   /*     UsuarioImpl usuario = new UsuarioImpl("Pepe","superPepe","1234", 78, new GregorianCalendar());

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

    */

        Utilidades utilidades = new Utilidades();
        UsuarioImpl u = utilidades.toObject("randomkwiz", "123456789");
        ArrayList<CicloMenstrual> arrayList =gestion.obtenerListaCiclosMenstruales(u);

       // System.out.println(arrayList.size());
/*
        for(int i = 0; i < arrayList.size(); i ++){
            System.out.println(arrayList.get(i).getUsuario().getNick());
            System.out.println(utilidades.formatearFecha(arrayList.get(i).getFechaInicio()));

        }
 */
       // System.out.println(gestion.estaEmbarazada(u));

        //System.out.println(utilidades.formatearFecha(gestion.obtenerEmbarazoEnCurso(u).getFechaFinEstimada()));
        UsuarioImpl u2 = utilidades.toObject("abamlingf7", "123456789");


        System.out.println(gestion.estaEmbarazada(u2));
        gestion.eliminarCuenta(u2);


    }
}
