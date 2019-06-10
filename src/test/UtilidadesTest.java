package test;

import clasesBasicas.RevisionPersonalImpl;
import clasesBasicas.UsuarioImpl;
import enumerado.EstadoAnimico;
import enumerado.FlujoVaginal;
import enumerado.Sexo;
import enumerado.Sintoma;
import gestion.Gestion;
import utilidades.Utilidades;
import validaciones.Validar;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class UtilidadesTest {
    public static void main(String[] args) {
        Utilidades util = new Utilidades();
/*
        System.out.println(util.formatearFecha(new GregorianCalendar()));
        System.out.println(util.formatearFecha(null));
        System.out.println(util.formatearFecha(null));


        Validar validar = new Validar();
        System.out.println(validar.combinacionInicioSesion("randomkwiz", "123456789"));

        UsuarioImpl u = util.toObject("randomkwiz", "123456789");

        System.out.println(u.toString());


 */
/*
        System.out.println("ENUM SINTOMA");
        System.out.println();
        util.imprimirValoresEnum(Sintoma.values());
        System.out.println();
        System.out.println("ENUM ESTADO ANIMICO");
        System.out.println();
        util.imprimirValoresEnum(EstadoAnimico.values());
        System.out.println();
        System.out.println("ENUM SEXO");
        System.out.println();
        util.imprimirValoresEnum(Sexo.values());
        System.out.println();
        System.out.println("ENUM FLUJO VAGINAL");
        System.out.println();
        util.imprimirValoresEnum(FlujoVaginal.values());

 */
        //System.out.println(util.obtenerIDEnum(EstadoAnimico.ACTIVA));

        Gestion gestion = new Gestion();
        UsuarioImpl usuario = new UsuarioImpl("randomkwiz", "123456789");
        String id = gestion.obtenerIDRevisionPersonalDelDiaEnCurso(usuario);
        RevisionPersonalImpl revisionPersonal = gestion.construirObjeto(usuario, id);
        ArrayList<RevisionPersonalImpl> lista = gestion.buscarRevisionPersonalPorFecha(usuario, 2019);



        for(int i = 0; i < lista.size(); i ++){
            util.imprimirDatosRevisionPersonal(lista.get(i));
        }

    }
}
