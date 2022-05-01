package data;

import logic.Paciente;
import logic.Medico;
import logic.Admin;
import logic.Ciudad;
import logic.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Especialidad;

public class Dao {
    Database db;
    
    public Dao(){
        db = Database.instance();
    }
    
    //---------------------------- MEDICOS ----------------------------
    public Medico readMedico(String id, String password) throws Exception {
        String sql = "select * from medicos m where id=? and password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        stm.setString(2, password);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromMedicos(rs, "m"); } 
        else { throw new Exception("Medico no existe"); }
    }
    
    public Medico fromMedicos(ResultSet rs, String alias){
        try {
            Medico m = new Medico();
            m.setID(rs.getString(alias + ".id"));
            m.setPassword(rs.getString(alias + ".password"));
            m.setName(rs.getString(alias + ".name"));
            m.setEspecialidad(rs.getString(alias + ".especialidad"));
            m.setCosto(rs.getInt(alias + ".costo"));
            m.setCiudad(new Ciudad(rs.getString(alias + ".ciudad")));
            m.setDireccion(rs.getString(alias + ".direccion"));
            m.setTipo(rs.getString(alias + ".tipo"));
            m.setInfo(rs.getString(alias + ".info"));
            m.setEstado(rs.getInt(alias + ".estado"));
            
            
            return m;
        } catch (SQLException ex) { return null; }
    }
    
    public Medico searchMedico(String id) throws Exception {
        String sql = "select from * medicos m where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromMedicos(rs, "m"); } 
        else { throw new Exception("Medico no existe"); }
    }
    
