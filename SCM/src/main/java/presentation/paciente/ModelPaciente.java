package presentation.paciente;

import logic.Paciente;

public class ModelPaciente {
    Paciente current;
    
    public ModelPaciente() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Paciente());        
    }
    
    public Paciente getCurrent() {
        return current;
    }

    public void setCurrent(Paciente current) {
        this.current = current;
    }
}
