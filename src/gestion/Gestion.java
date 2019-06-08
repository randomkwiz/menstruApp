package gestion;

import clasesBasicas.UsuarioImpl;
import validaciones.Validar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
