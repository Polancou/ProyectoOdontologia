package sys.model.pacientes;
// Generated 17-jul-2018 21:17:55 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * MedicoPaciente generated by hbm2java
 */
public class MedicoPaciente  implements java.io.Serializable {


     private Integer id;
     private String nombreMedico;
     private String telefonoMedico;
     private String direccionMedico;
     private Set<Paciente> pacientes = new HashSet<Paciente>(0);

    public MedicoPaciente() {
    }

	
    public MedicoPaciente(String nombreMedico, String telefonoMedico, String direccionMedico) {
        this.nombreMedico = nombreMedico;
        this.telefonoMedico = telefonoMedico;
        this.direccionMedico = direccionMedico;
    }
    public MedicoPaciente(String nombreMedico, String telefonoMedico, String direccionMedico, Set<Paciente> pacientes) {
       this.nombreMedico = nombreMedico;
       this.telefonoMedico = telefonoMedico;
       this.direccionMedico = direccionMedico;
       this.pacientes = pacientes;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombreMedico() {
        return this.nombreMedico;
    }
    
    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }
    public String getTelefonoMedico() {
        return this.telefonoMedico;
    }
    
    public void setTelefonoMedico(String telefonoMedico) {
        this.telefonoMedico = telefonoMedico;
    }
    public String getDireccionMedico() {
        return this.direccionMedico;
    }
    
    public void setDireccionMedico(String direccionMedico) {
        this.direccionMedico = direccionMedico;
    }
    public Set<Paciente> getPacientes() {
        return this.pacientes;
    }
    
    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }




}


