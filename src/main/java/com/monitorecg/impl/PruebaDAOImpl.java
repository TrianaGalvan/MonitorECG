/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.impl;

import com.monitorecg.dao.impl.PruebaDAO;
import com.monitorecg.hibernate.HibernateUtil;
import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Prueba;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class PruebaDAOImpl implements PruebaDAO{

   @Override
    public boolean eliminarPrueba(Prueba p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean resp = false;
        try{
            t.begin();
            s.delete(p);
            resp = true;
            t.commit();
        }catch(HibernateException he){
            resp = false;
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return resp;
    }

    @Override
    public boolean modificarPrueba(Prueba p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean resp = false;
        try{
            t.begin();
            s.saveOrUpdate(p);
            resp = true;
            t.commit();
        }catch(HibernateException he){
            resp = false;
            he.printStackTrace();
            if( t !=null){
                t.rollback();
            }
        }
        return resp;
    }

    @Override
    public boolean agregarPrueba(Prueba p) {
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
    public List<Prueba> obtenerPruebas() {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        try{
            t.begin();
            Query q = s.createQuery("from Prueba");
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
    public Prueba obtenerPrueba(Prueba p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        Prueba pc = null; 
        try{
            t.begin();
            pc = (Prueba) s.get(Prueba.class,p.getIdPrueba());
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
