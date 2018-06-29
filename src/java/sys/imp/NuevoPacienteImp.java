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
import sys.bean.Expi.BeanControlPlaca;
import sys.bean.Expi.BeanCuestionario;
import static sys.bean.Expi.BeanCuestionario.alergias;
import static sys.bean.Expi.BeanCuestionario.selectedConsoles;
import sys.bean.Expi.BeanDatosPersonales;
import sys.bean.Expi.BeanExaOrofacial;
import sys.bean.Expi.BeanPeri;
import sys.dao.daoNuevoPaciente;
import sys.model.pacientes.AnalisisOclusion;
import sys.model.pacientes.Atm;
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
    public String insertarNuevoPaciente() {
        String inserto = "";
        Session session = null;
        try {
            //primera pestaÃ±a del paciente
            DireccionPaciente direccion = BeanDatosPersonales.dirreccionPaciente;
            MedicoPaciente medico = BeanDatosPersonales.medico;
            TrabajoPaciente trabajo = BeanDatosPersonales.trabajoPaciente;
            Paciente paciente = BeanDatosPersonales.paciente;
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(direccion);
            session.save(medico);
            session.save(trabajo);
            paciente.setDireccionPaciente(direccion.getId());
            paciente.setMedicoPaciente(medico.getId());
            paciente.setTrabajoPaciente(trabajo.getId());
            paciente.setFechaRegistro(new Date());
            session.save(paciente);
            
            //segunda pestaÃ±a del cuestionario
            PreguntasPaciente preguntas = BeanCuestionario.preguntasPaciente;
            preguntas.setPadecimientos(Arrays.toString(selectedConsoles));
            preguntas.setAlergiasMedicamentos(Arrays.toString(alergias));
            preguntas.setPaciente(paciente.getId());
            session.save(preguntas);
            
            //tercera pestaÃ±a de examenes oral y orofacial
            ExamenOral examenoral= BeanExaOrofacial.examenOral;
            ExamenOrofacial examen = BeanExaOrofacial.examenOrofacial;
            Atm atm = BeanExaOrofacial.atm;
            AnalisisOclusion analisis = BeanExaOrofacial.analisisOclusion;
            HallazgosRadiograficos hallazgos = BeanExaOrofacial.hallazgosRadiograficos;
            session.save(examenoral);
            session.save(atm);
            session.save(analisis);
            session.save(hallazgos);
            examen.setAtm(atm.getId());
            examen.setAnalisisOclusion(analisis.getId());
            examen.setHallazgosRadiograficos(hallazgos.getId());
            examen.setExamenOral(examenoral.getId());
            examen.setPaciente(paciente.getId());
            examen.setFecha(new Date());
            session.save(examen);
            
            //insertar la placa dentobacteriana
            ControlPlaca control = BeanControlPlaca.control;
            control.setEstado("nuevo");
            System.out.println(control.getDientes());
            control.setDientes(control.getDientes());
            control.setPaciente(paciente.getId());
            session.save(control);
            
            
            //insertar tabla odontograma
            Periodontograma periodonto = BeanPeri.periodonto;
            periodonto.setEstado("nuevo");
            periodonto.setPaciente(paciente.getId());
            periodonto.setDientes(periodonto.getDientes());
            session.save(periodonto);
            
            
            
            session.getTransaction().commit();
            
            
            inserto = paciente.getNombre();
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
