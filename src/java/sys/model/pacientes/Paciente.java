package sys.model.pacientes;
// Generated 11/04/2018 12:39:53 PM by Hibernate Tools 4.3.1


import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author EduardoArcos
 */

@Entity
@Table(name = "paciente")
public class Paciente  implements java.io.Serializable {


     private Integer id;
     private int direccionPaciente;
     private int medicoPaciente;
     private int trabajoPaciente;
     private String folio;
     private String nombre;
     private int edad;
     private String sexo;
     private Date fechaNacim;
     private String telefono;
     private String estatura;
     private String peso;
     private String estadoCivil;
     private String nivelEstudios;
     private String estadoSalud;
     private String porqueSolicita;
     private String observaciones;
     private Date fechaRegistro;
     //private Set examenOrofacials = new HashSet(0);
     //private Set planTratamientos = new HashSet(0);
     //private Set preguntasPacientes = new HashSet(0);
     //private Set odontogramas = new HashSet(0);

    public Paciente() {
    }

	
    public Paciente(int direccionPaciente, int medicoPaciente, int trabajoPaciente, String folio, String nombre, int edad, String sexo, Date fechaNacim, String telefono, String estatura, String peso, String estadoCivil, String nivelEstudios, String estadoSalud, String porqueSolicita, String observaciones, Date fechaRegistro) {
        this.direccionPaciente = direccionPaciente;
        this.medicoPaciente = medicoPaciente;
        this.trabajoPaciente = trabajoPaciente;
        this.folio = folio;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaNacim = fechaNacim;
        this.telefono = telefono;
        this.estatura = estatura;
        this.peso = peso;
        this.estadoCivil = estadoCivil;
        this.nivelEstudios = nivelEstudios;
        this.estadoSalud = estadoSalud;
        this.porqueSolicita = porqueSolicita;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
    }
    /*
    public Paciente(DireccionPaciente direccionPaciente, MedicoPaciente medicoPaciente, TrabajoPaciente trabajoPaciente, String folio, String nombre, int edad, String sexo, Date fechaNacim, String telefono, String estatura, String peso, String estadoCivil, String nivelEstudios, String estadoSalud, String porqueSolicita, String observaciones, Date fechaRegistro, Set examenOrofacials, Set planTratamientos, Set preguntasPacientes, Set odontogramas) {
       this.direccionPaciente = direccionPaciente;
       this.medicoPaciente = medicoPaciente;
       this.trabajoPaciente = trabajoPaciente;
       this.folio = folio;
       this.nombre = nombre;
       this.edad = edad;
       this.sexo = sexo;
       this.fechaNacim = fechaNacim;
       this.telefono = telefono;
       this.estatura = estatura;
       this.peso = peso;
       this.estadoCivil = estadoCivil;
       this.nivelEstudios = nivelEstudios;
       this.estadoSalud = estadoSalud;
       this.porqueSolicita = porqueSolicita;
       this.observaciones = observaciones;
       this.fechaRegistro = fechaRegistro;
       this.examenOrofacials = examenOrofacials;
       this.planTratamientos = planTratamientos;
       this.preguntasPacientes = preguntasPacientes;
       this.odontogramas = odontogramas;
    }*/
   
    @Id
    @Column(name = "id")
    @GeneratedValue
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name = "domicilio")
    public int getDireccionPaciente() {
        return this.direccionPaciente;
    }
    
    public void setDireccionPaciente(int direccionPaciente) {
        this.direccionPaciente = direccionPaciente;
    }
    
    @Column(name = "medico")
    public int getMedicoPaciente() {
        return this.medicoPaciente;
    }
    
    public void setMedicoPaciente(int medicoPaciente) {
        this.medicoPaciente = medicoPaciente;
    }
    
    @Column(name = "ocupacion")
    public int getTrabajoPaciente() {
        return this.trabajoPaciente;
    }
    
    public void setTrabajoPaciente(int trabajoPaciente) {
        this.trabajoPaciente = trabajoPaciente;
    }
    
    @Column(name = "folio")
    public String getFolio() {
        return this.folio;
    }
    
    public void setFolio(String folio) {
        this.folio = folio;
    }
    
    @Column(name = "nombre")
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name = "edad")
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Column(name = "sexo")
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    @Column(name = "fecha_nacim")
    public Date getFechaNacim() {
        return this.fechaNacim;
    }
    
    public void setFechaNacim(Date fechaNacim) {
        this.fechaNacim = fechaNacim;
    }
    
    @Column(name = "telefono")
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Column(name = "estatura")
    public String getEstatura() {
        return this.estatura;
    }
    
    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }
    
    @Column(name = "peso")
    public String getPeso() {
        return this.peso;
    }
    
    public void setPeso(String peso) {
        this.peso = peso;
    }
    
    @Column(name = "estado_civil")
    public String getEstadoCivil() {
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    @Column(name = "nivel_estudios")
    public String getNivelEstudios() {
        return this.nivelEstudios;
    }
    
    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }
    
    @Column(name = "estado_salud")
    public String getEstadoSalud() {
        return this.estadoSalud;
    }
    
    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
    
    @Column(name = "porque_solicita")
    public String getPorqueSolicita() {
        return this.porqueSolicita;
    }
    
    public void setPorqueSolicita(String porqueSolicita) {
        this.porqueSolicita = porqueSolicita;
    }
    
    @Column(name = "observaciones")
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    @Column(name = "fecha_registro")
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    /*
    public Set getExamenOrofacials() {
        return this.examenOrofacials;
    }
    
    public void setExamenOrofacials(Set examenOrofacials) {
        this.examenOrofacials = examenOrofacials;
    }
    public Set getPlanTratamientos() {
        return this.planTratamientos;
    }
    
    public void setPlanTratamientos(Set planTratamientos) {
        this.planTratamientos = planTratamientos;
    }
    public Set getPreguntasPacientes() {
        return this.preguntasPacientes;
    }
    
    public void setPreguntasPacientes(Set preguntasPacientes) {
        this.preguntasPacientes = preguntasPacientes;
    }
    public Set getOdontogramas() {
        return this.odontogramas;
    }
    
    public void setOdontogramas(Set odontogramas) {
        this.odontogramas = odontogramas;
    }*/
}


