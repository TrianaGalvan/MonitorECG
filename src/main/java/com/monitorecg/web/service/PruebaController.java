/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.google.gson.Gson;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.impl.PruebaDAOImpl;
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
        get("/pruebas",(req,res)->pdi.obtenerPruebas(),jsonutil);
        
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
          }, jsonutil);
        
        post("/prueba","application/json",(req,res)-> {
            String body = req.body();
            Gson gson = jsonutil.getGson();
            Prueba p = gson.fromJson(body,Prueba.class);
            boolean respuesta =pdi.agregarPrueba(p);
            if(respuesta){
                return p;
            }else{
                res.body("La prueba no se agregó");
                return null;
            }
            
        },jsonutil);
        
        delete("/prueba/:id",(req,res)->{
            String id = req.params("id");
            Prueba p = new Prueba();
            p.setIdPrueba(Integer.parseInt(id));
            boolean resp = pdi.eliminarPrueba(p);
            if(resp){
                return "ok";
            }
            else{
                return "error";
            }
        },jsonutil);
        
        put("/prueba/:id","application/json" ,(req,res)->{
            String body = req.body();
            String id = req.params("id");
            Gson gson = jsonutil.getGson();
            Prueba p = gson.fromJson(body,Prueba.class);
            
            p.setIdPrueba(Integer.parseInt(id));
            boolean resp = pdi.modificarPrueba(p);
            if(resp){
                return "ok";
            }else{
                return "error";
            }
        },jsonutil);
    }
    
}
