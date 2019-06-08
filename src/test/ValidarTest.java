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
        validar.pesoUsuario();


    }
}
