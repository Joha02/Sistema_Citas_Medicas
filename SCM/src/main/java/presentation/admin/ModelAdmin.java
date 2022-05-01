package presentation.admin;

import java.util.ArrayList;
import java.util.List;
import logic.Admin;
import logic.Especialidad;
import logic.Medico;

public class ModelAdmin {

    Admin current;
    List<Medico> registros;
    List<Especialidad> especialidades;
    
    public ModelAdmin() {
        this.reset();
    }

    public void reset() {
        setAdmin(new Admin());
        List<Medico> rows = new ArrayList<>();
    }

    public Admin getAdmin() {
        return current;
    }

    public List<Medico> getListarMedicos() {
        return registros;
    }
    
    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }
    
    public void setAdmin(Admin current) {
        this.current = current;
    }

    public void setListarMedicos(List<Medico> registros) {
        this.registros = registros;
    }
    
    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
}
