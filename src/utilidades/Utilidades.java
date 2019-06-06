package utilidades;

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
}
