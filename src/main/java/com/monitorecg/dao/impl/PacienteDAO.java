/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.dao.impl;

import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Prueba;
import java.util.List;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public interface PacienteDAO {
    public boolean eliminarPaciente(Paciente c);
    public boolean modificarPaciente(Paciente c);
    public boolean agregarPaciente(Paciente c);
    public List<Paciente> obtenerPacientes(); 
    public Paciente obtenerPaciente(Paciente c);
    public Paciente obtenerPacientePorCorreo(Paciente p);
    public List<Paciente> obtenerPacientePorCURP(Paciente p);
    public List<Paciente> obtenerPacientePorNombre(Paciente p);
    public List<Object[]> obtenerTablaPruebas(Paciente p);
    public Paciente loginPaciente(Paciente p);
    public Paciente verificarCorreo(Paciente p);
    public boolean actualizarDatosPersonales(Paciente p );
    public List<String> obtenerTokens();
    public String obtenerToken(Prueba p);
}
