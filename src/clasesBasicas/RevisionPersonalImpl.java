/*
 * Propiedades
 *   Basicas
 *          UsuarioImpl usuario
 *          ArrayList<EstadoAnimico> arraylistEstadoAnimico
 *          ArrayList<Sintomas> arraylistSintomas
 *          ArrayList<Sexo> arraylistSexo
 *          ArrayList<FlujoVaginal> arraylistFlujoVaginal
 *          GregorianCalendar fecha
 *
 *
 *   Derivadas
 *   Compartidas
 * Requisitos:
 *
 * Metodos interface
 * Metodos añadidos
 * Metodos object y otros:
 * */
package clasesBasicas;

import enumerado.EstadoAnimico;
import enumerado.FlujoVaginal;
import enumerado.Sexo;
import enumerado.Sintoma;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class RevisionPersonalImpl {
    UsuarioImpl usuario;
    String ID;
    ArrayList<EstadoAnimico> arraylistEstadoAnimico;
    ArrayList<Sintoma> arraylistSintoma;
    ArrayList<Sexo> arraylistSexo;
    ArrayList<FlujoVaginal> arraylistFlujoVaginal;
    GregorianCalendar fecha;

    /**
     * Constructor con parametros
     *
     * @param usuario usuario al que pertenece la revision personal
     */
    public RevisionPersonalImpl(UsuarioImpl usuario) {
        this.usuario = usuario;
        this.arraylistEstadoAnimico = new ArrayList<>();
        this.arraylistSintoma = new ArrayList<>();
        this.arraylistSexo = new ArrayList<>();
        this.arraylistFlujoVaginal = new ArrayList<>();
        this.fecha = new GregorianCalendar();
    }

    /**
     * Constructor con parametros
     *
     * @param usuario                usuario al que pertenece la revision personal
     * @param arraylistEstadoAnimico arraylist de estados animicos de la revision
     * @param arraylistSintoma       arraylist de sintomas de la revision
     * @param arraylistSexo          arraylist de sexo de la revision
     * @param arraylistFlujoVaginal  arraylist de flujo vaginal de la revision
     * @param fecha                  fecha de la revision
     */
    public RevisionPersonalImpl(UsuarioImpl usuario, ArrayList<EstadoAnimico> arraylistEstadoAnimico, ArrayList<Sintoma> arraylistSintoma, ArrayList<Sexo> arraylistSexo, ArrayList<FlujoVaginal> arraylistFlujoVaginal, GregorianCalendar fecha) {
        this.usuario = usuario;
        this.arraylistEstadoAnimico = arraylistEstadoAnimico;
        this.arraylistSintoma = arraylistSintoma;
        this.arraylistSexo = arraylistSexo;
        this.arraylistFlujoVaginal = arraylistFlujoVaginal;
        this.fecha = fecha;
    }

    //getters y setters

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public UsuarioImpl getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioImpl usuario) {
        this.usuario = usuario;
    }

    public ArrayList<EstadoAnimico> getArraylistEstadoAnimico() {
        return arraylistEstadoAnimico;
    }


    public void setArraylistEstadoAnimico(ArrayList<EstadoAnimico> arraylistEstadoAnimico) {
        this.arraylistEstadoAnimico = arraylistEstadoAnimico;
    }

    public void addEstadoAnimico(EstadoAnimico estadoAnimico) {
        arraylistEstadoAnimico.add(estadoAnimico);
    }

    public ArrayList<Sintoma> getArraylistSintoma() {
        return arraylistSintoma;
    }

    public void setArraylistSintoma(ArrayList<Sintoma> arraylistSintoma) {
        this.arraylistSintoma = arraylistSintoma;
    }

    public void addSintoma(Sintoma sintoma) {
        arraylistSintoma.add(sintoma);
    }

    public ArrayList<Sexo> getArraylistSexo() {
        return arraylistSexo;
    }

    public void setArraylistSexo(ArrayList<Sexo> arraylistSexo) {
        this.arraylistSexo = arraylistSexo;
    }

    public void addSexo(Sexo sexo) {
        arraylistSexo.add(sexo);
    }

    public ArrayList<FlujoVaginal> getArraylistFlujoVaginal() {
        return arraylistFlujoVaginal;
    }

    public void setArraylistFlujoVaginal(ArrayList<FlujoVaginal> arraylistFlujoVaginal) {
        this.arraylistFlujoVaginal = arraylistFlujoVaginal;
    }

    public void addFlujoVaginal(FlujoVaginal flujoVaginal) {
        arraylistFlujoVaginal.add(flujoVaginal);
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
}
