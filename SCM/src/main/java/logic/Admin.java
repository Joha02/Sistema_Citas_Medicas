package logic;

public class Admin extends Usuario {
    String tipo;
    
    public Admin() {
        super();
        this.tipo = "";
    }
    
    public Admin(String ID, String password, String name){
        super(ID, password, name);
        this.tipo = "3"; //Se refiere a que es administrador.
    }
    
    public String getTipo() { return tipo; }
    
    public void setTipo(String tipo){ this.tipo = tipo; }
    
    @Override  
    public String toString() {
        return "Administrador: " + name + "\n";
    }     
}
