package logic;

import data.Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private Dao dao;
    private static Service Instance;
    private List<Medico> registros = new ArrayList();
    private List<Especialidad> especialidades = new ArrayList();
    private List<Ciudad> ciudades = new ArrayList();
    private List<Integer> frecuencias = new ArrayList();
    private List<Integer> costos = new ArrayList();
    
    public static Service instance(){
        if(Instance == null){
            Instance = new Service();
        }
        return Instance;
    }
    
    
    public Service() {
        try{ dao = new Dao(); } catch(Exception e){}
        frecuencias.add(15);frecuencias.add(20);frecuencias.add(30);frecuencias.add(45);
        frecuencias.add(1);frecuencias.add(2);frecuencias.add(3);frecuencias.add(4);
        
        costos.add(10000);costos.add(25000);costos.add(35000);costos.add(45000);costos.add(50000);
        costos.add(100000);costos.add(150000);costos.add(200000);costos.add(250000);costos.add(300000);
    }
    
    public List<Integer> getFrecuencias(){
        return frecuencias;
    }
    
    public List<Integer> getCostos(){
        return costos;
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
    

    public Medico searchMedicoID(String ID) throws Exception{
        Medico med = dao.searchMedico(ID);
        if(med != null ){
            return med;
        }else{
            throw new Exception("Error");
        }
    } 
    
    public void setEstadoMed(int estado, String id) throws Exception{
        dao.setEstadoMed(estado, id);
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
    
    public void updateMedico(Medico m)throws Exception{
        dao.updateMed(m);
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
    
    public Admin adminFind(Usuario usuario) throws Exception{
        Admin ad = dao.searchAdmin(usuario.getID());
        if (ad != null) 
            return ad;
        else 
            throw new Exception("Admin no existe");
    } 
    
    public List<Medico> getRegistros() throws SQLException{
        registros = dao.getRegistros(0);
        return registros;
    }
    
    public void AddRegistro(Medico medico) throws Exception {
        if (medico != null) { 
            registros.add(medico);
        } 
        else { throw new Exception("Error al guardar registro"); }
    }
    
    public List<Especialidad> getEspecialidades() throws SQLException{
        especialidades = dao.getEspecialidades();
        return especialidades;
    }
    
    public void addEspecialidad(String espec) throws Exception{
        if (espec != "") { 
            dao.addEspecialidad(new Especialidad(espec));
        }
        else { throw new Exception("Cadena vacia"); }
    }
    
    public List<Ciudad> getCiudades() throws SQLException{
        ciudades = dao.getCiudades();
        return ciudades;
    }
    
    public void addCiudad(String ciu) throws Exception{
        if (ciu != "") { 
            dao.addCiudad(new Ciudad(ciu));
        }
        else { throw new Exception("Cadena vacia"); }
    }
    
    //--------------------------- CIUDAD ---------------------------
    public void AddCiudad(Ciudad ciudad) throws Exception {
        if (ciudad != null) { 
            ciudades.add(ciudad);
        } 
        else { throw new Exception("Error al guardar registro"); }
    }
    
    public Ciudad searchCiudad(String ID) throws Exception{
        Ciudad ciu = dao.searchCiudad(ID);
        if(ciu != null ){
            return ciu;
        }else{
            throw new Exception("Error");
        }
    } 
    
    public Ciudad CiudadFind(Ciudad ciudad) throws Exception{
        Ciudad ciu = dao.searchCiudad(ciudad.getCiudad());
        if (ciu != null) 
            return ciu;
        else 
            throw new Exception("Ciudad no existe");
    }    
    
    public void AddCiudad(String name) throws Exception {
        if (name != "") { 
            dao.addCiudad(new Ciudad(name));
        }
        else { throw new Exception("No se ha añadido ciudad"); }
    }
    
    
     //-------------------------------------Citas--------------------------------------

    public List<Medico> searchMedicos(String ciudad, String especialidad) throws Exception{
        return dao.searchMedicosDisponibles(ciudad,especialidad);
    }
    
    public List<Cita> searchCita(String medico_id) throws Exception{
        return dao.searchCitasDisponibles(medico_id);
    }
    
    public Cita search_Cita(String ID) throws Exception{
        Cita cita = dao.searchCita(ID);
        if(cita != null ){
            return cita;
        }else{
            throw new Exception("Error");
        }
    } 

    public void agendarCita(Cita cita) throws Exception {
        dao.agendarCita(cita);
    }
    
    public ArrayList<Cita> seachCitasByPaciente(String id) throws Exception{
        return dao.readByPaciente(id);
    }
    public ArrayList<Cita> seachCitasByMedico(String id) throws Exception{
        return dao.readByMedico(id);
    }

}


