/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.server.spark;

import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.impl.CardiologoDAOImpl;
import com.monitorecg.impl.PacienteDAOImpl;
import com.monitorecg.impl.PruebaDAOImpl;
import com.monitorecg.impl.ReporteDAOImpl;
import com.monitorecg.web.service.CardiologoController;
import com.monitorecg.web.service.PacienteController;
import com.monitorecg.web.service.PruebaController;
import com.monitorecg.web.service.ReporteController;
import spark.servlet.SparkApplication;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class MonitorECGApplication implements SparkApplication{

    @Override
    public void init() {
        CardiologoController cardiologoController = new CardiologoController(new CardiologoDAOImpl());
        PacienteController pacienteController = new PacienteController(new PacienteDAOImpl());
        PruebaController pruebaController = new PruebaController(new PruebaDAOImpl());
        ReporteController reporteController = new ReporteController(new ReporteDAOImpl());
    }
    
}
