/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.impl;

import com.monitorecg.dao.impl.PacienteDAO;
import com.monitorecg.hibernate.HibernateUtil;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Paciente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class PacienteDAOImpl implements PacienteDAO{

    @Override
    public void eliminarPaciente(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try{
            t.begin();
            s.delete(p);
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
    }

    @Override
    public void modificarPaciente(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try{
            t.begin();
            s.saveOrUpdate(p);
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if( t !=null){
                t.rollback();
            }
        }
    }

    @Override
    public boolean agregarPaciente(Paciente p) {
        Session s;
        boolean r; 
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try{
            t.begin();
            s.save(p);
            t.commit();
            r = true; 
        }catch(HibernateException he){
            he.printStackTrace();
            if( t != null){
                t.rollback();
            }
            r = false;
        }
        return r;
    }

    @Override
    public List<Paciente> obtenerPacientes() {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        try{
            t.begin();
            Query q = s.createQuery("from Paciente");
            resultados = q.list();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return resultados;
    }

    @Override
    public Paciente obtenerPaciente(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        Paciente pc = null; 
        try{
            t.begin();
            pc = (Paciente) s.get(Paciente.class,p.getIdPaciente());
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return pc;
    }

    @Override
    public List<Paciente> obtenerPacientePorCorreo(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List<Paciente> resultados = null; 
        
        try{
            t.begin();
            Query q = s.createQuery("From Paciente WHERE correo = :correo");
            q.setParameter("correo", p.getCorreo());
            resultados = q.list();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return resultados;
    }

    @Override
    public List<Paciente> obtenerPacientePorCURP(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List<Paciente> resultados = null; 
        
        try{
            t.begin();
            Query q = s.createQuery("From Paciente WHERE curp = :curp");
            q.setParameter("curp", p.getCurp());
            resultados = q.list();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return resultados;
    }

    @Override
    public List<Paciente> obtenerPacientePorNombre(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List<Paciente> resultados = null; 
        
        try{
            t.begin();
            Query q = s.createQuery("From Paciente WHERE nombre like :nombre");
            q.setParameter("nombre", p.getNombre());
            resultados = q.list();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return resultados;
    }

    @Override
    public List<Object[]> obtenerTablaPruebas(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean existencias = false; 
        List<Object[]> objects;
        try{
            t.begin();
            Query q =  s.createQuery("select p.nombre as nombre, pr.fecha as fecha ,r.estatus as estatus,p.apellidoPaterno,p.apellidoMaterno,p.idPaciente,pr.idPrueba,r.idReporte,pr.hora " +
                                    "from Paciente p " +
                                    "inner join p.pruebas pr " +
                                    "inner join pr.reporte r " +
                                    "where p.idPaciente = :id");
            q.setParameter("id",p.getIdPaciente());
            objects = q.list();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
            objects = null; 
        }
        return objects;
    }
    
}
