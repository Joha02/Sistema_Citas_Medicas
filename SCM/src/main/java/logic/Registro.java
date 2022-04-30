package logic;

public class Registro {
    private Medico medico;
    
    public Registro(){}
    
    public Registro(Medico medico){
        this.medico = medico;
    }
    
    public Medico getMedico(){
        return medico;
    }
    
    public void setMedico(Medico medico){
        this.medico = medico;
    }
}
