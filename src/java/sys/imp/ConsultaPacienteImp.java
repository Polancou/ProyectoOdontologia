/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.bean.Expi.BeanConsulta;
import sys.bean.Expi.BeanControlPlaca;
import sys.bean.Expi.BeanPeri;
import sys.dao.daoConsultaPaciente;
import sys.model.pacientes.Consultas;
import sys.model.pacientes.ControlPlaca;
import sys.model.pacientes.Paciente;
import sys.model.pacientes.Periodontograma;
import sys.util.HibernateUtil;

/**
 *
 * @author Ramses Mtnz Santiago
 */
public class ConsultaPacienteImp implements daoConsultaPaciente {

    @Override
    public List<Paciente> verFoliosPaciente(Paciente paciente) {
        List<Paciente> listPacientes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Paciente as p where p.folio= '" + paciente.getFolio() + "'";
        try {
            listPacientes = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listPacientes;
    }

    @Override
    public List<Paciente> verNombresPaciente(Paciente paciente) {
        List<Paciente> listPacientes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Paciente as p where p.nombre= '" + paciente.getNombre() + "'";
        try {
            listPacientes = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        System.out.println(listPacientes.size());
        return listPacientes;
    }

    @Override
    public boolean insertaConsulta() {
        boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            ControlPlaca control = BeanControlPlaca.control;
            int idPaciente = BeanConsulta.folio;
            control.setEstado("subsecuente");
            System.out.println(control.getDientes());
            control.setDientes(control.getDientes());
            control.setPaciente(idPaciente);
            session.save(control);

            Periodontograma periodonto = BeanPeri.periodonto;
            periodonto.setEstado("subsecuente");
            periodonto.setPaciente(idPaciente);
            periodonto.setDientes(periodonto.getDientes());
            session.save(periodonto);

            Consultas consultas = new Consultas();
            consultas.setControlPlaca(control.getId());
            consultas.setFecha(new Date());
            consultas.setPaciente(idPaciente);
            consultas.setPeriodonto(periodonto.getId());
            session.save(consultas);

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

    @Override
    public List<Consultas> verConsultas() {
        List<Consultas> listaConsultas = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int idPaciente = BeanConsulta.folio;
        String hql = "from Consultas where paciente= " + idPaciente;
        try {
            listaConsultas = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listaConsultas;
    }

    @Override
    public String verPlaca() {
        int id = BeanConsulta.controlPlaca;
        String cadena = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            ControlPlaca control = (ControlPlaca) session.get(ControlPlaca.class, id);
            cadena = control.getDientes();
            BeanControlPlaca.control.setNumDientes(control.getNumDientes());
            BeanControlPlaca.control.setNumSuperficies(control.getNumSuperficies());
            BeanControlPlaca.control.setSuperficiesPlacas(control.getSuperficiesPlacas());
            BeanControlPlaca.control.setExtensionPlaca(control.getExtensionPlaca());
            System.out.println(cadena);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally {

            if (session != null) {
                session.close();
            }
        }
        return cadena;

    }

    @Override
    public String verPeriodontograma() {
        int id = BeanConsulta.periodontograma;
        String cadena = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Periodontograma periodonto = (Periodontograma) session.get(Periodontograma.class, id);
            cadena = periodonto.getDientes();
            System.out.println(cadena);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cadena;
    }
}
