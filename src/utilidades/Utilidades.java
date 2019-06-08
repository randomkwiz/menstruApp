package utilidades;

import clasesBasicas.UsuarioImpl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Utilidades {
    /*
    * INTERFAZ
    * Comentario: dado un objeto GregorianCalendar, devuelve un String con la fecha formateada
    *              de forma "dd/MM/yyyy"
    * Signatura: public String formatearFecha (GregorianCalendar fecha)
    * Precondiciones:
    * Entradas: objeto de tipo GregorianCalendar
    * Salidas: String con la fecha formateada
    * Postcondiciones: Asociado al nombre se devuelve un String con la fecha formateada bajo patron "dd/MM/yyyy",
    *                   o bien una cadena vacia si hay algun error o el objeto GregorianCalendar de entrada es null.
    * */
    public String formatearFecha (GregorianCalendar fecha){
        String fechaFormateada = " ";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(fecha != null){
            fechaFormateada = sdf.format(fecha.getTime());
        }
        return fechaFormateada;
    }

    /*
     * INTERFAZ
     * Comentario: Inicia la conexion con la bbdd con un usuario y contraseña dados
     * Signatura: public boolean iniciarConexion(String sourceURL,String user, String pass)
     * Precondiciones:
     * Entradas: String sourceURL, que es la fuente, String user que es el usuario del SQL, y String pass que es la contraseña
     * Salidas: boolean
     * Postcondiciones: Asociado al nombre devuelve un boolean que sera true si la conexion se ha creado correctamente
     *                   y false si ha habido algun problema
     * */
    public Connection iniciarConexion(String sourceURL, String user, String pass){
        Connection c = null;
        try{
            c = DriverManager.getConnection(sourceURL, user, pass);
        }catch (SQLException e){
            e.getStackTrace();
        }
        return c;
    }

    /*
    * INTERFAZ
    * Comentario: Dados un usuario y contraseña, devuelve el objeto UsuarioImpl correspondiente, o null si la combinacion no existe.
    * Signatura: public UsuarioImpl toObject(String nick, String pass)
    * Precondiciones:
    * Entradas: String nick, String pass
    * Salidas: objeto UsuarioImpl
    * Postcondiciones: Asociado al nombre devuelve un objeto UsuarioImpl correspondiente a la combinacion usuario/contraseña dados. Si la
    *                   combinacion es erronea devuelve null.
    * */
    public UsuarioImpl toObject(String nick, String pass){
        UsuarioImpl user = new UsuarioImpl();
        try{
            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select * from USUARIO where NICK = ? and PWDCOMPARE(?,PASS)= 1";

            //Crear conexion
            Connection conexionBD = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el statement
            PreparedStatement preparedStatement = conexionBD.prepareStatement(miSelect);
            preparedStatement.setString(1, nick);
            preparedStatement.setString(2, pass);

            //Ejecuto
            ResultSet miResultado = preparedStatement.executeQuery();

            if(miResultado.next()){
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(miResultado.getDate("FECHANACIMIENTO"));
                user.setNombre(miResultado.getString("NOMBRE"));
                //System.out.println(miResultado.getString("NOMBRE"));
                //System.out.println("ENTRA");
                user.setNick(nick);
                user.setPassword(pass);
                user.setFechaNacimiento(gc);
                user.setPeso(miResultado.getDouble("PESO"));
            }

            //Cerrar
            miResultado.close();
            preparedStatement.close();
            conexionBD.close();

        }catch (SQLException e){
            System.err.println(e);
        }
        return  user;
    }

}
