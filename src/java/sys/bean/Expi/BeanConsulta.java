/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean.Expi;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sys.dao.daoConsultaPaciente;
import sys.imp.ConsultaPacienteImp;
import sys.model.pacientes.Consultas;
import sys.model.pacientes.ControlPlaca;
import sys.model.pacientes.Paciente;
import sys.model.pacientes.Periodontograma;

/**
 *
 * @author Ramses Mtnz Santiago
 */
@Named(value = "ConsultaPaciente")
@ViewScoped
public class BeanConsulta implements Serializable {

    
    @ManagedProperty("#{flash}")   
private Flash flash;
    private Paciente paciente;
  
    private  int folio;
    private int valor;
    private List<Paciente> listPaciente;
    private List<Consultas> consulta;
    private Consultas consultas;
    private  ControlPlaca VercontrolPlaca;
    private  Periodontograma Verperiodontograma;
     private String numdientes;
    private String Superficiesplaca;
    private String numsuperficies;
    private String extensionplaca;
    private String dientecontrol;
    private String dienteBDcontrol;    
     private String dienteimg;
    private String dienteBDperi;
    private ControlPlaca controlPlaca;
    private Periodontograma periodontograma;
    private Paciente temporal;
    private Date cuando;
 
     public BeanConsulta() {
        paciente = new Paciente();
        consultas = new Consultas();
        controlPlaca = new ControlPlaca();
        periodontograma = new Periodontograma();
    }
     
    @PostConstruct
    protected void init(){
        String cadenacontrol = "#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff,#ffffff";
        String dienteval = controlPlaca.getDientes();
        if (dienteval == null){
            controlPlaca.setDientes(cadenacontrol);
        }
        String cadena = "svg/dientes/18.png,svg/dientes/17.png,svg/dientes/16.png,svg/dientes/15.png,svg/dientes/14.png,svg/dientes/13.png,svg/dientes/12.png,svg/dientes/11.png,svg/dientes/21.png,svg/dientes/22.png,svg/dientes/23.png,svg/dientes/24.png,svg/dientes/25.png,svg/dientes/26.png,svg/dientes/27.png,svg/dientes/28.png,svg/dientes/55.png,svg/dientes/54.png,svg/dientes/53.png,svg/dientes/52.png,svg/dientes/51.png,svg/dientes/61.png,svg/dientes/62.png,svg/dientes/63.png,svg/dientes/64.png,svg/dientes/65.png,svg/dientes/85.png,svg/dientes/84.png,svg/dientes/83.png,svg/dientes/82.png,svg/dientes/81.png,svg/dientes/71.png,svg/dientes/72.png,svg/dientes/73.png,svg/dientes/74.png,svg/dientes/75.png,svg/dientes/48.png,svg/dientes/47.png,svg/dientes/46.png,svg/dientes/45.png,svg/dientes/44.png,svg/dientes/43.png,svg/dientes/42.png,svg/dientes/41.png,svg/dientes/31.png,svg/dientes/32.png,svg/dientes/33.png,svg/dientes/34.png,svg/dientes/35.png,svg/dientes/36.png,svg/dientes/37.png,svg/dientes/38.png";
        String dienteperi = periodontograma.getDientes();
        if (dienteperi == null){
            periodontograma.setDientes(cadena);
        }
        if(FacesContext.getCurrentInstance().getExternalContext().getFlash().containsKey("nuevopaciente")) {
            Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            paciente = (Paciente) mandar.get("nuevopaciente");
            System.out.println("pasa algo");
            System.out.println("el paciente es "+paciente.getId());
            System.out.println("el folio es "+paciente.getFolio());
        }
         if(FacesContext.getCurrentInstance().getExternalContext().getFlash().containsKey("id")) {
            Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            valor = (int) mandar.get("id");
            System.out.println("segundo if");
            System.out.println("el valor es "+valor);
        }

         if(FacesContext.getCurrentInstance().getExternalContext().getFlash().containsKey("controlp")) {
            Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            VercontrolPlaca = (ControlPlaca)mandar.get("controlp");
            System.out.println("tercer if");
            System.out.println("el control es "+VercontrolPlaca.getId());
        }
         
          if(FacesContext.getCurrentInstance().getExternalContext().getFlash().containsKey("periodonto")) {
            Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            Verperiodontograma = (Periodontograma)mandar.get("periodonto");
            System.out.println("cuarto if");
            System.out.println("el peri es "+Verperiodontograma.getId());
        }
         if(FacesContext.getCurrentInstance().getExternalContext().getFlash().containsKey("periodonto")) {
            Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            Verperiodontograma = (Periodontograma)mandar.get("periodonto");
            System.out.println("cuarto if");
            System.out.println("el peri es "+Verperiodontograma.getId());
        } 
          if(FacesContext.getCurrentInstance().getExternalContext().getFlash().containsKey("fecha")) {
            Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            cuando = (Date)mandar.get("fecha");
            System.out.println("quinto if");
            System.out.println("la fecha es "+cuando);
        } 
          
         
         
    }
    
