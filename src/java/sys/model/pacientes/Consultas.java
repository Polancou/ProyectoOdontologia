/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.model.pacientes;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "consultas")
public class Consultas implements Serializable {
    
    int id,paciente,periodonto,controlPlaca;
    Date fecha;
    
    public Consultas() {
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

    @Column(name = "periodontograma")
    public int getPeriodonto() {
        return periodonto;
    }

    public void setPeriodonto(int periodonto) {
        this.periodonto = periodonto;
    }

    @Column(name = "control_placa")
    public int getControlPlaca() {
        return controlPlaca;
    }

    public void setControlPlaca(int controlPlaca) {
        this.controlPlaca = controlPlaca;
    }

    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
