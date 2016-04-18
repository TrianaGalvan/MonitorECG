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
    public boolean eliminarPaciente(Paciente p) {
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
    public boolean modificarPaciente(Paciente p) {
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
    public Paciente obtenerPacientePorCorreo(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Paciente paciente = null; 
        
        try{
            t.begin();
            Query q = s.createQuery("From Paciente WHERE correo = :correo");
            q.setParameter("correo", p.getCorreo());
            paciente = (Paciente) q.uniqueResult();
            t.commit();            
        }catch(HibernateException he){
            paciente = null;
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        
        return paciente;
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
            Query q = s.createQuery("From Paciente WHERE nombre = :nombre and apellidoPaterno = :ap and apellidoMaterno = :am");
            q.setParameter("nombre", p.getNombre());
            q.setParameter("ap", p.getApellidoPaterno());
            q.setParameter("am", p.getApellidoMaterno());
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

    @Override
    public Paciente loginPaciente(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Paciente paciente = null; 
        try{
            t.begin();
            Query q =  s.createQuery("from Paciente p " +
                                    "where p.correo = :correo and p.contrasena = :pass");
            q.setParameter("correo",p.getCorreo());
            q.setParameter("pass",p.getContrasena());
            paciente = (Paciente) q.uniqueResult();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return paciente;
    }

    @Override
    public Paciente verificarCorreo(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        Paciente paciente = null;
        try{
            t.begin();
            Query q = s.createQuery("From Paciente WHERE correo = :correo");
            q.setParameter("correo", p.getCorreo());
            paciente = (Paciente) q.uniqueResult();
            t.commit();
        }catch(HibernateException he){
            he.printStackTrace();
            if(t !=null){
                t.rollback();
            }
        }
        return paciente;
    }

    @Override
    public boolean actualizarDatosPersonales(Paciente p) {
        Session s;
        s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        boolean resp = true;
        try{
            t.begin();
            String actualizar_datos_medicos = "update Paciente p set p.nombre = :nom,p.apellidoPaterno = :app, "
                    + "p.apellidoMaterno = :apm , p.sexo = :s, p.edad =:edad, p.curp =:curp, "
                    +"p.correo = :correo , p.telefono = :tel where p.idPaciente = :id";
            Query q = s.createQuery(actualizar_datos_medicos);
            q.setParameter("nom", p.getNombre());
            q.setParameter("app", p.getApellidoPaterno());
            q.setParameter("apm", p.getApellidoMaterno());
            q.setParameter("s",p.getSexo());
            q.setParameter("edad", p.getEdad());
            q.setParameter("curp", p.getCurp());
            q.setParameter("correo", p.getCorreo());
            q.setParameter("tel", p.getTelefono());
            q.setParameter("id", p.getIdPaciente());
            System.out.println(q.toString());
            q.executeUpdate();
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
    
    
    
}
