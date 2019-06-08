package validaciones;

import utilidades.Utilidades;

import java.io.Console;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Validar {

    /*
    * Mostrar y validar menu log in or sign up
    * */

    public int logInOrSignUp (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Iniciar sesion");
            opcion = sc.nextInt();
        }while (opcion < 0 || opcion > 2);
        return opcion;
    }


    /*
     * Mostrar y validar menu principal
     * */

    public int menuPrincipal (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do{
        System.out.println("0. Salir");
        System.out.println("1. Cuenta");
        System.out.println("2. Revision personal");
        System.out.println("3. Ciclo");
        System.out.println("4. Revision medica (solo si existe embarazo)");
        opcion = sc.nextInt();
        }while (opcion < 0 || opcion > 4);
        return opcion;
    }



    /*
     * Mostrar y validar submenu CUENTA
     * */

    public int subMenuCuenta (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do{
        System.out.println("0. Salir");
        System.out.println("1. Ver datos de la cuenta");
        System.out.println("2. Modificar datos de la cuenta");
        System.out.println("3. Eliminar cuenta");
        opcion = sc.nextInt();
        }while (opcion < 0 || opcion > 3);
        return opcion;
    }


    /*
     * Mostrar y validar submenu RevisionPersonal
     * */

    public int subMenuRevisionPersonal (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("0. Salir");
            System.out.println("1. Registrar revision personal");
            System.out.println("2. Ver revisiones personales ");
            System.out.println("3. Buscar revision personal");
            System.out.println("4. Modificar revision personal");
            System.out.println("5. Eliminar revision personal");
            opcion = sc.nextInt();
        }while (opcion < 0 || opcion > 5);
        return opcion;
    }


    /*
     * Mostrar y validar submenu Ciclo
     * */

    public int subMenuCiclo (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do{
        System.out.println("0. Salir");
        System.out.println("1. Registrar ciclo (menstruacion o embarazo)");
        System.out.println("2. Ver datos del ciclo actual ");
        System.out.println("3. Marcar fin del ciclo actual");
        System.out.println("4. Modificar ciclo actual");
        System.out.println("5. Eliminar ciclo");
        opcion = sc.nextInt();
        }while (opcion < 0 || opcion > 5);
        return opcion;
    }


    /*
     * Mostrar y validar submenu RevisionMedica
     * */

    public int subMenuRevisionMedica (){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do{
        System.out.println("0. Salir");
        System.out.println("1. Registrar revision medica");
        System.out.println("2. Ver revisiones pasadas ");
        System.out.println("3. Buscar revision");
        System.out.println("4. Modificar revision");
        System.out.println("5. Ver fecha siguiente revision");
        System.out.println("6. Eliminar revision");
        opcion = sc.nextInt();
        }while (opcion < 0 || opcion > 6);
        return opcion;
    }


    /*
    * INTERFAZ
    *  Comentario: Pide y valida un nuevo nick de usuario. La forma de validarlo sera comprobar
    *               que ese nick no exista en la base de datos y que el numero de caracteres este entre 3 y 25.
    * Signatura: public String nuevoNickUsuario()
    * Precondiciones:
    * Entradas:
    * Salidas: String con el nuevo nick de usuario
    * Postcondiciones: asociado al nombre se devolvera un String que contendra un nick de usuario no existente aun en la base
    *                   de datos del programa.
    * */
    public String nuevoNickUsuario(){
        Scanner sc = new Scanner(System.in);
        String nuevoNick = " ";
        do{
            System.out.println("Introduce tu nuevo nick: ");
            System.out.println("Recuerda que tu nick no puede contener espacios en blanco y debe tener entre 3 y 25 caracteres.");
            nuevoNick = sc.next();
        }while (nuevoNick.length() < 3 || nuevoNick.length() > 25 || isRegistrado(nuevoNick));

        return nuevoNick;
    }

    /*
     * INTERFAZ
     *  Comentario: Comprueba si un nick de usuario está registrado en la base de datos.
     * Signatura: public boolean isRegistrado(String nickUsuario)
     * Precondiciones:
     * Entradas: String nickUsuario que es el nick a comprobar
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devolvera un boolean que sera true si el nick de usuario ya existe en la base de datos
     *                  y sera false si el nick de usuario no existe en la base de datos.
     * */
    public boolean isRegistrado(String nickUsuario){
        boolean registrado = false;
        Utilidades util = new Utilidades();
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "SELECT NICK FROM USUARIO WHERE NICK = '" + nickUsuario+ "'"; //hay que ponerle las comillas simples

            // Crear una conexion con el DriverManager
            //Connection connexionBaseDatos = util.iniciarConexion(sourceURL, usuario, password); -> no funciona
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);
            //Ejecuto la consulta
            Statement sentencia = connexionBaseDatos.createStatement();

            //Recibo los datos en el ResultSet
            ResultSet resultados = sentencia.executeQuery(miSelect);


            // Recorremos el ResultSet
            while (resultados.next()){
                if(resultados.getString("NICK").equals(nickUsuario)){
                    registrado = true;
                }
            }

            // Cerrar
            sentencia.close();
            connexionBaseDatos.close();
        }
        catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return registrado;
    }


    /*
     * INTERFAZ
     *  Comentario: Pide y valida una contraseña de usuario. La forma de validarla sera comprobar
     *               que el numero de caracteres este entre 8 y 50.
     * Signatura: public String establecerPassword()
     * Precondiciones:
     * Entradas:
     * Salidas: String con la password
     * Postcondiciones: asociado al nombre se devolvera un String que contendra una contraseña de usuario de entre 8 y 50 caracteres.
     * */
    public String establecerPassword(){
        Scanner sc = new Scanner(System.in);
       String password ;
        //referencia a la consola
        Console con = System.console();
        do {
            System.out.println("Introduce la contraseña (8-50 caracteres): ");
            if (con == null) {  //si no hay consola, se pedira la contraseña de forma normal
                password = sc.next();
            } else {    //si si hay consola, pedira la contraseña de forma que no se veran los caracteres
                //to read password
                char[] ch = con.readPassword(); //el metodo readPassword no muestra los caracteres al escribirlos

                //converting char array into string
                password = String.valueOf(ch);
            }
        }while (password.length() < 8 || password.length() > 50);

        return password;
    }

    /*
     * INTERFAZ
     *  Comentario: Pide y valida un nombre para la cuenta del usuario. La validacion consiste en que el nombre debe tener mas de 2 caracteres y menos
     *              de 50
     * Signatura: public String nombreUsuario()
     * Precondiciones:
     * Entradas:
     * Salidas: String con el nombre
     * Postcondiciones: asociado al nombre se devolvera un String que contendra el nombre del usuario de entre 3 y 50 caracteres, o bien
     *                  un espacio en blanco si el usuario no desea rellenar el campo.
     * */
    public String nombreUsuario(){
        Scanner sc = new Scanner(System.in);
        String nombreUsuario ;
        do{
            System.out.println("Introduce tu nombre real:");
            System.out.println("Escribe 0 si no deseas rellenar este campo.");
            nombreUsuario = sc.nextLine();
        }while ( !nombreUsuario.equals("0") && (nombreUsuario.length() < 3 || nombreUsuario.length() > 50) );
        if(nombreUsuario.equals("0")){
            nombreUsuario = " ";
        }
        return nombreUsuario;
    }

    /*
     * INTERFAZ
     *  Comentario: Pide y valida el peso de un usuario. La validacion consiste en que el peso debe ser positivo.
     * Signatura: public String pesoUsuario()
     * Precondiciones:
     * Entradas:
     * Salidas: double peso
     * Postcondiciones: asociado al nombre se devolvera un double que contendra el peso del usuario o bien
     *                  un 0 si el usuario no desea rellenar el campo.
     * */
    public double pesoUsuario(){
        Scanner sc = new Scanner(System.in);
        double peso;
        do{
            System.out.println("Introduce peso en kg:");
            System.out.println("Escribe 0 si no deseas rellenar este campo.");
            peso = sc.nextDouble();
        }while (peso < 0);

        return peso;
    }

    /* Estudio interfaz:
     * Necesidades: un año, pasado por valor
     * Devoluciones: un boolean, pasado asociado al nombre
     * Necesidades/Devoluciones: --
     * Requisitos: --
     *
     * Interfaz:
     * Prototipo: boolean esBisiesto(int anno)
     * Comentario: subprograma que indica si un año es bisiesto o no
     * Formula: un año es bisiesto si es divisible entre 400 o bien es divisible entre 4 pero no entre 100. el año debe ser superior o igual a 1582
     * Precondiciones:
     * Entrada: entero año
     * Salida: boolean
     * Entrada/Salida: --
     * Postcondiciones: asociado al nombre se devuelve un boolean como true si el año es bisiesto y como false si no lo es
     * */
    public boolean esBisiesto(int anno){
        boolean bisiesto=false;

        if ( anno >= 1582 && (anno % 400 ==0 || (anno %4 == 0 && anno %100 != 0) )) {
            bisiesto=true;
        }


        return bisiesto;
    }


    /* Estudio interfaz:
     * Necesidades: fecha en formato dia, mes y año. Parámetros pasados por valor
     * Devoluciones: booleano que dira si la fecha es valida o no, parámetro devuelto asociado al nombre
     * Necesidades/Devoluciones:
     * Requisitos:
     *
     * Interfaz:
     * Prototipo: boolean fechaEsValida (int dia, int mes, int anno)
     * Comentario: subprograma que indica si una fecha dada es valida o no
     * Precondiciones:
     * Entrada: entero dia, entero mes, entero anno
     * Salida: boolean
     * Entrada/Salida: --
     * Postcondiciones: asociado al nombre se devolverá un boolean que tendrá el valor true si la fecha es valida y false si no lo es
     * */

    public boolean fechaEsValida (int dia, int mes, int anno){
        boolean fechaValida=false;

        if (dia>= 1 && dia<=31 && (mes >= 1 || mes <= 12) && anno >= 1582 ){

            /* Meses con 31: 1,3,5,7,8,10,12
             * Meses con 30: 4,6,9,11
             * Meses con 28 o 29: 2
             * */
            switch (mes){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    fechaValida=true;
                    break;
                case 2:
                    if (dia <= 28  || ( dia==29 && esBisiesto(anno) ) ) {
                        fechaValida=true;
                    }

                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(dia <=30){
                        fechaValida=true;
                    }
                    break;
            }
        }


        return fechaValida;

    }

    /*
    * INTERFAZ
    * Comentario: pide y valida una fecha de cumpleaños. Devuelve un objeto GregorianCalendar
    * Signatura: public GregorianCalendar fechaCumple()
    * Precondiciones:
    * Entradas:
    * Salidas: objeto gregorianCalendar
    * Postcondiciones: asociado al nombre se devuelve un objeto gregorian calendar con la fecha validada previamente.
    *                   Esto es para asegurar que la fecha que indica el usuario y la que refleja GregorianCalendar coinciden, debido
    *                   a que si el usuario introduce el 31 de junio, Gregorian Calendar automaticamente entenderia
    *                   el 1 de julio. Para evitar esto, valido la entrada del usuario previamente y ya no podria introducir
    *                   el 31 de junio.
    * */
    public GregorianCalendar fechaCumple(){
        Scanner sc = new Scanner(System.in);
        GregorianCalendar fechaCumple = new GregorianCalendar();
        int dia;
        int mes;
        int anyo;
        do{
            System.out.println("Introduce tu fecha de nacimiento: ");
            System.out.print("Dia: ");
            dia = sc.nextInt();
            System.out.print("Mes: ");
            mes = sc.nextInt();
            System.out.print("Año: ");
            anyo = sc.nextInt();
        }while (!fechaEsValida(dia, mes, anyo));

        fechaCumple.set(GregorianCalendar.YEAR, anyo);
        fechaCumple.set(GregorianCalendar.MONTH, mes-1);    //va de 0 a 11
        fechaCumple.set(GregorianCalendar.DATE, dia);


    return fechaCumple;

    }
}
