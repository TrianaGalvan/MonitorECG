/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.server.spark;

import com.monitorecg.impl.CardiologoDAOImpl;
import com.monitorecg.web.service.CardiologoController;
import spark.servlet.SparkApplication;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class MonitorECGApplication implements SparkApplication{

    @Override
    public void init() {
        CardiologoController cardiologoController = new CardiologoController(new CardiologoDAOImpl());
    }
    
}
