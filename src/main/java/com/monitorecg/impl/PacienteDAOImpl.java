/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.impl;

import com.monitorecg.dao.impl.PacienteDAO;
import com.monitorecg.hibernate.HibernateUtil;
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
    
}
