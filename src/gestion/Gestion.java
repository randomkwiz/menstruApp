package gestion;

import clasesBasicas.*;
import enumerado.EstadoAnimico;
import enumerado.FlujoVaginal;
import enumerado.Sexo;
import enumerado.Sintoma;
import utilidades.Utilidades;
import validaciones.Validar;

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



/*
* Comentario: Comprobar si existe una revision personal para el dia en curso para el usuario indicado y si no
*               existe la crea.
* Signatura: public String existeRevisionPersonalDelDiaEnCurso(UsuarioImpl user)
* Precondiciones:
* Entradas: UsuarioImpl user
* Salidas: String
* Postcondiciones: asociado al nombre devuelve un String que sera el ID de la revision si existe o el de la nueva creada. Devuelve null
*                   si hay algun problema.
* */
public String obtenerIDRevisionPersonalDelDiaEnCurso(UsuarioImpl user){
    String revision = null;

   if(!existeRevisionPersonalActual(user)){
       crearRevisionPersonalDiaEnCurso(user);
   }

   try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select id\n" +
                    "from REVISIONPERSONAL\n" +
                    "where FECHA = cast (CURRENT_TIMESTAMP as date)\n" +
                    "\t\tand ID_USUARIO = ?";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, user.getNick());

            // execute insert SQL stetement
            ResultSet miResultado = preparedStatement.executeQuery();


            if (miResultado.next()){
                revision = miResultado.getString("ID");
                miResultado.close();
                preparedStatement.close();
                connexionBaseDatos.close();
            }


            //cerrar

            miResultado.close();
            preparedStatement.close();
            connexionBaseDatos.close();

        }
        catch (SQLException sqle) {
            System.err.println(sqle);
        }
    return revision;

}

    /*
    * INTERFAZ
    * Comentario: Crea una nueva revision personal para el dia actual y el usuario indicado
    * Signatura: public boolean crearRevisionPersonalDiaEnCurso(UsuarioImpl usuario)
    * Entrada: usuario
    * Salida: boolean
    * Postcondiciones: Saltara excepcion SQL si hay algun problema.
    *                  Asociado al nombre devuelve un boolean que sera true si se inserta correctamente y false si no.
    * */
    public boolean crearRevisionPersonalDiaEnCurso(UsuarioImpl user){
        boolean exito = false;

        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "insert into REVISIONPERSONAL (ID_USUARIO, FECHA)\n" +
                    "values(?, cast (CURRENT_TIMESTAMP as date))";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, user.getNick());

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
     * Comentario: Comprobar si existe una revision personal para el dia en curso para el usuario indicado
     * Signatura: public String existeRevisionPersonalDelDiaEnCurso(UsuarioImpl user)
     * Precondiciones:
     * Entradas: UsuarioImpl user
     * Salidas: boolean
     * Postcondiciones: asociado al nombre devuelve un boolean que sera true si existe una revision para el dia actual y false si no
     * */
    public boolean existeRevisionPersonalActual(UsuarioImpl user){
        boolean existe = false;
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select id\n" +
                    "from REVISIONPERSONAL\n" +
                    "where FECHA = cast (CURRENT_TIMESTAMP as date)\n" +
                    "\t\tand ID_USUARIO = ?";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, user.getNick());

            // execute insert SQL stetement
            ResultSet miResultado = preparedStatement.executeQuery();


            if (miResultado.next()){
                existe = true;
            }


            //cerrar

            miResultado.close();
            preparedStatement.close();
            connexionBaseDatos.close();



        }
        catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return existe;

    }






    /*
     *   INTERFAZ
     * Comentario: método para instanciar un objeto RevisionPersonalImpl en java con los datos
     *              de la BBDD de una revision personal en concreto
     * Signatura: public RevisionPersonalImpl construirObjeto (UsuarioImpl user, String identificador)
     * Precondiciones:
     * Entradas: objeto UsuarioImpl que es el usuario en uso
     * Salidas: objeto revisionpersonalimpl que es la revision personal del dia en curso
     * Postcondiciones: asociado al nombre se devuelve objeto revisionpersonalimpl que es la revision personal del dia en curso
     * */
    public RevisionPersonalImpl construirObjeto (UsuarioImpl user, String identificador){
        RevisionPersonalImpl revisionPersonal = new RevisionPersonalImpl(user);
        GregorianCalendar fecha = new GregorianCalendar();
        try{
        // Define la fuente de datos para el driver
        String sourceURL = "jdbc:sqlserver://localhost";
        String usuario = "menstruApp";
        String password = "menstruApp";
        String miSelect = "SELECT * \n" +
                "FROM REVISIONPERSONAL\n" +
                "WHERE ID = ?";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

        // Crear una conexion con el DriverManager
        Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

        //Preparo el prepared statement indicando que son cada ? del select
        PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
        preparedStatement.setString(1, identificador);

        // execute insert SQL stetement
        ResultSet miResultado = preparedStatement.executeQuery();

        if(miResultado.next()){
            revisionPersonal.setID(identificador);
            fecha.setTime(miResultado.getDate("FECHA"));
            revisionPersonal.setFecha(fecha);
        }


        // Cerrar
            miResultado.close();
            preparedStatement.close();
        connexionBaseDatos.close();

    }
        catch (SQLException sqle) {
        System.err.println(sqle);
    }
    return revisionPersonal;
    }



    /*
     * INTERFAZ
     * Comentario: carga en un objeto RevisionPersonal su array de estados de animo cogiendo los datos de la BBDD
     * Signatura: public boolean cargarEstadosDeAnimoRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */
    public boolean cargarEstadosDeAnimoRevisionPersonal (RevisionPersonalImpl revision){
        boolean exito = false;
        EstadoAnimico estado = EstadoAnimico.NULL;
        revision.getArraylistEstadoAnimico().clear();    //antes de cargarlo lo limpio para evitar duplicaciones
        try{
        // Define la fuente de datos para el driver
        String sourceURL = "jdbc:sqlserver://localhost";
        String usuario = "menstruApp";
        String password = "menstruApp";
        String miSelect = "select * \n" +
                "from REVISIONPERSONAL_ESTADOANIMICO as re\n" +
                "inner join ESTADOANIMICO as e\n" +
                "on re.ID_ESTADOANIMICO = e.ID\n" +
                "where ID_REVISIONPERSONAL = ?";

        //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

        // Crear una conexion con el DriverManager
        Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

        //Preparo el prepared statement indicando que son cada ? del select
        PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
        preparedStatement.setString(1, revision.getID());

        // execute insert SQL stetement
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            revision.addEstadoAnimico(estado.valueOf(resultSet.getString("ESTADO")));
        }
        exito = true;


        // Cerrar
            resultSet.close();
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
     * Comentario: carga en un objeto RevisionPersonal su array de Sintomas cogiendo los datos de la BBDD
     * Signatura: public boolean cargarSintomasRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */
    public boolean cargarSintomasRevisionPersonal (RevisionPersonalImpl revision){
        boolean exito = false;
        Sintoma estado = Sintoma.NULL;
        revision.getArraylistSintoma().clear();    //antes de cargarlo lo limpio por si acaso
        try{
            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select * \n" +
                    "from REVISIONPERSONAL_SINTOMA as rs\n" +
                    "inner join SINTOMA as s\n" +
                    "on rs.ID_SINTOMA = s.ID\n" +
                    "where ID_REVISIONPERSONAL = ?";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, revision.getID());

            // execute insert SQL stetement
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                revision.addSintoma(estado.valueOf(resultSet.getString("SINTOMA")));
            }
            exito = true;


            // Cerrar
            resultSet.close();
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
     * Comentario: carga en un objeto RevisionPersonal su array de Sexo cogiendo los datos de la BBDD
     * Signatura: public boolean cargarSexoRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */

    public boolean cargarSexoRevisionPersonal (RevisionPersonalImpl revision){
        boolean exito = false;
        Sexo estado = Sexo.NULL;
        revision.getArraylistSexo().clear();    //antes de cargarlo lo limpio por si acaso
        try{
            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select * \n" +
                    "from REVISIONPERSONAL_SEXO as rsx\n" +
                    "inner join SEXO as sx\n" +
                    "on rsx.ID_SEXO = sx.ID\n" +
                    "where ID_REVISIONPERSONAL = ?";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, revision.getID());

            // execute insert SQL stetement
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                revision.addSexo(estado.valueOf(resultSet.getString("OBSERVACION")));
            }
            exito = true;


            // Cerrar
            resultSet.close();
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
     * Comentario: carga en un objeto RevisionPersonal su array de FlujoVaginal cogiendo los datos de la BBDD
     * Signatura: public boolean cargarFlujoVaginalRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */
    public boolean cargarFlujoVaginalRevisionPersonal (RevisionPersonalImpl revision){
        boolean exito = false;
        FlujoVaginal estado = FlujoVaginal.NULL;
        revision.getArraylistFlujoVaginal().clear();    //antes de cargarlo lo limpio por si acaso
        try{
            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select * \n" +
                    "from REVISIONPERSONAL_FLUJOVAGINAL as rf\n" +
                    "inner join FLUJOVAGINAL as f\n" +
                    "on rf.ID_FLUJOVAGINAL = f.ID\n" +
                    "where ID_REVISIONPERSONAL = ?";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, revision.getID());

            // execute insert SQL stetement
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                revision.addFlujoVaginal(estado.valueOf(resultSet.getString("TIPO")));
            }
            exito = true;


            // Cerrar
            resultSet.close();
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
    * Comentario: Inserta en la BBDD la relacion entre una revision personal y un estado de animo
    * Signatura: public boolean insertarEstadoAnimoEnRevisionPersonal (RevisionPersonalImpl revision, EstadoAnimico estado)
    * Precondiciones:
    * Entradas: RevisionImpl y EstadoAnimico
    * Salida: boolean
    * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
    *                   si la revision no existe lanzara excepcion nullpointer
    *                   si se intenta insertar un valor repetido saltara excepcion de SQL Server
    * */
    public boolean insertarEstadoAnimoEnRevisionPersonal (RevisionPersonalImpl revision, EstadoAnimico estado){
        boolean exito = false;
        Utilidades utilidades = new Utilidades();
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "insert into REVISIONPERSONAL_ESTADOANIMICO " +
                    "(ID_REVISIONPERSONAL, ID_ESTADOANIMICO)\n" +
                    "values (?, ?)";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, revision.getID());
            preparedStatement.setString(2, utilidades.obtenerIDEnum(estado));


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
     * Comentario: Inserta en la BBDD la relacion entre una revision personal y un sintoma
     * Signatura: public boolean insertarSintomaEnRevisionPersonal (RevisionPersonalImpl revision, Sintoma sintoma)
     * Precondiciones:
     * Entradas: RevisionImpl y Sintoma
     * Salida: boolean
     * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     *                   si la revision no existe lanzara excepcion nullpointer
     * si se intenta insertar un valor repetido saltara excepcion de SQL Server
     * */
    public boolean insertarSintomaEnRevisionPersonal (RevisionPersonalImpl revision, Sintoma sintoma){
        boolean exito = false;
        Utilidades utilidades = new Utilidades();
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "insert into REVISIONPERSONAL_SINTOMA(ID_REVISIONPERSONAL, ID_SINTOMA)\n" +
                    "values (?, ? )";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, revision.getID());
            preparedStatement.setString(2, utilidades.obtenerIDEnum(sintoma));


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
     * Comentario: Inserta en la BBDD la relacion entre una revision personal y un tipo de flujo vaginal
     * Signatura: public boolean insertarFlujoVaginalEnRevisionPersonal (RevisionPersonalImpl revision, FlujoVaginal flujo)
     * Precondiciones:
     * Entradas: RevisionImpl y FlujoVaginal
     * Salida: boolean
     * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     *                   si la revision no existe lanzara excepcion nullpointer
     * si se intenta insertar un valor repetido saltara excepcion de SQL Server
     * */
    public boolean insertarFlujoVaginalEnRevisionPersonal (RevisionPersonalImpl revision, FlujoVaginal flujoVaginal){
        boolean exito = false;
        Utilidades utilidades = new Utilidades();
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "insert into REVISIONPERSONAL_FLUJOVAGINAL(ID_REVISIONPERSONAL, ID_FLUJOVAGINAL)\n" +
                    "values (?, ? )";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, revision.getID());
            preparedStatement.setString(2, utilidades.obtenerIDEnum(flujoVaginal));


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
     * Comentario: Inserta en la BBDD la relacion entre una revision personal y el Sexo
     * Signatura: public boolean insertarSexoEnRevisionPersonal (RevisionPersonalImpl revision, Sexo observacion)
     * Precondiciones:
     * Entradas: RevisionImpl y Sexo
     * Salida: boolean
     * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     *                   si la revision no existe lanzara excepcion nullpointer
     * si se intenta insertar un valor repetido saltara excepcion de SQL Server
     * */
    public boolean insertarSexoEnRevisionPersonal (RevisionPersonalImpl revision, Sexo sexo){
        boolean exito = false;
        Utilidades utilidades = new Utilidades();
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "insert into REVISIONPERSONAL_SEXO(ID_REVISIONPERSONAL, ID_SEXO)\n" +
                    "values (?, ?)";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, revision.getID());
            preparedStatement.setString(2, utilidades.obtenerIDEnum(sexo));


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
    * Comentario: este metodo se encarga de llamar a otros metodos para cargar todos los arraylist
    *               del objeto RevisionPersonalImpl
    * Signatura public boolean cargarRevisionPersonalCompleta(RevisionPersonalImpl revision)
    * Precondiciones:
    * Entradas: RevisionPersonalImpl revision
    * Salida: boolean
    * Postcondiciones: si no existe lanzara nullpointer exception. Se modifica el objeto Revision ya que se
    *                   cargan los arraylist que tiene el mismo como atributo.
    *                   Asociado al nombre se devuelve un boolean que sera true si todas las operaciones salen correctamente y false
    *                   si hay algun problema.
    * */
    public boolean cargarRevisionPersonalCompleta(RevisionPersonalImpl revision){
        boolean estadosDeAnimo = false;
        boolean sexo = false;
        boolean flujo = false;
        boolean sintoma = false;
        boolean estadoFinal = false;

        estadosDeAnimo = cargarEstadosDeAnimoRevisionPersonal(revision);
        sexo = cargarSexoRevisionPersonal(revision);
        flujo = cargarFlujoVaginalRevisionPersonal(revision);
        sintoma = cargarSintomasRevisionPersonal(revision);

        if(estadosDeAnimo && sexo && flujo && sintoma){
            estadoFinal = true;
        }

        return  estadoFinal;
    }

}
