/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.impl;

import com.monitorecg.dao.impl.ReporteDAO;
import com.monitorecg.hibernate.HibernateUtil;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Reporte;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class ReporteDAOImpl implements ReporteDAO{
    @Override
    public boolean eliminarReporte(Reporte p) {
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
    public boolean modificarReporte(Reporte p) {
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
    public boolean agregarReporte(Reporte p) {
        Session s;
        boolean r; 
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try{
            t.begin();
            Serializable obj = s.save(p);
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
    public List<Reporte> obtenerReportes() {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        try{
            t.begin();
            Query q = s.createQuery("from Reporte");
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
    public Reporte obtenerReporte(Reporte p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        Reporte pc = null; 
        try{
            t.begin();
            pc = (Reporte) s.get(Reporte.class,p.getIdReporte());
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
    public boolean modificarRecomendaciones(Reporte r) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean actualizacion = false;
        try{
            t.begin();
            Query q =  s.createQuery("UPDATE Reporte SET recomendaciones = :r, estatus = :s WHERE idReporte = :id");
            q.setParameter("r",r.getRecomendaciones());
            q.setParameter("s",r.getEstatus());
            q.setParameter("id",r.getIdReporte());
            q.executeUpdate();
            actualizacion = true; 
            t.commit();
        }catch(HibernateException he){
            actualizacion = false;
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return actualizacion;
    }

    @Override
    public Reporte verificarEstatusReporte(Reporte r) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Reporte reporte = null; 
        try{
            t.begin();
            Query q =  s.createQuery("FROM Reporte where idReporte = :id");
            q.setParameter("id",r.getIdReporte());
            reporte = (Reporte) q.uniqueResult();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return reporte;
    }

    @Override
    public Prueba obtenerIdPacienteFromReporte(Reporte r) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Prueba prueba = null; 
        Object obj;
        int id = 0;
        Date fecha = null;
        
        try{
            t.begin();
            Query q =  s.createQuery("select pr.paciente.idPaciente,pr.fecha FROM Prueba pr inner join "
                    + "pr.reporte "
                    + "where pr.reporte.idReporte = :id");
            q.setParameter("id",r.getIdReporte());
            List<Object[]> rows = q.list();
            if(rows != null){
                for (Object[] row: rows) {
                    id = (int) row[0]; 
                    fecha = (Date) row[1];
                }
                prueba = new Prueba();
                prueba.setFecha(fecha);
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(id);
                prueba.setPaciente(paciente);
            }
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return prueba;
    }
}
