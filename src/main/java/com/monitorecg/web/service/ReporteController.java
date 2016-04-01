/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.google.gson.Gson;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Reporte;
import com.monitorecg.impl.ReporteDAOImpl;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class ReporteController extends JsonController{

    public ReporteController(final ReporteDAOImpl pdi) {
        get("/reportes",(req,res)->pdi.obtenerReportes(),jsonutilreporte);
        
        get("/reporte/:id",(req, res) -> {
            String id = req.params(":id");
            Reporte p = new Reporte();
            p.setIdReporte(Integer.parseInt(id));
            Reporte reporte = pdi.obtenerReporte(p);
            if (reporte != null) {
              return reporte;
            }
            res.body("Reporte con id: "+id);
            res.status(400);
            //res.type("application/json");
            return "No se encontro el reporte con el id: "+id;
          }, jsonutilreporte);
        
        post("/reporte","application/json",(req,res)-> {
            String body = req.body();
            Gson gson = jsonutil.getGson();
            Reporte p = gson.fromJson(body,Reporte.class);
            boolean respuesta =pdi.agregarReporte(p);
            if(respuesta){
                return p;
            }else{
                res.body("La reporte no se agregó");
                return null;
            }
            
        },jsonutil);
        
        delete("/reporte/:id",(req,res)->{
            String id = req.params("id");
            Reporte p = new Reporte();
            p.setIdReporte(Integer.parseInt(id));
            boolean resp = pdi.eliminarReporte(p);
            if(resp){
                return "ok";
            }
            else{
                return "error";
            }
        },jsonutil);
        
        put("/reporte/:id","application/json" ,(req,res)->{
            String body = req.body();
            String id = req.params("id");
            Gson gson = jsonutil.getGson();
            Reporte reporte = gson.fromJson(body,Reporte.class);
            reporte.setIdReporte(Integer.parseInt(id));
            boolean resp = pdi.modificarReporte(reporte);
            if(resp){
                return "ok";
            }else{
                return "error";
            }
        },jsonutil);
    }
    
}
