package tests;

import clasesBasicas.CicloMenstrual;
import clasesBasicas.RevisionPersonalImpl;
import clasesBasicas.UsuarioImpl;
import enumerado.EstadoAnimico;
import gestion.Gestion;
import org.junit.jupiter.api.Test;
import utilidades.Utilidades;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GestionTest {

    @Test
    void pedirCrearUsuario() {
        Gestion g = new Gestion();
        UsuarioImpl usuarioPrueba = g.pedirCrearUsuario();
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.set(GregorianCalendar.YEAR, 2003);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        fecha.set(GregorianCalendar.HOUR_OF_DAY, 0);
        fecha.set(GregorianCalendar.MINUTE, 0);
        fecha.set(GregorianCalendar.SECOND, 0);
        fecha.set(GregorianCalendar.MILLISECOND, 0);
        assertEquals("NickPrueba", usuarioPrueba.getNick());
        assertEquals("NombrePrueba", usuarioPrueba.getNombre());
        assertEquals(25.5, usuarioPrueba.getPeso());
        assertEquals(fecha, usuarioPrueba.getFechaNacimiento());

    }

    @Test
    void insertarUsuarioEnBBDD() {

    }

    @Test
    void ultimoCicloMenstrual() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.set(GregorianCalendar.YEAR, 2019);
        fecha.set(GregorianCalendar.MONTH, 5);
        fecha.set(GregorianCalendar.DATE, 17);
        fecha.set(GregorianCalendar.HOUR_OF_DAY, 0);
        fecha.set(GregorianCalendar.MINUTE, 0);
        fecha.set(GregorianCalendar.SECOND, 0);
        fecha.set(GregorianCalendar.MILLISECOND, 0);
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("usuarioPrueba", "123456789");
        CicloMenstrual ultimoCiclo = new CicloMenstrual(usuarioPrueba, fecha);
        gestion.insertarCiclo(ultimoCiclo);

        assertEquals(ultimoCiclo.getFechaInicio().getTime(), gestion.ultimoCicloMenstrual(usuarioPrueba).getFechaInicio().getTime());
        assertEquals(ultimoCiclo.getUsuario(), gestion.ultimoCicloMenstrual(usuarioPrueba).getUsuario());

    }

    @Test
    void obtenerListaCiclosMenstruales() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("usuarioPrueba", "123456789");
        assertEquals(7, gestion.obtenerListaCiclosMenstruales(usuarioPrueba).size());


        usuarioPrueba = utilidades.cargarUsuario("randomkwiz", "123456789");
        assertEquals(0, gestion.obtenerListaCiclosMenstruales(usuarioPrueba).size());

    }

    @Test
    void obtenerListaEmbarazos() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("usuarioPrueba", "123456789");
        assertEquals(0, gestion.obtenerListaEmbarazos(usuarioPrueba).size());


        usuarioPrueba = utilidades.cargarUsuario("randomkwiz", "123456789");
        assertEquals(2, gestion.obtenerListaEmbarazos(usuarioPrueba).size());
    }

    @Test
    void estaEmbarazada() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("usuarioPrueba", "123456789");
        assertEquals(true, gestion.estaEmbarazada(usuarioPrueba));

        usuarioPrueba = utilidades.cargarUsuario("randomkwiz", "123456789");
        assertEquals(false, gestion.estaEmbarazada(usuarioPrueba));
    }

    @Test
    void obtenerEmbarazoEnCurso() {
    }

    @Test
    void obtenerEdad() {
        Gestion g = new Gestion();
        Utilidades u = new Utilidades();
        GregorianCalendar fecha = new GregorianCalendar();
        UsuarioImpl usuario = u.cargarUsuario("randomkwiz", "123456789");
        int edad = g.obtenerEdad(usuario);
        assertEquals(15, edad);

        fecha.set(GregorianCalendar.YEAR, 2003);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        fecha.set(GregorianCalendar.HOUR_OF_DAY, 0);
        fecha.set(GregorianCalendar.MINUTE, 0);
        fecha.set(GregorianCalendar.SECOND, 0);
        fecha.set(GregorianCalendar.MILLISECOND, 0);
        usuario.setFechaNacimiento(fecha);

        edad = g.obtenerEdad(usuario);
        assertEquals(15, edad);


        fecha.set(GregorianCalendar.YEAR, 2050);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        usuario.setFechaNacimiento(fecha);

        edad = g.obtenerEdad(usuario);
        assertEquals(0, edad);
    }

    @Test
    void eliminarCuenta() {
    }

    @Test
    void obtenerIDRevisionPersonalDelDiaEnCurso() {
    }

    @Test
    void crearRevisionPersonalDiaEnCurso() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("usuarioPrueba", "123456789");
        gestion.crearRevisionPersonalDiaEnCurso(usuarioPrueba);
        String identificador = gestion.obtenerIDRevisionPersonalDelDiaEnCurso(usuarioPrueba);
        RevisionPersonalImpl revisionPersonal = gestion.construirObjetoRevisionPersonal(usuarioPrueba, identificador);
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.set(GregorianCalendar.HOUR_OF_DAY, 0);
        fecha.set(GregorianCalendar.MINUTE, 0);
        fecha.set(GregorianCalendar.SECOND, 0);
        fecha.set(GregorianCalendar.MILLISECOND, 0);

        assertEquals(fecha, revisionPersonal.getFecha());
        assertEquals(identificador, revisionPersonal.getID());
    }

    @Test
    void existeRevisionPersonalActual() {
    }

    @Test
    void construirObjetoRevisionPersonal() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("randomkwiz", "123456789");
        String identificador = gestion.obtenerIDRevisionPersonalDelDiaEnCurso(usuarioPrueba);
        RevisionPersonalImpl revisionPersonal = gestion.construirObjetoRevisionPersonal(usuarioPrueba, identificador);
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.set(GregorianCalendar.HOUR_OF_DAY, 0);
        fecha.set(GregorianCalendar.MINUTE, 0);
        fecha.set(GregorianCalendar.SECOND, 0);
        fecha.set(GregorianCalendar.MILLISECOND, 0);

        assertEquals(fecha, revisionPersonal.getFecha());
        assertEquals(identificador, revisionPersonal.getID());
    }

    @Test
    void cargarEstadosDeAnimoRevisionPersonal() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("usuarioPrueba", "123456789");
        String identificador = gestion.obtenerIDRevisionPersonalDelDiaEnCurso(usuarioPrueba);
        RevisionPersonalImpl revisionPersonal = gestion.construirObjetoRevisionPersonal(usuarioPrueba, identificador);


        gestion.insertarEstadoAnimoEnRevisionPersonal(revisionPersonal, EstadoAnimico.ACTIVA);
        gestion.insertarEstadoAnimoEnRevisionPersonal(revisionPersonal, EstadoAnimico.IRACUNDA);
        gestion.insertarEstadoAnimoEnRevisionPersonal(revisionPersonal, EstadoAnimico.TRISTE);
        gestion.cargarEstadosDeAnimoRevisionPersonal(revisionPersonal);

        assertEquals(3, revisionPersonal.getArraylistEstadoAnimico().size());
        assertEquals(usuarioPrueba, revisionPersonal.getUsuario());
    }

    @Test
    void cargarSintomasRevisionPersonal() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("usuarioPrueba", "123456789");
        String identificador = gestion.obtenerIDRevisionPersonalDelDiaEnCurso(usuarioPrueba);
        RevisionPersonalImpl revisionPersonal = gestion.construirObjetoRevisionPersonal(usuarioPrueba, identificador);


        gestion.insertarEstadoAnimoEnRevisionPersonal(revisionPersonal, EstadoAnimico.ACTIVA);
        gestion.insertarEstadoAnimoEnRevisionPersonal(revisionPersonal, EstadoAnimico.IRACUNDA);
        gestion.insertarEstadoAnimoEnRevisionPersonal(revisionPersonal, EstadoAnimico.TRISTE);
        gestion.cargarEstadosDeAnimoRevisionPersonal(revisionPersonal);

        assertEquals(3, revisionPersonal.getArraylistEstadoAnimico().size());
        assertEquals(usuarioPrueba, revisionPersonal.getUsuario());
    }

    @Test
    void cargarSexoRevisionPersonal() {
    }

    @Test
    void cargarFlujoVaginalRevisionPersonal() {
    }

    @Test
    void insertarEstadoAnimoEnRevisionPersonal() {
    }

    @Test
    void insertarSintomaEnRevisionPersonal() {
    }

    @Test
    void insertarFlujoVaginalEnRevisionPersonal() {
    }

    @Test
    void insertarSexoEnRevisionPersonal() {
    }

    @Test
    void cargarRevisionPersonalCompleta() {
    }

    @Test
    void obtenerCicloActual() {
    }

    @Test
    void actualizarFechaFinCiclo() {
    }

    @Test
    void insertarCiclo() {
    }

    @Test
    void eliminarCicloBBDD() {
    }

    @Test
    void buscarRevisionPersonalPorFecha() {
    }

    @Test
    void buscarRevisionPersonalPorFecha1() {
    }

    @Test
    void buscarRevisionPersonalPorFecha2() {
    }

    @Test
    void buscarRevisionPersonalPorRegistro() {
    }

    @Test
    void eliminarRevisionPersonal() {
    }

    @Test
    void imprimirDatosDeLaCuenta() {
    }

    @Test
    void buscarRevisionPersonalPorFechaModulo() {
    }

    @Test
    void preguntarEnums() {
    }

    @Test
    void imprimirDatosCicloEnCurso() {
    }

    @Test
    void actualizarNombreUsuario() {
    }

    @Test
    void actualizarPesoUsuario() {
    }

    @Test
    void actualizarPasswordUsuario() {
    }

    @Test
    void obtenerEstadoDeAnimoMasUsado() {
    }

    @Test
    void obtenerSintomaMasUsado() {
    }

    @Test
    void obtenerSexoMasUsado() {
    }

    @Test
    void obtenerFlujoVaginalMasUsado() {
    }

    @Test
    void imprimirAnalisisRevisionesPersonales() {
    }

    @Test
    void actualizarFechaNacimiento() {
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("randomkwiz", "123456789");
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.set(GregorianCalendar.YEAR, 2003);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        fecha.set(GregorianCalendar.HOUR_OF_DAY, 0);
        fecha.set(GregorianCalendar.MINUTE, 0);
        fecha.set(GregorianCalendar.SECOND, 0);
        fecha.set(GregorianCalendar.MILLISECOND, 0);
        gestion.actualizarFechaNacimiento(usuarioPrueba, fecha);
        usuarioPrueba = utilidades.cargarUsuario("randomkwiz", "123456789");

        assertEquals(fecha.getTime(), usuarioPrueba.getFechaNacimiento().getTime());


    }
}