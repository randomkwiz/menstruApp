/*
 * Estudio del MAIN
 * Comentario: menstruApp es un programa para registrar los ciclos menstruales de una persona, pudiendo obtener predicciones sobre
 * cuándo terminará su ciclo actual y cuándo comenzará aproximadamente el siguiente ciclo.
 * Tambien el usuario puede registrar si se ha producido un embarazo y llevar un registro de las citas médicas relacionadas con dicho embarazo.
 * Ademas, existe la posibilidad de registrar en una revision personal el/los estados de animos, sintomas, estado del flujo vaginal y
 * observaciones sobre las relaciones sexuales.
 *
 * Entradas:
 *   -opcion del menu dentro del rango definido por el programador
 *   -fechas relacionada con el registro de datos asi como el inicio o fin de los ciclos menstruales o embarazos,
 *   citas medicas,...
 *   -estados de animo, sintomas, flujo vaginal, observaciones sobre el sexo del usuario
 *   -datos personales del usuario para el registro
 * Salidas:
 *   -eco de los datos
 *   -informacion sobre el ciclo del usuario
 *   -mensajes de ayuda y guia para el correcto manejo del programa
 *
 *
 * */
/*
PSEUDOCODIGO
* inicio
* repetir
*   preguntarLogInOrSignUp
*   si respuesta no es salir
*    segun respuesta
*        caso 1: crear cuenta
*        caso 2: iniciar sesion
*            repetir
*               mostrarMenuPedirValidarOpcion
*                   si opcion no es salir
*                       segun opcion
*                           caso 1: cuenta
*                           caso 2: revision personal
*                           caso 3: ciclo
*                           caso 4: revision medica (solo para embarazadas)
*                       finSegun
*                   finSi
*            mientras opcion no sea salir
*    finSegun
*    finSi
* mientras(opcion no sea salir)
* fin
 */

/*
 * PSEUDOCODIGO CUENTA
 * repetir
 *   leer validar opcion
 *   si opcion no es salir
 *       segun opcion
 *           caso 1: Ver datos de la cuenta
 *           caso 2: Modificar datos de la cuenta
 *           caso 3: Eliminar cuenta
 *       finSegun
 *   finSi
 * mientras opcion no sea salir
 * */

/*
 * PSEUDOCODIGO RevisionPersonal
 * repetir
 *   leer validar opcion
 *   si opcion no es salir
 *       segun opcion
 *           caso 1: Registrar revision personal
 *           caso 2: Ver revisiones personales
 *           caso 3: Buscar revision personal
 *           caso 4: Eliminar revision personal
             caso 5: Ver analisis personal
 *       finSegun
 *   finSi
 * mientras opcion no sea salir
 * */

/*
 * PSEUDOCODIGO Ciclo
 * repetir
 *   leer validar opcion
 *   si opcion no es salir
 *       segun opcion
 *           caso 1: Registrar ciclo (menstruacion o embarazo)
 *           caso 2: Ver datos del ciclo actual
 *           caso 3: Marcar fin del ciclo actual
 *           caso 4: Eliminar ciclo
             caso 5: Ver ciclos anteriores
 *       finSegun
 *   finSi
 * mientras opcion no sea salir
 * */


/*
 * PSEUDOCODIGO RevisionMedica
 * repetir
 *   leer validar opcion    //la usuaria debe estar embarazada
 *   si opcion no es salir
 *       segun opcion
 *           caso 1: Registrar revision medica
 *           caso 2: Ver revisiones pasadas
 *           caso 3: Buscar revision
 *           caso 4: Modificar revision
 *           caso 5: Ver fecha siguiente revision
 *           caso 6: Eliminar revision
 *       finSegun
 *   finSi
 * mientras opcion no sea salir
 * */

package main;

