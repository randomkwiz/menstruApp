package resguardos;

import clasesBasicas.*;
import enumerado.EstadoAnimico;
import enumerado.FlujoVaginal;
import enumerado.Sexo;
import enumerado.Sintoma;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Resguardo {


    /*
     * INTERFAZ
     * Comentario: metodo para pedir todos los datos de creacion de una cuenta de usuario nueva y construir un nuevo
     *               objeto UsuarioImpl. Hace llamadas a la clase de Validacion.
     * Signatura public UsuarioImpl pedirCrearUsuario()
     * Precondiciones:
     * Entradas:
     * Salidas: objeto usuarioImpl
     * Postcondiciones: asociado al nombre se devolvera un nuevo objeto UsuarioImpl con los datos pedidos al usuario
     * */

    /**
     * metodo para pedir todos los datos de creacion de una cuenta de usuario nueva y construir un nuevo
     * objeto UsuarioImpl. Hace llamadas a la clase de Validacion para pedir y validar los datos.
     *
     * @return asociado al nombre devuelve un objeto UsuarioImpl que sera el nuevo usuario creado con los datos pedidos.
     */
    public UsuarioImpl pedirCrearUsuario() {

        return null;
    }


    /*
     * INTERFAZ
     * Comentario: Inserta un objeto UsuarioImpl en la BBDD del programa.
     * Signatura: public boolean insertarUsuarioEnBBDD(UsuarioImpl usuario)
     * Precondiciones:
     * Entradas: objeto de tipo UsuarioImpl
     * Salidas: un boolean
     * Postcondiciones: asociado al nombre devuelve un boolean que sera true si el usuario se ha insertado correctamente
     *                   y false si ha habido algun problema. Si el objeto usuario pasado como parametro de entrada
     *                  no estuviera bien construido o fuera nulo, saltaria excepcion.
     * */

    /**
     * Inserta un objeto UsuarioImpl en la BBDD del programa.
     *
     * @param user usuario a insertar en la base de datos del programa, en la tabla usuario.
     * @return asociado al nombre devuelve un boolean que sera true si la inserción se realizó correctamente y false si hubo algún problema.
     */
    public boolean insertarUsuarioEnBBDD(UsuarioImpl user) {
        boolean exito = false;

        return exito;
    }


    /*
     * INTERFAZ
     * Comentario: Este metodo consulta la BBDD del programa y devuelve el ciclo menstrual del usuario con la fecha de inicio mas reciente.
     * Signatura: public CicloMenstrual ultimoCicloMenstrual(UsuarioImpl user)
     * Precondiciones:
     * Entradas: UsuarioImpl usuario
     * Salidas: objeto CicloMenstrual
     * Postcondiciones: asociado al nombre se devuelve el ciclo menstrual que el usuario tenga sin fecha de fin, o si todos tienen fecha de
     *                  fin, se devuelve el que tenga una fecha de inicio mayor. Si el usuario pasado como parametro de entrada
     *                  fuera null o no estuviera bien construido, saltaria excepcion.
     * */

    /**
     * Este metodo consulta la BBDD del programa y devuelve el ciclo menstrual del usuario con la fecha de inicio mas reciente.
     *
     * @param user que es el usuario del que se consultaran los datos del ciclo menstrual
     * @return asociado al nombre se devuelve el ciclo menstrual que el usuario tenga sin fecha de fin, o si todos tienen fecha de
     * fin, se devuelve el que tenga una fecha de inicio mayor.
     */
    public CicloMenstrual ultimoCicloMenstrual(UsuarioImpl user) {
        CicloMenstrual menstruacion = new CicloMenstrual();

        return menstruacion;
    }


    /*
     * INTERFAZ
     * Comentario: Este metodo consulta la BBDD del programa y devuelve un arraylist de todos los ciclos menstruales del usuario
     * Signatura: public ArrayList<CicloMenstrual> obtenerListaCiclosMenstruales(UsuarioImpl user)
     * Precondiciones:
     * Entradas: UsuarioImpl usuario
     * Salidas: arraylist de objetos CicloMenstrual
     * Postcondiciones: asociado al nombre se devuelve un arraylist de objetos ciclo menstrual del usuario. Si el usuario
     *                  es nulo o está mal construido, saltara excepcion.
     * */

    /**
     * Este metodo consulta la BBDD del programa y devuelve un arraylist de todos los ciclos menstruales del usuario
     *
     * @param user usuario del que se buscaran los ciclos menstruales
     * @return asociado al nombre se devuelve un arraylist con todos los objetos ciclo menstrual del usuario.
     */
    public ArrayList<CicloMenstrual> obtenerListaCiclosMenstruales(UsuarioImpl user) {
        ArrayList<CicloMenstrual> arrayList = new ArrayList<CicloMenstrual>();

        return arrayList;
    }

    /*
     * INTERFAZ
     * Comentario: Este metodo consulta la BBDD del programa y devuelve un arraylist de todos los embarazos del usuario
     * Signatura: public ArrayList<CicloEmbarazo> obtenerListaEmbarazos(UsuarioImpl user)
     * Precondiciones:
     * Entradas: UsuarioImpl usuario
     * Salidas: arraylist de objetos CicloEmbarazo
     * Postcondiciones: asociado al nombre se devuelve un arraylist de objetos CicloEmbarazo del usuario. Si el usuario
     *                  es nulo o está mal construido, saltara excepcion.
     * */

    /**
     * Este metodo consulta la BBDD del programa y devuelve un arraylist de todos los embarazos del usuario
     *
     * @param user usuario del que se consultaran los datos
     * @return asociado al nombre se devuelve un arraylist de objetos CicloEmbarazo del usuario.
     */
    public ArrayList<CicloEmbarazo> obtenerListaEmbarazos(UsuarioImpl user) {
        ArrayList<CicloEmbarazo> arrayList = new ArrayList<>();

        return arrayList;
    }


    /*
     * INTERFAZ
     * Comentario: Este metodo comprueba si un usuario tiene un embarazo en curso actualmente
     * Signatura public boolean estaEmbarazada(UsuarioImpl user)
     * Precondiciones:
     * Entradas: objeto UsuarioImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre devuelve un boolean que indica si el usuario tiene un embarazo en curso en la fecha actual,
     *                  el boolean sera true si sí y false si no o si hay algun problema.
     *                  Si el usuario es null o esta mal construido saltara excepcion.
     * */

    /**
     * Este metodo comprueba si un usuario tiene un embarazo en curso actualmente (sin fecha de fin)
     *
     * @param user el usuario del que se desean buscar los datos
     * @return asociado al nombre devuelve un boolean que indica si el usuario tiene un embarazo en curso en la fecha actual,
     * el boolean sera true si sí y false si no o si hay algun problema.
     */
    public boolean estaEmbarazada(UsuarioImpl user) {
        boolean hayEmbarazo = false;

        return hayEmbarazo;
    }


    /*
     * INTERFAZ
     * Comentario: Este metodo consulta la BBDD del programa y devuelve el objeto CicloEmbarazo en curso de un usuario,
     *              o null si no tuviera ninguno
     * Signatura: public CicloEmbarazo obtenerEmbarazoEnCurso(UsuarioImpl user)
     * Precondiciones:
     * Entradas: UsuarioImpl usuario
     * Salidas: objeto CicloEmbarazo
     * Postcondiciones: asociado al nombre se devuelve un objeto embarazo o null si no hay ninguno embarazo en curso. Si el
     *                  usuario es null o esta mal construido saltara excepcion.
     * */

    /**
     * Este metodo consulta la BBDD del programa y devuelve el objeto CicloEmbarazo en curso de un usuario,
     * o null si no tuviera ninguno
     *
     * @param user el usuario del que se extraera el embarazo en curso.
     * @return asociado al nombre se devuelve un objeto embarazo o null si no hay ninguno embarazo en curso.
     */
    public CicloEmbarazo obtenerEmbarazoEnCurso(UsuarioImpl user) {
        CicloEmbarazo embarazo = new CicloEmbarazo();

        return embarazo;
    }


    /*
     * INTERFAZ
     * Comentario: obtiene la edad de un usuario a partir de su fecha de nacimiento.
     * Signatura: public int obtenerEdad(UsuarioImpl usuario)
     * Precondiciones:
     * Entradas: Objeto usuario
     * Salidas: entero
     * Postcondiciones: asociado al nombre se devuelve la edad, o -1 si el usuario no posee fecha de nacimiento registrada o hay algun error.
     * */

    /**
     * obtiene la edad de un usuario a partir de su fecha de nacimiento.
     *
     * @param usuario usuario del que se calculara la edad
     * @return asociado al nombre se devuelve la edad, o -1 si el usuario no posee fecha de nacimiento registrada o hay algun error.
     */
    public int obtenerEdad(UsuarioImpl usuario) {
        int edad = -1;

        return edad;
    }

    /*
     * INTERFAZ
     * Comentario: Elimina una cuenta de usuario
     * Signatura: public boolean eliminarCuenta(UsuarioImpl usuario)
     * Precondiciones:
     * Entradas: objeto usuarioimpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre devuelve un boolean que sera true si la cuenta se ha borrado satisfactoriamente y
     *                   false si no, o hubo algun problema. Si el usuario no existe, no se eliminara su cuenta y devolvera false.
     * */

    /**
     * Elimina una cuenta de usuario
     *
     * @param user usuario del que se eliminara la cuenta
     * @return asociado al nombre devuelve un boolean que sera true si la cuenta se ha borrado satisfactoriamente y
     * false si no, o hubo algun problema. Si el usuario no existe, no se eliminara su cuenta (pues no existe) y devolvera false.
     */
    public boolean eliminarCuenta(UsuarioImpl user) {
        boolean exito = false;

        return exito;
    }


    /*
     * Comentario: Comprobar si existe una revision personal para el dia en curso para el usuario indicado y si no
     *               existe la crea.
     * Signatura: public String existeRevisionPersonalDelDiaEnCurso(UsuarioImpl user)
     * Precondiciones:
     * Entradas: UsuarioImpl user
     * Salidas: String
     * Postcondiciones: asociado al nombre devuelve un String que sera el ID de la revision si existe o el de la nueva creada. Devuelve null
     *                   si hay algun problema. Saltara excepcion si el usuario pasado como parametro es null o esta mal construido.
     * */

    /**
     * Comprobar si existe una revision personal para el dia en curso para el usuario indicado y si no
     * existe la crea.
     *
     * @param user usuario sobre el que se realizara la operacion
     * @return asociado al nombre devuelve un String que sera el ID de la revision si existe o el de la nueva creada. Devuelve null
     * si hay algun problema.
     * @see #crearRevisionPersonalDiaEnCurso
     */
    public String obtenerIDRevisionPersonalDelDiaEnCurso(UsuarioImpl user) {
        String revision = null;

        return revision;

    }

    /*
     * INTERFAZ
     * Comentario: Crea una nueva revision personal para el dia actual y el usuario indicado
     * Signatura: public boolean crearRevisionPersonalDiaEnCurso(UsuarioImpl user)
     * Entrada: usuario
     * Salida: boolean
     * Postcondiciones: Si el usuario pasado como parametro no existe o no tiene los campos rellenos saltara SQLServerException.
     *                  Asociado al nombre devuelve un boolean que sera true si se inserta correctamente y false si no.
     *
     * */

    /**
     * Crea una nueva revision personal para el dia actual y el usuario indicado
     *
     * @param user usuario del cual se creara una revision personal
     * @return Asociado al nombre devuelve un boolean que sera true si se inserta correctamente y false si no.
     */
    public boolean crearRevisionPersonalDiaEnCurso(UsuarioImpl user) {
        boolean exito = false;


        return exito;

    }


    /*
     * Comentario: Comprueba si existe una revision personal para el dia en curso para el usuario indicado
     * Signatura: public boolean existeRevisionPersonalActual(UsuarioImpl user)
     * Precondiciones:
     * Entradas: UsuarioImpl user
     * Salidas: boolean
     * Postcondiciones: asociado al nombre devuelve un boolean que sera true si existe una revision para el dia actual y false si no.
     *                  Si el usuario pasado como parametro no existe devolvera false.
     * */

    /**
     * Comprueba si existe una revision personal para el dia en curso para el usuario indicado
     *
     * @param user usuario del cual se realizara la comprobacion
     * @return asociado al nombre devuelve un boolean que sera true si existe una revision para el dia actual y false si no.
     * Si el usuario pasado como parametro no existe devolvera false.
     */
    public boolean existeRevisionPersonalActual(UsuarioImpl user) {
        boolean existe = false;

        return existe;

    }


    /*
     *   INTERFAZ
     * Comentario: método para instanciar un objeto RevisionPersonalImpl en java con los datos
     *              de la BBDD de una revision personal en concreto
     * Signatura: public RevisionPersonalImpl construirObjeto(UsuarioImpl user, String identificador)
     * Precondiciones: El usuario y el identificador pasados como parametro de entrada deben existir en la base de datos del programa.
     * Entradas: objeto UsuarioImpl que es el usuario en uso, String identificador que sera el ID de la revision personal
     * Salidas: objeto revisionpersonalimpl que es la revision personal del dia en curso
     * Postcondiciones: asociado al nombre se devuelve objeto revisionpersonalimpl que es la revision personal del dia en curso
     * */

    /**
     * método para instanciar un objeto RevisionPersonalImpl en java con los datos
     * de la BBDD de una revision personal en concreto
     *
     * @param user          objeto UsuarioImpl que es el usuario
     * @param identificador el ID de la revision personal del citado usuario
     * @return asociado al nombre se devuelve objeto revisionpersonalimpl que es la revision personal del dia en curso del usuario
     * indicado
     */
    public RevisionPersonalImpl construirObjeto(UsuarioImpl user, String identificador) {
        RevisionPersonalImpl revisionPersonal = new RevisionPersonalImpl(user);

        return revisionPersonal;
    }


    /*
     * INTERFAZ
     * Comentario: carga en un objeto RevisionPersonal su array de estados de animo cogiendo los datos de la BBDD
     * Signatura: public boolean cargarEstadosDeAnimoRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                  El hecho de que no existan datos que introducir en el array no implicará que el método devuelva
     *                  false.
     *                  Si la revision es null, saltara excepcion.
     *                   Se modifica el objeto RevisionPersonalImpl.
     * */

    /**
     * carga en un objeto RevisionPersonal su array de estados de animo cogiendo los datos de la BBDD
     *
     * @param revision revision en la que se cargaran los datos
     * @return asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     */
    public boolean cargarEstadosDeAnimoRevisionPersonal(RevisionPersonalImpl revision) {
        boolean exito = false;

        return exito;

    }

    /*
     * INTERFAZ
     * Comentario: carga en un objeto RevisionPersonal su array de Sintomas cogiendo los datos de la BBDD
     * Signatura: public boolean cargarSintomasRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                  El hecho de que no existan datos que introducir en el array no implicará que el método devuelva
     *                  false.
     *                  Si la revision es null, saltara excepcion.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */

    /**
     * carga en un objeto RevisionPersonal su array de Sintomas cogiendo los datos de la BBDD
     *
     * @param revision revision en la que se cargaran los datos
     * @return asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     */
    public boolean cargarSintomasRevisionPersonal(RevisionPersonalImpl revision) {
        boolean exito = false;

        return exito;

    }

    /*
     * INTERFAZ
     * Comentario: carga en un objeto RevisionPersonal su array de Sexo cogiendo los datos de la BBDD
     * Signatura: public boolean cargarSexoRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                  El hecho de que no existan datos que introducir en el array no implicará que el método devuelva
     *                  false.
     *                  Si la revision es null, saltara excepcion.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */

    /**
     * carga en un objeto RevisionPersonal su array de Sexo cogiendo los datos de la BBDD
     *
     * @param revision revision en la que se cargaran los datos
     * @return asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     */

    public boolean cargarSexoRevisionPersonal(RevisionPersonalImpl revision) {
        boolean exito = false;

        return exito;

    }

    /*
     * INTERFAZ
     * Comentario: carga en un objeto RevisionPersonal su array de FlujoVaginal cogiendo los datos de la BBDD
     * Signatura: public boolean cargarFlujoVaginalRevisionPersonal (RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: Objeto RevisionPersonalImpl
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     *                  El hecho de que no existan datos que introducir en el array no implicará que el método devuelva
     *                  false.
     *                  Si la revision es null, saltara excepcion.
     *                   Se modifica el objeto RevisionPersonalImpl.
     *
     * */

    /**
     * carga en un objeto RevisionPersonal su array de FlujoVaginal cogiendo los datos de la BBDD
     *
     * @param revision revision en la que se cargaran los datos
     * @return asociado al nombre se devuelve un boolean que sera true si se cargo con exito o false si no.
     */
    public boolean cargarFlujoVaginalRevisionPersonal(RevisionPersonalImpl revision) {
        boolean exito = false;

        return exito;

    }


    /*
     * INTERFAZ
     * Comentario: Inserta en la BBDD la relacion entre una revision personal y un estado de animo
     * Signatura: public boolean insertarEstadoAnimoEnRevisionPersonal (RevisionPersonalImpl revision, EstadoAnimico estado)
     * Precondiciones:
     * Entradas: RevisionImpl y EstadoAnimico
     * Salida: boolean
     * Postcondiciones:  asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     *                   si la revision no existe lanzara excepcion nullpointer
     *                   si se intenta insertar un valor repetido saltara excepcion de SQL Server
     * */

    /**
     * Inserta en la BBDD la relacion entre una revision personal y un estado de animo
     *
     * @param revision revision sobre la que operamos
     * @param estado   estado que queremos insertar
     * @return asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     */
    public boolean insertarEstadoAnimoEnRevisionPersonal(RevisionPersonalImpl revision, EstadoAnimico estado) {
        boolean exito = false;

        return exito;

    }


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

    /**
     * Inserta en la BBDD la relacion entre una revision personal y un sintoma
     *
     * @param revision revision sobre la que operamos
     * @param sintoma  sintoma que queremos insertar
     * @return asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     */
    public boolean insertarSintomaEnRevisionPersonal(RevisionPersonalImpl revision, Sintoma sintoma) {
        boolean exito = false;

        return exito;
    }

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

    /**
     * Inserta en la BBDD la relacion entre una revision personal y un sintoma
     *
     * @param revision     revision sobre la que operamos
     * @param flujoVaginal flujo vaginal que queremos insertar
     * @return asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     */
    public boolean insertarFlujoVaginalEnRevisionPersonal(RevisionPersonalImpl revision, FlujoVaginal flujoVaginal) {
        boolean exito = false;

        return exito;
    }

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

    /**
     * Inserta en la BBDD la relacion entre una revision personal y un sintoma
     *
     * @param revision revision sobre la que operamos
     * @param sexo     sexo que queremos insertar
     * @return asociado al nombre devuelve un boolean que sera true si la insercion se realizo con exito y false si no
     */
    public boolean insertarSexoEnRevisionPersonal(RevisionPersonalImpl revision, Sexo sexo) {
        boolean exito = false;

        return exito;
    }

    /*
     * INTERFAZ
     * Comentario: este metodo se encarga de llamar a otros metodos para cargar todos los arraylist
     *               del objeto RevisionPersonalImpl recibido como parametro
     * Signatura public boolean cargarRevisionPersonalCompleta(RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: RevisionPersonalImpl revision
     * Salida: boolean
     * Postcondiciones: si no existe lanzara nullpointer exception. Se modifica el objeto Revision ya que se
     *                   cargan los arraylist que tiene el mismo como atributo.
     *                   Asociado al nombre se devuelve un boolean que sera true si todas las operaciones salen correctamente y false
     *                   si hay algun problema.
     * */

    /**
     * este metodo se encarga de llamar a otros metodos para cargar todos los arraylist
     * del objeto RevisionPersonalImpl recibido como parametro
     *
     * @param revision revision cuyos atributos queremos cargar con datos de la base de datos
     * @return Asociado al nombre se devuelve un boolean que sera true si todas las operaciones salen correctamente y false
     * si hay algun problema.
     * @see #cargarEstadosDeAnimoRevisionPersonal(RevisionPersonalImpl)
     * @see #cargarFlujoVaginalRevisionPersonal(RevisionPersonalImpl)
     * @see #cargarSexoRevisionPersonal(RevisionPersonalImpl)
     * @see #cargarSintomasRevisionPersonal(RevisionPersonalImpl)
     */
    public boolean cargarRevisionPersonalCompleta(RevisionPersonalImpl revision) {

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

    /**
     * Metodo para obtener un ciclo (CicloMenstrual o Embarazo) que esté en curso actualmente (sin fecha de fin real en la base de datos).
     *
     * @param user usuario sobre el cual se realizara la consulta
     * @return Asociado al nombre devolverá un Ciclo que será el Ciclo en curso en el día actual para el usuario
     * pasado por parametro. De no existir o haber algun problema,
     * devolverá null.
     */
    public Ciclo obtenerCicloActual(UsuarioImpl user) {
        Ciclo cicloEnCurso = null;

        return cicloEnCurso;
    }

    /*
     * INTERFAZ
     * Comentario: metodo para insertar la fecha de fin de un ciclo en la BBDD
     * Signatura: public boolean actualizarFechaFinCiclo(Ciclo ciclo, GregorianCalendar fechaFinCiclo)
     * Precondiciones:
     * Entradas: Ciclo del cual actualizaremos la fecha de fin
     *           fecha nueva de fin de ciclo
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que indica si la actualizacion se realizo correctamente
     *                   o no. Si el ciclo pasado ya tenia fecha de fin, se actualizara con la nueva fecha.
     * */

    /**
     * metodo para insertar la fecha de fin de un ciclo en la BBDD
     *
     * @param ciclo         Ciclo del cual actualizaremos la fecha de fin
     * @param fechaFinCiclo fecha nueva de fin de ciclo
     * @return asociado al nombre se devuelve un boolean que indica si la actualizacion se realizo correctamente
     * o no. Si el ciclo pasado ya tenia fecha de fin, se actualizara con la nueva fecha.
     */
    public boolean actualizarFechaFinCiclo(Ciclo ciclo, GregorianCalendar fechaFinCiclo) {
        boolean exito = false;

        return exito;
    }


    /*
     * INTERFAZ
     * Comentario: metodo para insertar un ciclo en la BBDD
     * Signatura: public boolean insertarCiclo(Ciclo ciclo)
     * Precondiciones:
     * Entradas: Ciclo a insertar
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que indica si la inserccion se realizo correctamente
     *                   o no. La base de datos quedara actualizada con el nuevo registro.
     * */

    /**
     * metodo para insertar un ciclo en la BBDD
     *
     * @param ciclo Ciclo a insertar en la BBDD
     * @return asociado al nombre se devuelve un boolean que indica si la inserccion se realizo correctamente (true)
     * o no (false).
     */
    public boolean insertarCiclo(Ciclo ciclo) {
        boolean exito = false;

        return exito;
    }


    /*
     * INTERFAZ
     * Comentario: metodo para borrar un ciclo de un usuario de la BBDD
     * Signatura: public boolean eliminarCicloBBDD(UsuarioImpl user, String IDCiclo)
     * Precondiciones:
     * Entradas: usuario del cual modificaremos su ciclo
     *           ID del ciclo a eliminar
     * Salidas:
     * Postcondiciones: asociado al nombre se devolvera un boolean que indicara si el borrado se realizo correctamente.
     *                  La base de datos quedara modificada.
     *
     * */

    /**
     * metodo para borrar un ciclo de un usuario de la BBDD
     *
     * @param user    usuario del cual modificaremos su ciclo
     * @param IDCiclo ID del ciclo a eliminar
     * @return asociado al nombre se devolvera un boolean que indicara si el borrado se realizo correctamente.
     */
    public boolean eliminarCicloBBDD(UsuarioImpl user, String IDCiclo) {
        boolean exito = false;

        return exito;
    }


    /*inicio METODOS BUSCAR*/
    /*
     * INTERFAZ
     * Signatura: public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorFecha(UsuarioImpl user, int anyo)
     * Comentario: busca las revisiones que ha hecho un usuario en la fecha dada
     * Precondiciones:
     * Entrada: usuario y entero año
     * Salida: arraylist de objetos revisiones
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre devuelve un arraylist con las revisiones que coincidan con la fecha indicada
     * */

    /**
     * busca las revisiones que ha hecho un usuario en la fecha dada
     *
     * @param user usuario del cual se buscaran las revisiones
     * @param anyo año del que se buscaran las revisiones
     * @return asociado al nombre devuelve un arraylist con las revisiones que coincidan con la fecha indicada
     */
    public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorFecha(UsuarioImpl user, int anyo) {
        ArrayList<RevisionPersonalImpl> revisionPersonalLista = new ArrayList<RevisionPersonalImpl>();

        return revisionPersonalLista;
    }

    /*
     * INTERFAZ - METODO SOBRECARGADO
     * Signatura: public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorFecha(UsuarioImpl user, int anyo, int mes)
     * Comentario: busca las revisiones que ha hecho un usuario en la fecha dada
     * Precondiciones:
     * Entrada: usuario y entero año y un entero mes
     * Salida: arraylist de objetos revisiones
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre devuelve un arraylist con las revisiones que coincidan con la fecha indicada
     * */

    /**
     * busca las revisiones que ha hecho un usuario en la fecha dada
     *
     * @param user usuario del cual se buscaran las revisiones
     * @param anyo año del cual se buscaran las revisiones
     * @param mes  mes del cual se buscaran las revisiones
     * @return asociado al nombre devuelve un arraylist con las revisiones que coincidan con la fecha indicada
     */
    public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorFecha(UsuarioImpl user, int anyo, int mes) {
        ArrayList<RevisionPersonalImpl> revisionPersonalLista = new ArrayList<RevisionPersonalImpl>();

        return revisionPersonalLista;
    }

    /*
     * INTERFAZ - METODO SOBRECARGADO
     * Signatura: public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorFecha(UsuarioImpl user, int anyo, int mes, int dia)
     * Comentario: busca las revisiones que ha hecho un usuario en la fecha dada
     * Precondiciones:
     * Entrada: usuario y entero año y un entero mes
     * Salida: arraylist de objetos revisiones
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre devuelve un arraylist con las revisiones que coincidan con la fecha indicada
     * */

    /**
     * @param user usuario del cual se buscaran las revisiones
     * @param anyo año del cual se buscaran las revisiones
     * @param mes  mes del cual se buscaran las revisiones
     * @param dia  dia del cual se buscaran las revisiones
     * @return asociado al nombre devuelve un arraylist con las revisiones que coincidan con la fecha indicada
     */

    public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorFecha(UsuarioImpl user, int anyo, int mes, int dia) {
        ArrayList<RevisionPersonalImpl> revisionPersonalLista = new ArrayList<RevisionPersonalImpl>();

        return revisionPersonalLista;
    }


    /*
     * Comentario: Metodo para buscar revisiones por el registro (Sintoma, Sexo, Flujo vaginal, Estado de animo) de un usuario concreto
     * Signatura: public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorRegistro(UsuarioImpl user, String registro)
     * Precondiciones:
     * Entradas: usuario del que se buscara la revision y registro por el cual se filtrara la busqueda
     * Salidas: lista de revisiones
     * Postcondiciones: asociado al nombre devuelve un arraylist con las revisiones encontradas que cumplan con el criterio de busqueda
     * */

    /**
     * Metodo para buscar revisiones por el registro (Sintoma, Sexo, Flujo vaginal, Estado de animo) de un usuario concreto
     *
     * @param user     usuario del que se buscaran las revisiones
     * @param registro registro (Sintoma, Sexo, Flujo vaginal, Estado de animo) por el cual se filtrara la busqueda
     * @return asociado al nombre devuelve un arraylist con las revisiones encontradas que cumplan con el criterio de busqueda
     */

    public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorRegistro(UsuarioImpl user, String registro) {
        ArrayList<RevisionPersonalImpl> revisionPersonalLista = new ArrayList<RevisionPersonalImpl>();


        return revisionPersonalLista;
    }


    /*
     * INTERFAZ
     * Comentario: metodo para eliminar de la BBDD una revision personal concreta
     * Signatura: public boolean eliminarRevisionPersonal(RevisionPersonalImpl revision)
     * Precondiciones:
     * Entradas: revision a eliminar
     * Salidas: boolean
     * Postcondiciones: asociado al nombre se devuelve un boolean que sera true si se ha ejecutado correctamente la instruccion y el
     *         registro ha sido borrado y false si hubo algun problema o no se elimino ninguna fila.
     * */

    /**
     * metodo para eliminar de la BBDD una revision personal concreta
     *
     * @param revision revision a eliminar
     * @return asociado al nombre se devuelve un boolean que sera true si se ha ejecutado correctamente la instruccion y el
     * registro ha sido borrado y false si hubo algun problema o no se elimino ninguna fila.
     */
    public boolean eliminarRevisionPersonal(RevisionPersonalImpl revision) {
        boolean exito = false;

        return exito;
    }

    /*
     * INTERFAZ
     * Comentario: muestra los datos de la cuenta del usuario pasado como parametro
     * Signatura: public void imprimirDatosDeLaCuenta(UsuarioImpl usuario)
     * Precondiciones:
     * Entradas: usuario del cual se mostraran los datos
     * Salidas:
     * Postcondiciones: imprime en pantalla. Si el usuario es nulo, saltara excepcion.
     * */

    /**
     * muestra los datos de la cuenta del usuario pasado como parametro
     *
     * @param usuarioLogado usuario del cual se mostraran los datos de la cuenta
     * @see #estaEmbarazada(UsuarioImpl)
     * @see #obtenerEdad(UsuarioImpl)
     * @see #obtenerEmbarazoEnCurso(UsuarioImpl)
     * @see #ultimoCicloMenstrual(UsuarioImpl)
     */
    public void imprimirDatosDeLaCuenta(UsuarioImpl usuarioLogado) {

    }

    /*
     * INTERFAZ
     * Comentario: Modulo de buscar por fecha
     * Signatura: public void buscarPorFechaModulo(UsuarioImpl usuarioLogado)
     * Precondiciones:
     * Entradas: usuario del cual se buscaran las revisiones
     * Salidas: arraylist con las revisiones buscadas
     * Postcondiciones: asociado al nombre se devolvera un arraylist que contendra las revisiones buscadas por el usuario
     * */

    /**
     * Modulo de buscar por fecha
     *
     * @param usuarioLogado usuario del cual se buscaran las revisiones
     * @return asociado al nombre se devolvera un arraylist que contendra las revisiones buscadas por el usuario
     * @see #buscarRevisionPersonalPorFecha(UsuarioImpl, int)
     * @see #buscarRevisionPersonalPorFecha(UsuarioImpl, int, int)
     * @see #buscarRevisionPersonalPorFecha(UsuarioImpl, int, int, int)
     */
    public ArrayList<RevisionPersonalImpl> buscarRevisionPersonalPorFechaModulo(UsuarioImpl usuarioLogado) {

        ArrayList<RevisionPersonalImpl> revisionesBuscadas = new ArrayList<RevisionPersonalImpl>();

        return revisionesBuscadas;
    }

    /*
     * INTERFAZ
     * Comentario: Metodo que se encarga de llamar a los metodos que piden y validan una opcion de varias listas de enum
     *             y devuelve el valor de la opcion escogida.
     * Signatura: public String preguntarEnums(int opcionSubMenuRegistrarRevisionPersonal)
     * Precondiciones:
     * Entradas: entero opcion que es la opcion elegida por el usuario
     * Salidas: String con el valor del enum elegido
     * Postcondiciones: asociado al nombre devolvera una cadena con el valor del enum elegido, o cadena
     *                   con espacio en blanco si no se elige nada o la opcion pasada como parametro no esta
     *                   dentro del rango elegible (1-4)
     * */

    /**
     * Metodo que se encarga de llamar a los metodos que piden y validan una opcion de varias listas de enum
     * *             y devuelve el valor de la opcion escogida.
     *
     * @param opcionSubMenuRegistrarRevisionPersonal entero opcion que es la opcion elegida por el usuario
     * @return asociado al nombre devolvera una cadena con el valor del enum elegido, o cadena
     * con espacio en blanco si no se elige nada o la opcion pasada como parametro no esta
     * dentro del rango elegible (1-4)
     */
    public String preguntarEnums(int opcionSubMenuRegistrarRevisionPersonal) {
        String opcionEnum = "";

        return opcionEnum;
    }

    /*
     * INTERFAZ
     * Comentario: metodo que imprime por pantalla datos del ultimo ciclo sin cierre de un usuario
     * Signatura: public void imprimirDatosCicloEnCurso(Ciclo cicloActual, UsuarioImpl usuarioLogado)
     * Precondiciones:
     * Entradas: Ciclo que sera el ultimo ciclo sin cierre, del que se mostraran los datos y usuario al cual pertenece el ciclo
     * Salidas:
     * Postcondiciones: imprime en pantalla
     * */

    /**
     * metodo que imprime por pantalla datos del ultimo ciclo sin cierre de un usuario
     *
     * @param cicloActual   Ciclo que sera el ultimo ciclo sin cierre, del que se mostraran los datos
     * @param usuarioLogado usuario al cual pertenece el ciclo
     */
    public void imprimirDatosCicloEnCurso(Ciclo cicloActual, UsuarioImpl usuarioLogado) {

        System.out.println("Datos del ciclo actual en resguardo");

    }


    /*
    INTERFAZ
    Comentario: metodo para actualizar el nombre de un usuario
    Signatura: public boolean actualizarNombreUsuario(UsuarioImpl user, String nuevoNombre)
    Precondiciones:
    Entradas: usuario del que se modificaran los datos
              nuevoNombre nuevo nombre del usuario
    Salidas: boolean
    Postcondiciones: asociado al nombre se devolvera un boolean que sera true si la modificacion se realizo
                    correctamente y false si no. Si el usuario no existe lanzara excepcion.

     */

    /**
     * metodo para actualizar el nombre de un usuario
     *
     * @param user        usuario del que se modificaran los datos
     * @param nuevoNombre nuevo nombre del usuario
     * @return asociado al nombre se devolvera un boolean que sera true si la modificacion se realizo
     * correctamente y false si no. Si el usuario no existe lanzara excepcion.
     */
    public boolean actualizarNombreUsuario(UsuarioImpl user, String nuevoNombre) {
        boolean exito = false;

        return exito;
    }

        /*
    INTERFAZ
    Comentario: metodo para actualizar el peso de un usuario
    Signatura: public boolean actualizarPesoUsuario(UsuarioImpl user, double nuevoPeso)
    Precondiciones:
    Entradas: usuario del que se modificaran los datos
              nuevoPeso nuevo peso del usuario
    Salidas: boolean
    Postcondiciones: asociado al nombre se devolvera un boolean que sera true si la modificacion se realizo
                    correctamente y false si no. Si el usuario no existe lanzara excepcion.

     */

    /**
     * metodo para actualizar el peso de un usuario
     *
     * @param user      usuario del que se modificaran los datos
     * @param nuevoPeso nuevo peso del usuario
     * @return asociado al nombre se devolvera un boolean que sera true si la modificacion se realizo
     * correctamente y false si no. Si el usuario no existe lanzara excepcion.
     */
    public boolean actualizarPesoUsuario(UsuarioImpl user, double nuevoPeso) {
        boolean exito = false;

        return exito;
    }

           /*
    INTERFAZ
    Comentario: metodo para actualizar la contraseña de un usuario
    Signatura: public boolean actualizarPasswordUsuario(UsuarioImpl user, String nuevaPassword)
    Precondiciones:
    Entradas: usuario del que se modificaran los datos
              nuevaPassword nueva contraseña del usuario
    Salidas: boolean
    Postcondiciones: asociado al nombre se devolvera un boolean que sera true si la modificacion se realizo
                    correctamente y false si no. Si el usuario no existe lanzara excepcion.

     */

    /**
     * metodo para actualizar la contraseña de un usuario
     *
     * @param user          usuario del que se modificaran los datos
     * @param nuevaPassword nueva contraseña del usuario
     * @return asociado al nombre se devolvera un boolean que sera true si la modificacion se realizo
     * correctamente y false si no. Si el usuario no existe lanzara excepcion.
     */
    public boolean actualizarPasswordUsuario(UsuarioImpl user, String nuevaPassword) {
        boolean exito = false;

        return exito;
    }


    /*
     * INTERFAZ
     * Comentario: Metodo que devuelve los valores del estado de animo mas utilizado en las
     *              revisiones personales de un usuario
     * Signatura: public ArrayList<String> obtenerEstadoDeAnimoMasUsado(UsuarioImpl user)
     * Precondiciones:
     * Entradas: usuario del que se buscara el estado de animo mas usado
     * Salidas: valores de los estados de animo mas usados
     * Postcondiciones: asociado al nombre se devuelve un arraylist de cadenas con los valores del estado de animo mas usado
     *                  o bien null si el usuario en cuestion no existe o no tiene revisiones personales registradas.
     * */

    /**
     * Metodo que devuelve los valores del estado de animo mas utilizado en las
     * revisiones personales de un usuario
     *
     * @param user usuario del que se buscara el estado de animo mas usado
     * @return asociado al nombre se devuelve un arraylist de cadenas con los valores del estado de animo mas usado
     * o bien null si el usuario en cuestion no existe o no tiene revisiones personales registradas.
     */
    public ArrayList<String> obtenerEstadoDeAnimoMasUsado(UsuarioImpl user) {
        String estadoAnimico = null;
        ArrayList<String> listaEstadosAnimicos = new ArrayList<String>();

        return listaEstadosAnimicos;
    }

    /*
     * INTERFAZ
     * Comentario: Metodo que devuelve los valores del sintoma mas utilizado en las
     *              revisiones personales de un usuario
     * Signatura: public ArrayList<String> obtenerSintomaMasUsado(UsuarioImpl user)
     * Precondiciones:
     * Entradas: usuario del que se buscara el sintoma mas usado
     * Salidas: valores de los sintomas mas usados
     * Postcondiciones: asociado al nombre se devuelve un arraylist de cadenas con los valores del sintoma mas usado
     *                  o bien null si el usuario en cuestion no existe o no tiene revisiones personales registradas.
     * */

    /**
     * Metodo que devuelve los valores del sintoma mas utilizado en las
     * revisiones personales de un usuario
     *
     * @param user usuario del que se buscara el sintoma mas usado
     * @return asociado al nombre se devuelve un arraylist de cadenas con los valores del sintoma mas usado
     * o bien null si el usuario en cuestion no existe o no tiene revisiones personales registradas.
     */
    public ArrayList<String> obtenerSintomaMasUsado(UsuarioImpl user) {
        String sintoma = null;
        ArrayList<String> listaSintomas = new ArrayList<String>();


        return listaSintomas;
    }


    /*
     * INTERFAZ
     * Comentario: Metodo que devuelve los valores de la/s observacion/es sexual/es mas utilizada en las
     *              revisiones personales de un usuario
     * Signatura: public ArrayList<String> obtenerSexoMasUsado(UsuarioImpl user)
     * Precondiciones:
     * Entradas: usuario del que se buscara el sintoma mas usado
     * Salidas: valores de las observaciones sexuales mas usadas
     * Postcondiciones: asociado al nombre se devuelve un arraylist de cadenas con los valores mas usados
     *                  o bien null si el usuario en cuestion no existe o no tiene revisiones personales registradas.
     * */

    /**
     * Metodo que devuelve los valores de la/s observacion/es sexual/es mas utilizada en las
     * revisiones personales de un usuario
     *
     * @param user usuario del que se buscara el registro mas usado
     * @return asociado al nombre se devuelve un arraylist de cadenas con los valores mas usado
     * o bien null si el usuario en cuestion no existe o no tiene revisiones personales registradas.
     */
    public ArrayList<String> obtenerSexoMasUsado(UsuarioImpl user) {
        String sexo = null;
        ArrayList<String> listaSexo = new ArrayList<String>();

        return listaSexo;
    }


    /*
     * INTERFAZ
     * Comentario: Metodo que devuelve los valores del tipo de flujo vaginal mas utilizados en las
     *              revisiones personales de un usuario
     * Signatura: public ArrayList<String> obtenerFlujoVaginalMasUsado(UsuarioImpl user)
     * Precondiciones:
     * Entradas: usuario del que se buscara el o los tipos de flujo vaginales mas usados
     * Salidas: valores de los tipos de flujo vaginal mas usados
     * Postcondiciones: asociado al nombre se devuelve un arraylist de cadenas con los valores mas usados
     *                  o bien null si el usuario en cuestion no existe o no tiene revisiones personales registradas.
     * */

    /**
     * Metodo que devuelve los valores del tipo de flujo vaginal mas utilizados en las
     * revisiones personales de un usuario
     *
     * @param user usuario del que se buscara el registro mas usado
     * @return asociado al nombre se devuelve un arraylist de cadenas con los valores mas usado
     * o bien null si el usuario en cuestion no existe o no tiene revisiones personales registradas.
     */
    public ArrayList<String> obtenerFlujoVaginalMasUsado(UsuarioImpl user) {
        String tipoFlujo = null;
        ArrayList<String> listaFlujoVaginal = new ArrayList<String>();

        return listaFlujoVaginal;
    }

    /*
    INTERFAZ
    Comentario: Metodo que imprime el analisis personal de un usuario dado
    Signatura: public void imprimirAnalisisRevisionesPersonales(UsuarioImpl user)
    Precondiciones:
    Entradas: usuario del que se imprimira el analisis personal
    Salidas:
    Postcondiciones: imprime en pantalla
*/

    /**
     * Metodo que imprime el analisis personal de un usuario dado
     *
     * @param user usuario del que se imprimira el analisis personal
     */
    public void imprimirAnalisisRevisionesPersonales(UsuarioImpl user) {


    }
  /*
    INTERFAZ
    Comentario: metodo para actualizar la fecha de nacimiento de un usuario
    Signatura: public boolean actualizarFechaNacimiento(UsuarioImpl user, GregorianCalendar nuevaFecha)
    Precondiciones:
    Entradas: usuario del que se modificaran los datos
              nuevaFecha nueva fecha de nacimiento del usuario
    Salidas: boolean
    Postcondiciones: asociado al nombre se devolvera un boolean que sera true si la modificacion se realizo
                    correctamente y false si no. Si el usuario no existe lanzara excepcion.

     */

    /**
     * metodo para actualizar la fecha de nacimiento de un usuario
     *
     * @param user       usuario del que se modificaran los datos
     * @param nuevaFecha nueva fecha de nacimiento del usuario
     * @return asociado al nombre se devolvera un boolean que sera true si la modificacion se realizo
     * correctamente y false si no. Si el usuario no existe lanzara excepcion.
     */
    public boolean actualizarFechaNacimiento(UsuarioImpl user, GregorianCalendar nuevaFecha) {
        boolean exito = false;

        return exito;
    }



}


