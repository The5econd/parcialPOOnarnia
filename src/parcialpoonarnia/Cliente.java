/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoonarnia;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Ricardo Villeda
 */
public class Cliente {
    
    public String Dui;
    public String infoCliente;
    public String nombre;
    public String apellido;
    public String tarjetaCredito;
    public String telefono;
    ArrayList<Reservacion> Reservaciones = new ArrayList<>();
    ArrayList<Habitacion> Habitaciones = new ArrayList<>();
    ArrayList<Paquete> Paquetes = new ArrayList<>(); 
    
    public String getDui() {
        return Dui;
    }

    public void setDui(String Dui) {
        this.Dui = Dui;
    }

    public ArrayList<Paquete> getPaquetes() {
        return Paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> Paquetes) {
        this.Paquetes = Paquetes;
    }
    
    public ArrayList<Reservacion> getReservaciones() {
        return Reservaciones;
    }

    public void setReservaciones(ArrayList<Reservacion> Reservaciones) {
        this.Reservaciones = Reservaciones;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return Habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> Habitaciones) {
        this.Habitaciones = Habitaciones;
    }

    public String getInfoCliente() {
        return infoCliente;
    }

    public void setInfoCliente(String infoCliente) {
        this.infoCliente = infoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Cliente() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Nombre: ");
        this.nombre = leer.nextLine();
        System.out.println("Apellido: ");
        this.apellido = leer.nextLine();
        System.out.println("Telefono: ");
        this.telefono = leer.nextLine();
        System.out.println("Tarjeta de credito o debito: ");
        this.tarjetaCredito = leer.nextLine();
        System.out.println("DUI: ");
        this.Dui = leer.nextLine();
        this.infoCliente = "Nombre: " + this.nombre + " Apellido: " + this.apellido + " DUI: " + this.Dui + " Telefono: " + this.telefono + " Tarjeta de credito: " + this.tarjetaCredito;
    }
}
