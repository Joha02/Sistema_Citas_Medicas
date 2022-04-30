package logic;

import java.sql.Timestamp;

public class Cita {

    private String ID;
    private Medico medico;
    private Paciente paciente;
    private String date;
    private String estado;
    private String anotaciones;

    public Cita() {
    }

    public Cita(Medico medico, Paciente paciente, String ID, String estado, String anotaciones, String date) {
        this.medico = medico;
        this.paciente = paciente;
        this.estado = estado;
        this.anotaciones = anotaciones;
        this.date = date; 
    }

    public String getId() {
        return ID;
    }

    public void setId(String ID) {
        this.ID = ID;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Usuario getpaciente() {
        return paciente;
    }

    public void setpaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    @Override
    public String toString() {
        return "Appointment[ " + medico + ", " + paciente + ", " + date + " ]";
    }
}
