package tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestPrueba {
    public static void main(String[] args) {
        GregorianCalendar cal = new GregorianCalendar(2019, Calendar.JUNE, 5);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        cal.add(Calendar.DAY_OF_MONTH, 35);

        String fecha = sdf.format(cal.getTime());
        System.out.println(fecha);



    }
}
