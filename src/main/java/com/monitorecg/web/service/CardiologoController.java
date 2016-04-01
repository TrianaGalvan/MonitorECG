/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.impl.CardiologoDAOImpl;
import com.monitorecg.impl.CardiologoDAOImpl;
import static com.monitorecg.web.service.JsonUtil.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import static spark.Spark.*;
/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class CardiologoController extends JsonController{
     
    
    public CardiologoController(final CardiologoDAOImpl cardiologoService) {

        get("/cardiologos",(req,res)->cardiologoService.obtenerCardiologos(),jsonutil);
        
        get("/cardiologo/:id",(req, res) -> {
            String id = req.params(":id");
            Cardiologo c = new Cardiologo();
            c.setIdCardiologo(Integer.parseInt(id));
            Cardiologo cardiologo = cardiologoService.obtenerCardiologo(c);
            if (cardiologo != null) {
              
              return cardiologo;
            }
            res.body("Cardiologo con id: "+id);
            res.status(400);
            //res.type("application/json");
            return "No se encontro el cardiologo con el id: "+id;
          }, jsonutil);
        
        post("/cardiologo","application/json",(req,res)-> {
            String body = req.body();
            Gson gson = jsonutil.getGson();
            Cardiologo c = gson.fromJson(body, Cardiologo.class);
            boolean respuesta = cardiologoService.agregarCardiologo(c);
            if(respuesta){
                return c;
            }else{
                res.body("El cardiologo no se agregó");
                return null;
            }
            
        },jsonutil);
        
        delete("/cardiologo/:id",(req,res)->{
            String id = req.params("id");
            Cardiologo c = new Cardiologo();
            c.setIdCardiologo(Integer.parseInt(id));
            boolean resp = cardiologoService.eliminarCardiologo(c);
            if(resp){
                return "ok";
            }
            else{
                return "error";
            }
        },jsonutil);
        
        put("/cardiologo/:id","application/json" ,(req,res)->{
            String body = req.body();
            String id = req.params("id");
            Gson gson = jsonutil.getGson();
            Cardiologo c = gson.fromJson(body, Cardiologo.class);
            
            c.setIdCardiologo(Integer.parseInt(id));
            boolean resp = cardiologoService.modificarCardiologo(c);
            if(resp){
                return "ok";
            }else{
                return "error";
            }
        },jsonutil);
        
     }
     
    
     
}
