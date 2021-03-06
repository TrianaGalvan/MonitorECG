/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.impl;

import com.monitorecg.dao.CardiologoDAO;
import com.monitorecg.hibernate.HibernateUtil;
import com.monitorecg.hibernate.entities.Cardiologo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class CardiologoDAOImpl implements CardiologoDAO{

    @Override
    public boolean eliminarCardiologo(Cardiologo p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean respuesta = false;
        try{
            t.begin();
            s.delete(p);
            respuesta = true; 
            t.commit();
        }catch(HibernateException he){
            respuesta = false;
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return respuesta;
    }

    @Override
    public boolean modificarCardiologo(Cardiologo p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean modificacion = false; 
        try{
            t.begin();
            s.saveOrUpdate(p);
            modificacion = true; 
            t.commit();
        }catch(HibernateException he){
            modificacion = false;
            he.printStackTrace();
            if( t !=null){
                t.rollback();
            }
        }
        return modificacion;
    }

    @Override
    public boolean agregarCardiologo(Cardiologo p) {
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
    public List<Cardiologo> obtenerCardiologos() {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        try{
            t.begin();
            Query q = s.createQuery("from Cardiologo");
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
    public Cardiologo obtenerCardiologo(Cardiologo p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        Cardiologo pc = null; 
        try{
            t.begin();
            pc = (Cardiologo) s.get(Cardiologo.class,p.getIdCardiologo());
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return pc;
    }
    
    
    
    /** Mis metodos**/
    @Override
    public Cardiologo loginCardiologo(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        Cardiologo cardiologo = null; 
        try{
            t.begin();
            Query q =  s.createQuery("FROM Cardiologo WHERE correo = :user and contrasena = :pass");
            q.setParameter("user",c.getCorreo());
            q.setParameter("pass",c.getContrasena());
            q.setMaxResults(1);
            cardiologo = (Cardiologo) q.uniqueResult();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return cardiologo;
    }

    @Override
    public Cardiologo buscarCardiologoPorCorreo(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Cardiologo cardiologo = null; 
        try{
            t.begin();
            Query q =  s.createQuery("FROM Cardiologo c WHERE c.correo = :user");
            q.setMaxResults(1);
            q.setParameter("user",c.getCorreo());
            cardiologo = (Cardiologo) q.uniqueResult();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return cardiologo;
    }

    @Override
    public boolean cambiarContrasena(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Cardiologo cardiologo = null; 
        boolean cambio = false; 
        try{
            t.begin();
            Query q =  s.createQuery("UPDATE Cardiologo SET contrasena = :contrasena WHERE correo = :correo");
            q.setParameter("correo",c.getCorreo());
            q.setParameter("contrasena",c.getContrasena());
            q.executeUpdate();
            t.commit();
            System.out.println(q.toString());
            cambio = true;
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
            cambio = false;
        }
        return cambio;
    }

    @Override
    public Cardiologo buscarCorreo(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Cardiologo cardiologo = null; 
        boolean existencias = false; 
        try{
            t.begin();
            Query q =  s.createQuery("FROM Cardiologo WHERE correo = :email");
            q.setParameter("email",c.getCorreo());
            cardiologo = (Cardiologo) q.uniqueResult();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        if(cardiologo != null){
            existencias = true; 
        }
        return cardiologo;
    }

    @Override
    public List<Object[]> obtenerTablaElectrocardiogramas(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Cardiologo cardiologo = null; 
        boolean existencias = false; 
        List<Object[]> objects;
        try{
            t.begin();
            Query q =  s.createQuery("select p.nombre as nombre, pr.fecha as fecha ,r.estatus as estatus,p.apellidoPaterno,p.apellidoMaterno,p.idPaciente,pr.idPrueba,r.idReporte " +
                                    "from Cardiologo c " +
                                    "inner join c.pacientes p " +
                                    "inner join p.pruebas pr " +
                                    "inner join pr.reporte r "+
                                    "where c.idCardiologo = :id");
            q.setParameter("id",c.getIdCardiologo());
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

    @Override
    public boolean moficarCardiologoSinContrasena(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean modificacion = false; 
        try{
            t.begin();
            Query q = s.createQuery("UPDATE Cardiologo c SET "+
                           "c.nombre = :nom, "+
                           "c.apellidoPaterno = :ap, "+
                           "c.apellidoMaterno = :am, "+
                           "c.edad = :edad, "+
                           "c.cedula = :cedula, "+
                           "c.sexo = :s, "+
                           "c.correo = :correo, "+
                           "c.telefono = :tel, "+
                           "c.instituto = :instituto, "+
                           "c.curp = :curp "+
                           "where idCardiologo = :id");
            q.setParameter("nom",c.getNombre());
            q.setParameter("ap",c.getApellidoPaterno());
            q.setParameter("am",c.getApellidoMaterno());
            q.setParameter("edad",c.getEdad());
            q.setParameter("cedula",c.getCedula());
            q.setParameter("s",c.getSexo());
            q.setParameter("correo",c.getCorreo());
            q.setParameter("tel",c.getTelefono());
            q.setParameter("instituto",c.getInstituto());
            q.setParameter("curp",c.getCurp());
            q.setParameter("id",c.getIdCardiologo());
            q.executeUpdate();
            modificacion = true; 
            t.commit();
        }catch(HibernateException he){
            modificacion = false;
            he.printStackTrace();
            if( t !=null){
                t.rollback();
            }
        }
        return modificacion;
    }

    @Override
    public boolean modificarContrasena(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean modificacion = false; 
        try{
            t.begin();
            Query q = s.createQuery("UPDATE Cardiologo c SET "+
                           "c.contrasena = :pass "+
                           "where idCardiologo = :id");
            q.setParameter("pass",c.getContrasena());
            q.setParameter("id",c.getIdCardiologo());
            q.executeUpdate();
            modificacion = true; 
            t.commit();
        }catch(HibernateException he){
            modificacion = false;
            he.printStackTrace();
            if( t !=null){
                t.rollback();
            }
        }
        return modificacion;
    }

    @Override
    public Long contarPruebasNoRevisadas(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Cardiologo cardiologo = null; 
        boolean existencias = false; 
        Long num = 0L;
        try{
            t.begin();
            Query q =  s.createQuery("select count(*)" +
                                    "from Cardiologo c " +
                                    "inner join c.pacientes p " +
                                    "inner join p.pruebas pr " +
                                    "inner join pr.reporte r "+
                                    "where c.idCardiologo = :id and r.estatus = 2");
            q.setParameter("id",c.getIdCardiologo());
            num  = (Long) q.uniqueResult();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return num;
    }
    
    
 
}
