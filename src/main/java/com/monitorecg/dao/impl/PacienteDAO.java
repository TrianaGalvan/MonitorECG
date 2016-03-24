/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.dao.impl;

import com.monitorecg.hibernate.entities.Paciente;
import com.monitorecg.hibernate.entities.Paciente;
import java.util.List;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public interface PacienteDAO {
    public void eliminarPaciente(Paciente c);
    public void modificarPaciente(Paciente c);
    public boolean agregarPaciente(Paciente c);
    public List<Paciente> obtenerPacientes(); 
    public Paciente obtenerPaciente(Paciente c);
}
