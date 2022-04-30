package presentation.buscar;

import logic.Usuario;

public class ModelBuscar {
    Usuario current;
    
    public ModelBuscar() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Usuario());        
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }
}
