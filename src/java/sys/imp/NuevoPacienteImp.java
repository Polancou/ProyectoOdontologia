/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import sys.bean.Bita.beanReportes;
import sys.dao.daoNuevoPaciente;
import sys.model.pacientes.AnalisisOclusion;
import sys.model.pacientes.Atm;
import sys.model.pacientes.Consultas;
import sys.model.pacientes.ControlPlaca;
import sys.model.pacientes.DireccionPaciente;
import sys.model.pacientes.ExamenOral;
import sys.model.pacientes.ExamenOrofacial;
import sys.model.pacientes.HallazgosRadiograficos;
import sys.model.pacientes.MedicoPaciente;
import sys.model.pacientes.Paciente;
import sys.model.pacientes.Periodontograma;
import sys.model.pacientes.PreguntasPaciente;
import sys.model.pacientes.TrabajoPaciente;
import sys.util.HibernateUtil;

/**
 *
 * @author Ramses Mtnz Santiago
 */
public class NuevoPacienteImp implements daoNuevoPaciente {

    @Override
    public boolean insertarNuevoPaciente(DireccionPaciente direccion,MedicoPaciente medico,TrabajoPaciente trabajo, Paciente paciente, ControlPlaca control,Periodontograma periodonto,ExamenOral examenoral, ExamenOrofacial examen,Atm atm,AnalisisOclusion analisis,HallazgosRadiograficos hallazgos,PreguntasPaciente preguntas) {
        boolean inserto = false;
        Session session = null;
        try {
            //primera pestaña del paciente
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(direccion);
            session.save(medico);
            session.save(trabajo);
            paciente.setDireccionPaciente(direccion);
            paciente.setMedicoPaciente(medico);
            paciente.setTrabajoPaciente(trabajo);
            paciente.setFechaRegistro(new Date());
            session.save(paciente);
            
            //segunda pestaña del cuestionario
            preguntas.setAlergiasMedicamentos(preguntas.getAlergiasMedicamentos());
            preguntas.setPadecimientos(preguntas.getPadecimientos());
            preguntas.setPaciente(paciente);
            session.save(preguntas);
            
            //tercera pestaña de examenes oral y orofacial
            session.save(examenoral);
            session.save(atm);
            session.save(analisis);
            session.save(hallazgos);
            examen.setAtm(atm);
            examen.setAnalisisOclusion(analisis);
            examen.setHallazgosRadiograficos(hallazgos);
            examen.setExamenOral(examenoral);
            examen.setPaciente(paciente);
            examen.setFecha(new Date());
            session.save(examen);
            
            //insertar la placa dentobacteriana
            control.setEstado("nuevo");
            System.out.println(control.getDientes());
            control.setDientes(control.getDientes());
            control.setPaciente(paciente);
            session.save(control);
            
            
            //insertar tabla odontograma
            periodonto.setEstado("nuevo");
            periodonto.setPaciente(paciente);
            periodonto.setDientes(periodonto.getDientes());
            session.save(periodonto);
            
            Consultas primera = new Consultas();
            primera.setFolio(paciente.getFolio());
            primera.setPaciente(paciente);
            primera.setControlPlaca(control);
            primera.setPeriodontograma(periodonto);
            primera.setFecha(new Date());
            session.save(primera);
            
            session.getTransaction().commit();
            inserto = true;
            
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return inserto;
    
    
    }


}
