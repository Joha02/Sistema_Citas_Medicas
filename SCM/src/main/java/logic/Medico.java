package logic;

import java.util.List;

public class Medico extends Usuario {
    String especialidad;
    int costo;
    Ciudad ciudad;
    String direccion;
    String tipo;
    String info;
    int estado;
    List<Cita> citas; 
    
    public Medico() {
    }
    
    public Medico(String ID, String password, String name, String especialidad, int costo, Ciudad ciudad, String direccion, String info) {
        super(ID, password, name);
        this.especialidad = especialidad;
        this.costo = costo;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.tipo = "1";
        this.info = info;
        this.estado = 0;
    }

    public Medico(String tipo) {
        this.tipo = tipo;
    }

    public Medico( String ID, String password, String name) {
        super(ID, password, name);
        this.tipo = "1";
        this.estado = 0;
    }
 

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Medico{" + "especialidad=" + especialidad + ", costo=" + costo + ", ciudad=" + ciudad + ", direccion=" + direccion + ", tipo=" + tipo + ", info=" + info + '}';
    }   
   
    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas ) {
        this.citas = citas;
    }

  
    
}
