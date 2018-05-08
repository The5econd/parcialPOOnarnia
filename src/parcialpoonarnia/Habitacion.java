/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoonarnia;
import java.util.ArrayList;
/**
 *
 * @author thesecond
 */
public class Habitacion {
    private String piso;
    private int numero;
    private double precioHabitacion;
    private String idHabitacion;
    ArrayList<String> DisponibilidadMes = new ArrayList<>();

    public ArrayList<String> getDisponibilidadMes() {
        return DisponibilidadMes;
    }

    public void setDisponibilidadMes(ArrayList<String> DisponibilidadMes) {
        this.DisponibilidadMes = DisponibilidadMes;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecioHabitacion() {
        double CostoExtra;
        if(piso.equals("F")||piso.equals("E")){
            CostoExtra = precioHabitacion / 10 ;
            return (precioHabitacion + CostoExtra);
        }
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Habitacion() {
    }
    
    public void Disponibilidad(){
        for(int i=1;i<=37;i++){
            DisponibilidadMes.add("Disponible");
        }
    }
}
