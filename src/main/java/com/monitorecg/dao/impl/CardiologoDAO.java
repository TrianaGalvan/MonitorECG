/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.dao;

import com.monitorecg.hibernate.entities.Cardiologo;
import java.util.List;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public interface CardiologoDAO {
    public boolean eliminarCardiologo(Cardiologo c);
    public boolean modificarCardiologo(Cardiologo c);
    public boolean agregarCardiologo(Cardiologo c);
    public List<Cardiologo> obtenerCardiologos(); 
    public Cardiologo obtenerCardiologo(Cardiologo c);
    public Cardiologo loginCardiologo(Cardiologo c);
    public Cardiologo buscarCardiologoPorCorreo(Cardiologo c); 
    public boolean cambiarContrasena(Cardiologo c);
    public Cardiologo buscarCorreo(Cardiologo c);
    public List<Object[]> obtenerTablaElectrocardiogramas(Cardiologo c);
    public boolean moficarCardiologoSinContrasena(Cardiologo c);
    public boolean modificarContrasena(Cardiologo c);
    public Long contarPruebasNoRevisadas(Cardiologo c);
}
