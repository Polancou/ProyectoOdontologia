/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.pacientes.Consultas;
import sys.model.pacientes.Paciente;

/**
 *
 * @author Ramses Mtnz Santiago
 */
public interface daoConsultaPaciente {
    
    public List<Paciente> verFoliosPaciente (Paciente paciente);
    
    public List<Paciente> verNombresPaciente (Paciente paciente);
    
    public boolean insertaConsulta();
    
    public List <Consultas> verConsultas();
    
    public String verPlaca();
    
    public String verPeriodontograma();
    
}
