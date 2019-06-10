package utilidades;

import clasesBasicas.RevisionPersonalImpl;
import clasesBasicas.UsuarioImpl;
import enumerado.EstadoAnimico;
import gestion.Gestion;

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
                GregorianCalendar gc = null;
                if(miResultado.getDate("FECHANACIMIENTO") != null){
                    gc = new GregorianCalendar();
                    gc.setTime(miResultado.getDate("FECHANACIMIENTO"));
                }

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
        System.out.println("-------------------------------------------------------------------------------");


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


    /*
    * INTERFAZ
    * Comentario: imprime en pantalla los datos de una revision personal
    * Signatura: public void imprimirDatosRevisionPersonal(RevisionPersonalImpl revision)
    * Precondiciones:
    * Entradas:
    * Salidas:
    * Postcondiciones: imprime en pantalla
    * */
    public void imprimirDatosRevisionPersonal(RevisionPersonalImpl revision){
        Gestion gestion = new Gestion();
        //carga los datos
        gestion.cargarRevisionPersonalCompleta(revision);

        System.out.println("Revision personal del dia : "+ formatearFecha(revision.getFecha()));
        System.out.println("Estados de animo:");

        if(revision.getArraylistEstadoAnimico().size() == 0){
            System.out.println("No tienes ningún estado de ánimo registrado para el día de hoy.");
        }else{
            for(int i = 0; i < revision.getArraylistEstadoAnimico().size(); i ++){
                if (i == revision.getArraylistEstadoAnimico().size() -1){
                    System.out.println(revision.getArraylistEstadoAnimico().get(i) + ". " );
                }else{
                    System.out.print(revision.getArraylistEstadoAnimico().get(i) + ", " );
                }
            }
        }



        System.out.println("Sintomas:");
        if(revision.getArraylistSintoma().size() == 0){
            System.out.println("No tienes ningún síntoma registrado para el día de hoy.");
        }else {
            for (int i = 0; i < revision.getArraylistSintoma().size(); i++) {
                if (i == revision.getArraylistSintoma().size() - 1) {
                    System.out.println(revision.getArraylistSintoma().get(i) + ". ");
                } else {
                    System.out.print(revision.getArraylistSintoma().get(i) + ", ");
                }
            }
        }


        System.out.println("Flujo Vaginal:");
        if(revision.getArraylistFlujoVaginal().size() == 0){
            System.out.println("No tienes ningún tipo de flujo vaginal registrado para el día de hoy.");
        }else {
            for (int i = 0; i < revision.getArraylistFlujoVaginal().size(); i++) {
                if (i == revision.getArraylistFlujoVaginal().size() - 1) {
                    System.out.println(revision.getArraylistFlujoVaginal().get(i) + ". ");
                } else {
                    System.out.print(revision.getArraylistFlujoVaginal().get(i) + ", ");
                }
            }
        }

        System.out.println("Sexo:");
        if(revision.getArraylistSexo().size() == 0){
            System.out.println("No tienes ninguna observación sexual registrada para el día de hoy.");
        }else {
            for (int i = 0; i < revision.getArraylistSexo().size(); i++) {
                if (i == revision.getArraylistSexo().size() - 1) {
                    System.out.println(revision.getArraylistSexo().get(i) + ". ");
                } else {
                    System.out.print(revision.getArraylistSexo().get(i) + ", ");
                }
            }
        }
        System.out.println("-------------------------------------------------------------------------------");

    }


    /*
     * INTERFAZ
     * Comentario: imprime en pantalla los datos de una lista de objetos RevisionPersonalImpl
     * Signatura: public void imprimirDatosRevisionPersonalLista(ArrayList<RevisionPersonalImpl> revisiones)
     * Precondiciones:
     * Entradas:
     * Salidas:
     * Postcondiciones: imprime en pantalla
     * */
    public void imprimirDatosRevisionPersonalLista(ArrayList<RevisionPersonalImpl> revisiones){

        for(int i = 0; i < revisiones.size(); i ++){
            imprimirDatosRevisionPersonal(revisiones.get(i));
        }
    }

}
