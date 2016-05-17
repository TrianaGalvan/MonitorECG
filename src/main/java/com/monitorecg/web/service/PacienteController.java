/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.google.gson.Gson;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.impl.PacienteDAOImpl;
import com.monitorecg.mail.Mail;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class PacienteController extends JsonController{

    public PacienteController(final PacienteDAOImpl pdi) {
        get("/pacientes",(req,res)->pdi.obtenerPacientes(),jsonutilpaciente);
        
        get("/paciente/:id",(req, res) -> {
            String id = req.params(":id");
            Paciente p = new Paciente();
            p.setIdPaciente(Integer.parseInt(id));
            Paciente paciente = pdi.obtenerPaciente(p);
            if (paciente != null) {
              return paciente;
            }
            res.body("Paciente con id: "+id);
            res.status(400);
            //res.type("application/json");
            return "No se encontro el paciente con el id: "+id;
          }, jsonutilpaciente);
        
        post("/paciente/login",(req,res)->{
            String correo = req.raw().getParameter("correo");
            String pass = req.raw().getParameter("pass");
            String token  = req.raw().getParameter("token");
            Paciente p = new Paciente();
            p.setCorreo(correo);
            p.setContrasena(pass);
            p.setToken(token);
            p = pdi.loginPaciente(p);
       
            return p;
        },jsonutilpaciente);
        
        post("/paciente","application/json",(req,res)-> {
            String body = req.body();
            Gson gson = jsonutil.getGson();
            Paciente p = gson.fromJson(body,Paciente.class);
            boolean respuesta =pdi.agregarPaciente(p);
            if(respuesta){
                return p;
            }else{
                res.body("El paciente no se agregó");
                return null;
            }
            
        },jsonutil);
        
        delete("/paciente/:id",(req,res)->{
            String id = req.params("id");
            Paciente p = new Paciente();
            p.setIdPaciente(Integer.parseInt(id));
            boolean resp = pdi.eliminarPaciente(p);
            if(resp){
                return "ok";
            }
            else{
                return "error";
            }
        },jsonutil);
        
        put("/paciente/:id","application/json" ,(req,res)->{
            String body = req.body();
            String id = req.params("id");
            Gson gson = jsonutil.getGson();
            Paciente p = gson.fromJson(body,Paciente.class);
            p.setIdPaciente(Integer.parseInt(id));
            boolean resp = pdi.modificarPaciente(p);
            if(resp){
                return "ok";
            }else{
                return "error";
            }
        },jsonutil);
        
        //ACTUALIZAR DATOS PERSONALES 
        put("/paciente/dp/:id","application/json" ,(req,res)->{
            String body = req.body();
            String id = req.params("id");
            Gson gson = jsonutil.getGson();
            Paciente p = gson.fromJson(body,Paciente.class);
            p.setIdPaciente(Integer.parseInt(id));
            boolean resp = pdi.actualizarDatosPersonales(p);
            if(resp){
                return "ok";
            }else{
                return "error";
            }
        },jsonutil);
        
        
        //MODIFICAR EL METODO MODIFICAR PARA QUE SOLO ACTUALIZE LOS DATOS DEL PACIENTE NO EL ID DEL CARDIOLOGO 
        /*put("/paciente/:id","application/json" ,(req,res)->{
            String body = req.body();
            String id = req.params("id");
            Gson gson = jsonutil.getGson();
            Paciente p = gson.fromJson(body,Paciente.class);
            p.setIdPaciente(Integer.parseInt(id));
            boolean resp = pdi.modificarPaciente(p);
            if(resp){
                return "ok";
            }else{
                return "error";
            }
        },jsonutil);*/
        
        
        post("/paciente/verificarCorreo", (req,res)->{
            String correo = req.raw().getParameter("correo");
            Paciente p = new Paciente();
            p.setCorreo(correo);
            p = (Paciente) pdi.verificarCorreo(p);
            if(p != null){
                return true;
            }else{
                return false;
            }
        },jsonutil);
    }
    
}
