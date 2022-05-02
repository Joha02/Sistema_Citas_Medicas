package logic;

public class Admin extends Usuario {
    
    
    public Admin() {
        super();
        
    }
    
    public Admin(String ID, String password, String name){
        super(ID, password, name, "3");
    }
    
    public String getTipo() { return tipo; }
    
    public void setTipo(String tipo){ this.tipo = tipo; }
    
    @Override  
    public String toString() {
        return "Administrador: " + name + "\n";
    }     
}
