/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
        get("/users",(req,res)->cardiologoService.obtenerCardiologos(),jsonutil);
        get("/users/:id","application/json",(req, res) -> {
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
     }
     
    
     
}
