/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.google.gson.Gson;
import com.monitorecg.dropbox.UtilDropbox;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Reporte;
import com.monitorecg.impl.PacienteDAOImpl;
import com.monitorecg.impl.PruebaDAOImpl;
import com.monitorecg.impl.ReporteDAOImpl;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class PruebaController extends JsonController{

    public PruebaController(final PruebaDAOImpl pdi) {
        get("/pruebas",(req,res)->pdi.obtenerPruebas(),jsonutilprueba);
        
        get("/prueba/correo",(req, res) -> {
            String correo = req.queryParams("email");
            List<Prueba> listaPruebasEncontradas = null;
            //obtener el paciente 
            Paciente paciente = new Paciente();
            paciente.setCorreo(correo);
            PacienteDAOImpl pacientedaoimpl; 
            pacientedaoimpl = new PacienteDAOImpl();
            paciente = pacientedaoimpl.obtenerPacientePorCorreo(paciente);
            if(paciente != null){
                Set<Prueba> pruebas = paciente.getPruebas();
            
                Iterator<Prueba> iterador = pruebas.iterator();

                Prueba p = new Prueba();

                listaPruebasEncontradas = new ArrayList<Prueba>();

                while (iterador.hasNext()) {                
                    Prueba pr = iterador.next();
                    p.setIdPrueba(pr.getIdPrueba());
                    Prueba prueba = pdi.obtenerPrueba(p);
                    listaPruebasEncontradas.add(prueba);
                }
                return listaPruebasEncontradas;
            }
            
            return "No hay pruebas o el paciente no existe";
          }, jsonutilprueba);
        
        get("/prueba/:id",(req, res) -> {
            String id = req.params(":id");
            
            Prueba p = new Prueba();
            p.setIdPrueba(Integer.parseInt(id));
            Prueba prueba = pdi.obtenerPrueba(p);
            if (prueba != null) {
              return prueba;
            }
            res.body("Prueba con id: "+id);
            res.status(400);
            //res.type("application/json");
            return "No se encontro el prueba con el id: "+id;
          }, jsonutilprueba);     
        
        post("/prueba","application/json",(req,res)-> {
            
            MultipartConfigElement multiPartConfigElement = new MultipartConfigElement("/tmp");
            req.raw().setAttribute("org.eclipse.multipartConfig", multiPartConfigElement);
            try {
                Part file = req.raw().getPart("filePrueba");
                String name = getFileName(file);
                String tittleFormat = name.substring(1, name.length()-1);
                generarArchivo(file,tittleFormat);
                //subirlo al dropbox 
                UtilDropbox dropbox = new UtilDropbox();
                dropbox.uploadToDropbox("/tmp/"+tittleFormat);
            } catch (IOException ex) {
                Logger.getLogger(PruebaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServletException ex) {
                Logger.getLogger(PruebaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DbxException ex) {
                Logger.getLogger(PruebaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Se creo el archivo en tmp");
            
            String body = req.raw().getParameter("prueba");
            body = body.substring(1,body.length()-1);
            Gson gson = jsonutilprueba.getGson();
            
            Prueba p = gson.fromJson(body,Prueba.class);
            boolean respuesta =pdi.agregarPrueba(p);
            if(respuesta){
                return p;
            }else{
                res.body("La prueba no se agregó");
                return null;
            }
            
        },jsonutilprueba);
        
        delete("/prueba/:id",(req,res)->{
            String id = req.params("id");
            Prueba p = new Prueba();
            
            p.setIdPrueba(Integer.parseInt(id));
            p = pdi.obtenerPrueba(p);
            Reporte reporte = p.getReporte();
            boolean resp = pdi.eliminarPrueba(p);
            //eliminar reportes 
            reporte.getIdReporte();
            ReporteDAOImpl rdi = new ReporteDAOImpl();
            rdi.eliminarReporte(reporte);
            
            //eliminar los reportes que tengas asociada la prueba 
            if(resp){
                return "ok";
            }
            else{
                return "error";
            }
        },jsonutilprueba);
        
        put("/prueba/:id","application/json" ,(req,res)->{
            String body = req.body();
            String id = req.params("id");
            Gson gson = jsonutilprueba.getGson();
            Prueba p = gson.fromJson(body,Prueba.class);
            
            p.setIdPrueba(Integer.parseInt(id));
            boolean resp = pdi.modificarPrueba(p);
            if(resp){
                return "ok";
            }else{
                return "error";
            }
        },jsonutilprueba);
    }
    
    public void generarArchivo(Part part,String fileName){
        OutputStream out = null; 
        
        InputStream is = null; 
        try {                
            if(part != null ){
                is = part.getInputStream();
            }
            out = new FileOutputStream("/tmp/"+fileName);
            int read = 0; 
            final  byte[] bytes = new byte[1024];
            while ((read = is.read(bytes)) != -1) {                    
                out.write(bytes,0,read);
            }

        } catch (IOException ex) {
            Logger.getLogger(PruebaController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(is != null && out != null){
                try {
                    out.close();
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(PruebaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }
    
    public String getFileName(final  Part part){
        final  String partHeader = part.getHeader("content-disposition");
        for(String val: part.getHeader("content-disposition").split(";")){
            if(val.trim().startsWith("filename")){
                return val.substring(val.indexOf("=")+1).trim().replace("'\'","");
            }
        }
        return null;
    }
}