import clasesBasicas.*;
import enumerado.EstadoAnimico;
import enumerado.FlujoVaginal;
import enumerado.Sexo;
import enumerado.Sintoma;
import gestion.Gestion;
import resguardos.Resguardo;
import utilidades.Utilidades;
import validaciones.Validar;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class main {
    public static void main(String[] args) {
        Validar validar = new Validar();
        Resguardo resguardo = new Resguardo();
        Gestion gestion = new Gestion();
        Utilidades utilidades = new Utilidades();
        UsuarioImpl usuario = null;
        UsuarioImpl usuarioLogado = null;
        RevisionPersonalImpl revisionPersonal = null;
        Ciclo cicloActual = null;
        GregorianCalendar fechaInicioCicloActual = null;
        GregorianCalendar fechaFinCicloActual = null;
        String revisionPersonalID = null;
        int opcionLogInOrSignUp, opcionMenuPrincipal, opcionCuenta, opcionRevisionPersonal, opcionCiclo, opcionRevisionMedica;
        int opcionSubMenuRegistrarRevisionPersonal;
        String mensaje = " ";
        String opcionEnum = "";
        ArrayList<RevisionPersonalImpl> revisionesBuscadas;
        int opcionBuscarRevisionPersonal;
        int opcionReglaOEmbarazo;
        String IDCicloABorrar = "";
        int opcionModificarDatosCuenta;


        do {
            //preguntarLogInOrSignUp
            opcionLogInOrSignUp = validar.logInOrSignUp();
            if (opcionLogInOrSignUp != 0) {
                switch (opcionLogInOrSignUp) {
                    case 1:
                        //Crear cuenta
                        //System.out.println("Modulo crear cuenta en construccion");

                        //pedirValidarDatos
                        usuario = gestion.pedirCrearUsuario();
                        //insertarUsuarioEnBBDD
                        mensaje = (gestion.insertarUsuarioEnBBDD(usuario)) ? "Cuenta creada con exito" : "Hubo un problema al crear tu cuenta, intentelo de nuevo mas tarde";
                        System.out.println(mensaje);

                        break;
                    case 2:
                        //Iniciar sesion
                        //System.out.println("Modulo iniciar sesion en construccion");
                        //pedirValidarInicioSesion
                        usuarioLogado = validar.pedirLogin();
                        System.out.println("Buenas " + usuarioLogado.getNick() + ", has iniciado sesion con exito");
                        revisionPersonalID = gestion.obtenerIDRevisionPersonalDelDiaEnCurso(usuarioLogado);
                        revisionPersonal = gestion.construirObjeto(usuarioLogado, revisionPersonalID);

                        do {
                            //mostrarMenuPedirValidarOpcion
                            opcionMenuPrincipal = validar.menuPrincipal();
                            if (opcionMenuPrincipal != 0) {
                                switch (opcionMenuPrincipal) {
                                    case 1:
                                        //Cuenta
                                        // System.out.println("Modulo Cuenta del menu principal en construccion");
                                        do {
                                            opcionCuenta = validar.subMenuCuenta();
                                            if (opcionCuenta != 0) {
                                                switch (opcionCuenta) {
                                                    case 1:
                                                        //Ver datos de la cuenta
                                                        //System.out.println("Modulo ver datos de la cuenta en construccion");
                                                        gestion.imprimirDatosDeLaCuenta(usuarioLogado);
                                                        break;
                                                    case 2:
                                                        //Modificar datos de la cuenta
                                                        //System.out.println("Modulo modificar datos de la cuenta en construccion");
                                                        do {
                                                            opcionModificarDatosCuenta = validar.pedirValidarMenuCampoAModificar();
                                                            if (opcionModificarDatosCuenta != 0) {
                                                                switch (opcionModificarDatosCuenta) {
                                                                    case 1:
                                                                        //Nombre
                                                                        String nuevoNombre = validar.pedirValidarNuevoNombre(usuarioLogado);
                                                                        if (nuevoNombre != null) {
                                                                            if (gestion.actualizarNombreUsuario(usuarioLogado, nuevoNombre)) {
                                                                                System.out.println("Nombre actualizado con exito.");
                                                                                usuarioLogado = utilidades.cargarUsuario(usuarioLogado.getNick(), usuarioLogado.getPassword());
                                                                            } else {
                                                                                System.out.println("Hubo un error al actualizar su nombre, intentelo de nuevo mas tarde.");
                                                                            }
                                                                        }

                                                                        break;
                                                                    case 2:
                                                                        //Peso
                                                                        double nuevoPeso = validar.pedirValidarNuevoPeso(usuarioLogado);
                                                                        if (nuevoPeso != 0) {
                                                                            if (gestion.actualizarPesoUsuario(usuarioLogado, nuevoPeso)) {
                                                                                System.out.println("Peso actualizado con exito.");
                                                                                usuarioLogado = utilidades.cargarUsuario(usuarioLogado.getNick(), usuarioLogado.getPassword());
                                                                            } else {
                                                                                System.out.println("Hubo un error al actualizar su peso, intentelo de nuevo mas tarde.");
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 3:
                                                                        //Contraseña
                                                                        UsuarioImpl usuarioParaConfirarCambio = validar.pedirLogin();
                                                                        System.out.println("NUEVA CONTRASEÑA: ");
                                                                        String nuevaPassword = validar.establecerPassword();
                                                                        if (usuarioParaConfirarCambio.equals(usuarioLogado)) {
                                                                            if (gestion.actualizarPasswordUsuario(usuarioLogado, nuevaPassword)) {
                                                                                System.out.println("Contraseña actualizada con exito.");
                                                                                usuarioLogado = utilidades.cargarUsuario(usuarioLogado.getNick(), nuevaPassword);
                                                                            } else {
                                                                                System.out.println("Hubo un error al actualizar la contraseña, intentelo de nuevo mas tarde.");
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        //Fecha nacimiento
                                                                        GregorianCalendar nuevaFechaNacimiento = validar.validarFecha();
                                                                        if (nuevaFechaNacimiento != null) {
                                                                            if (gestion.actualizarFechaNacimiento(usuarioLogado, nuevaFechaNacimiento)) {
                                                                                System.out.println("Fecha de nacimiento cambiada con exito");
                                                                                usuarioLogado = utilidades.cargarUsuario(usuarioLogado.getNick(), usuarioLogado.getPassword());
                                                                            } else {
                                                                                System.out.println("Hubo un error al actualizar la fecha de nacimiento. " +
                                                                                        "\nIntentelo de nuevo mas tarde");
                                                                            }
                                                                        } else {
                                                                            System.out.println("No se modifico la fecha de nacimiento");
                                                                        }

                                                                        break;


                                                                }
                                                            }

                                                        } while (opcionModificarDatosCuenta != 0);
                                                        break;
                                                    case 3:
                                                        //Eliminar cuenta
                                                        //System.out.println("Modulo eliminar cuenta en construccion");
                                                        if (validar.borrarCuenta()) {
                                                            gestion.eliminarCuenta(usuarioLogado);
                                                            System.out.println("Su cuenta ha sido borrada.");
                                                            System.out.println("Se le forzara el cierre de sesion.");
                                                            opcionCuenta = 0;
                                                            opcionMenuPrincipal = 0;
                                                            opcionLogInOrSignUp = 0;    //esto para que se cierre el programa entero

                                                        } else {
                                                            System.out.println("No se borrara su cuenta.");
                                                        }

                                                        break;
                                                }
                                            }
                                        } while (opcionCuenta != 0);
                                        break;
                                    case 2:
                                        //Revision personal
                                        //System.out.println("Modulo Revision personal del menu principal en construccion");
                                        //Para facilitar esta parte, solo se podran registrar revisiones personales del dia en curso
                                        do {
                                            opcionRevisionPersonal = validar.subMenuRevisionPersonal();
                                            if (opcionRevisionPersonal != 0) {
                                                switch (opcionRevisionPersonal) {

                                                    case 1:
                                                        //Registrar revision personal
                                                        //System.out.println("Modulo registrar revision personal en construccion");
                                                        do {
                                                            opcionSubMenuRegistrarRevisionPersonal = validar.submenuRegistrarRevisionPersonal();
                                                            if (opcionSubMenuRegistrarRevisionPersonal != 0) {
                                                                switch (opcionSubMenuRegistrarRevisionPersonal) {
                                                                    case 1:
                                                                        //EstadoAnimico
                                                                        do {
                                                                            opcionEnum = validar.pedirValidarOpcionEnum(EstadoAnimico.values());
                                                                            if (opcionEnum != null) {
                                                                                if (gestion.insertarEstadoAnimoEnRevisionPersonal(revisionPersonal, EstadoAnimico.valueOf(opcionEnum))) {
                                                                                    System.out.println("Estado de animo registrado con exito en tu revision de hoy.");
                                                                                } else {
                                                                                    System.out.println("Hubo un problema al intentar registrar el estado de animo en tu revision de hoy." +
                                                                                            "\nIntentalo de nuevo mas tarde");
                                                                                }
                                                                            }
                                                                        } while (opcionEnum != null);


                                                                        break;
                                                                    case 2:
                                                                        //Flujo vaginal
                                                                        do {
                                                                            opcionEnum = validar.pedirValidarOpcionEnum(FlujoVaginal.values());
                                                                            if (opcionEnum != null) {
                                                                                if (gestion.insertarFlujoVaginalEnRevisionPersonal(revisionPersonal, FlujoVaginal.valueOf(opcionEnum))) {
                                                                                    System.out.println("Estado del flujo vaginal registrado con exito en tu revision de hoy.");
                                                                                } else {
                                                                                    System.out.println("Hubo un problema al intentar registrar el estado del flujo vaginal en tu revision de hoy." +
                                                                                            "\nIntentalo de nuevo mas tarde");
                                                                                }
                                                                            }
                                                                        } while (opcionEnum != null);

                                                                        break;
                                                                    case 3:
                                                                        //Sexo
                                                                        do {
                                                                            opcionEnum = validar.pedirValidarOpcionEnum(Sexo.values());
                                                                            if (opcionEnum != null) {
                                                                                if (gestion.insertarSexoEnRevisionPersonal(revisionPersonal, Sexo.valueOf(opcionEnum))) {
                                                                                    System.out.println("Observacion sobre el sexo registrada con exito en tu revision de hoy.");
                                                                                } else {
                                                                                    System.out.println("Hubo un problema al intentar registrar la observacion sobre el sexo en tu revision de hoy." +
                                                                                            "\nIntentalo de nuevo mas tarde");
                                                                                }
                                                                            }
                                                                        } while (opcionEnum != null);

                                                                        break;
                                                                    case 4:
                                                                        //Sintomas
                                                                        do {
                                                                            opcionEnum = validar.pedirValidarOpcionEnum(Sintoma.values());
                                                                            if (opcionEnum != null) {
                                                                                if (gestion.insertarSintomaEnRevisionPersonal(revisionPersonal, Sintoma.valueOf(opcionEnum))) {
                                                                                    System.out.println("Sintoma registrado con exito en tu revision de hoy.");
                                                                                } else {
                                                                                    System.out.println("Hubo un problema al intentar registrar el sintoma en tu revision de hoy." +
                                                                                            "\nIntentalo de nuevo mas tarde");
                                                                                }
                                                                            }
                                                                        } while (opcionEnum != null);

                                                                        break;
                                                                }

                                                            }
                                                        } while (opcionSubMenuRegistrarRevisionPersonal != 0);
                                                        break;
                                                    case 2:
                                                        //Ver revisiones personales
                                                        //de momento solo va a poder verse la del dia en curso
                                                        //System.out.println("Modulo ver revisiones personales en construccion");

                                                        utilidades.imprimirDatosRevisionPersonal(revisionPersonal);

                                                        break;
                                                    case 3:
                                                        //Buscar revision personal
                                                        // System.out.println("Modulo buscar revision personal en construccion");


                                                        do {
                                                            opcionBuscarRevisionPersonal = validar.pedirValidarSiBuscarPorFechaOEstadoEnum();
                                                            if (opcionBuscarRevisionPersonal != 0) {
                                                                switch (opcionBuscarRevisionPersonal) {
                                                                    case 1:
                                                                        //Buscar por fecha
                                                                        //System.out.println("Buscar por fecha en construccion");
                                                                        revisionesBuscadas = gestion.buscarRevisionPersonalPorFechaModulo(usuarioLogado);
                                                                        if (revisionesBuscadas.size() > 0) {
                                                                            utilidades.imprimirDatosRevisionPersonalLista(revisionesBuscadas);
                                                                        } else {
                                                                            System.out.println("No existen revisiones con esas caracteristicas.");
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        //Buscar por registro
                                                                        //System.out.println("Buscar por registro en construccion");
                                                                        do {
                                                                            System.out.println("¿Por qué registro quieres buscar?");

                                                                            opcionSubMenuRegistrarRevisionPersonal = validar.submenuRegistrarRevisionPersonal();

                                                                            if (opcionSubMenuRegistrarRevisionPersonal != 0) {
                                                                                opcionEnum = gestion.preguntarEnums(opcionSubMenuRegistrarRevisionPersonal);
                                                                                revisionesBuscadas = gestion.buscarRevisionPersonalPorRegistro(usuarioLogado, opcionEnum);

                                                                                if (revisionesBuscadas.size() == 0) {
                                                                                    System.out.println("No existen revisiones con esas caracteristicas.");
                                                                                } else {
                                                                                    System.out.println("Revisiones que contienen el registro: " + opcionEnum);
                                                                                    utilidades.imprimirDatosRevisionPersonalLista(revisionesBuscadas);
                                                                                }
                                                                            }

                                                                        } while (opcionSubMenuRegistrarRevisionPersonal != 0);
                                                                        break;
                                                                }
                                                            }

                                                        } while (opcionBuscarRevisionPersonal != 0);
                                                        break;

                                                    case 4:
                                                        //Eliminar revision personal
                                                        //System.out.println("Modulo eliminar revision personal en construccion");
                                                        //Primero busca la revision que desea borrar
                                                        RevisionPersonalImpl revisionAEliminar = null;
                                                        do {
                                                            opcionBuscarRevisionPersonal = validar.pedirValidarSiBuscarPorFechaOEstadoEnum();
                                                            if (opcionBuscarRevisionPersonal != 0) {
                                                                switch (opcionBuscarRevisionPersonal) {
                                                                    case 1:
                                                                        //Buscar por fecha
                                                                        //System.out.println("Buscar por fecha en construccion");
                                                                        revisionesBuscadas = gestion.buscarRevisionPersonalPorFechaModulo(usuarioLogado);
                                                                        if (revisionesBuscadas.size() > 0) {
                                                                            System.out.println("Elija aquella que desea borrar: ");
                                                                            revisionAEliminar = validar.pedirValidarListaRevisionesPersonalesImpl(revisionesBuscadas);
                                                                            if (revisionAEliminar != null) {
                                                                                if (validar.borrarRevision()) {
                                                                                    gestion.eliminarRevisionPersonal(revisionAEliminar);
                                                                                    System.out.println("Revision personal eliminada correctamente.");
                                                                                } else {
                                                                                    System.out.println("No se elimino su revision personal.");
                                                                                }
                                                                            } else {
                                                                                System.out.println("Volviendo atras");
                                                                            }
                                                                        } else {
                                                                            System.out.println("No existen revisiones con esas caracteristicas.");
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        //Buscar por registro
                                                                        //System.out.println("Buscar por registro en construccion");
                                                                        do {
                                                                            System.out.println("¿Por qué registro quieres buscar?");
                                                                            opcionSubMenuRegistrarRevisionPersonal = validar.submenuRegistrarRevisionPersonal();
                                                                            if (opcionSubMenuRegistrarRevisionPersonal != 0) {
                                                                                opcionEnum = gestion.preguntarEnums(opcionSubMenuRegistrarRevisionPersonal);
                                                                                revisionesBuscadas = gestion.buscarRevisionPersonalPorRegistro(usuarioLogado, opcionEnum);
                                                                                if (revisionesBuscadas.size() > 0) {
                                                                                    System.out.println("Revisiones con el registro " + opcionEnum);
                                                                                    System.out.println("Elija aquella que desea borrar: ");
                                                                                    revisionAEliminar = validar.pedirValidarListaRevisionesPersonalesImpl(revisionesBuscadas);
                                                                                    if (revisionAEliminar != null) {
                                                                                        if (validar.borrarRevision()) {
                                                                                            gestion.eliminarRevisionPersonal(revisionAEliminar);
                                                                                            System.out.println("Revision personal eliminada correctamente.");
                                                                                        } else {
                                                                                            System.out.println("No se elimino su revision personal.");
                                                                                        }
                                                                                    } else {
                                                                                    }
                                                                                } else {
                                                                                    System.out.println("No se encontraron revisiones con esas caracteristicas");
                                                                                }
                                                                            }
                                                                        } while (opcionSubMenuRegistrarRevisionPersonal != 0);

                                                                        break;
                                                                }
                                                            }
                                                        } while (opcionBuscarRevisionPersonal != 0);
                                                        break;
                                                    case 5:
                                                        //Ver analisis personal
                                                        gestion.imprimirAnalisisRevisionesPersonales(usuarioLogado);
                                                        break;


                                                }
                                            }
                                        } while (opcionRevisionPersonal != 0);
                                        break;
                                    case 3:
                                        //Ciclo
                                        //System.out.println("Modulo Ciclo del menu principal en construccion");
                                        do {
                                            opcionCiclo = validar.subMenuCiclo();
                                            cicloActual = gestion.obtenerCicloActual(usuarioLogado);
                                            if (opcionCiclo != 0) {
                                                switch (opcionCiclo) {
                                                    case 1:
                                                        //Registrar ciclo (menstruacion o embarazo)
                                                        //System.out.println("Modulo registrar ciclo en construccion");

                                                        opcionReglaOEmbarazo = validar.pedirValidarMenuReglaOEmbarazo();
                                                        if (cicloActual == null && opcionReglaOEmbarazo != 0) {
                                                            fechaInicioCicloActual = validar.pedirFechaInicioFinCiclo();
                                                            switch (opcionReglaOEmbarazo) {
                                                                case 1:
                                                                    //Regla
                                                                    cicloActual = new CicloMenstrual(usuarioLogado, fechaInicioCicloActual);
                                                                    break;
                                                                case 2:
                                                                    //Embarazo
                                                                    cicloActual = new CicloEmbarazo(usuarioLogado, fechaInicioCicloActual);
                                                                    break;

                                                            }
                                                            gestion.insertarCiclo(cicloActual);
                                                        } else if (cicloActual != null) {
                                                            System.out.println("Ya existe un ciclo en curso.");
                                                        }
                                                        break;
                                                    case 2:
                                                        //Ver datos del ciclo actual
                                                        //System.out.println("Modulo ver datos del ciclo actual en construccion");
                                                        cicloActual = gestion.obtenerCicloActual(usuarioLogado);
                                                        if (cicloActual != null) {
                                                            gestion.imprimirDatosCicloEnCurso(cicloActual, usuarioLogado);
                                                        } else {
                                                            System.out.println("No existe un ciclo actual registrado ");
                                                        }
                                                        break;
                                                    case 3:
                                                        //Marcar fin del ciclo actual
                                                        //System.out.println("Modulo marcar fin del ciclo actual en construccion");
                                                        if (cicloActual == null) {
                                                            System.out.println("No existe un ciclo actualmente");
                                                        } else {
                                                            fechaFinCicloActual = validar.pedirFechaInicioFinCiclo();
                                                            cicloActual.setFechaFinReal(fechaFinCicloActual);   //para tener el dato en memoria principal
                                                            gestion.actualizarFechaFinCiclo(cicloActual, fechaFinCicloActual);  //para guardarlo en la BBDD

                                                        }

                                                        break;

                                                    case 4:
                                                        //Eliminar ciclo
                                                        //System.out.println("Modulo eliminar ciclo en construccion");
                                                        do {
                                                            opcionReglaOEmbarazo = validar.pedirValidarMenuReglaOEmbarazo();

                                                            if (opcionReglaOEmbarazo != 0) {
                                                                switch (opcionReglaOEmbarazo) {
                                                                    case 1:
                                                                        IDCicloABorrar = validar.pedirValidarCiclosMenstrualesDeUsuario(usuarioLogado);
                                                                        break;
                                                                    case 2:
                                                                        IDCicloABorrar = validar.pedirValidarEmbarazosDeUsuario(usuarioLogado);
                                                                        break;

                                                                }
                                                                if (IDCicloABorrar != null) {
                                                                    gestion.eliminarCicloBBDD(usuarioLogado, IDCicloABorrar);
                                                                    System.out.println("Ciclo eliminado");
                                                                }
                                                            }
                                                        } while (opcionReglaOEmbarazo != 0);
                                                        break;
                                                    case 5:
                                                        //ver ciclos anteriores
                                                        do {
                                                            opcionReglaOEmbarazo = validar.pedirValidarMenuReglaOEmbarazo();
                                                            if (opcionReglaOEmbarazo != 0) {
                                                                switch (opcionReglaOEmbarazo) {
                                                                    case 1:
                                                                        utilidades.imprimirCiclosMenstruales(usuarioLogado);
                                                                        break;
                                                                    case 2:
                                                                        utilidades.imprimirEmbarazos(usuarioLogado);
                                                                        break;
                                                                }
                                                            }
                                                        } while (opcionReglaOEmbarazo != 0);


                                                        break;

                                                }
                                            }
                                        } while (opcionCiclo != 0);
                                        break;
                                    case 4:
                                        //Revision medica (solo si existe embarazo)
                                        if (gestion.estaEmbarazada(usuarioLogado)) {
                                            System.out.println("Modulo Revision medica del menu principal en construccion");
                                            do {
                                                opcionRevisionMedica = validar.subMenuRevisionMedica();
                                                if (opcionRevisionMedica != 0) {
                                                    switch (opcionRevisionMedica) {
                                                        case 1:
                                                            //Registrar revision medica
                                                            System.out.println("Modulo registrar revision medica en construccion");
                                                            break;
                                                        case 2:
                                                            //Ver revisiones pasadas
                                                            System.out.println("Modulo ver revisiones medicas pasadas en construccion");
                                                            break;
                                                        case 3:
                                                            //Buscar revision
                                                            System.out.println("Modulo buscar revision medica en construccion");
                                                            break;
                                                        case 4:
                                                            //Modificar revision
                                                            System.out.println("Modulo modificar revision medica en construccion");
                                                            break;
                                                        case 5:
                                                            //Ver fecha siguiente revision
                                                            System.out.println("Modulo ver fecha siguiente revision medica en construccion");
                                                            break;
                                                        case 6:
                                                            //Eliminar revision
                                                            System.out.println("Modulo eliminar revision medica en construccion");
                                                            break;
                                                    }
                                                }
                                            } while (opcionRevisionMedica != 0);

                                        } else {
                                            System.out.println("No existe un embarazo en curso, no tiene acceso a esta seccion");
                                        }
                                        break;
                                    case 5:
                                        System.out.println("Modulo Medicamentos en construccion");
                                        break;
                                }
                            }
                        } while (opcionMenuPrincipal != 0);
                        break;
                } //fin del switch ( opcionLogInOrSignUp )
            }   //fin del if (opcionLogInOrSignUp != 0)
        } while (opcionLogInOrSignUp != 0);
    }
}
