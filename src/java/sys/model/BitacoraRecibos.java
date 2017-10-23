package sys.model;
// Generated 14/10/2017 07:17:00 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * BitacoraRecibos generated by hbm2java
 */
public class BitacoraRecibos  implements java.io.Serializable {


     private int folio;
     private Alumnos alumnos;
     private MaestroMaterias maestroMaterias;
     private MenuTratamientos menuTratamientos;
     private String nombrePaciente;
     private int cantidad;
     private Date fecha;
     private String comentario;
     private int sexo;
     private int clinica;
    public BitacoraRecibos() {
        menuTratamientos = new MenuTratamientos();
        alumnos = new Alumnos();
        maestroMaterias = new MaestroMaterias();
        
    }

	
    public BitacoraRecibos(int folio, Alumnos alumnos, MenuTratamientos menuTratamientos, int cantidad, Date fecha, int sexo, int clinica) {
        this.folio = folio;
        this.alumnos = alumnos;
        this.menuTratamientos = menuTratamientos;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.sexo = sexo;
        this.clinica = clinica;
    }
    public BitacoraRecibos(int folio, Alumnos alumnos, MaestroMaterias maestroMaterias, MenuTratamientos menuTratamientos, String nombrePaciente, int cantidad, Date fecha, String comentario, int sexo, int clinica) {
       this.folio = folio;
       this.alumnos = alumnos;
       this.maestroMaterias = maestroMaterias;
       this.menuTratamientos = menuTratamientos;
       this.nombrePaciente = nombrePaciente;
       this.cantidad = cantidad;
       this.fecha = fecha;
       this.comentario = comentario;
       this.sexo = sexo;
       this.clinica = clinica;
    }
   
    public int getFolio() {
        return this.folio;
    }
    
    public void setFolio(int folio) {
        this.folio = folio;
    }
    public Alumnos getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }
    public MaestroMaterias getMaestroMaterias() {
        return this.maestroMaterias;
    }
    
    public void setMaestroMaterias(MaestroMaterias maestroMaterias) {
        this.maestroMaterias = maestroMaterias;
    }
    public MenuTratamientos getMenuTratamientos() {
        return this.menuTratamientos;
    }
    
    public void setMenuTratamientos(MenuTratamientos menuTratamientos) {
        this.menuTratamientos = menuTratamientos;
    }
    public String getNombrePaciente() {
        return this.nombrePaciente;
    }
    
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public int getSexo() {
        return this.sexo;
    }
    
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
    public int getClinica() {
        return this.clinica;
    }
    
    public void setClinica(int clinica) {
        this.clinica = clinica;
    }




}


