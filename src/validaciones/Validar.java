package validaciones;

import clasesBasicas.CicloEmbarazo;
import clasesBasicas.RevisionMedicaImpl;
import clasesBasicas.RevisionPersonalImpl;
import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import utilidades.Utilidades;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validar<T extends Enum<T>> {

    /*
     * Mostrar y validar menu log in or sign up
     * */

    public int logInOrSignUp() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("0. Salir");
                System.out.println("1. Crear cuenta");
                System.out.println("2. Iniciar sesion");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 2);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }
        return opcion;
    }


    /*
     * Mostrar y validar menu principal
     * */

    public int menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("0. Salir al menu de login");
                System.out.println("1. Cuenta");
                System.out.println("2. Revision personal");
                System.out.println("3. Ciclo");
                System.out.println("4. Revision medica (solo si existe embarazo)");
                System.out.println("5. Medicamento");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 5);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }
        return opcion;
    }



    /*
     * Mostrar y validar submenu CUENTA
     * */

    public int subMenuCuenta() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("0. Volver atras");
                System.out.println("1. Ver datos de la cuenta");
                System.out.println("2. Modificar datos de la cuenta");
                System.out.println("3. Eliminar cuenta");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 3);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return opcion;
    }


    /*
     * Mostrar y validar submenu RevisionPersonal
     * */

    public int subMenuRevisionPersonal() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("0. Volver atras");
                System.out.println("1. Registrar revision personal");
                System.out.println("2. Ver revisiones personales ");
                System.out.println("3. Buscar revision personal");
                System.out.println("4. Eliminar revision personal");
                System.out.println("5. Ver analisis personal");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 5);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return opcion;
    }


    /*
     * Mostrar y validar submenu Ciclo
     * */

    public int subMenuCiclo() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("0. Volver atras");
                System.out.println("1. Registrar ciclo (menstruacion o embarazo)");
                System.out.println("2. Ver datos del ciclo actual ");
                System.out.println("3. Marcar fin del ciclo actual");
                System.out.println("4. Eliminar ciclo");
                System.out.println("5. Ver ciclos anteriores");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 5);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return opcion;
    }


    /*
     * Mostrar y validar submenu RevisionMedica
     * */

    public int subMenuRevisionMedica() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("0. Volver atras");
                System.out.println("1. Registrar revision medica");
                System.out.println("2. Ver revisiones pasadas ");
                System.out.println("3. Buscar revision");
                System.out.println("4. Modificar revision");
                System.out.println("5. Ver fecha siguiente revision");
                System.out.println("6. Eliminar revision");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 6);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

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
    public String nuevoNickUsuario() {
        Scanner sc = new Scanner(System.in);
        String nuevoNick = " ";
        try {
            do {
                System.out.println("Introduce tu nuevo nick: ");
                System.out.println("Recuerda que tu nick no puede contener espacios en blanco y debe tener entre 3 y 25 caracteres.");
                nuevoNick = sc.next();
            } while (nuevoNick.length() < 3 || nuevoNick.length() > 25 || isRegistrado(nuevoNick));
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


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
    public boolean isRegistrado(String nickUsuario) {
        boolean registrado = false;
        Utilidades util = new Utilidades();
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "SELECT NICK FROM USUARIO WHERE NICK = '" + nickUsuario + "'"; //hay que ponerle las comillas simples

            // Crear una conexion con el DriverManager
            //Connection connexionBaseDatos = util.iniciarConexion(sourceURL, usuario, password); -> no funciona
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);
            //Ejecuto la consulta
            Statement sentencia = connexionBaseDatos.createStatement();

            //Recibo los datos en el ResultSet
            ResultSet resultados = sentencia.executeQuery(miSelect);


            // Recorremos el ResultSet
            while (resultados.next()) {
                if (resultados.getString("NICK").equals(nickUsuario)) {
                    registrado = true;
                }
            }

            // Cerrar
            sentencia.close();
            resultados.close();
            connexionBaseDatos.close();

        } catch (SQLException sqle) {
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
    public String establecerPassword() {
        Scanner sc = new Scanner(System.in);
        String password = null;
        //referencia a la consola
        Console con = System.console();
        try {
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
            } while (password.length() < 8 || password.length() > 50);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


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
     *                  un null si el usuario no desea rellenar el campo.
     * */
    public String nombreUsuario() {
        Scanner sc = new Scanner(System.in);
        String nombreUsuario = null;
        try {
            do {
                System.out.println("Introduce tu nombre real:");
                System.out.println("Escribe 0 si no deseas rellenar este campo.");
                nombreUsuario = sc.nextLine();
            } while (!nombreUsuario.equals("0") && (nombreUsuario.length() < 3 || nombreUsuario.length() > 50));
            if (nombreUsuario.equals("0")) {
                nombreUsuario = null;   //devuelvo un null en vez de espacio en blanco para que en la bbdd se ponga NULL y no " "
            }
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
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
    public double pesoUsuario() {
        Scanner sc = new Scanner(System.in);
        double peso = 0;
        try {
            do {
                System.out.println("Introduce peso en kg:");
                System.out.println("Escribe 0 si no deseas rellenar este campo.");
                peso = sc.nextDouble();
            } while (peso < 0);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


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
    public boolean esBisiesto(int anno) {
        boolean bisiesto = false;

        if (anno >= 1582 && (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0))) {
            bisiesto = true;
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

    public boolean fechaEsValida(int dia, int mes, int anno) {
        boolean fechaValida = false;

        if (dia >= 1 && dia <= 31 && (mes >= 1 || mes <= 12) && anno >= 1582) {

            /* Meses con 31: 1,3,5,7,8,10,12
             * Meses con 30: 4,6,9,11
             * Meses con 28 o 29: 2
             * */
            switch (mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    fechaValida = true;
                    break;
                case 2:
                    if (dia <= 28 || (dia == 29 && esBisiesto(anno))) {
                        fechaValida = true;
                    }

                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (dia <= 30) {
                        fechaValida = true;
                    }
                    break;
            }
        }


        return fechaValida;

    }


    /*
     * INTERFAZ
     * Comentario: pide y valida una fecha. Devuelve un objeto GregorianCalendar
     * Signatura: public GregorianCalendar validarFecha()
     * Precondiciones:
     * Entradas:
     * Salidas: objeto gregorianCalendar
     * Postcondiciones: asociado al nombre se devuelve un objeto gregorian calendar con la fecha validada previamente.
     *                   Esto es para asegurar que la fecha que indica el usuario y la que refleja GregorianCalendar coinciden, debido
     *                   a que si el usuario introduce el 31 de junio, Gregorian Calendar automaticamente entenderia
     *                   el 1 de julio. Para evitar esto, valido la entrada del usuario previamente y ya no podria introducir
     *                   el 31 de junio.
     *                   Tambien valida que la fecha introducida no sea superior a la actual.
     * */
    public GregorianCalendar validarFecha() {
        Scanner sc = new Scanner(System.in);
        GregorianCalendar fecha = null;
        GregorianCalendar fechaHoy = new GregorianCalendar();
        int dia = -1;
        int mes = -1;
        int anyo = -1;
        try {

            do {
                do {


                    System.out.print("Dia: ");
                    dia = sc.nextInt();


                } while (dia < 0 || dia > 31);


                do {

                    System.out.print("Mes: ");
                    mes = sc.nextInt();

                } while (mes < 0 || mes > 12);


                do {

                    System.out.print("Año: ");
                    anyo = sc.nextInt();

                } while (anyo != 0 && anyo < 1582);

                fecha = new GregorianCalendar();
                fecha.set(GregorianCalendar.YEAR, anyo);
                fecha.set(GregorianCalendar.MONTH, mes - 1);    //va de 0 a 11
                fecha.set(GregorianCalendar.DATE, dia);
            } while (!fechaEsValida(dia, mes, anyo) && (dia != 0 || mes != 0 || anyo != 0) || fecha.after(fechaHoy)  );
        } catch (InputMismatchException e) {
            System.out.println("Error al registrar la fecha, intenta cambiarla desde el programa mas adelante.");
            dia = 0;
            mes = 0;
            anyo = 0;
        }

        if ((dia == 0 && mes == 0 && anyo == 0) || fecha.after(fechaHoy)) {
            fecha = null;
        }
        return fecha;
    }


    /*
     * INTERFAZ
     * Comentario: comprueba una combinacion de nick/password
     * Signatura public boolean combinacionInicioSesion(String nick, String pass)
     * Precondiciones:
     * Entradas: nick del usuario y contraseña
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devolvera un boolean que sera true si la combinacion de nick y contraseña es correcta y false si no.
     * */
    public boolean combinacionInicioSesion(String nick, String pass) {
        boolean exito = false;
        try {
            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select nick from USUARIO where NICK =? and PWDCOMPARE(?,PASS)= 1";


            //Crear conexion con la BBDD
            Connection conexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = conexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, nick);
            preparedStatement.setString(2, pass);

            //Ejecutar
            ResultSet miResultado = preparedStatement.executeQuery();
            if (miResultado.next()) {    //el metodo .next() devuelve false si no hay mas filas
                exito = true;
                //System.out.println("Entra");
            }

            //Cerrar
            miResultado.close();
            preparedStatement.close();
            conexionBaseDatos.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return exito;
    }


    /*
     * INTERFAZ
     * Comentario: pide los datos del login y devuelve el objeto Usuario
     * Signatura: public UsuarioImpl pedirLogin()
     *
     * */
    public UsuarioImpl pedirLogin() {
        String nick = "";
        String pass = "";
        UsuarioImpl usuario = null;
        Utilidades util = new Utilidades();
        Scanner sc = new Scanner(System.in);
        try {
            do {
                System.out.println("Introduce el nick: ");
                nick = sc.next();
                pass = establecerPassword();
            } while (combinacionInicioSesion(nick, pass) == false);

            usuario = util.cargarUsuario(nick, pass);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return usuario;
    }

    /*
     * INTERFAZ
     * Signatura: public boolean borrarCuenta()
     * Comentario: pide y valida si el usuario desea realmente eliminar su cuenta.
     * Precondiciones:
     * Entradas:
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si el usuario efectivamente desea eliminar su cuenta y false si no
     * */
    public boolean borrarCuenta() {
        Scanner sc = new Scanner(System.in);
        boolean seguro = false;
        String respuesta = " ";
        try {
            do {
                System.out.println("¿Estas segura de que deseas eliminar tu cuenta? SI/NO");
                respuesta = sc.nextLine().toUpperCase();
            } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

            if (respuesta.equals("SI")) {
                seguro = true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return seguro;
    }

    /*
     * INTERFAZ
     * Signatura: public boolean borrarRevision()
     * Comentario: pide y valida si el usuario desea realmente eliminar su revision.
     * Precondiciones:
     * Entradas:
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si el usuario efectivamente desea eliminar su revision y false si no
     * */
    public boolean borrarRevision() {
        Scanner sc = new Scanner(System.in);
        boolean seguro = false;
        String respuesta = " ";
        try {
            do {
                System.out.println("¿Estas segura de que deseas eliminar la revision? SI/NO");
                respuesta = sc.nextLine().toUpperCase();
            } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

            if (respuesta.equals("SI")) {
                seguro = true;
            }
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return seguro;
    }


    /*
     * INTERFAZ
     * Comentario: Submenu del apartado RevisionPersonal, lee y valida la opcion elegida
     * Signatura public int submenuRegistrarRevisionPersonal()
     * Salida: entero que es la opcion del menu (0 - 4)
     * Postcondiciones: asociado al nombre devuelve una opcion elegida por el usuario entre 0 y 4
     * */
    public int submenuRegistrarRevisionPersonal() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("Opciones:");
                System.out.println("0. Volver atras");
                System.out.println("1. Estado animico");
                System.out.println("2. Flujo vaginal");
                System.out.println("3. Sexo");
                System.out.println("4. Sintomas");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 4);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return opcion;
    }

    /*
     * INTERFAZ
     * Comentario: muestra en pantalla, pide y valida la opcion de una lista de valores de un enum
     * Signatura: public String pedirValidarOpcionEnum(T[] enumerados)
     * Precondiciones: como entrada se debe pasar un enum
     * Entradas: un enum
     * Salidas: String que es el valor del enum elegido por el usuario
     * Postcondiciones: asociado al nombre se devuelve como cadena el valor del enum elegido por el usuario
     *               o null si el usuario desea salir de este menu
     * */
    public String pedirValidarOpcionEnum(T[] enumerados) {
        Scanner sc = new Scanner(System.in);
        Utilidades utilidades = new Utilidades();
        int opcion = -1;
        String value = null;
        try {

            do {
                System.out.println("0. Volver atras");
                utilidades.imprimirValoresEnum(enumerados);
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion >= enumerados.length);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        if (opcion != 0) {
                for (T col : enumerados) {
                    if (col.ordinal() == opcion) {
                        value = col.toString();
                    }
                }

            }

        return value;
    }

    /*
     * INTERFAZ
     * Signatura: public GregorianCalendar pedirFechaInicioCiclo()
     * Comentario: pide y valida una fecha, o devuelve la fecha actual si el usuario no desea establecer otra fecha.
     * Precondiciones:
     * Entradas:
     * Salidas: fecha GregorianCalendar
     * Postcondiciones: Asociado al nombre devuelve una fecha valida o devuelve la fecha actual si el usuario no desea establecer otra fecha.
     * */
    public GregorianCalendar pedirValidarFecha() {
        GregorianCalendar fecha = new GregorianCalendar();
        GregorianCalendar hoy = new GregorianCalendar();
        Scanner sc = new Scanner(System.in);
        int dia, mes, anyo;
        try {
            do {
                do {
                    System.out.println("Introduce 0 en los tres campos para establecer la fecha por defecto (actual)");
                    System.out.print("Dia: ");
                    dia = sc.nextInt();
                    System.out.print("Mes: ");
                    mes = sc.nextInt();
                    System.out.print("Año: ");
                    anyo = sc.nextInt();

                } while (!fechaEsValida(dia, mes, anyo) && (dia != 0 || mes != 0 || anyo != 0));

                if (dia != 0 && mes != 0 && anyo != 0) {
                    fecha.set(GregorianCalendar.YEAR, anyo);
                    fecha.set(GregorianCalendar.MONTH, mes - 1);    //va de 0 a 11
                    fecha.set(GregorianCalendar.DATE, dia);
                }
            } while (fecha.after(hoy));
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return fecha;

    }

    /*
     * INTERFAZ
     * Comentario: Elegir si el usuario desea registrar el inicio de un ciclo menstrual o de un embarazo
     * Signatura: public int pedirValidarMenuReglaOEmbarazo()
     * Precondiciones:
     * Entradas:
     * Salidas: entero
     * Postcondiciones: Asociado al nombre se devolvera 1 para regla, 2 para embarazo o 0 para ninguno
     * */
    public int pedirValidarMenuReglaOEmbarazo() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("Elige");
                System.out.println("0. Volver atras");
                System.out.println("1. Menstruacion");
                System.out.println("2. Embarazo");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 2);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return opcion;
    }

    /*
     * INTERFAZ
     * Comentario:Pide y valida la opcion del usuario sobre qué campo de la cuenta desea modificar
     * Signatura: public int pedirValidarMenuCampoAModificar()
     * Precondiciones:
     * Entradas:
     * Salidas: entero
     * Postcondiciones: Asociado al nombre se devolvera 1 para el nombre, 2 para el peso
     *                  3 para la contraseña o 0 para volver atras
     * */
    public int pedirValidarMenuCampoAModificar() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("Elige");
                System.out.println("0. Volver atras");
                System.out.println("1. Nombre");
                System.out.println("2. Peso");
                System.out.println("3. Contraseña");
                System.out.println("4. Fecha de nacimiento");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 4);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return opcion;
    }

    /*
     * INTERFAZ
     * Comentario: pide y valida un nombre para el usuario
     * Signatura: public String pedirValidarNuevoNombre(UsuarioImpl usuario)
     * Precondiciones:
     * Entradas: Usuario que sera el usuario del que pediremos el nuevo nombre
     * Salidas: String que sera el nuevo nombre del usuario
     * Postcondiciones: Asociado al nombre devuelve un String con el nuevo nombre de usuario o null si el usuario
     *                   finalmente no desea cambiar el nombre.
     * */
    public String pedirValidarNuevoNombre(UsuarioImpl usuario) {
        Scanner sc = new Scanner(System.in);
        String nuevoNombre = null;
        try {
            do {
                System.out.println("Introduce tu nombre:");
                System.out.println("Pulsa 0 para volver atras");
                nuevoNombre = sc.next();
            } while (!nuevoNombre.equals(0) && nuevoNombre.length() < 3 || nuevoNombre.length() > 50);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return nuevoNombre;
    }

    /*
     * INTERFAZ
     * Comentario: pide y valida un nuevo peso para el usuario
     * Signatura: public double pedirValidarNuevoPeso(UsuarioImpl usuario)
     * Precondiciones:
     * Entradas: Usuario que sera el usuario del que pediremos el nuevo peso
     * Salidas: double que sera el nuevo peso del usuario
     * Postcondiciones: Asociado al nombre devuelve un double con el nuevo peso de usuario o 0 si el usuario
     *                   finalmente no desea cambiar el peso.
     * */
    public double pedirValidarNuevoPeso(UsuarioImpl usuario) {
        Scanner sc = new Scanner(System.in);
        double nuevoPeso = -1;
        try {
            do {
                System.out.println("Introduce tu peso:");
                System.out.println("Pulsa 0 para volver atras");
                nuevoPeso = sc.nextInt();
            } while (nuevoPeso < 0 || nuevoPeso > 400);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return nuevoPeso;
    }

    /*INTERFAZ
     * Comentario: metodo para listar en pantalla todos los ciclos que haya tenido un usuario y devolver el Id del elegido
     * Signatura public String pedirValidarCiclosMenstrualesDeUsuario(UsuarioImpl user)
     * Precondiciones:
     * Entradas:
     * Salidas:
     * Postcondiciones: Imprime en pantalla y devuelve asociado al nombre el ID del ciclo elegido por el usuario
     *                  o null si no desea eliminar ninguno.
     * */
    public String pedirValidarCiclosMenstrualesDeUsuario(UsuarioImpl user) {
        Gestion gestion = new Gestion();
        Utilidades util = new Utilidades();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        String idCiclo = null;
        try {
            do {
                System.out.println("Ciclos menstruales");
                System.out.println("0. Volver atras");
                util.imprimirCiclosMenstruales(user);
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > gestion.obtenerListaCiclosMenstruales(user).size());

            if (opcion > 0) {
                idCiclo = gestion.obtenerListaCiclosMenstruales(user).get(opcion - 1).getID();
            }
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return idCiclo;
    }


    /*INTERFAZ
     * Comentario: metodo para listar en pantalla todos los embarazos que haya tenido un usuario y devolver el Id del elegido
     * Signatura public String pedirValidarEmbarazosDeUsuario(UsuarioImpl user)
     * Precondiciones:
     * Entradas:
     * Salidas:
     * Postcondiciones: Imprime en pantalla y devuelve asociado al nombre el ID del ciclo elegido por el usuario
     * o null si no desea eliminar ninguno.
     * */
    public String pedirValidarEmbarazosDeUsuario(UsuarioImpl user) {
        Gestion gestion = new Gestion();
        Utilidades util = new Utilidades();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        String idCiclo = null;
        try {
            do {
                System.out.println("Embarazos");
                System.out.println("0. Volver atras");
                util.imprimirEmbarazos(user);
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > gestion.obtenerListaEmbarazos(user).size());
            if (opcion != 0) {
                idCiclo = gestion.obtenerListaEmbarazos(user).get(opcion - 1).getID();
            }
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return idCiclo;
    }

    /*
     * INTERFAZ
     * Comentario: metodo que pide y valida si el usuario desea buscar revisiones personales por fecha, o por estado individual.
     * Signatura: public int pedirValidarSiBuscarPorFechaOEstadoEnum()
     * Precondiciones:
     * Entradas:
     * Salidas:
     * Postcondiciones: asociado al nombre devuelve un entero que sera 0 si el usuario no desea ninguna de las opciones, 1 si el usuario desea buscar por fecha
     *                   y 2 si el usuario desea buscar por enum.
     * */
    public int pedirValidarSiBuscarPorFechaOEstadoEnum() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        try {
            do {
                System.out.println("0. Volver atras");
                System.out.println("1. Buscar por fecha");
                System.out.println("2. Buscar por registro");
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > 2);

        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        return opcion;
    }

    /*
     * INTERFAZ
     * Signatura: public int anyo()
     * Comentario: pide y valida un año
     * Precondiciones:
     * Entradas:
     * Salidas: int
     * Postcondiciones: asociado al nombre se devuelve un año
     * */
    public int anyo() {
        Scanner sc = new Scanner(System.in);
        int anyo_buscado = 1582;
        try {
            do {
                System.out.println("Introduce el año de la/s revision/es a buscar: ");
                anyo_buscado = sc.nextInt();
            } while (anyo_buscado < 1582);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return anyo_buscado;
    }

    /*
     * INTERFAZ
     * Signatura: public int mes()
     * Comentario: pide y valida un mes. El mes 0 significa que el usuario no desea tener en cuenta el mes en la busqueda.
     * Precondiciones:
     * Entradas:
     * Salidas: int
     * Postcondiciones: asociado al nombre se devuelve un mes
     * */
    public int mes() {
        Scanner sc = new Scanner(System.in);
        int mes_buscado = 0;
        try {
            do {
                System.out.println("Introduce el mes de la/s revision/es a buscar. Escribe 0 si no deseas tener en cuenta el mes: ");
                mes_buscado = sc.nextInt();
            } while (mes_buscado < 0 || mes_buscado > 12);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return mes_buscado;
    }

    /*
     * INTERFAZ
     * Signatura: public int dia()
     * Comentario: pide y valida un dia. El dia 0 significa que el usuario no desea tener en cuenta el dia en la busqueda.
     * Precondiciones:
     * Entradas:
     * Salidas: int
     * Postcondiciones: asociado al nombre se devuelve un dia
     * */
    public int dia() {
        Scanner sc = new Scanner(System.in);
        int dia_buscado = 0;
        try {
            do {
                System.out.println("Introduce el dia de la/s revision/es a buscar. Escribe 0 si no deseas tener en cuenta el dia: ");
                dia_buscado = sc.nextInt();
            } while (dia_buscado < 0 || dia_buscado > 31);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return dia_buscado;
    }

    /*
     * INTERFAZ
     * Comentario: Metodo que muestra, pide y valida una lista de RevisionesPersonalesImpl y devuelve la revision seleccionada
     *           por el usuario
     * Signatura: public RevisionPersonalImpl pedirValidarListaRevisionesPersonalesImpl(ArrayList<RevisionPersonalImpl> lista)
     * Precondiciones:
     * Entradas:
     * Salidas: revision personal
     * Postcondiciones: asociado al nombre devuelve una revision que sera la elegida por el usuario o null si el usuario no
     *                   elige ninguna
     * */
    public RevisionPersonalImpl pedirValidarListaRevisionesPersonalesImpl(ArrayList<RevisionPersonalImpl> lista) {
        RevisionPersonalImpl revisionElegida = null;
        Scanner sc = new Scanner(System.in);
        Utilidades util = new Utilidades();
        int opcion = 0;
        try {
            do {
                util.imprimirDatosRevisionPersonalLista(lista);
                opcion = sc.nextInt();
            } while (opcion < 0 || opcion > lista.size());
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        if (opcion != 0) {
            revisionElegida = lista.get(opcion - 1);
        }

        return revisionElegida;
    }


    /*
    * INTERFAZ
    * Comentario: pide y valida los datos de un objeto RevisionMedicaImpl y
    *             lo construye, devolviendolo asociado al nombre.
    * Signatura: public RevisionMedicaImpl pedirValidarRevisionMedicaImpl (CicloEmbarazo embarazo)
    * Precondiciones:
    * Entradas: CicloEmbarazo al que hace referencia la cita medica.
    * Salidas: objeto revision medica
    * Postcondiciones: asociado al nombre se devuelve un objeto revision medica, o null si el objeto
    *                   embarazo es null.
    * */

    /**
     * Pide y valida los datos de un objeto RevisionMedicaImpl y
     *   lo construye, devolviendolo asociado al nombre.
     * @param embarazo CicloEmbarazo al que hace referencia la cita medica.
     * @return asociado al nombre se devuelve un objeto revision medica, o null si el objeto
     *      embarazo es null.
     */
    public RevisionMedicaImpl pedirValidarRevisionMedicaImpl (CicloEmbarazo embarazo){
        RevisionMedicaImpl revisionMedica = null;
        Scanner sc = new Scanner(System.in);
        double peso = 0.0;
        double cintura = 0.0;
        double cadera = 0.0;
        String estadoFeto = "";
        String observaciones = "";
        GregorianCalendar fechaCitaActual = null;
        GregorianCalendar fechaSiguienteCita = null;
        if(embarazo != null){
        do{
            peso = pesoUsuario();
            cintura = medidaUsuario("cintura");
            cadera = medidaUsuario("cadera");
            System.out.println("Introduce observaciones sobre el estado del feto : ");
            estadoFeto = sc.nextLine();
            System.out.println("Introduce observaciones generales de la revision medica: ");
            observaciones = sc.nextLine();
            fechaCitaActual = pedirValidarFecha();
            if(hacerPreguntaSioNo("¿Tienes fecha para la siguiente cita?")){
                fechaSiguienteCita = pedirValidarFecha();
            }else{
                System.out.println("No tienes fecha para la siguiente cita");
            }

        }while (fechaSiguienteCita != null && !fechaSiguienteCita.after(fechaCitaActual));
        revisionMedica = new RevisionMedicaImpl(embarazo,peso,cintura,cadera,estadoFeto,observaciones,fechaCitaActual,fechaSiguienteCita);
        }
        return revisionMedica;
    }

    /*
     * INTERFAZ
     *  Comentario: Pide y valida la medida de cm de un usuario.
     *              La validacion consiste en que la medida debe ser positiva.
     * Signatura: public double medidaUsuario(String parteAMedir)
     * Precondiciones:
     * Entradas: String que sera la parte a medir
     * Salidas: double medida
     * Postcondiciones: asociado al nombre se devolvera un double que contendra la medida del usuario o bien
     *                  un 0 si el usuario no desea rellenar el campo.
     * */
    public double medidaUsuario(String parteAMedir) {
        Scanner sc = new Scanner(System.in);
        double medida = 0;
        try {
            do {
                System.out.println("Introduce la nueva medida de tu "+parteAMedir+" en cm:");
                System.out.println("Escribe 0 si no deseas rellenar este campo.");
                medida = sc.nextDouble();
            } while (medida < 0);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return medida;
    }

    /*
     * Comentario: metodo para validar una pregunta de respuesta S/N
     * Precondiciones:
     * Entradas:
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si el usuario responde que si y false si no
     * */
    public boolean hacerPreguntaSioNo(String pregunta){
        String respuesta = "";
        boolean respuestaUsuario = false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(pregunta+" SI/NO");
            respuesta = sc.next();
            respuesta = respuesta.toUpperCase();
        } while (!respuesta.equals("SI") && !respuesta.equals("NO"));
        if(respuesta.equals("SI")){
            respuestaUsuario = true;
        }
        return respuestaUsuario;
    }


}
