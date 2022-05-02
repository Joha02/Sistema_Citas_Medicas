/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.medico.citas;

import java.util.ArrayList;
import java.util.List;
import logic.Cita;
import logic.Medico;

public class ModelCitas {
    List<Cita> citas;
    Medico medico;

    public ModelCitas() {
        this.reset();
    }

    public void reset(){ 
        List<Cita> rows = new ArrayList<>();         
        this.setCitas(rows);
    }
    
    public void setCitas(List<Cita> citas){
        this.citas =citas;    
    }

     public List<Cita> getCitas() {
        return citas;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
     
     
}
