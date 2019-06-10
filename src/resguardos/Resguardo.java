package resguardos;

import clasesBasicas.Ciclo;
import clasesBasicas.CicloMenstrual;
import clasesBasicas.UsuarioImpl;

public class Resguardo {

    /*
    *   INTERFAZ
    * Comentario: método para saber si existe un registro de revision personal para el dia en curso
    * Signatura: public boolean existeRegistroRevisionPersonalDiaEnCurso(UsuarioImpl user)
    * Precondiciones:
    * Entradas: objeto UsuarioImpl que es el usuario en uso
    * Salidas: boolean
    * Postcondiciones: asociado al nombre devuelve un boolean true si existe un registro de revision personal para el dia en curso
    *                  para el usuario pasado por parametro y false si no.
    * */

    /*
     *   INTERFAZ
     * Comentario: método para instanciar un objeto RevisionPersonalImpl en java con los datos
     *              de la BBDD de una revision personal en concreto
     * Signatura: public RevisionPersonalImpl construirObjeto (UsuarioImpl user, String identificador)
     * Precondiciones:
     * Entradas: objeto UsuarioImpl que es el usuario en uso
     * Salidas: objeto revisionpersonalimpl que es la revision personal del dia en curso
     * Postcondiciones: asociado al nombre se devuelve objeto revisionpersonalimpl que es la revision personal del dia en curso
     * */

    /*
    * INTERFAZ
    * Comentario: carga en un objeto RevisionPersonal su array de estados de animo cogiendo los datos de la BBDD
    * Signatura: public boolean cargarEstadosDeAnimoRevisionPersonal (RevisionPersonalImpl revision)
    * Precondiciones:
    * Entradas: Objeto RevisionPersonalImpl
    * Salidas: boolean
    * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
    *                   Se modifica el objeto RevisionPersonalImpl.
    *
    * */


    /*
     * INTERFAZ
     * Comentario: carga en un objeto RevisionPersonal su array de Sintomas cogiendo los datos de la BBDD
     * Signatura: public boolean cargarSintomasRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */

    /*
     * INTERFAZ
     * Comentario: carga en un objeto RevisionPersonal su array de Sexo cogiendo los datos de la BBDD
     * Signatura: public boolean cargarSexoRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */

    /*
     * INTERFAZ
     * Comentario: carga en un objeto RevisionPersonal su array de FlujoVaginal cogiendo los datos de la BBDD
     * Signatura: public boolean cargarFlujoVaginalRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */


    /*
     * INTERFAZ
     * Comentario: Inserta en la BBDD la relacion entre una revision personal y un estado de animo
     * Signatura: public boolean insertarEstadoAnimoEnRevisionPersonal (RevisionPersonalImpl revision, EstadoAnimico estado)
     * Precondiciones:
     * Entradas: RevisionImpl y EstadoAnimico
     * Salida: boolean
     * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     *                   si la revision no existe lanzara excepcion nullpointer
     * si se intenta insertar un valor repetido saltara excepcion de SQL Server
     * */

    /*
     * INTERFAZ
     * Comentario: Inserta en la BBDD la relacion entre una revision personal y un sintoma
     * Signatura: public boolean insertarSintomaEnRevisionPersonal (RevisionPersonalImpl revision, Sintoma sintoma)
     * Precondiciones:
     * Entradas: RevisionImpl y Sintoma
     * Salida: boolean
     * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     *                   si la revision no existe lanzara excepcion nullpointer
     * si se intenta insertar un valor repetido saltara excepcion de SQL Server
     * */



    /*
     * INTERFAZ
     * Comentario: Inserta en la BBDD la relacion entre una revision personal y un tipo de flujo vaginal
     * Signatura: public boolean insertarFlujoVaginalEnRevisionPersonal (RevisionPersonalImpl revision, FlujoVaginal flujo)
     * Precondiciones:
     * Entradas: RevisionImpl y FlujoVaginal
     * Salida: boolean
     * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     *                   si la revision no existe lanzara excepcion nullpointer
     * si se intenta insertar un valor repetido saltara excepcion de SQL Server
     * */


    /*
     * INTERFAZ
     * Comentario: Inserta en la BBDD la relacion entre una revision personal y el Sexo
     * Signatura: public boolean insertarSexoEnRevisionPersonal (RevisionPersonalImpl revision, Sexo observacion)
     * Precondiciones:
     * Entradas: RevisionImpl y Sexo
     * Salida: boolean
     * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     *                   si la revision no existe lanzara excepcion nullpointer
     * si se intenta insertar un valor repetido saltara excepcion de SQL Server
     * */


    /*
    * INTERFAZ
    * Comentario: Metodo para insertar un ciclo menstrual en la BBDD.
    * Signatura: public boolean insertarCicloMenstrual(UsuarioImpl user, CicloMenstrual menstru)
    * Precondiciones:
    * Entradas: UsuarioImpl user y CicloMenstrual menstru
    * Salidas: boolean
    * Postcondiciones: asociado al nombre se devuelve un boolean
    *                   -true si la insercion se realizo correctamente
    *                   -false si hubo algun problema
    * */
    public boolean insertarCicloMenstrual(UsuarioImpl user, CicloMenstrual menstru){

        return false;
    }

    /*
    * INTERFAZ
    * Comentario: Metodo para obtener un ciclo (CicloMenstrual o Embarazo) que esté en curso actualmente.
    * Signatura public Ciclo obtenerCicloActual (UsuarioImpl user)
    * Precondiciones:
    * Entradas: UsuarioImpl user, usuario del que se desea comprobar el ciclo actual.
    * Salidas: Ciclo
    * Postcondiciones: Asociado al nombre devolverá un Ciclo que será el Ciclo en curso en el día actual para el usuario
    *                   pasado por parametro. De no existir o haber algun problema,
    *                   devolverá null.
    *
    * */
    public Ciclo obtenerCicloActual (UsuarioImpl user){
        return null;
    }
}
