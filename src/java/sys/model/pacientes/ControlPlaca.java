/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.model.pacientes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ramses Mtnz Santiago
 */
@Entity
@Table(name = "control_placa")
public class ControlPlaca implements Serializable {
    
    private int id,paciente;
    private String estado, numDientes,numSuperficies,superficiesPlacas,extensionPlaca,dientes;

    public ControlPlaca() {
    }

    public ControlPlaca(int paciente, String estado, String numDientes, String numSuperficies, String superficiesPlacas, String extensionPlaca, String dientes) {
        this.paciente = paciente;
        this.estado = estado;
        this.numDientes = numDientes;
        this.numSuperficies = numSuperficies;
        this.superficiesPlacas = superficiesPlacas;
        this.extensionPlaca = extensionPlaca;
        this.dientes = dientes;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "paciente")
    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "num_dientes")
    public String getNumDientes() {
        return numDientes;
    }

    public void setNumDientes(String numDientes) {
        this.numDientes = numDientes;
    }

    @Column(name = "num_superficies")
    public String getNumSuperficies() {
        return numSuperficies;
    }

    public void setNumSuperficies(String numSuperficies) {
        this.numSuperficies = numSuperficies;
    }

    @Column(name = "superficies_placa")
    public String getSuperficiesPlacas() {
        return superficiesPlacas;
    }

    public void setSuperficiesPlacas(String superficiesPlacas) {
        this.superficiesPlacas = superficiesPlacas;
    }

    @Column(name = "extension_placa")
    public String getExtensionPlaca() {
        return extensionPlaca;
    }

    public void setExtensionPlaca(String extensionPlaca) {
        this.extensionPlaca = extensionPlaca;
    }

    @Column(name = "dientes")
    public String getDientes() {
        return dientes;
    }

    public void setDientes(String dientes) {
        this.dientes = dientes;
    }
    
    
    
}
