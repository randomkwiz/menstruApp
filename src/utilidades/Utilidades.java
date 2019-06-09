package utilidades;

import clasesBasicas.UsuarioImpl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.GregorianCalendar;

public class Utilidades <T extends Enum<T>>{
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

    /*
     * Comentario: Imprime en pantalla los valores de un enum
     * Signatura: public void imprimirValoresEnum(<T> enumerado)
     * Precondiciones:
     * Entradas:
     * Salidas:
     * Postcondiciones: en pantalla imprimira los valores del enum recibido por parametros
     * */
    public void imprimirValoresEnum(T[] enumerado){

        for(int i = 1; i < enumerado.length; i ++){
            System.out.println(i +". "+enumerado[i]);
        }


    }

    /*
    * INTERFAZ
    * Comentario: metodo que busca el valor del enum en la BBDD y devuelve su ID
    * Signatura: public String obtenerIDEnum (T enumerado)
    * Precondiciones:
    * Entradas: enum
    * Salidas: String
    * Postcondiciones: si el enum no esta registrado en la BBDD se devolvera un null. Asociado al nombre se devuelve
    *                   el ID del enum registrado en la BBDD.
    * */
    public String obtenerIDEnum (T enumerado){
        String idEnum = null;
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "menstruApp";
            String password = "menstruApp";
            String miSelect = "select *\n" +
                    "from ESTADOANIMICO\n" +
                    "where ESTADO = ?\n" +
                    "union\n" +
                    "select * \n" +
                    "from SINTOMA\n" +
                    "where SINTOMA = ?\n" +
                    "union\n" +
                    "select *\n" +
                    "from FLUJOVAGINAL\n" +
                    "where TIPO = ?\n" +
                    "union\n" +
                    "select * \n" +
                    "from SEXO\n" +
                    "where OBSERVACION = ?";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager
            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);

            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, enumerado.toString());
            preparedStatement.setString(2, enumerado.toString());
            preparedStatement.setString(3, enumerado.toString());
            preparedStatement.setString(4, enumerado.toString());

            // execute insert SQL stetement
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                idEnum = resultSet.getString("ID");
            }



            // Cerrar
            resultSet.close();
            preparedStatement.close();
            connexionBaseDatos.close();
        }
        catch (SQLException sqle) {
            System.err.println(sqle);
        }

        return idEnum;
    }



}
