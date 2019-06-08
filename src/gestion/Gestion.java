package gestion;

import clasesBasicas.Ciclo;
import clasesBasicas.CicloEmbarazo;
import clasesBasicas.CicloMenstrual;
import clasesBasicas.UsuarioImpl;
import validaciones.Validar;

import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Gestion {
    /*
    * INTERFAZ
    * Comentario: metodo para pedir todos los datos de creacion de una cuenta de usuario nueva y construir un nuevo
    *               objeto UsuarioImpl. Hace llamadas a la clase de Validacion.
    * Signatura public UsuarioImpl pedirCrearUsuario()
    * Precondiciones:
    * Entradas:
    * Salidas: objeto usuarioImpl o null si hay algun problema
    * Postcondiciones: asociado al nombre se devolvera un nuevo objeto UsuarioImpl o bien un null si hay algun problema
    * */
    public UsuarioImpl pedirCrearUsuario(){
        Validar validar = new Validar();
        String nick;
        String nombre;
        String pass;
        double peso;
        GregorianCalendar fechaCumple = null;
        UsuarioImpl nuevoUsuario ;

        nick = validar.nuevoNickUsuario();
        nombre = validar.nombreUsuario();
        pass = validar.establecerPassword();
        peso = validar.pesoUsuario();
        fechaCumple = validar.fechaCumple();

        nuevoUsuario = new UsuarioImpl(nombre,nick, pass, peso, fechaCumple);

return nuevoUsuario;
    }


    /*
    * INTERFAZ
    * Comentario: Inserta un objeto UsuarioImpl en la BBDD del programa.
    * Signatura: public boolean insertarUsuarioEnBBDD(UsuarioImpl usuario)
    * Precondiciones:
    * Entradas: objeto de tipo UsuarioImpl
    * Salidas: un boolean
    * Postcondiciones: asociado al nombre devuelve un boolean que sera true si el usuario se ha insertado correctamente
    *                   y false si ha habido algun problema.
    * */
    public boolean insertarUsuarioEnBBDD(UsuarioImpl user){
        boolean exito = false;
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "INSERT INTO USUARIO (NICK, NOMBRE, PASS,PESO, FECHANACIMIENTO) " +
                    "VALUES" + "(?,?,PWDENCRYPT(?),?,?)";   //el PWDESCRYPT es para encriptar

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);
            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, user.getNick());
            preparedStatement.setString(2, user.getNombre());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDouble(4, user.getPeso());
            if(user.getFechaNacimiento()!= null) {
                preparedStatement.setDate(5, new java.sql.Date(user.getFechaNacimiento().getTimeInMillis()));
            }else {
                preparedStatement.setDate(5, null);
            }

            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            exito = true;


            // Cerrar
            preparedStatement.close();
            connexionBaseDatos.close();



        }
        catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return exito;
    }


    /*
    * INTERFAZ
    * Comentario: Este metodo consulta la BBDD del programa y devuelve el objeto CicloMenstrual mas reciente de un usuario
    * Signatura: public CicloMenstrual ultimoCicloMenstrual(UsuarioImpl usuario)
    * Precondiciones:
    * Entradas: UsuarioImpl usuario
    * Salidas: objeto CicloMenstrual
    * Postcondiciones: asociado al nombre se devuelve un ciclo menstrual
    * */
    public CicloMenstrual ultimoCicloMenstrual(UsuarioImpl user){
        CicloMenstrual menstruacion = new CicloMenstrual();
        GregorianCalendar fechaInicio = new GregorianCalendar();
        GregorianCalendar fechaFin = new GregorianCalendar();
        try{
            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select top 1 *\n" +
                    "from CICLOMENSTRUAL\n" +
                    "where ID_USUARIO = ?\n" +
                    "ORDER BY FECHAINICIO desc";

            //Crear conexion
            Connection conexionBD = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el statement
            PreparedStatement preparedStatement = conexionBD.prepareStatement(miSelect);
            preparedStatement.setString(1, user.getNick());
            //Ejecuto
            ResultSet miResultado = preparedStatement.executeQuery();

            if(miResultado.next()){

                fechaInicio.setTime(miResultado.getDate("FECHAINICIO"));
                menstruacion.setFechaInicio(fechaInicio);
                if(miResultado.getDate("FECHAFIN_REAL") != null) {
                    fechaFin.setTime(miResultado.getDate("FECHAFIN_REAL"));
                }else{
                    fechaFin = null;
                }


                menstruacion.setFechaFinReal(fechaFin);
                menstruacion.setUsuario(user);
            }

            //Cerrar
            miResultado.close();
            preparedStatement.close();
            conexionBD.close();

        }catch (SQLException e){
            System.err.println(e);
        }


        return menstruacion;
    }


    /*
     * INTERFAZ
     * Comentario: Este metodo consulta la BBDD del programa y devuelve un arraylist de todos los ciclos menstruales del usuario
     * Signatura: public ArrayList<CicloMenstrual> obtenerListaCiclosMenstruales(UsuarioImpl usuario)
     * Precondiciones:
     * Entradas: UsuarioImpl usuario
     * Salidas: arraylist de objetos CicloMenstrual
     * Postcondiciones: asociado al nombre se devuelve un arraylist de objetos ciclo menstrual del usuario
     * */
    public ArrayList<CicloMenstrual> obtenerListaCiclosMenstruales(UsuarioImpl user){
        ArrayList<CicloMenstrual> arrayList = new ArrayList<CicloMenstrual>();
        CicloMenstrual menstruacion = null;
        GregorianCalendar fechaInicio = null;
        GregorianCalendar fechaFin = null;
        try{
            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select  *\n" +
                    "from CICLOMENSTRUAL\n" +
                    "where ID_USUARIO = ?";

            //Crear conexion
            Connection conexionBD = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el statement
            PreparedStatement preparedStatement = conexionBD.prepareStatement(miSelect);
            preparedStatement.setString(1, user.getNick());
            //Ejecuto
            ResultSet miResultado = preparedStatement.executeQuery();

            while(miResultado.next()){
                menstruacion = new CicloMenstrual();
                fechaInicio = new GregorianCalendar();
                fechaFin = new GregorianCalendar();

                fechaInicio.setTime(miResultado.getDate("FECHAINICIO"));
                menstruacion.setFechaInicio(fechaInicio);
                if(miResultado.getDate("FECHAFIN_REAL") != null) {
                    fechaFin.setTime(miResultado.getDate("FECHAFIN_REAL"));
                }else{
                    fechaFin = null;
                }

                menstruacion.setFechaFinReal(fechaFin);
                menstruacion.setUsuario(user);

                arrayList.add(menstruacion);
            }

            //Cerrar
            miResultado.close();
            preparedStatement.close();
            conexionBD.close();

        }catch (SQLException e){
            System.err.println(e);
        }


        return arrayList;
    }

    /*
    * INTERFAZ
    * Comentario: Este metodo comprueba si un usuario tiene un embarazo en curso actualmente
    * Signatura public boolean estaEmbarazada(UsuarioImpl user)
    * Precondiciones:
    * Entradas: objeto UsuarioImpl
    * Salidas: boolean
    * Postcondiciones: asociado al nombre devuelve un boolean que indica si el usuario tiene un embarazo en curso en la fecha actual. True si sí y false si no
    *                   o si hay algun problema.
    * */
    public boolean estaEmbarazada(UsuarioImpl user){
        boolean hayEmbarazo = false;
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select  *\n" +
                    "from EMBARAZO\n" +
                    "where ID_USUARIO = ? AND FECHAFIN_REAL IS NULL";

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);
            //no tengo la libreria del jdcb porque me hacian falta permisos

            //Ejecuto la consulta
            PreparedStatement preparedStatement= connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, user.getNick());

            //Recibo los datos en el ResultSet
            ResultSet resultados = preparedStatement.executeQuery();


            if(resultados.next()){
                hayEmbarazo = true;
            }

            // Cerrar conexiones

            resultados.close();
            preparedStatement.close();
            connexionBaseDatos.close();
        }
        catch (SQLException sqle) {
            System.err.println(sqle);
        }
    return hayEmbarazo;
    }


    /*
     * INTERFAZ
     * Comentario: Este metodo consulta la BBDD del programa y devuelve el objeto CicloEmbarazo en curso de un usuario, o null si no tuviera ninguno
     * Signatura: public CicloEmbarazo obtenerEmbarazoEnCurso(UsuarioImpl user)
     * Precondiciones:
     * Entradas: UsuarioImpl usuario
     * Salidas: objeto CicloEmbarazo
     * Postcondiciones: asociado al nombre se devuelve un objeto embarazo o null si no hay ninguno embarazo en curso
     * */
    public CicloEmbarazo obtenerEmbarazoEnCurso(UsuarioImpl user){
        CicloEmbarazo embarazo = new CicloEmbarazo();
        GregorianCalendar fechaInicio = new GregorianCalendar();
        GregorianCalendar fechaFin = new GregorianCalendar();
        try{
            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select  *\n" +
                    "from EMBARAZO\n" +
                    "where ID_USUARIO = ? AND FECHAFIN_REAL IS NULL";

            //Crear conexion
            Connection conexionBD = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el statement
            PreparedStatement preparedStatement = conexionBD.prepareStatement(miSelect);
            preparedStatement.setString(1, user.getNick());
            //Ejecuto
            ResultSet miResultado = preparedStatement.executeQuery();

            if(miResultado.next()){

                fechaInicio.setTime(miResultado.getDate("FECHAINICIO"));
                embarazo.setFechaInicio(fechaInicio);
                if(miResultado.getDate("FECHAFIN_REAL") != null) {
                    fechaFin.setTime(miResultado.getDate("FECHAFIN_REAL"));
                }else{
                    fechaFin = null;
                }


                embarazo.setFechaFinReal(fechaFin);
                embarazo.setUsuario(user);
            }

            //Cerrar
            miResultado.close();
            preparedStatement.close();
            conexionBD.close();

        }catch (SQLException e){
            System.err.println(e);
        }


        return embarazo;
    }


    /*
    * INTERFAZ
    * Comentario: obtiene la edad de un usuario
    * Signatura: public int obtenerEdad(UsuarioImpl usuario)
    * Precondiciones:
    * Entradas: Objeto usuario
    * Salidas: entero
    * Postcondiciones: asociado al nombre se devuelve la edad, o -1 si el usuario no posee fecha de nacimiento registrada o hay algun error.
    * */
    public int obtenerEdad(UsuarioImpl usuario){
        int edad = -1;
        GregorianCalendar fechaActual = new GregorianCalendar();

        if(usuario.getFechaNacimiento() != null) {
            edad = fechaActual.get(GregorianCalendar.YEAR) - usuario.getFechaNacimiento().get(GregorianCalendar.YEAR);
        }
        return edad;
    }

    /*
    * INTERFAZ
    * Comentario: Elimina una cuenta de usuario
    * Signatura: public boolean eliminarCuenta(UsuarioImpl usuario)
    * Precondiciones:
    * Entradas: objeto usuarioimpl
    * Salidas: boolean
    * Postcondiciones: asociado al nombre devuelve un boolean que sera true si la cuenta se ha borrado satisfactoriamente y
    *                   false si no, o hubo algun problema
    * */
    public boolean eliminarCuenta(UsuarioImpl user){
        boolean exito = false;
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "DELETE FROM USUARIO WHERE NICK = ?";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1,user.getNick() );

            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            exito = true;

            // Cerrar
            preparedStatement.close();
            connexionBaseDatos.close();

        }
        catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return exito;
    }


}
