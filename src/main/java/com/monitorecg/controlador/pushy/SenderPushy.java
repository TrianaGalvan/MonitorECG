/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.controlador.pushy;

import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Reporte;
import com.monitorecg.impl.PacienteDAOImpl;
import com.monitorecg.impl.ReporteDAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class SenderPushy {
    public List<String> registrationIDs = null;
    public Prueba pr; 
    
    public void sendPush(Reporte reporte){
        // Prepare registration IDs array
        obtenerTokenBD(reporte);

        // Set payload (any object, it will be serialized to JSON)
        HashMap<String, String> payload = new HashMap<String, String>();
               
        // Add test message
        payload.put("recomendaciones",reporte.getRecomendaciones());
        payload.put("idReporte",Integer.toString(reporte.getIdReporte()));
        payload.put("status",Integer.toString(reporte.getEstatus()));
        if(pr  != null){
            payload.put("fecha",pr.getFecha().toString());
        }
        
        
        if(!registrationIDs.isEmpty()){
            // Prepare the push request
            PushyPushRequest push = new PushyPushRequest(payload, registrationIDs.toArray(new String[registrationIDs.size()]));
            
            try {
                // Try sending the push notification
                PushyAPI.sendPush(push);
            } catch (Exception exc) {
                // Error, print to output
                System.out.println(exc.toString());
            }
        }

    }
    
    public void obtenerTokenBD(Reporte reporte){
        registrationIDs = new ArrayList<String>();
        //obtener el token del paciente al que se le tiene que enviar la notificacion 
        PacienteDAOImpl pdi = new PacienteDAOImpl(); 
        ReporteDAOImpl rdi = new ReporteDAOImpl();
        
        //obtener el id del paciente del reporte 
        pr = rdi.obtenerIdPacienteFromReporte(reporte);
        
        //verificar si existe la prueba 
        if(pr != null){
            //generar los tokens de la bd 
            String tken = pdi.obtenerToken(pr);
            registrationIDs.add(tken);
        }
    }
}
