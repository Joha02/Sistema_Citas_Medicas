package logic;

import data.Dao;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private Dao dao;
    private static Service Instance;
    private List<Registro> registros = new ArrayList();
    private List<String> especialidades = new ArrayList();
    private List<Ciudad> ciudades = new ArrayList();
    
    
    public static Service instance(){
        if(Instance == null){
            Instance = new Service();
        }
        return Instance;
    }
    
    
    public Service() {
        try{
            dao = new Dao();
        }
        catch(Exception e){
        }
    }
    
    //--------------------------- MEDICO ---------------------------
    public Medico medicoFind(Usuario usuario) throws Exception{
        Medico med = dao.searchMedico(usuario.getID());
        if (med != null) 
            return med;
        else 
            throw new Exception("Medico no existe");
    }   
    
    public Medico searchMedico(String ID, String password) throws Exception{
        Medico med = dao.readMedico(ID, password);
        if(med != null && med.getPassword().equals(password)){
            return med;
        }else{
            throw new Exception("Error");
        }
    }    
    
    public void AddMedico(String id, String password, String name, String especialidad, int costo, Ciudad ciudad, String direccion, String info) throws Exception {
        if (id != "" && password != "" && name != "") { 
            dao.addMedico(new Medico(id, password, name, especialidad, costo, ciudad, direccion, info)); 
        } 
        else { throw new Exception("No se ha añadido usuario"); }
    }
    
    public void AddMedico(String id, String password, String name) throws Exception {
        if (id != "" && password != "" && name != "") { 
            dao.addMedico(new Medico(id, password, name));
        }
        else { throw new Exception("No se ha añadido usuario"); }
    }
    
    
    
    //--------------------------- PACIENTE ---------------------------
    public Paciente searchPaciente(String ID, String password) throws Exception{
        Paciente pac = dao.searchPaciente(ID);
        if(pac != null && pac.getPassword().equals(password)){
            return pac;
        }else{
            throw new Exception("Error");
        }
    } 
    
    public Paciente pacienteFind(Usuario usuario) throws Exception{
        Paciente pac = dao.searchPaciente(usuario.getID());
        if (pac != null) 
            return pac;
        else 
            throw new Exception("Paciente no existe");
    }    
    
    public void AddPaciente(String id, String password, String name) throws Exception {
        if (id != "" && password != "" && name != "") { 
            dao.addPaciente(new Paciente(id, password, name));
        }
        else { throw new Exception("No se ha añadido usuario"); }
    }
    //--------------------------- ADMINISTRADOR ---------------------------
    public Admin searchAdmin(String ID, String password) throws Exception{
        Admin ad = dao.searchAdmin(ID);
        if(ad != null && ad.getPassword().equals(password)){
            return ad;
        }else{
            throw new Exception("Error");
        }
    } 
    
       //---------------------------------------------------------------------
    public List getRegistros(){
        return registros;
    }
    
    public Medico getMedico(int pos){
        Medico med = registros.get(pos).getMedico();
        return med;
    }
    
    public void AddRegistro(Medico medico) throws Exception {
        if (medico != null) { 
            Registro reg = new Registro(medico);
            registros.add(reg);
        } 
        else { throw new Exception("Error al guardar registro"); }
    }
    
    public void AddEspecialidad(String espec) throws Exception {
        if (espec != "") { 
            especialidades.add(espec);
        } 
        else { throw new Exception("Error al guardar registro"); }
    }
    
    public void AddCiudad(Ciudad ciudad) throws Exception {
        if (ciudad != null) { 
            ciudades.add(ciudad);
        } 
        else { throw new Exception("Error al guardar registro"); }
    }
    
    //--------------------------- CIUDAD ---------------------------
    public Ciudad searchCiudad(String ID) throws Exception{
        Ciudad ciu = dao.searchCiudad(ID);
        if(ciu != null ){
            return ciu;
        }else{
            throw new Exception("Error");
        }
    } 
    
    public Ciudad CiudadFind(Ciudad ciudad) throws Exception{
        Ciudad ciu = dao.searchCiudad(ciudad.getID());
        if (ciu != null) 
            return ciu;
        else 
            throw new Exception("Ciudad no existe");
    }    
    
    public void AddCiudad(String id, String name) throws Exception {
        if (id != "" && name != "") { 
            dao.addCiudad(new Ciudad(id, name));
        }
        else { throw new Exception("No se ha añadido ciudad"); }
    }
    
    
     //-------------------------------------Citas--------------------------------------//

    public List<Medico> searchMedicos(String ciudad, String especialidad) throws Exception{
        return dao.searchMedicosDisponibles(ciudad,especialidad);
    }
    
    public List<Cita> searchCita(String medico_id) throws Exception{
        return dao.searchCitasDisponibles(medico_id);
    }
    
    
    
    
}


