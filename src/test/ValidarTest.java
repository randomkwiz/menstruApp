package test;

import validaciones.Validar;

public class ValidarTest {
    public static void main(String[] args) {
        Validar validar = new Validar();

        System.out.println("angela: "+validar.isRegistrado("angela"));
        System.out.println("pepita: "+validar.isRegistrado("pepita"));
        System.out.println("PEPITA: "+validar.isRegistrado("PEPITA"));

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
        validar.fechaCumple();

    }
}
