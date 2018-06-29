/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean.Expi;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sys.model.pacientes.DireccionPaciente;
import sys.model.pacientes.MedicoPaciente;
import sys.model.pacientes.Paciente;
import sys.model.pacientes.TrabajoPaciente;

/**
 *
 * @author Ramses Mtnz Santiago
 */
@Named(value = "DatosPersonales")
@ViewScoped
public class BeanDatosPersonales implements Serializable {

    public static DireccionPaciente dirreccionPaciente;
    public static MedicoPaciente medico;
    public static TrabajoPaciente trabajoPaciente;
    public static Paciente paciente;
    public static String profe;

    @PostConstruct
    protected void init() {
        paciente.setSexo("M");
        paciente.setEstadoSalud("Bueno");
    }
    
    public BeanDatosPersonales() {
        dirreccionPaciente = new DireccionPaciente();
        medico = new MedicoPaciente();
        profe = new String();
        trabajoPaciente = new TrabajoPaciente();
        paciente = new Paciente();
    }

    public String getProfe() {
        return profe;
    }

    public void setProfe(String profe) {
        this.profe = profe;
    }

    public DireccionPaciente getDirreccionPaciente() {
        return dirreccionPaciente;
    }

    public void setDirreccionPaciente(DireccionPaciente dirreccionPaciente) {
        this.dirreccionPaciente = dirreccionPaciente;
    }

    public MedicoPaciente getMedico() {
        return medico;
    }

    public void setMedico(MedicoPaciente medico) {
        this.medico = medico;
    }

    public TrabajoPaciente getTrabajoPaciente() {
        return trabajoPaciente;
    }

    public void setTrabajoPaciente(TrabajoPaciente trabajoPaciente) {
        this.trabajoPaciente = trabajoPaciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
