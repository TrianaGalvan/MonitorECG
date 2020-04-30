/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.monitorecg.impl.CardiologoDAOImpl;
import com.monitorecg.impl.PacienteDAOImpl;
import com.monitorecg.impl.PruebaDAOImpl;
import com.monitorecg.impl.ReporteDAOImpl;
import com.monitorecg.web.service.CardiologoController;
import com.monitorecg.web.service.PacienteController;
import com.monitorecg.web.service.PruebaController;
import com.monitorecg.web.service.ReporteController;

import static spark.Spark.*;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class Main {
	public static void main(String[] args) {
//            port(getHerokuAssignedPort());
            CardiologoController cardiologoController = new CardiologoController(new CardiologoDAOImpl());
            PacienteController pacienteController = new PacienteController(new PacienteDAOImpl());
            PruebaController pruebaController = new PruebaController(new PruebaDAOImpl());
            ReporteController reporteController = new ReporteController(new ReporteDAOImpl());
	}

	static int getHerokuAssignedPort() {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (processBuilder.environment().get("PORT") != null) {
                return Integer.parseInt(processBuilder.environment().get("PORT"));
            }
            return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
	}
}
