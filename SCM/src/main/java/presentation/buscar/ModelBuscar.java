package presentation.buscar;

import java.util.ArrayList;
import java.util.List;
import logic.Medico;
import logic.Usuario;

public class ModelBuscar {
    Usuario current;
    List<Medico> medicos ;
    
    public ModelBuscar() {
        this.reset();
    }
    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
    
    public void reset(){
        setCurrent(new Usuario());  
        this.medicos = new ArrayList();
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

   
}
