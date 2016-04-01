/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;
import spark.Filter;
import spark.Request;
import spark.Response;
import static spark.Spark.*;
/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class JsonController {
    protected JsonUtil jsonutil = new JsonUtil();
    protected JsonUtilPaciente jsonutilpaciente = new JsonUtilPaciente();
    protected JsonUtilPrueba jsonutilprueba = new JsonUtilPrueba();
    protected JsonUtilReporte jsonutilreporte = new JsonUtilReporte();
    
    public JsonController(){
        after(new Filter() {
            @Override
            public void handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
            }
        });
    }
}
