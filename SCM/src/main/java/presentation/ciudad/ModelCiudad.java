package presentation.ciudad;

import java.util.ArrayList;
import java.util.List;
import logic.Ciudad;

public class ModelCiudad {
    List<Ciudad> ciudades;
    Ciudad current;
    
    public ModelCiudad() {
        this.reset();
    }
    
    public void reset(){
        setCurrent(new Ciudad()); 
        List<Ciudad> rows = new ArrayList<>();         
        this.setCiudades(rows);
    }
    
    public Ciudad getCurrent() {
        return current;
    }

    public void setCurrent(Ciudad current) {
        this.current = current;
    }
    
    
    public void setCiudades(List<Ciudad> ciudades){
        this.ciudades =ciudades;    
    }

     public List<Ciudad> getCiudades() {
        return ciudades;
    }
}
