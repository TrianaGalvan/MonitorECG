/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.dao.impl;


import com.monitorecg.hibernate.entities.Reporte;
import java.util.List;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public interface ReporteDAO {
    public boolean eliminarReporte(Reporte r);
    public boolean modificarReporte(Reporte r);
    public boolean agregarReporte(Reporte r);
    public List<Reporte> obtenerReportes(); 
    public Reporte obtenerReporte(Reporte r);
    public boolean modificarRecomendaciones(Reporte r);
    public Reporte verificarEstatusReporte(Reporte r);
}
