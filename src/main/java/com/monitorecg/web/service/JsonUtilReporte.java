/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Reporte;
import com.monitorecg.web.service.exclusiones.Exclusiones;
import spark.ResponseTransformer;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class JsonUtilReporte implements ResponseTransformer{

   Gson gson = new GsonBuilder().registerTypeAdapter(Reporte.class,new ReporteTypeAdapter()).setExclusionStrategies(new Exclusiones()).setPrettyPrinting().create();
    
    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }

    public Gson getGson() {
        return gson;
    }
    
}
