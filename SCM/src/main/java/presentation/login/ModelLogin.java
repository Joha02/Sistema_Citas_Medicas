package presentation.login;

import logic.Usuario;

public class ModelLogin {
    Usuario current;
    
    public ModelLogin() {
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
