package logic;

public class Paciente extends Usuario {
    String tipo;
    
    public Paciente(){
        super();
        this.tipo = "";
    }
   
    public Paciente(String id){
        super(id);
        this.tipo = "";
    }
    
    public Paciente(String ID, String password, String name){
        super(ID, password, name);
        this.tipo = "2"; //Se refiere a que es paciente.
    }
    
    public String getTipo() { return tipo; }
    
    public void setTipo(String tipo){ this.tipo = tipo; }
    
    @Override  
    public String toString() {
        return "Paciente: " + name + "\n";
    }     
}
