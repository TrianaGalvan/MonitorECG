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
    public void eliminarCardiologo(Cardiologo p) {
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
    public void modificarCardiologo(Cardiologo p) {
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
    
    
    
    public static void main(String[] args) {
        //agregar
        /*Cardiologo p = new Cardiologo("paletas", 12.50);
        CardiologoDAOImpl pimpl = new CardiologoDAOImpl(); 
        pimpl.agregarCardiologo(p);*/
        
        //modificar
       /* System.out.println("------ Modificar producto ---------");
        Cardiologo p = new Cardiologo(11,"paletas",30.50);
        CardiologoDAOImpl pimplm = new CardiologoDAOImpl(); 
        pimplm.modificarCardiologo(p);
        
        //eliminar
        System.out.println("------ Eliminar producto ---------");
        Cardiologo pe = new Cardiologo();
        pe.setIdCardiologo(10);
        pe.setNombre("Ricolino");
        CardiologoDAOImpl pimple = new CardiologoDAOImpl(); 
        pimple.eliminarCardiologo(pe);
        */
        //leer un producto
        /*System.out.println("------ Leer producto ---------");
        CardiologoDAOImpl imp = new CardiologoDAOImpl(); 
        Cardiologo p = new Cardiologo();
        p.setIdCardiologo(8);
        p.setNombre("maruchan");
        Cardiologo producto = imp.obtenerCardiologo(p);
        System.out.println(producto.toString());*/
        
        //leer muchos productos 
        /*CardiologoDAOImpl imp = new CardiologoDAOImpl(); 
        System.out.println("------ Leer productos ---------");
        List productos = imp.obtenerCardiologos();
        for (Object val : productos) {
            System.out.println(val.toString());
        }*/
        
    }


    @Override
    public Cardiologo loginCardiologo(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null; 
        Cardiologo cardiologo = null; 
        try{
            t.begin();
            Query q =  s.createQuery("FROM Cardiologo c WHERE c.correo = :user and c.contrasena = :pass");
            q.setParameter("user",c.getCorreo());
            q.setParameter("pass",c.getContrasena());
            t.commit();
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
    public void cambiarContrasena(Cardiologo c) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Cardiologo cardiologo = null; 
        try{
            t.begin();
            Query q =  s.createQuery("UPDATE Cardiologo c SET c.contrasena = :contrasena WHERE c.correo = :correo");
            q.setParameter("correo",c.getCorreo());
            q.setParameter("contrasena",c.getContrasena());
            q.executeUpdate();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
    }
    
    
}
