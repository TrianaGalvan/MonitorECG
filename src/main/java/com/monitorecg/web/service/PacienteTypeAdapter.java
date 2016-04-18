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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class PacienteTypeAdapter extends TypeAdapter<Paciente> {

    @Override
    public void write(JsonWriter writer, Paciente t) throws IOException {
       writer.beginObject();
       if (t == null) {
         writer.nullValue();
         return;
       }
       writer.name("idPaciente").value(t.getIdPaciente());
       writer.name("nombre").value(t.getNombre());
       writer.name("apellidoPaterno").value(t.getApellidoPaterno());
       writer.name("apellidoMaterno").value(t.getApellidoMaterno());
       writer.name("sexo").value(t.getSexo());
       writer.name("edad").value(t.getEdad());
       writer.name("curp").value(t.getCurp());
       writer.name("correo").value(t.getCorreo());
       writer.name("telefono").value(t.getTelefono());
       writer.name("contrasena").value(t.getContrasena());
       writer.name("peso").value(t.getPeso());
       writer.name("imc").value(t.getImc());
       writer.name("frecuenciaRespiratoria").value(t.getFrecuenciaRespiratoria());
       writer.name("altura").value(t.getAltura());
       writer.name("fechamodificacion").value(t.getFechamodificacion());
       writer.name("presionDiastolica").value(t.getPresionDiastolica());
       writer.name("presionSistolica").value(t.getPresionSistolica());
       writer.name("cardiologo");
       writeCardiologo(writer,t.getCardiologo());
       writer.endObject();
    }

    @Override
    public Paciente read(JsonReader reader) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void writeCardiologo(JsonWriter writer,Cardiologo c){
        try { 
            writer.beginObject();
            writer.name("idCardiologo").value(c.getIdCardiologo());
            writer.endObject();
        } catch (IOException ex) {
            Logger.getLogger(PacienteTypeAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
