/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoonarnia;

/**
 *
 * @author thesecond
 */
public class Paquete {
    String nombrePaquete;
    String contenidoPaquete;
    double precioPaquete;
    
    public Paquete(String nombrePaquete, String contenidoPaquete, double precioPaquete) {
        this.nombrePaquete = nombrePaquete;
        this.contenidoPaquete = contenidoPaquete;
        this.precioPaquete = precioPaquete;
    }
    
    public Paquete() {
    }
    
    public String getNombrePaquete() {
        return nombrePaquete;
    }
    
    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }
    
    public String getContenidoPaquete() {
        return contenidoPaquete;
    }
    
    public void setContenidoPaquete(String contenidoPaquete) {
        this.contenidoPaquete = contenidoPaquete;
    }
    
    public double getPrecioPaquete() {
        return precioPaquete;
    }
    
    public void setPrecioPaquete(double precioPaquete) {
        this.precioPaquete = precioPaquete;
    }
}
