/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoonarnia;

/**
 *
 * @author javie
 */
public class Reservacion {
    public String infoHuesped;
    public String pisoHabitacion;
    public int numeroHabitacion;
    public int diasReservacion;
    public double costoNoche;
    public double costoTotal;
    public int Fecha;
    public String nombrePaquete;
    
    public int getFecha() {
        return Fecha;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }

    public String getInfoHuesped() {
        return infoHuesped;
    }

    public void setInfoHuesped(String infoHuesped) {
        this.infoHuesped = infoHuesped;
    }

    public String getPisoHabitacion() {
        return pisoHabitacion;
    }

    public void setPisoHabitacion(String pisoHabitacion) {
        this.pisoHabitacion = pisoHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getDiasReservacion() {
        return diasReservacion;
    }

    public void setDiasReservacion(int diasReservacion) {
        this.diasReservacion = diasReservacion;
    }

    public double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }
    
    public Reservacion() {
        
    }
}
