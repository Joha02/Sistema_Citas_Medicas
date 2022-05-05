package logic;

import java.util.List;

public class Paciente extends Usuario {
    List<Cita> citas; 
    public Paciente(){
        super();
        this.tipo = "";


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

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
    
    
    
}
