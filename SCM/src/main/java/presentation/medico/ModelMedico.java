package presentation.medico;

import logic.Medico;

public class ModelMedico {
    Medico current;
    
    public ModelMedico() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Medico());        
    }
    
    public Medico getCurrent() {
        return current;
    }

    public void setCurrent(Medico current) {
        this.current = current;
    }
}
