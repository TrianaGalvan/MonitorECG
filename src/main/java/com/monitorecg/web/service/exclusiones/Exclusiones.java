/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service.exclusiones;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.monitorecg.hibernate.entities.Cardiologo;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Reporte;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class Exclusiones implements ExclusionStrategy{

    @Override
    public boolean shouldSkipField(FieldAttributes fa) {
        if(fa.getDeclaringClass() == Cardiologo.class){
            if(fa.getName().equals("pacientes")){
                return true;
            }
        }else if(fa.getDeclaringClass() == Paciente.class){
            if(fa.getName().equals("pruebas")){
                return true;
            }
            /*else if(fa.getName().equals("cardiologo")){
                return true;
            }*/
        }else if(fa.getDeclaringClass() == Prueba.class){
            if(fa.getName().equals("paciente")){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> type) {
        return false;
    }
    
}
