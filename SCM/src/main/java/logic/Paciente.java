package logic;

public class Paciente extends Usuario {
    
    public Paciente(){
        super();
    }
   
    public Paciente(String id){
        super(id);
    }
    
    public Paciente(String ID, String password, String name){
        super(ID, password, name, "2");
    }
    
    public String getTipo() { return tipo; }
    
    public void setTipo(String tipo){ this.tipo = tipo; }
    
    @Override  
    public String toString() {
        return "Paciente: " + name + "\n";
    }     
}