    @PreDestroy
    public void preDestroy(){
       
    }

     
    public List<Consultas> getConsulta() {
        //hacer la consulta de la lista de consultas where paciente = folio
        System.out.println("Llega aqui");
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        consulta = bdao.verConsultas(valor);
        return consulta;
    }
    
    
    
    public void Obtienetodo(){
        String nuevotexto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nuevotexto");
        periodontograma.setDientes(nuevotexto);
    }
    
    
    public void obtenerControlPlaca() {
        String nuevotexto = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nuevotexto");
        controlPlaca.setDientes(nuevotexto);
    }
     

    public void setConsulta(List<Consultas> consulta) {
        this.consulta = consulta;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public List<Paciente> getListPaciente() {
        return listPaciente;
    }

    public void setListPaciente(List<Paciente> listPaciente) {
        this.listPaciente = listPaciente;
    }

   

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void folioPaciente() {
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        listPaciente = bdao.verFoliosPaciente(paciente);
        if (listPaciente.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Paciente",
                    "Lo sentimos, no aparece ningún registro con el folio " + paciente.getFolio()));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente",
                    "Se han encontrado " + listPaciente.size() + " resultados con el folio " + paciente.getFolio()));
        }
    }

    public void nombresPaciente() {
        System.out.println(paciente.getNombre());
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        listPaciente = bdao.verNombresPaciente(paciente);
        if (listPaciente.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Paciente",
                    "Lo sentimos, no aparece ningún registro con el nombre " + paciente.getNombre()));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente",
                    "Se han encontrado " + listPaciente.size() + " resultados con el nombre " + paciente.getNombre()));
        }
        
    }

    public void nuevaConsulta(int id, String folio, String name) throws IOException {
        System.out.println("el id es " +id);
        setFolio(id); 
        paciente.setId(id);
        paciente.setFolio(folio);
        paciente.setNombre(name);
        Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        mandar.put("nuevopaciente", paciente);
        mandar.keep("nuevopaciente");
        System.out.println("Redirecionando...\nFolio es:" + id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/FdO-3.0/pages/Alumnos/ConsultaSubsecuente.xhtml");
    }

    public void verHistorial(int id, String name, String folio) throws IOException {
        System.out.println("el id es "+id);
        setFolio(id); 
        paciente.setId(id);
        paciente.setFolio(folio);
        paciente.setNombre(name);
        Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        mandar.put("nuevopaciente", paciente);
        mandar.put("id", id);
        mandar.keep("id");
        System.out.println("Redirecionando...\nFolio es:" + id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/FdO-3.0/pages/Alumnos/Historial.xhtml");
    }
    
    public void insertarConsulta() {
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        boolean inserto = bdao.insertaConsulta(controlPlaca, periodontograma,paciente);
        if(inserto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Éxito!", "Se ha guardado exitosamente su consulta"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Lo sentimos, no se ha guardado su consulta.\nConsulte con el administrador."));    
        }
        System.out.println(inserto);
    }
    
   

    public void verControlPlaca(ControlPlaca control, Date fecha) throws IOException {
        System.out.println("Control");
        Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        setVercontrolPlaca(control);
        setCuando(fecha);
        mandar.put("fecha",fecha);
        mandar.keep("fecha");
        mandar.put("controlp", control);
        mandar.keep("controlp");
        FacesContext.getCurrentInstance().getExternalContext().redirect("/FdO-3.0/pages/Alumnos/viewControlPlaca.xhtml");
    }

    public void verPeriodontograma(Periodontograma periodonto, Date fecha) throws IOException {
        Flash mandar = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        mandar.put("periodonto", periodonto);
        mandar.keep("periodonto");
        setCuando(fecha);
        mandar.put("fecha",fecha);
        mandar.keep("fecha");
        setVerperiodontograma(periodonto);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/FdO-3.0/pages/Alumnos/viewPeriodontograma.xhtml");
    }

    /**
     * @return the controlPlaca
     */
    public ControlPlaca getControlPlaca() {
        return controlPlaca;
    }

    /**
     * @param controlPlaca the controlPlaca to set
     */
    public void setControlPlaca(ControlPlaca controlPlaca) {
        this.controlPlaca = controlPlaca;
    }

    /**
     * @return the periodontograma
     */
    public Periodontograma getPeriodontograma() {
        return periodontograma;
    }

    /**
     * @param periodontograma the periodontograma to set
     */
    public void setPeriodontograma(Periodontograma periodontograma) {
        this.periodontograma = periodontograma;
    }

    /**
     * @return the consultas
     */
    public Consultas getConsultas() {
        return consultas;
    }

    /**
     * @param consultas the consultas to set
     */
    public void setConsultas(Consultas consultas) {
        this.consultas = consultas;
    }

    /**
     * @return the numdientes
     */
    public String getNumdientes() {
        return numdientes;
    }

    /**
     * @param numdientes the numdientes to set
     */
    public void setNumdientes(String numdientes) {
        this.numdientes = numdientes;
    }

    /**
     * @return the Superficiesplaca
     */
    public String getSuperficiesplaca() {
        return Superficiesplaca;
    }

    /**
     * @param Superficiesplaca the Superficiesplaca to set
     */
    public void setSuperficiesplaca(String Superficiesplaca) {
        this.Superficiesplaca = Superficiesplaca;
    }

    /**
     * @return the numsuperficies
     */
    public String getNumsuperficies() {
        return numsuperficies;
    }

    /**
     * @param numsuperficies the numsuperficies to set
     */
    public void setNumsuperficies(String numsuperficies) {
        this.numsuperficies = numsuperficies;
    }

    /**
     * @return the extensionplaca
     */
    public String getExtensionplaca() {
        return extensionplaca;
    }

    /**
     * @param extensionplaca the extensionplaca to set
     */
    public void setExtensionplaca(String extensionplaca) {
        this.extensionplaca = extensionplaca;
    }

    /**
     * @return the dientecontrol
     */
    public String getDientecontrol() {
        return dientecontrol;
    }

    /**
     * @param dientecontrol the dientecontrol to set
     */
    public void setDientecontrol(String dientecontrol) {
        this.dientecontrol = dientecontrol;
    }

    /**
     * @return the dienteBDcontrol
     */
    public String getDienteBDcontrol() {
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        String dientes = bdao.verPlaca(VercontrolPlaca);
        this.dienteBDcontrol=dientes;
        return dienteBDcontrol;
    }

    /**
     * @param dienteBDcontrol the dienteBDcontrol to set
     */
    public void setDienteBDcontrol(String dienteBDcontrol) {
        this.dienteBDcontrol = dienteBDcontrol;
    }

    /**
     * @return the dienteimg
     */
    public String getDienteimg() {
        return dienteimg;
    }

    /**
     * @param dienteimg the dienteimg to set
     */
    public void setDienteimg(String dienteimg) {
        this.dienteimg = dienteimg;
    }

    /**
     * @return the dienteBDperi
     */
    public String getDienteBDperi() {
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        String dientes = bdao.verPeriodontograma(Verperiodontograma);
        this.dienteBDperi=dientes;
        return dienteBDperi;
    }

    /**
     * @param dienteBDperi the dienteBDperi to set
     */
    public void setDienteBDperi(String dienteBDperi) {
        this.dienteBDperi = dienteBDperi;
    }


    /**
     * @return the VercontrolPlaca
     */
    public ControlPlaca getVercontrolPlaca() {
        return VercontrolPlaca;
    }

    /**
     * @param VercontrolPlaca the VercontrolPlaca to set
     */
    public void setVercontrolPlaca(ControlPlaca VercontrolPlaca) {
        this.VercontrolPlaca = VercontrolPlaca;
    }

    /**
     * @return the Verperiodontograma
     */
    public Periodontograma getVerperiodontograma() {
        return Verperiodontograma;
    }

    /**
     * @param Verperiodontograma the Verperiodontograma to set
     */
    public void setVerperiodontograma(Periodontograma Verperiodontograma) {
        this.Verperiodontograma = Verperiodontograma;
    }

    /**
     * @return the temporal
     */
    public Paciente getTemporal() {
        return temporal;
    }

    /**
     * @param temporal the temporal to set
     */
    public void setTemporal(Paciente temporal) {
        this.temporal = temporal;
    }

    /**
     * @return the flash
     */
    public Flash getFlash() {
        return flash;
    }

    /**
     * @param flash the flash to set
     */
    public void setFlash(Flash flash) {
        this.flash = flash;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the cuando
     */
    public Date getCuando() {
        return cuando;
    }

    /**
     * @param cuando the cuando to set
     */
    public void setCuando(Date cuando) {
        this.cuando = cuando;
    }

}
