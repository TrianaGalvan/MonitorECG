package com.monitorecg.hibernate.entities;
// Generated 16-mar-2016 13:26:37 by Hibernate Tools 4.3.1



/**
 * ReporteId generated by hbm2java
 */
public class ReporteId  implements java.io.Serializable {


     private int idReporte;
     private int cardiologoIdCardiologo;
     private int pruebaIdPrueba;

    public ReporteId() {
    }

    public ReporteId(int idReporte, int cardiologoIdCardiologo, int pruebaIdPrueba) {
       this.idReporte = idReporte;
       this.cardiologoIdCardiologo = cardiologoIdCardiologo;
       this.pruebaIdPrueba = pruebaIdPrueba;
    }
   
    public int getIdReporte() {
        return this.idReporte;
    }
    
    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }
    public int getCardiologoIdCardiologo() {
        return this.cardiologoIdCardiologo;
    }
    
    public void setCardiologoIdCardiologo(int cardiologoIdCardiologo) {
        this.cardiologoIdCardiologo = cardiologoIdCardiologo;
    }
    public int getPruebaIdPrueba() {
        return this.pruebaIdPrueba;
    }
    
    public void setPruebaIdPrueba(int pruebaIdPrueba) {
        this.pruebaIdPrueba = pruebaIdPrueba;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ReporteId) ) return false;
		 ReporteId castOther = ( ReporteId ) other; 
         
		 return (this.getIdReporte()==castOther.getIdReporte())
 && (this.getCardiologoIdCardiologo()==castOther.getCardiologoIdCardiologo())
 && (this.getPruebaIdPrueba()==castOther.getPruebaIdPrueba());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdReporte();
         result = 37 * result + this.getCardiologoIdCardiologo();
         result = 37 * result + this.getPruebaIdPrueba();
         return result;
   }   


}


