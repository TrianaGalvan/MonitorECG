/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service.exclusiones;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.monitorecg.hibernate.entities.Cardiologo;

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
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> type) {
        return false;
    }
    
}
