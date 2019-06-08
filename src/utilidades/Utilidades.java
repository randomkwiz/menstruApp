package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
}
