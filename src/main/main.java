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
*                           caso 1: Ver datos de la cuenta
*                           caso 2: Hacer revision personal
*                           caso 3: Registrar ciclo
*                           caso 4: cancelar cuenta
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
package main;
public class main {
}
