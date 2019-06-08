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
*   segun respuesta
*       caso log in
*           pedirValidarInicioSesion
*           repetir
*               mostrarMenuPedirValidarOpcion
*                   si (opcion no es salir)
*                       segun(opcion)
                            caso 1: Cuenta
                            caso 2: Revision Personal
                            caso 3: Ciclo
                            caso 4: Revision Medica (solo si la usuaria esta embarazada)
*                       finSegun
*                   finSi
*           mientras(opcion no sea salir)
*       caso registrarse
*           pedirValidarDatosUsuario
*               si (opcion no es salir)
*                   pedirValidarDatos
*                   solicitarAltaCliente
*               finSi
*   finSegun
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
 *           caso 4: Modificar revision personal
 *           caso 5: Eliminar revision personal
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
 *           caso 4: Modificar ciclo actual
 *           caso 5: Eliminar ciclo
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

import clasesBasicas.UsuarioImpl;
import gestion.Gestion;
import interfaces.Usuario;
import resguardos.Resguardo;
import validaciones.Validar;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Validar validar = new Validar();
        Resguardo resguardo = new Resguardo();
        Gestion gestion = new Gestion();
        Scanner sc = new Scanner(System.in);
        UsuarioImpl usuario = null;
        UsuarioImpl usuarioLogado = null;
        int opcionLogInOrSignUp,opcionMenuPrincipal, opcionCuenta, opcionRevisionPersonal, opcionCiclo, opcionRevisionMedica;
        String respuesta="";
        String mensaje = " ";
        String nick;
        String pass;


        do {
            //preguntarLogInOrSignUp
            opcionLogInOrSignUp = validar.logInOrSignUp();
            if (opcionLogInOrSignUp != 0){

            switch (opcionLogInOrSignUp) {
                case 1:
                    //Crear cuenta
                    //System.out.println("Modulo crear cuenta en construccion");

                    //pedirValidarDatos
                    usuario = gestion.pedirCrearUsuario();
                    //insertarUsuarioEnBBDD
                    mensaje = (gestion.insertarUsuarioEnBBDD(usuario)) ? "Cuenta creada con exito":"Hubo un problema al crear tu cuenta, intentelo de nuevo mas tarde";
                    System.out.println(mensaje);

                    break;
                case 2:
                    //Iniciar sesion
                    //System.out.println("Modulo iniciar sesion en construccion");
                    //pedirValidarInicioSesion
                    usuarioLogado = validar.pedirLogin();
                    System.out.println("Buenas "+usuarioLogado.getNick()+", has iniciado sesion con exito");

                    do {
                        //mostrarMenuPedirValidarOpcion
                        opcionMenuPrincipal = validar.menuPrincipal();
                        if (opcionMenuPrincipal != 0) {
                            switch (opcionMenuPrincipal) {
                                case 1:
                                    //Cuenta
                                    System.out.println("Modulo Cuenta del menu principal en construccion");
                                    do{
                                        opcionCuenta = validar.subMenuCuenta();
                                        if(opcionCuenta != 0){
                                            switch (opcionCuenta){
                                                case 1:
                                                    //Ver datos de la cuenta
                                                    System.out.println("Modulo ver datos de la cuenta en construccion");
                                                    break;
                                                case 2:
                                                    //Modificar datos de la cuenta
                                                    System.out.println("Modulo modificar datos de la cuenta en construccion");
                                                    break;
                                                case 3:
                                                    //Eliminar cuenta
                                                    System.out.println("Modulo eliminar cuenta en construccion");
                                                    break;
                                            }
                                        }
                                    }while (opcionCuenta != 0);
                                    break;
                                case 2:
                                    //Revision personal
                                    System.out.println("Modulo Revision personal del menu principal en construccion");
                                    do{
                                        opcionRevisionPersonal = validar.subMenuRevisionPersonal();
                                        if(opcionRevisionPersonal != 0){
                                            switch (opcionRevisionPersonal){
                                                case 1:
                                                    //Registrar revision personal
                                                    System.out.println("Modulo registrar revision personal en construccion");
                                                    break;
                                                case 2:
                                                    //Ver revisiones personales
                                                    System.out.println("Modulo ver revisiones personales en construccion");
                                                    break;
                                                case 3:
                                                    //Buscar revision personal
                                                    System.out.println("Modulo buscar revision personal en construccion");
                                                    break;
                                                case 4:
                                                    //Modificar revision personal
                                                    System.out.println("Modulo modificar revision personal en construccion");
                                                    break;
                                                case 5:
                                                    //Eliminar revision personal
                                                    System.out.println("Modulo eliminar revision personal en construccion");
                                                    break;

                                            }
                                        }
                                    }while (opcionRevisionPersonal != 0);
                                    break;
                                case 3:
                                    //Ciclo
                                    System.out.println("Modulo Ciclo del menu principal en construccion");
                                    do{
                                        opcionCiclo = validar.subMenuCiclo();
                                        if(opcionCiclo != 0){
                                            switch (opcionCiclo){
                                                case 1:
                                                    //Registrar ciclo (menstruacion o embarazo)
                                                    System.out.println("Modulo registrar ciclo en construccion");
                                                    break;
                                                case 2:
                                                    //Ver datos del ciclo actual
                                                    System.out.println("Modulo ver datos del ciclo actual en construccion");
                                                    break;
                                                case 3:
                                                    //Marcar fin del ciclo actual
                                                    System.out.println("Modulo marcar fin del ciclo actual en construccion");
                                                    break;
                                                case 4:
                                                    //Modificar ciclo actual
                                                    System.out.println("Modulo modificar ciclo actual en construccion");
                                                    break;
                                                case 5:
                                                    //Eliminar ciclo
                                                    System.out.println("Modulo eliminar ciclo en construccion");
                                                    break;

                                            }
                                        }
                                    }while (opcionCiclo != 0);
                                    break;
                                case 4:
                                    //Revision medica (solo si existe embarazo)
                                    System.out.println("Modulo Revision medica del menu principal en construccion");
                                    do{
                                        opcionRevisionMedica = validar.subMenuRevisionMedica();
                                        if(opcionRevisionMedica != 0){
                                            switch (opcionRevisionMedica){
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
                                    }while (opcionRevisionMedica != 0);
                                    break;

                            }
                        }

                    } while (opcionMenuPrincipal != 0);


                    break;

            } //fin del switch ( opcionLogInOrSignUp )
        }   //fin del if (opcionLogInOrSignUp != 0)

        }while(opcionLogInOrSignUp != 0);


    }
}
