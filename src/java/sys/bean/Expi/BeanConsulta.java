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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sys.dao.daoConsultaPaciente;
import sys.imp.ConsultaPacienteImp;
import sys.model.pacientes.Consultas;
import sys.model.pacientes.Paciente;

/**
 *
 * @author Ramses Mtnz Santiago
 */
@Named(value = "ConsultaPaciente")
@ViewScoped
public class BeanConsulta implements Serializable {

    private Paciente paciente;
    public static int folio;
    private List<Paciente> listPaciente;
    private List<Consultas> consulta;
    public static int controlPlaca,periodontograma;

    public int getControlPlaca() {
        return controlPlaca;
    }

    public void setControlPlaca(int controlPlaca) {
        this.controlPlaca = controlPlaca;
    }

    public int getPeriodontograma() {
        return periodontograma;
    }

    public void setPeriodontograma(int periodontograma) {
        this.periodontograma = periodontograma;
    }

    public List<Consultas> getConsulta() {
        //hacer la consulta de la lista de consultas where paciente = folio
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        consulta = bdao.verConsultas();
        return consulta;
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

    public BeanConsulta() {
        paciente = new Paciente();
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

    public void nuevaConsulta(int folio) throws IOException {
        this.setFolio(folio);
        System.out.println("Redirecionando...\nFolio es:" + folio);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/FdO-3.0/pages/Alumnos/ConsultaSubsecuente.xhtml");
    }

    public void verHistorial(int folio) throws IOException {
        this.setFolio(folio);
        System.out.println("Redirecionando...\nFolio es:" + folio);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/FdO-3.0/pages/Alumnos/Historial.xhtml");
    }

    public void insertarConsulta() {
        daoConsultaPaciente bdao = new ConsultaPacienteImp();
        boolean inserto = bdao.insertaConsulta();
        if(inserto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Éxito!", "Se ha guardado exitosamente su consulta. Regrese al menú principal."));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Lo sentimos, no se ha guardado su consulta.\nConsulte con el administrador."));    
        }
        System.out.println(inserto);
    }

    public void verControlPlaca(int id) throws IOException {
        setControlPlaca(id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/FdO-3.0/pages/Alumnos/viewControlPlaca.xhtml");
    }

    public void verPeriodontograma(int id) throws IOException {
        setPeriodontograma(id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/FdO-3.0/pages/Alumnos/viewPeriodontograma.xhtml");
    }

}
