/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.paciente.citas;

import presentation.paciente.citas.*;
import java.util.ArrayList;
import java.util.List;
import logic.Cita;
import logic.Paciente;
import logic.Usuario;

public class ModelCitas {
    List<Cita> citas;
    Paciente paciente;
    Usuario current;

    public ModelCitas() {
        this.reset();
    }

    public void reset(){ 
        List<Cita> rows = new ArrayList<>();         
        this.setCitas(rows);
    }
    
    public void setCitas(List<Cita> citas){
        this.citas = citas;    
    }

     public List<Cita> getCitas() {
        return citas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
     
    public void setCurrent(Usuario current) {
        this.current = current;
    }
    
  
}
