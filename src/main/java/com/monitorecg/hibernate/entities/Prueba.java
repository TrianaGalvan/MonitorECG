package com.monitorecg.hibernate.entities;
// Generated 16-mar-2016 13:26:37 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Prueba generated by hbm2java
 */
public class Prueba  implements java.io.Serializable {


     private int idPrueba;
     private Date fecha;
     private Date hora;
     private byte[] muestraqrs;
     private byte[] muestracompleta;
     private Integer frecuenciacardiaca;
     private String observaciones;
     private Date fechaenvio;
     private Date horaenvio;
     private Paciente paciente;
     
     private Reporte reporte; 
    
     public Prueba() {
     }

	
    public Prueba(int id) {
        this.idPrueba = id;
    }
    public Prueba(int id, Date fecha, Date hora, byte[] muestraqrs, byte[] muestracompleta, Integer frecuenciacardiaca, String observaciones, Date fechaenvio, Date horaenvio) {
       this.idPrueba = id;
       this.fecha = fecha;
       this.hora = hora;
       this.muestraqrs = muestraqrs;
       this.muestracompleta = muestracompleta;
       this.frecuenciacardiaca = frecuenciacardiaca;
       this.observaciones = observaciones;
       this.fechaenvio = fechaenvio;
       this.horaenvio = horaenvio;
    }

    public int getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }
  
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public byte[] getMuestraqrs() {
        return this.muestraqrs;
    }
    
    public void setMuestraqrs(byte[] muestraqrs) {
        this.muestraqrs = muestraqrs;
    }
    public byte[] getMuestracompleta() {
        return this.muestracompleta;
    }
    
    public void setMuestracompleta(byte[] muestracompleta) {
        this.muestracompleta = muestracompleta;
    }
    public Integer getFrecuenciacardiaca() {
        return this.frecuenciacardiaca;
    }
    
    public void setFrecuenciacardiaca(Integer frecuenciacardiaca) {
        this.frecuenciacardiaca = frecuenciacardiaca;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Date getFechaenvio() {
        return this.fechaenvio;
    }
    
    public void setFechaenvio(Date fechaenvio) {
        this.fechaenvio = fechaenvio;
    }
    public Date getHoraenvio() {
        return this.horaenvio;
    }
    
    public void setHoraenvio(Date horaenvio) {
        this.horaenvio = horaenvio;
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}


