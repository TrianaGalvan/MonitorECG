/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.web.service;

import com.monitorecg.impl.CardiologoDAOImpl;
import com.monitorecg.impl.PacienteDAOImpl;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class Main {
  public static void main(String[] args) {
      CardiologoController cardiologoController = new CardiologoController(new CardiologoDAOImpl());
  }
}
