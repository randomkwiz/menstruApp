package tests;

import clasesBasicas.CicloMenstrual;
import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import org.junit.jupiter.api.Test;
import utilidades.Utilidades;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class GestionTest {

    @Test
    void pedirCrearUsuario() {
        Gestion g = new Gestion();
        UsuarioImpl usuarioPrueba = g.pedirCrearUsuario();
        GregorianCalendar fecha = new GregorianCalendar();
        fecha.set(GregorianCalendar.YEAR, 2003);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        assertEquals("NickPrueba", usuarioPrueba.getNick());
        assertEquals("NombrePrueba", usuarioPrueba.getNombre());
        assertEquals(25.5, usuarioPrueba.getPeso() );
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
        UsuarioImpl usuarioPrueba = utilidades.cargarUsuario("usuarioPrueba", "123456789");
        CicloMenstrual ultimoCiclo = new CicloMenstrual(usuarioPrueba,fecha );
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
        assertEquals(1,edad);

        fecha.set(GregorianCalendar.YEAR, 2003);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        usuario.setFechaNacimiento(fecha);

        edad = g.obtenerEdad(usuario);
        assertEquals(15,edad);


        fecha.set(GregorianCalendar.YEAR, 2050);
        fecha.set(GregorianCalendar.MONTH, 12);
        fecha.set(GregorianCalendar.DATE, 1);
        usuario.setFechaNacimiento(fecha);

        edad = g.obtenerEdad(usuario);
        assertEquals(0,edad);
    }

    @Test
    void eliminarCuenta() {
    }

    @Test
    void obtenerIDRevisionPersonalDelDiaEnCurso() {
    }

    @Test
    void crearRevisionPersonalDiaEnCurso() {
    }

    @Test
    void existeRevisionPersonalActual() {
    }

    @Test
    void construirObjeto() {
    }

    @Test
    void cargarEstadosDeAnimoRevisionPersonal() {
    }

    @Test
    void cargarSintomasRevisionPersonal() {
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
    }
}