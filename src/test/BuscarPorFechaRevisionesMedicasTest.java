package test;

import clasesBasicas.Ciclo;
import clasesBasicas.CicloEmbarazo;
import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import utilidades.Utilidades;

public class BuscarPorFechaRevisionesMedicasTest {
    public static void main(String[] args) {
        Utilidades utilidades = new Utilidades();
        Gestion gestion = new Gestion();

        UsuarioImpl usuario = utilidades.cargarUsuario("usuariaEmbarazo", "123456789");
        Ciclo ciclo= gestion.obtenerCicloActual(usuario);
        CicloEmbarazo embarazo = (CicloEmbarazo) ciclo;

        //utilidades.car

        utilidades.formatearFecha(gestion.buscarRevisionMedicaPorFecha((CicloEmbarazo)ciclo,2019).get(0).getFechaCitaActual());



        utilidades.imprimirDatosRevisionMedicaImplLista(gestion.buscarRevisionMedicaPorFecha((CicloEmbarazo) ciclo,2019));
    }
}
