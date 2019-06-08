package validaciones;

import java.util.Scanner;

public class Validar {

    /*
    * Mostrar y validar menu log in or sign up
    * */

    public int logInOrSignUp (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        System.out.println("0. Salir");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Iniciar sesion");
        opcion = sc.nextInt();
        return opcion;
    }


    /*
     * Mostrar y validar menu principal
     * */

    public int menuPrincipal (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        System.out.println("0. Salir");
        System.out.println("1. Cuenta");
        System.out.println("2. Revision personal");
        System.out.println("3. Ciclo");
        System.out.println("4. Revision medica (solo si existe embarazo)");
        opcion = sc.nextInt();
        return opcion;
    }



    /*
     * Mostrar y validar submenu CUENTA
     * */

    public int subMenuCuenta (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        System.out.println("0. Salir");
        System.out.println("1. Ver datos de la cuenta");
        System.out.println("2. Modificar datos de la cuenta");
        System.out.println("3. Eliminar cuenta");
        opcion = sc.nextInt();
        return opcion;
    }


    /*
     * Mostrar y validar submenu RevisionPersonal
     * */

    public int subMenuRevisionPersonal (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        System.out.println("0. Salir");
        System.out.println("1. Registrar revision personal");
        System.out.println("2. Ver revisiones personales ");
        System.out.println("3. Buscar revision personal");
        System.out.println("4. Modificar revision personal");
        System.out.println("5. Eliminar revision personal");
        opcion = sc.nextInt();
        return opcion;
    }


    /*
     * Mostrar y validar submenu Ciclo
     * */

    public int subMenuCiclo (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        System.out.println("0. Salir");
        System.out.println("1. Registrar ciclo (menstruacion o embarazo)");
        System.out.println("2. Ver datos del ciclo actual ");
        System.out.println("3. Marcar fin del ciclo actual");
        System.out.println("4. Modificar ciclo actual");
        System.out.println("5. Eliminar ciclo");
        opcion = sc.nextInt();
        return opcion;
    }


    /*
     * Mostrar y validar submenu RevisionMedica
     * */

    public int subMenuRevisionMedica (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        System.out.println("0. Salir");
        System.out.println("1. Registrar revision medica");
        System.out.println("2. Ver revisiones pasadas ");
        System.out.println("3. Buscar revision");
        System.out.println("4. Modificar revision");
        System.out.println("5. Ver fecha siguiente revision");
        System.out.println("6. Eliminar revision");
        opcion = sc.nextInt();
        return opcion;
    }
}
