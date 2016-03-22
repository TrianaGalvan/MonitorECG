package com.monitorecg.hibernate.entities;
// Generated 16-mar-2016 13:26:37 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;




/**
 * Paciente generated by hbm2java
 */
public class Paciente  implements java.io.Serializable {


     private int idPaciente;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String sexo;
     private Integer edad;
     private String curp;
     private String correo;
     private String telefono;
     private String contrasena;
     private Double peso;
     private Double presionArterial;
     private Double imc;
     private Double frecuenciaRespiratoria;
     private Double altura;
     private String fechamodificacion;
     private Set<Prueba> pruebas = 
				new HashSet<Prueba>(0);
     

    public Paciente() {
    }

	
    public Paciente(int id) {
        this.idPaciente = id;
    }
    public Paciente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String sexo, Integer edad, String curp, String correo, String telefono, String contrasena, Double peso, Double presionArterial, Double imc, Double frecuenciaRespiratoria, Double altura, String fechamodificacion) {
       this.idPaciente = id;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.sexo = sexo;
       this.edad = edad;
       this.curp = curp;
       this.correo = correo;
       this.telefono = telefono;
       this.contrasena = contrasena;
       this.peso = peso;
       this.presionArterial = presionArterial;
       this.imc = imc;
       this.frecuenciaRespiratoria = frecuenciaRespiratoria;
       this.altura = altura;
       this.fechamodificacion = fechamodificacion;
    }
   
    public int getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(int id) {
        this.idPaciente = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Integer getEdad() {
        return this.edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getCurp() {
        return this.curp;
    }
    
    public void setCurp(String curp) {
        this.curp = curp;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Double getPeso() {
        return this.peso;
    }
    
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Double getPresionArterial() {
        return this.presionArterial;
    }
    
    public void setPresionArterial(Double presionArterial) {
        this.presionArterial = presionArterial;
    }
    public Double getImc() {
        return this.imc;
    }
    
    public void setImc(Double imc) {
        this.imc = imc;
    }
    public Double getFrecuenciaRespiratoria() {
        return this.frecuenciaRespiratoria;
    }
    
    public void setFrecuenciaRespiratoria(Double frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }
    public Double getAltura() {
        return this.altura;
    }
    
    public void setAltura(Double altura) {
        this.altura = altura;
    }
    public String getFechamodificacion() {
        return this.fechamodificacion;
    }
    
    public void setFechamodificacion(String fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Set<Prueba> getPruebas() {
        return pruebas;
    }

    public void setPruebas(Set<Prueba> pruebas) {
        this.pruebas = pruebas;
    }

     
}