    public void addMedico(Medico m) throws Exception {
        String sql = "insert into medicos(id, password, name, tipo, estado) "
                + "values (?,?,?,?,?);";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, m.getID());
        stm.setString(2, m.getPassword());
        stm.setString(3, m.getName());
        stm.setString(4, m.getTipo());
        stm.setInt(5, m.getEstado());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("MEdico ya existe");
        }
    }
    
     public List<Medico> searchMedicosDisponibles(String ciudad, String especialidad) throws Exception {
        String sql = "select * from medicos c where ciudad like ? and especialidad like ?;";// para revisasr inicio y final de las palabras
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, "%"+ciudad+"%");
        stm.setString(2, "%"+especialidad+"%");
        ResultSet rs = db.executeQuery(stm);
    
         
        List<Medico> medicosDisponibles = new ArrayList();
     
         while (rs.next()) {
             medicosDisponibles.add(fromMedicos(rs, "c"));
         }

         return medicosDisponibles;

    }
     
    //---------------------------- PACIENTES ----------------------------
    public Paciente readPaciente(String id, String password) throws Exception {
        String sql = "select * from pacientes p where id=? and password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        stm.setString(2, password);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromPacientes(rs, "p"); } 
        else { throw new Exception("Paciente no existe"); }
    }
    
    public Paciente fromPacientes(ResultSet rs, String alias){
        try {
            Paciente p = new Paciente();
            p.setID(rs.getString(alias + ".id"));
            p.setPassword(rs.getString(alias + ".password"));
            p.setName(rs.getString(alias + ".name"));
            return p;
        } catch (SQLException ex) { return null; }
    }
    
    public Paciente searchPaciente(String id) throws Exception {
        String sql = "select * from pacientes p where id=?;";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { 
            return fromPacientes(rs, "p"); 
        } 
        else { throw new Exception("Paciente no existe"); }
    }
    
    public void addPaciente(Paciente p) throws Exception {
        String sql = "insert into pacientes(id, password, name, tipo) "
                + "values (?,?,?,?);";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, p.getID());
        stm.setString(2, p.getPassword());
        stm.setString(3, p.getName());
        stm.setString(4, p.getTipo());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Paciente ya existe");
        }
    }
    //----------------------------- ADMINISTRADORES -----------------------------
    public Admin readAdmin(String id, String password) throws Exception {
        String sql = "select * from admins a where id=? and password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        stm.setString(2, password);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromAdmins(rs, "a"); } 
        else { throw new Exception("Admin no existe"); }
    }
    
    public Admin fromAdmins(ResultSet rs, String alias){
        try {
            Admin a = new Admin();
            a.setID(rs.getString(alias + ".id"));
            a.setPassword(rs.getString(alias + ".password"));
            a.setName(rs.getString(alias + ".name"));
            return a;
        } catch (SQLException ex) { return null; }
    }
    
    public Admin searchAdmin(String id) throws Exception {
        String sql = "select * from admins a where id=?;";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { 
            return fromAdmins(rs, "a"); 
        } 
        else { throw new Exception("Admin no existe"); }
    }
    
    public List<Medico> getRegistros(int estado) throws SQLException{
        String sql = "select * from medicos m where estado=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, estado);
        ResultSet rs = db.executeQuery(stm);
   
        List<Medico> registros = new ArrayList();
     
        while (rs.next()) { registros.add(fromMedicos(rs, "m")); } 
        
           return registros;
    }
    
    public void setEstadoMed(int estado, String id) throws Exception {
        String sql = "update medicos set estado=? where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setInt(1, estado);
        stm.setString(2, id);
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Medico no existe");
        }
    }
    
    public List<Especialidad> getEspecialidades() throws SQLException {
        List<Especialidad> especialidades = new ArrayList();
        try {
            String sql = "select * from especialidades e";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs = db.executeQuery(stm);
            while (rs.next()) {
                especialidades.add(fromEspecialidad(rs, "e"));
            } 
        }catch (SQLException ex) {}
        return especialidades;
    }
    
    public Especialidad fromEspecialidad(ResultSet rs, String alias) {
        try {
            Especialidad e = new Especialidad();
            e.setEspecialidad(rs.getString(alias + ".name"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void addEspecialidad(Especialidad e) throws Exception {
        String sql = "insert into especialidades(name) "
                + "values(?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getEspecialidad());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("Especialidad ya existe");
        }
    }
    
    //----------------------------- CITAS ----------------------------  
    public Cita readCita(String id) throws Exception {
        String sql = "select * from citas p where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromCitas(rs, "c"); } 
        else { throw new Exception("Cita no existe"); }
    }
    
    public Cita fromCitas(ResultSet rs, String alias){
        //id,date,estado,anotaciones, id_medico,id_paciente
        try {
            Cita c = new Cita();
            c.setId(rs.getString(alias + ".id"));
            c.setDate(rs.getString(alias + ".date"));
            c.setEstado(rs.getString(alias + ".estado")); 
            c.setAnotaciones(rs.getString(alias + ".anotaciones"));
            c.setMedico(new Medico(rs.getString(alias + ".id_medico")));
            c.setpaciente(new Paciente(rs.getString(alias + ".id_paciente")));
            return c;
        } catch (SQLException ex) { return null; }
    }
    
    public List<Cita> searchCitasDisponibles(String id_medico) throws Exception {
        String sql = "select * from citas c where id_medico=? and id_paciente is null";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id_medico);
        ResultSet rs = db.executeQuery(stm);
   
        List<Cita> citasDisponibles = new ArrayList();
     
        while (rs.next()) { citasDisponibles.add(fromCitas(rs, "c")); } 
        
           return citasDisponibles; 
     
    }
    
    //---------------------------- CIUDADES ----------------------------
    public Ciudad readCiudad(String id) throws Exception {
        String sql = "select * from ciudades ci where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { return fromCiudads(rs, "ci"); } 
        else { throw new Exception("Ciudad no existe"); }
    }
    
    public Ciudad fromCiudads(ResultSet rs, String alias){
        try {
            Ciudad ci = new Ciudad();
            ci.setName(rs.getString(alias + ".name"));
            return ci;
        } catch (SQLException ex) { return null; }
    }
    
    public Ciudad searchCiudad(String id) throws Exception {
        String sql = "select * from ciudades ci where id=?;";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) { 
            return fromCiudads(rs, "ci"); 
        } 
        else { throw new Exception("Ciudad no existe"); }
    }
    
    public void addCiudad(Ciudad ci) throws Exception {
        String sql = "insert into ciudades(name) "
                + "values (?);";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(2, ci.getName());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Ciudad ya existe");
        }
    }
     
}
