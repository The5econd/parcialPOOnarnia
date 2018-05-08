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
    
    /////////////////////////////Nueva reservacion///////////////////////////////////////////////////
    public void NuevaReservacion(String nombrePaquete, String pisoHabitacion, int numeroHabitacion){
        Reservacion nuevaReservacion = new Reservacion();      
        double costo, costoT;
        int fecha = 0, diaReservacion = 0;
        Scanner n = new Scanner(System.in);
        boolean bandera = true;
        while(bandera){
            System.out.println("Dia en que desea hacer la reserva(Tomar en cuenta que ahora es 1 de Enero): ");
            fecha = n.nextInt();
            if(fecha>0 && fecha<31){
                if(VerificarDisponibilidad(pisoHabitacion,numeroHabitacion,fecha)){
                   bandera = false;
                }
                else{
                    System.out.println("La habitacion no esta disponible ese dia. ");
                }
            }
            else{
                System.out.println("Por el momento solo se puede reservar hasta el 30 de Enero");
            }
        }
        while(!bandera){
            System.out.println("Cuantos dias piensa quedarse (El maximo son 7 días): ");
            diaReservacion = n.nextInt();
            int dias = 0;
            if(diaReservacion>0 && diaReservacion<8){
                for(int x=0;x<diaReservacion;x++){
                    if(VerificarDisponibilidad(pisoHabitacion,numeroHabitacion,fecha+x)){   
                        dias++;
                    }
                    else{
                        System.out.println("La habitacion que desea no esta disponible el dia "+(fecha+x));
                    }
                }
                if(dias == diaReservacion){
                    for(int x=0;x<diaReservacion;x++){
                        CambiarDisponibilidad(pisoHabitacion,numeroHabitacion,fecha+x);
                    }
                    bandera = true;
                }
            }
        }
        costo = CostoPorNoche(pisoHabitacion,numeroHabitacion,nombrePaquete);
        costoT = diaReservacion*costo;
        nuevaReservacion.setDiasReservacion(diaReservacion);
        nuevaReservacion.setFecha(fecha);
        nuevaReservacion.setInfoHuesped(infoCliente);
        nuevaReservacion.setNombrePaquete(nombrePaquete);
        nuevaReservacion.setNumeroHabitacion(numeroHabitacion);
        nuevaReservacion.setPisoHabitacion(pisoHabitacion);
        nuevaReservacion.setCostoNoche(costo);
        nuevaReservacion.setCostoTotal(costoT);
        Reservaciones.add(nuevaReservacion);
    }
    
    public double CostoPorNoche(String pisoHabitacion,int numeroHabitacion,String NombrePaquete){
        double costoPaquete = 0,costoHabitacion = 0;
        for(Paquete paquetes: Paquetes){
            if(paquetes.getNombrePaquete().equals(NombrePaquete)){
                costoPaquete = paquetes.getPrecioPaquete();
            }
        }
        for(Habitacion habitaciones:Habitaciones){
            if(habitaciones.getNumero() == numeroHabitacion && habitaciones.getPiso().equals(pisoHabitacion)){
                costoHabitacion = habitaciones.getPrecioHabitacion();
            }
        }
        return (costoPaquete + costoHabitacion);
    }
    
    public boolean VerificarReservacion(){
        int cont=0;
        for(Reservacion reservar: Reservaciones){
            cont++;
        }
        return (cont == 0 || cont == 1);
    }
    
    public boolean VerificarDisponibilidad(String pisoHabitacion,int numeroHabitacion,int dia){
        for(Habitacion h: Habitaciones){
            if(h.getNumero() == numeroHabitacion && h.getPiso().equals(pisoHabitacion)){
                return ("Disponible".equals(h.DisponibilidadMes.get(dia)));
            }
        }
        return false;
    }
    
    public void CambiarDisponibilidad(String pisoHabitacion,int numeroHabitacion,int dia){
        for(Habitacion h: Habitaciones){
            if(h.getNumero() == numeroHabitacion && h.getPiso().equals(pisoHabitacion)){
                h.DisponibilidadMes.set(dia - 1,"No disponible");
            }
        }
    }
    
    
}

