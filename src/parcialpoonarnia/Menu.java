/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoonarnia;

import java.util.Scanner;

/**
 *
 * @author Ricardo Villeda
 */
public class Menu {

    private static Menu menu;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void MostrarMenu() {
        AdminHotel admin = new AdminHotel();
        Scanner input = new Scanner(System.in);
        admin.CrearHabitaciones();
        admin.PaquetesPredeterminados();

        int opcion;
        boolean corriendo = true;

        while (corriendo) {

            //SE IMPRIME EL MENU
            System.out.println("***************MENU***************");
            System.out.println("1.Agregar Cliente");
            System.out.println("2.Modificar habitacion");
            System.out.println("3.Mostrar reservaciones de la semana");
            System.out.println("4.Mostrar habitaciones disponibles");
            System.out.println("5.Hacer reservacion");
            System.out.println("6.Cancelar reservacion");
            System.out.println("7.Modificar reservacion");
            System.out.println("8.Modificar paquetes");
            System.out.println("9.Salir");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    admin.AgregarCliente();
                    break;
                case 2:
                    admin.ModificarHabitacion();
                    break;
                case 3:
                    admin.MostrarReservacion();
                    break;
                case 4:
                    admin.MostrarHabitacionesDisponibles();
                    break;
                case 5:
                    admin.HacerReservacion();
                    break;
                case 6:
                    admin.CancelarReservacion();
                    break;
                case 7:
                    admin.ModificarReservacion();
                    break;
                case 8:
                    admin.ModificarPaquetes();
                    break;
                case 9:
                    corriendo = false;
                    break;
                default:
                    System.out.println("Ha ingresado una opcion invalida");
                    break;
            }
        }

    }
}
