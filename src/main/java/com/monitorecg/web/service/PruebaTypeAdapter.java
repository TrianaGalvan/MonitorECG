/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Reporte;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class PruebaTypeAdapter extends TypeAdapter<Prueba> {

    @Override
    public void write(JsonWriter writer, Prueba t) throws IOException {
        writer.beginObject(); 
        if (t == null) {
         writer.nullValue();
         return;
       }
       writer.name("idPrueba").value(t.getIdPrueba());
       
       Format formatter = new SimpleDateFormat("yyyy-MM-dd");
       String s = formatter.format(t.getFecha());
       writer.name("fecha").value(s);
       
       SimpleDateFormat sh = new SimpleDateFormat("HH:mm:ss");
       writer.name("hora").value(sh.format(t.getHora()));
       
       writer.name("observaciones").value(t.getObservaciones());
       
       if(t.getFrecuenciacardiaca() != null){
          writer.name("frecuenciaCardiaca").value(t.getFrecuenciacardiaca());
       }else{
           writer.name("frecuenciaCardiaca").value("0");
       }
           
       
       String se = formatter.format(t.getFechaenvio());
       writer.name("fechaEnvio").value(se);
       
       writer.name("horaEnvio").value(sh.format(t.getHoraenvio()));
       
       writer.name("paciente");
       writePaciente(writer,t.getPaciente());
       
       writer.name("reporte");
       writerReporte(writer,t.getReporte());
       
       writer.endObject();
    }

    @Override
    public Prueba read(JsonReader reader) throws IOException {
        Prueba prueba = new Prueba();
        reader.beginObject();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");
        while (reader.hasNext()) {            
            switch(reader.nextName()){
                case "idPrueba":
                    prueba.setIdPrueba(reader.nextInt());
                    break;
                case "fecha":
                    String fecha = reader.nextString();
                    try {
                        Date date = formatter.parse(fecha);
                        prueba.setFecha(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(PruebaTypeAdapter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "hora":
                    String hora = reader.nextString();
                    try {
                        Date horaDate = formatterHora.parse(hora);
                        prueba.setHora(horaDate);
                    } catch (ParseException ex) {
                        Logger.getLogger(PruebaTypeAdapter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    break;
                case "frecienciaCardiaca":
                    prueba.setFrecuenciacardiaca(reader.nextInt());
                    break;
                case  "observaciones":
                    prueba.setObservaciones(reader.nextString());
                    break;
                case "fechaEnvio":
                    String fechaEnvio = reader.nextString();
                    try {
                        Date date = formatter.parse(fechaEnvio);
                        prueba.setFechaenvio(date);
                    } catch (ParseException ex) {
                        Logger.getLogger(PruebaTypeAdapter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "horaEnvio":
                    String horaEnvio = reader.nextString();
                     try {
                        Date horaEnvioDate = formatterHora.parse(horaEnvio);
                        prueba.setHoraenvio(horaEnvioDate);
                    } catch (ParseException ex) {
                        Logger.getLogger(PruebaTypeAdapter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "paciente":
                    reader.beginObject();
                    Paciente paciente = new Paciente();
                    String name  = reader.nextName();
                    if(name.equals("idPaciente")){
                        paciente.setIdPaciente(reader.nextInt());
                    }                    
                    prueba.setPaciente(paciente);
                    reader.endObject();
                    break;
                case "reporte":
                    reader.beginObject();
                    Cardiologo c = new Cardiologo();
                    Reporte reporte = new Reporte();
                    String namereporte = reader.nextName();
                    if(namereporte.equals("idReporte")){
                        reporte.setIdReporte(reader.nextInt());
                        String namecardiologo = reader.nextName();
                        if(namecardiologo.equals("idCardiologo")){
                            c.setIdCardiologo(reader.nextInt());
                        }
                    }else if(namereporte.equals("idCardiologo")){
                        c.setIdCardiologo(reader.nextInt());
                        String estatus = reader.nextName();
                        if(estatus.equals("estatus")){
                            reporte.setEstatus(reader.nextInt());
                        }                        
                    }
                    reporte.setCardiologo(c);
                    prueba.setReporte(reporte);
                    reader.endObject();
                    break;
            }
        }
        reader.endObject();
        return prueba;
    }

    private void writePaciente(JsonWriter writer, Paciente paciente) {
        try { 
            writer.beginObject();
            writer.name("idPaciente").value(paciente.getIdPaciente());
            writer.endObject();
        } catch (IOException ex) {
            Logger.getLogger(PacienteTypeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writerReporte(JsonWriter writer, Reporte reporte) {
        try { 
            writer.beginObject();
            writer.name("idReporte").value(reporte.getIdReporte());
            writer.name("idCardiologo").value(reporte.getCardiologo().getIdCardiologo());
            writer.name("estatus").value(reporte.getEstatus());
            writer.name("recomendaciones").value(reporte.getRecomendaciones());
            writer.endObject();
        } catch (IOException ex) {
            Logger.getLogger(PacienteTypeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
