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
    public void NuevaReservacion(String nombrePaquete, String pisoHabitacion, int numeroHabitacion) {
        Reservacion nuevaReservacion = new Reservacion();
        double costo, costoT;
        int fecha = 0, diaReservacion = 0;
        Scanner n = new Scanner(System.in);
        boolean bandera = true;
        while (bandera) {
            System.out.println("Dia en que desea hacer la reserva(Tomar en cuenta que ahora es 1 de Enero): ");
            fecha = n.nextInt();
            if (fecha > 0 && fecha < 31) {
                if (VerificarDisponibilidad(pisoHabitacion, numeroHabitacion, fecha)) {
                    bandera = false;
                } else {
                    System.out.println("La habitacion no esta disponible ese dia. ");
                }
            } else {
                System.out.println("Por el momento solo se puede reservar hasta el 30 de Enero");
            }
        }
        while (!bandera) {
            System.out.println("Cuantos dias piensa quedarse (El maximo son 7 días): ");
            diaReservacion = n.nextInt();
            int dias = 0;
            if (diaReservacion > 0 && diaReservacion < 8) {
                for (int x = 0; x < diaReservacion; x++) {
                    if (VerificarDisponibilidad(pisoHabitacion, numeroHabitacion, fecha + x)) {
                        dias++;
                    } else {
                        System.out.println("La habitacion que desea no esta disponible el dia " + (fecha + x));
                    }
                }
                if (dias == diaReservacion) {
                    for (int x = 0; x < diaReservacion; x++) {
                        CambiarDisponibilidad(pisoHabitacion, numeroHabitacion, fecha + x);
                    }
                    bandera = true;
                }
            }
        }
        costo = CostoPorNoche(pisoHabitacion, numeroHabitacion, nombrePaquete);
        costoT = diaReservacion * costo;
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

    public double CostoPorNoche(String pisoHabitacion, int numeroHabitacion, String NombrePaquete) {
        double costoPaquete = 0, costoHabitacion = 0;
        for (Paquete paquetes : Paquetes) {
            if (paquetes.getNombrePaquete().equals(NombrePaquete)) {
                costoPaquete = paquetes.getPrecioPaquete();
            }
        }
        for (Habitacion habitaciones : Habitaciones) {
            if (habitaciones.getNumero() == numeroHabitacion && habitaciones.getPiso().equals(pisoHabitacion)) {
                costoHabitacion = habitaciones.getPrecioHabitacion();
            }
        }
        return (costoPaquete + costoHabitacion);
    }

    public boolean VerificarReservacion() {
        int cont = 0;
        for (Reservacion reservar : Reservaciones) {
            cont++;
        }
        return (cont == 0 || cont == 1);
    }

    public boolean VerificarDisponibilidad(String pisoHabitacion, int numeroHabitacion, int dia) {
        for (Habitacion h : Habitaciones) {
            if (h.getNumero() == numeroHabitacion && h.getPiso().equals(pisoHabitacion)) {
                return ("Disponible".equals(h.DisponibilidadMes.get(dia)));
            }
        }
        return false;
    }

    public void CambiarDisponibilidad(String pisoHabitacion, int numeroHabitacion, int dia) {
        for (Habitacion h : Habitaciones) {
            if (h.getNumero() == numeroHabitacion && h.getPiso().equals(pisoHabitacion)) {
                h.DisponibilidadMes.set(dia - 1, "No disponible");
            }
        }
    }
///////////////////////////Modificar Reservacion////////////////////////////////  

    public void ModificarReservacion(String infoCliente, String pisoHabitacion, int numeroHabitacion) {
        boolean bandera = true, seEncontro = false;
        Scanner n = new Scanner(System.in);
        int opcion;
        for (Reservacion r : Reservaciones) {
            if (r.getInfoHuesped().equals(infoCliente) && r.getNumeroHabitacion() == numeroHabitacion && r.getPisoHabitacion().equals(pisoHabitacion)) {
                seEncontro = true;
            }
        }
        if (seEncontro) {
            for (Reservacion modReservar : Reservaciones) {
                if (modReservar.pisoHabitacion.equals(pisoHabitacion) && modReservar.numeroHabitacion == numeroHabitacion) {
                    while (bandera) {
                        System.out.println("1.Cambiar de piso");
                        System.out.println("2.Cambiar la cantidad de dias");
                        System.out.println("3.Cambiar Fecha");
                        System.out.println("4.Cambiar paquete");
                        System.out.println("5.Salir");
                        opcion = n.nextInt();
                        switch (opcion) {
                            case 1:
                                CambiarPiso(modReservar);
                                break;
                            case 2:
                                CambiarCantidadDia(modReservar);
                                break;
                            case 3:
                                CambiarFecha(modReservar);
                                break;
                            case 4:
                                CambiarPaquete(modReservar);
                                break;
                            case 5:
                                bandera = false;
                                break;
                            default:
                                System.out.println("No digito ninguna de las opciones anteriores.");
                                break;
                        }
                    }
                }
            }
        } else {
            System.out.println("Los datos que ha ingresado son erroneos");
        }
    }

    public void CambiarPiso(Reservacion reservar) {
        Scanner n = new Scanner(System.in);
        boolean bandera = true;
        double nuevoCostoPorNoche, nuevoCostoTotal;
        String piso = "";
        int dias = 0;
        for (int i = 0; i < reservar.getDiasReservacion(); i++) {
            HabilitarHabitacion(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
        }
        while (bandera) {
            System.out.println("Digite el nuevo piso(A,B,C,D,E,F): ");
            while (bandera) {
                piso = n.nextLine();
                switch (piso) {
                    case "A":
                    case "B":
                    case "C":
                    case "D":
                    case "E":
                    case "F":
                        bandera = false;
                        break;
                    default:
                        System.out.println("Tiene que digitar la letra A, B, C, D, E, F");
                        break;
                }
            }
            for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                if (VerificarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i)) {
                    dias++;
                }
            }
            if (dias != reservar.getDiasReservacion()) {
                System.out.println("No puede escoger ese piso ya que esta ocupado en el día que usted quiere reservar");
                bandera = true;
            }
        }
        if (reservar.pisoHabitacion.equals(piso)) {
            System.out.println("Ha escogido el mismo piso");
            for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                CambiarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
            }
        } else {
            reservar.setPisoHabitacion(piso);
            for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                CambiarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
            }
            nuevoCostoPorNoche = CostoPorNoche(piso, reservar.getNumeroHabitacion(), reservar.getNombrePaquete());
            reservar.setCostoNoche(nuevoCostoPorNoche);
            nuevoCostoTotal = nuevoCostoPorNoche * reservar.getDiasReservacion();
            reservar.setCostoTotal(nuevoCostoTotal);
        }
    }

    public void CambiarCantidadDia(Reservacion reservar) {
        Scanner n = new Scanner(System.in);
        boolean bandera = true;
        double CostoTotal;
        int dia = 0, cont = 0;
        for (int i = 0; i < reservar.getDiasReservacion(); i++) {
            HabilitarHabitacion(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
        }
        while (bandera) {
            System.out.println("Nueva cantidad de dia/as(maximo de dias 7): ");
            while (bandera) {
                dia = n.nextInt();
                if (dia > 0 && dia < 8) {
                    bandera = false;
                } else {
                    System.out.println("La cantidad de dias no tiene que ser mayor a 7");
                }
            }
            for (int i = 0; i < dia; i++) {
                if (VerificarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i)) {
                    cont++;
                }
            }
            if (cont != dia) {
                System.out.println("No puede escoger esa cantidad de dias ya que la habitacion que desea ocupar esta ocupada o inhabilitada ");
                bandera = true;
            } else {
                bandera = false;
            }
        }
        if (reservar.diasReservacion == dia) {
            System.out.println("Ha escogido el mismo numero de día.");
            for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                CambiarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
            }
        } else {
            reservar.setDiasReservacion(dia);
            for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                CambiarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
            }
            CostoTotal = reservar.getCostoNoche() * dia;
            reservar.setCostoTotal(CostoTotal);
        }
    }

    public void CambiarFecha(Reservacion reservar) {
        Scanner n = new Scanner(System.in);
        boolean bandera = true;
        int fecha = 0, cont = 0;
        for (int i = 0; i < reservar.getDiasReservacion(); i++) {
            HabilitarHabitacion(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
        }
        while (bandera) {
            System.out.println("Nueva fecha: ");
            while (bandera) {
                fecha = n.nextInt();
                if (fecha > 0 && fecha < 31) {
                    bandera = false;
                } else {
                    System.out.println("El mes es Enero y este solo tiene 30 dias");
                }
            }
            for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                if (VerificarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i)) {
                    cont++;
                }
            }
            if (cont != reservar.getDiasReservacion()) {
                System.out.println("No puede escoger esa fecha ya que la habitacion que esta ocupada o inhabilitada ese día");
                bandera = true;
            } else {
                bandera = false;
            }
        }
        if (reservar.Fecha == fecha) {
            System.out.println("Ha escogido la misma fecha");
            for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                CambiarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
            }
        } else {
            reservar.setFecha(fecha);
            for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                CambiarDisponibilidad(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
            }
        }
    }

    public void CambiarPaquete(Reservacion reservar) {
        Scanner n = new Scanner(System.in);
        boolean bandera = true;
        String nombrePaquete = "";
        double costoPorNoche, costoTotal;
        System.out.println("Nuevo paquete: ");
        while (bandera) {
            nombrePaquete = n.nextLine();
            if (PaqueteExiste(nombrePaquete)) {
                bandera = false;
            } else {
                System.out.println("El paquete que ha digitado no existe");
                System.out.println("Los paquetes que estan en este momento son: ");
                MostrarPaquete();
            }
        }
        if (reservar.nombrePaquete.equals(nombrePaquete)) {
            System.out.println("Ha escogido el mismo paquete");
        } else {
            reservar.setNombrePaquete(nombrePaquete);
            costoPorNoche = CostoPorNoche(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), nombrePaquete);
            reservar.setCostoNoche(costoPorNoche);
            costoTotal = costoPorNoche * reservar.getDiasReservacion();
            reservar.setCostoTotal(costoTotal);
        }
    }

    public boolean PaqueteExiste(String nombrePaquete) {
        for (Paquete paquetes : Paquetes) {
            if (paquetes.getNombrePaquete().equals(nombrePaquete)) {
                return true;
            }
        }
        return false;
    }

    public void MostrarPaquete() {
        int n = 1;
        for (Paquete paquetes : Paquetes) {
            System.out.println("Paquete " + n + ": " + paquetes.getNombrePaquete());
            System.out.println("Contenido: " + paquetes.getContenidoPaquete());
            System.out.println("Precio: " + paquetes.getPrecioPaquete());
            n++;
        }
    }

    public void HabilitarHabitacion(String pisoHabitacion, int numeroHabitacion, int fecha) {
        for (Habitacion h : Habitaciones) {
            if (h.getPiso().equals(pisoHabitacion) && h.getNumero() == numeroHabitacion) {
                h.DisponibilidadMes.set(fecha, "Disponible");
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    public void CancelarReservacion() {
        String pisoHabitacion = "";
        int numeroHabitacion = 0;
        int cont = 0, eliminar = 0;
        boolean bandera = true, Eliminar = false;
        while (bandera) {
            Scanner n = new Scanner(System.in);
            System.out.println("Digite el numero de su habitacion: ");
            numeroHabitacion = n.nextInt();
            if (numeroHabitacion > 0 && numeroHabitacion < 10) {
                bandera = false;
            } else {
                System.out.println("Ha ingresado un numero de habitacion incorrecta.");
            }
        }
        while (!bandera) {
            Scanner n = new Scanner(System.in);
            System.out.println("Digite el piso de su habitacion: ");
            pisoHabitacion = n.nextLine();
            switch (pisoHabitacion) {
                case "A":
                case "B":
                case "C":
                case "D":
                case "E":
                case "F":
                    bandera = true;
                    break;
                default:
                    System.out.println("Ha ingresado un piso incorrecto");
            }
        }
        for (Reservacion reservar : Reservaciones) {
            if (reservar.getNumeroHabitacion() == numeroHabitacion && reservar.getPisoHabitacion().equals(pisoHabitacion)) {
                eliminar = cont;
                Eliminar = true;
                for (int i = 0; i < reservar.getDiasReservacion(); i++) {
                    HabilitarHabitacion(reservar.getPisoHabitacion(), reservar.getNumeroHabitacion(), reservar.getFecha() + i);
                }
            }
            cont++;
        }
        if (Eliminar) {
            Reservaciones.remove(eliminar);
        } else {
            System.out.println("No se encontro la reservacion.");
        }
    }
////////////////////////////////////////////////////////////////////////////////

    public void MostrarReservaciones() {
        for (Reservacion reservaciones : Reservaciones) {
            if (reservaciones.getFecha() < 8) {
                System.out.println(reservaciones.getInfoHuesped());
                System.out.println("El dia que reservo: " + reservaciones.getFecha());
                System.out.println("Dias reservado: " + reservaciones.getDiasReservacion());
                System.out.println("Costo por noche: " + reservaciones.getCostoNoche());
                System.out.println("Costo total: " + reservaciones.getCostoTotal());
            }
        }
    }
}
