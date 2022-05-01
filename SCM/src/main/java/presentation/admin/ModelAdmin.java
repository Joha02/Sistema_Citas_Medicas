package presentation.admin;

import java.util.ArrayList;
import java.util.List;
import logic.Admin;
import logic.Ciudad;
import logic.Especialidad;
import logic.Medico;

public class ModelAdmin {

    Admin current;
    List<Medico> registros;
    List<Especialidad> especialidades;
    List<Ciudad> ciudades;
    
    public ModelAdmin() {
        this.reset();
    }

    public void reset() {
        setAdmin(new Admin());
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
    
    public List<Ciudad> getCiudades() {
        return ciudades;
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
    
    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
