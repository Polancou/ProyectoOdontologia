package sys.model.pacientes;
// Generated 17-jul-2018 21:17:55 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PlanTratamiento generated by hbm2java
 */
public class PlanTratamiento  implements java.io.Serializable {


     private Integer id;
     private Paciente paciente;
     private Tratamientos tratamientos;
     private Date fecha;

    public PlanTratamiento() {
    }

    public PlanTratamiento(Paciente paciente, Tratamientos tratamientos, Date fecha) {
       this.paciente = paciente;
       this.tratamientos = tratamientos;
       this.fecha = fecha;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Tratamientos getTratamientos() {
        return this.tratamientos;
    }
    
    public void setTratamientos(Tratamientos tratamientos) {
        this.tratamientos = tratamientos;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


