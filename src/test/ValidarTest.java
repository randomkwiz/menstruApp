package test;

import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import utilidades.Utilidades;
import validaciones.Validar;

public class ValidarTest {
    public static void main(String[] args) {
        Validar validar = new Validar();
/*
        System.out.println("angela: "+validar.isRegistrado("angela"));
        System.out.println("pepita: "+validar.isRegistrado("pepita"));
        System.out.println("PEPITA: "+validar.isRegistrado("PEPITA"));
*/
        //validar.nuevoNickUsuario();
        //validar.establecerPassword();

        //System.out.println(validar.nombreUsuario());
        //validar.pesoUsuario();

        /*
        System.out.println(validar.fechaEsValida(29,2,2008));
        validar.fechaEsValida(29,2,2008);
        System.out.println(validar.fechaEsValida(28,2,2008));
        System.out.println(validar.fechaEsValida(30,2,2008));
        System.out.println(validar.fechaEsValida(28,2,2009));
        System.out.println(validar.fechaEsValida(30,2,2009));
        System.out.println(validar.fechaEsValida(31,6,2008));
        System.out.println(validar.fechaEsValida(32,2,2008));
        System.out.println(validar.fechaEsValida(32,7,2008));
        System.out.println(validar.fechaEsValida(31,7,2008));
*/
        //  validar.fechaCumple();

       /* System.out.println(validar.combinacionInicioSesion("randomkwiz", "12345"));
        System.out.println(validar.combinacionInicioSesion("randomkwiz", "123456789"));
        */
/*
       String prueba  = validar.pedirValidarOpcionEnum(Sexo.values());
        System.out.println(prueba);

        if(prueba == null){
            System.out.println("Prueba  == null funciona");
        }


 */
/*
         prueba  = validar.pedirValidarOpcionEnum(EstadoAnimico.values());
        System.out.println(prueba);

         prueba  = validar.pedirValidarOpcionEnum(FlujoVaginal.values());
        System.out.println(prueba);
         prueba  = validar.pedirValidarOpcionEnum(Sintoma.values());
        System.out.println(prueba);
 */

        Utilidades util = new Utilidades();
        UsuarioImpl usuario = new UsuarioImpl("randomkwiz", "123456789");
        Gestion gestion = new Gestion();
        String prueba = validar.pedirValidarCiclosMenstrualesDeUsuario(usuario);
        System.out.println(prueba);

        gestion.eliminarCicloBBDD(usuario, prueba);


        //  System.out.println(util.formatearFecha(validar.pedirFechaInicioFinCiclo()));


    }
}
