package sys.model.pacientes;
// Generated 17-jul-2018 21:17:55 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Consultas generated by hbm2java
 */
public class Consultas  implements java.io.Serializable {


     private Integer id;
     private ControlPlaca controlPlaca;
     private Paciente paciente;
     private Periodontograma periodontograma;
     private String folio;
     private Date fecha;

    public Consultas() {
    }

    public Consultas(ControlPlaca controlPlaca, Paciente paciente, Periodontograma periodontograma, String folio, Date fecha) {
       this.controlPlaca = controlPlaca;
       this.paciente = paciente;
       this.periodontograma = periodontograma;
       this.folio = folio;
       this.fecha = fecha;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public ControlPlaca getControlPlaca() {
        return this.controlPlaca;
    }
    
    public void setControlPlaca(ControlPlaca controlPlaca) {
        this.controlPlaca = controlPlaca;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Periodontograma getPeriodontograma() {
        return this.periodontograma;
    }
    
    public void setPeriodontograma(Periodontograma periodontograma) {
        this.periodontograma = periodontograma;
    }
    public String getFolio() {
        return this.folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


