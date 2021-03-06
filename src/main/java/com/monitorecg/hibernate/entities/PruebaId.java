package com.monitorecg.hibernate.entities;
// Generated 16-mar-2016 13:26:37 by Hibernate Tools 4.3.1



/**
 * PruebaId generated by hbm2java
 */
public class PruebaId  implements java.io.Serializable {


     private int idPrueba;
     private int pacienteIdPaciente;

    public PruebaId() {
    }

    public PruebaId(int idPrueba, int pacienteIdPaciente) {
       this.idPrueba = idPrueba;
       this.pacienteIdPaciente = pacienteIdPaciente;
    }
   
    public int getIdPrueba() {
        return this.idPrueba;
    }
    
    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }
    public int getPacienteIdPaciente() {
        return this.pacienteIdPaciente;
    }
    
    public void setPacienteIdPaciente(int pacienteIdPaciente) {
        this.pacienteIdPaciente = pacienteIdPaciente;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PruebaId) ) return false;
		 PruebaId castOther = ( PruebaId ) other; 
         
		 return (this.getIdPrueba()==castOther.getIdPrueba())
 && (this.getPacienteIdPaciente()==castOther.getPacienteIdPaciente());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPrueba();
         result = 37 * result + this.getPacienteIdPaciente();
         return result;
   }   


}


