/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.monitorecg.hibernate.entities.Reporte;
import java.io.IOException;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class ReporteTypeAdapter extends TypeAdapter<Reporte>{

    @Override
    public void write(JsonWriter writer, Reporte t) throws IOException {
        writer.beginObject(); 
        writer.name("idReporte").value(t.getIdReporte());
        writer.name("observaciones").value(t.getObservaciones());
        writer.name("recomendaciones").value(t.getRecomendaciones());
        writer.name("estatus").value(t.getEstatus());
        
        writer.name("cardiologo");
        writer.beginObject();
        writer.name("idCardiologo").value(t.getCardiologo().getIdCardiologo());
        writer.endObject();
        
        writer.endObject();
    }

    @Override
    public Reporte read(JsonReader reader) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
