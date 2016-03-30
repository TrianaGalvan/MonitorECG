/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.dao.impl;

import com.monitorecg.hibernate.entities.Prueba;
import com.monitorecg.hibernate.entities.Prueba;
import java.util.List;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public interface PruebaDAO {
    public boolean eliminarPrueba(Prueba c);
    public boolean modificarPrueba(Prueba c);
    public boolean agregarPrueba(Prueba c);
    public List<Prueba> obtenerPruebas(); 
    public Prueba obtenerPrueba(Prueba c);
}
