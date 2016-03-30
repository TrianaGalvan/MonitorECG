/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.web.service.exclusiones.Exclusiones;
import java.io.IOException;
import spark.ResponseTransformer;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class JsonUtilPaciente implements ResponseTransformer{
    Gson gson = new GsonBuilder().registerTypeAdapter(Paciente.class,new PacienteTypeAdapter()).setExclusionStrategies(new Exclusiones()).setPrettyPrinting().create();
    
    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }

    public Gson getGson() {
        return gson;
    }

}
