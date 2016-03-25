package com.monitorecg.hibernate.entities;
// Generated 16-mar-2016 13:26:37 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
/**
 * Cardiologo generated by hbm2java
 */
public class Cardiologo  implements java.io.Serializable {


     private int idCardiologo;
     private String instituto;
     private String cedula;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private Integer edad;
     private String sexo;
     private String correo;
     private String telefono;
     private String curp;
     private String contrasena;
     private Set<Paciente> pacientes = 
				new HashSet<Paciente>(0);

    public Cardiologo() {
    }

	
    public Cardiologo(int idCardiologo) {
        this.idCardiologo = idCardiologo;
    }
    public Cardiologo(int idCardiologo, String instituto, String cedula, String nombre, String apellidoPaterno, String apellidoMaterno, Integer edad, String sexo, String correo, String telefono, String curp, String contrasena) {
       this.idCardiologo = idCardiologo;
       this.instituto = instituto;
       this.cedula = cedula;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.edad = edad;
       this.sexo = sexo;
       this.correo = correo;
       this.telefono = telefono;
       this.curp = curp;
       this.contrasena = contrasena;
    }
   
    public int getIdCardiologo() {
        return this.idCardiologo;
    }
    
    public void setIdCardiologo(int idCardiologo) {
        this.idCardiologo = idCardiologo;
    }
    public String getInstituto() {
        return this.instituto;
    }
    
    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
    public Integer getEdad() {
        return this.edad;
    }
    
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    public String getCurp() {
        return this.curp;
    }
    
    public void setCurp(String curp) {
        this.curp = curp;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
   
}


