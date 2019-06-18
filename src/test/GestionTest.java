package test;

import clasesBasicas.Ciclo;
import clasesBasicas.CicloEmbarazo;
import clasesBasicas.RevisionPersonalImpl;
import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import utilidades.Utilidades;

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

  /*      Utilidades utilidades = new Utilidades();
        UsuarioImpl u = utilidades.toObject("randomkwiz", "123456789");
        ArrayList<CicloMenstrual> arrayList =gestion.obtenerListaCiclosMenstruales(u);
*/
        // System.out.println(arrayList.size());
/*
        for(int i = 0; i < arrayList.size(); i ++){
            System.out.println(arrayList.get(i).getUsuario().getNick());
            System.out.println(utilidades.formatearFecha(arrayList.get(i).getFechaInicio()));

        }
 */
        // System.out.println(gestion.estaEmbarazada(u));

        //System.out.println(utilidades.formatearFecha(gestion.obtenerEmbarazoEnCurso(u).getFechaFinEstimada()));
        //     UsuarioImpl u2 = utilidades.toObject("aabbayrl", "123456789");


        //   System.out.println(gestion.estaEmbarazada(u2));
        //  gestion.eliminarCuenta(u2);


        //System.out.println( gestion.existeRevisionPersonalDelDiaEnCurso(u2));

 /*      RevisionPersonalImpl rev = gestion.construirObjeto(u2,gestion.obtenerIDRevisionPersonalDelDiaEnCurso(u2));

        System.out.println(utilidades.formatearFecha(rev.getFecha()));
        System.out.println((rev.getID()));


  */
        /*prueba estados de animo*/
/*
        System.out.println();
        System.out.println("Prueba estados de animo");
        System.out.println(rev.getArraylistEstadoAnimico().size());

        gestion.cargarEstadosDeAnimoRevisionPersonal(rev);
        System.out.println(rev.getArraylistEstadoAnimico().size());

        for(int i  = 0; i < rev.getArraylistEstadoAnimico().size(); i ++ ){
            System.out.println(rev.getArraylistEstadoAnimico().get(i).name());
        }


 */
        /*prueba sintomas*/
        /*
        System.out.println();
        System.out.println("Prueba sintomas");
        System.out.println(rev.getArraylistSintoma().size());

        gestion.cargarSintomasRevisionPersonal(rev);
        System.out.println(rev.getArraylistSintoma().size());

        for(int i  = 0; i < rev.getArraylistSintoma().size(); i ++ ){
            System.out.println(rev.getArraylistSintoma().get(i).name());
        }

         */

        /*prueba sexo
        System.out.println();
        System.out.println("Prueba sexo");
        System.out.println(rev.getArraylistSexo().size());

        gestion.cargarSexoRevisionPersonal(rev);
        System.out.println(rev.getArraylistSexo().size());

        for(int i  = 0; i < rev.getArraylistSexo().size(); i ++ ){
            System.out.println(rev.getArraylistSexo().get(i).name());
        }


         */

        /*prueba flujo vaginal
        System.out.println();
        System.out.println("Prueba flujo vaginal");
        System.out.println(rev.getArraylistFlujoVaginal().size());

        gestion.cargarFlujoVaginalRevisionPersonal(rev);
        System.out.println(rev.getArraylistFlujoVaginal().size());

        for(int i  = 0; i < rev.getArraylistFlujoVaginal().size(); i ++ ){
            System.out.println(rev.getArraylistFlujoVaginal().get(i).name());
        }


         */


        /*prueba insertar estado de animo*/
/*
        gestion.insertarEstadoAnimoEnRevisionPersonal(rev, EstadoAnimico.DEPRIMIDA);
        gestion.cargarEstadosDeAnimoRevisionPersonal(rev);
        System.out.println(rev.getArraylistEstadoAnimico().size());

 */

        UsuarioImpl usuario = new UsuarioImpl("iventadoxdxd", "123456789");
        UsuarioImpl user = new UsuarioImpl("randomkwiz", "123456789");
        RevisionPersonalImpl revisionPersonal = new RevisionPersonalImpl(usuario);
        //  System.out.println(gestion.obtenerIDRevisionPersonalDelDiaEnCurso(usuario));

        //System.out.println(gestion.eliminarCuenta(usuario));
        //gestion.crearRevisionPersonalDiaEnCurso(usuario);


        //System.out.println(gestion.existeRevisionPersonalActual(usuario));
        //System.out.println(gestion.existeRevisionPersonalActual(user));


        //System.out.println(rev.toString());
        // System.out.println(gestion.cargarEstadosDeAnimoRevisionPersonal(null));

        //System.out.println(gestion.eliminarRevisionPersonal(revisionPersonal));

        Ciclo ciclo = gestion.ultimoCicloMenstrual(usuario);
        System.out.println(ciclo.getID());
        //gestion.obtenerCicloActual(usuario);
        Utilidades utilidades = new Utilidades();
        CicloEmbarazo embarazo = gestion.obtenerEmbarazoEnCurso(utilidades.cargarUsuario("usuarioPrueba", "123456789"));
        gestion.asignarIDAEmbarazo(embarazo);
        gestion.cargarEmbarazo(embarazo);


        System.out.println(embarazo.getID());

    }
}
