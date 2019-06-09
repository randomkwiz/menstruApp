package resguardos;

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
     *   INTERFAZ
     * Comentario: Metodo para insertar en la BBDD las relaciones de las tablas con la revision personal.
     * Signatura: public boolean insertarRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: RevisionPersonalImpl revision
     * Salidas: boolean
     * Postcondiciones: asociado al nombre devuelve un boolean que es true si se han insertado correctamente los datos
     *                  y false si hubo algun problema.
     * */
}
