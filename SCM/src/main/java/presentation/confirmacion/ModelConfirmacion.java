package presentation.confirmacion;

import java.util.ArrayList;
import java.util.List;
import logic.Cita;
import logic.Medico;
import logic.Usuario;

public class ModelConfirmacion {
    Usuario current;
    Medico medico ;
    Cita cita;
    
    public ModelConfirmacion() {
        this.reset();
    }
    public Medico getMedico() {
        return medico;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

   
    
    public void reset(){
        setCurrent(new Usuario());  
        this.medico = new Medico();
        this.cita = new Cita();  
        
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

   
}
