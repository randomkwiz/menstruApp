package interfaces;

import clasesBasicas.UsuarioImpl;
import enumerado.EstadoAnimico;
import enumerado.FlujoVaginal;
import enumerado.Sexo;
import enumerado.Sintoma;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface RevisionPersonal {
    public String getID();

    public void setID(String ID);

    public UsuarioImpl getUsuario();

    public void setUsuario(UsuarioImpl usuario);

    public ArrayList<EstadoAnimico> getArraylistEstadoAnimico();


    public void setArraylistEstadoAnimico(ArrayList<EstadoAnimico> arraylistEstadoAnimico);

    public void addEstadoAnimico(EstadoAnimico estadoAnimico);

    public ArrayList<Sintoma> getArraylistSintoma();

    public void setArraylistSintoma(ArrayList<Sintoma> arraylistSintoma);

    public void addSintoma(Sintoma sintoma);

    public ArrayList<Sexo> getArraylistSexo();

    public void setArraylistSexo(ArrayList<Sexo> arraylistSexo);

    public void addSexo(Sexo sexo);

    public ArrayList<FlujoVaginal> getArraylistFlujoVaginal();

    public void setArraylistFlujoVaginal(ArrayList<FlujoVaginal> arraylistFlujoVaginal);

    public void addFlujoVaginal(FlujoVaginal flujoVaginal);

    public GregorianCalendar getFecha();

    public void setFecha(GregorianCalendar fecha);

}
