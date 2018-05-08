package parcialpoonarnia;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author feranstirman1
 */
public class AdminHotel {
    ArrayList<Habitacion> Habitaciones = new ArrayList<>();
    ArrayList<Paquete> Paquetes = new ArrayList<>();
    ArrayList<Cliente> Clientes = new ArrayList<>();

    public ArrayList<Habitacion> getHabitaciones() {
        return Habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> Habitaciones) {
        this.Habitaciones = Habitaciones;
    }

    public ArrayList<Paquete> getPaquetes() {
        return Paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> Paquetes) {
        this.Paquetes = Paquetes;
    }

    public ArrayList<Cliente> getClientes() {
        return Clientes;
    }

    public void setClientes(ArrayList<Cliente> Clientes) {
        this.Clientes = Clientes;
    }

    public AdminHotel() {
    }
 
////////////////////////////////////////////////////////////////////////////////
    public void CrearHabitaciones(){
        Scanner n = new Scanner(System.in);
        double precioHabitacion;
        System.out.println("Costo que desea para las habitaciones: ");
        precioHabitacion = n.nextDouble();
        for(int i=1;i<=6;i+=1){
            for(int j=1;j<=10;j+=1){
                Habitacion nuevaHabitacion= new Habitacion();
                nuevaHabitacion.setNumero(j);
                switch(i){
                    case 1:
                        nuevaHabitacion.setPiso("A");
                        nuevaHabitacion.setIdHabitacion("A"+j);
                        break;
                    case 2:
                        nuevaHabitacion.setPiso("B");
                        nuevaHabitacion.setIdHabitacion("B"+j);
                        break;
                    case 3:
                        nuevaHabitacion.setPiso("C");
                        nuevaHabitacion.setIdHabitacion("C"+j);
                        break;
                    case 4:
                        nuevaHabitacion.setPiso("D");
                        nuevaHabitacion.setIdHabitacion("D"+j);
                        break;
                    case 5:
                        nuevaHabitacion.setPiso("E");
                        nuevaHabitacion.setIdHabitacion("E"+j);
                        break;
                    case 6:
                        nuevaHabitacion.setPiso("F");
                        nuevaHabitacion.setIdHabitacion("F"+j);
                        break;
                    default:
                        System.out.println("Ha habido un error creando las habitaciones");
                        break;
                }
                nuevaHabitacion.setPrecioHabitacion(precioHabitacion);
                nuevaHabitacion.Disponibilidad();
                Habitaciones.add(nuevaHabitacion);
            }
        }
        System.out.println("*****BIENVENIDO AL HOTEL VIÑA RAFINHA***********");
        System.out.println("Se han creado todas las habitaciones con exito!");
    }
////////////////////////////////////////////////////////////////////////////////    
    public void ModificarHabitacion(){
        Scanner n = new Scanner(System.in);
        int opcion;
        System.out.println("1.Cambiar precio ");
        System.out.println("2.Habilitar/Deshabilitar una habitacion");
        System.out.println("3.Habilitar/Deshabilitar un piso");
        opcion = n.nextInt();
        switch(opcion){
            case 1:
                PrecioHabitacion();
                break;
            case 2:
                HabilitarHabitacion();
                break;
            case 3:
                HabilitarPiso();
                break;
            default:
                System.out.println("Ha ingresado una opcion invalida");
                break;
        }
    }
    
    public void PrecioHabitacion(){
        Scanner n = new Scanner(System.in);
        String idHabitacion;
        int opcion;
        boolean bandera = false;
        System.out.println("Digite el id habitacion desea modificar(Piso y NHabitacion): ");
        idHabitacion = n.nextLine();
        for(Habitacion habitacion:Habitaciones){
            System.out.println(habitacion.getIdHabitacion());
            if(habitacion.getIdHabitacion().equals(idHabitacion)){
                double nuevoPrecio;
                System.out.println("Ingrese el nuevo precio de la habitacion:");
                nuevoPrecio = n.nextInt();
                habitacion.setPrecioHabitacion(nuevoPrecio);
                System.out.println("El precio de la habitacion "+habitacion.getIdHabitacion()+" ha sido actualizado con exito!");
                bandera = true;
                break;
            }
        }
        if(!bandera){
            System.out.println("La habitacion no fue encontrada. ");
        }
    }
    
    public void HabilitarHabitacion(){
        Scanner n = new Scanner(System.in);
        String idHabitacion;
        int dia, opcion;
        System.out.println("1.Habilitar Habitacion");
        System.out.println("2.Deshabilitar Habitacion");
        opcion=n.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Ingrese el codigo de la habitacion a habiliar:");
                idHabitacion=n.next();
                System.out.println("Ingrese el día en que lo desea habilitar");
                dia = n.nextInt() - 1;
                for(Habitacion h: Habitaciones){
                    if(idHabitacion.equals(h.getIdHabitacion())){
                        h.DisponibilidadMes.set(dia,"Disponible");
                        System.out.println(h.getIdHabitacion()+" ha sido habilitada");
                    }
                }
                break;
            case 2:
                System.out.println("Ingrese el codigo de la habitacion a deshabilitar:");
                idHabitacion=n.next();
                System.out.println("Ingrese el dia que desea inhabilitar");
                dia = n.nextInt() - 1;
                for(Habitacion h: Habitaciones){ 
                    if(idHabitacion.equals(h.getIdHabitacion())){
                        h.DisponibilidadMes.set(dia, "No disponible");
                        System.out.println(h.getIdHabitacion()+" ha sido deshabilitada");
                    }
                }
                break;
            default:
                System.out.println("Ha ingresado una opcion no valida");
        }
    }
    
    public void HabilitarPiso(){
        Scanner n = new Scanner(System.in);
        String piso;
        int opcion,dia;
        
        System.out.println("Ingrese el piso a modificar:");
        piso = n.nextLine();
        System.out.println("1.Habilitar Piso");
        System.out.println("2.Deshabilitar Piso");
        opcion = n.nextInt();
        System.out.println("Dia en que desea habilitar/inhabilitar el piso");
        dia = n.nextInt() - 1;
        
        for(Habitacion h: Habitaciones){
            if(piso.equals(h.getPiso())){
                switch(opcion){
                    case 1:
                        h.DisponibilidadMes.set(dia,"Disponible");
                        break;
                    case 2:
                        h.DisponibilidadMes.set(dia,"No disponible");
                        break;
                    default:
                        System.out.println("Ingreso una opcion no valida");
                }
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////   
    public void MostrarHabitacionesDisponibles(){
        Scanner n = new Scanner(System.in);
        int dia;
        System.out.println("Digite el día en que desea ver la disponibilidad de las habitaciones");
        dia = n.nextInt() - 1;
        for(Habitacion h: Habitaciones){
            System.out.println("La habitacion "+h.getIdHabitacion()+" se encuentra "+h.DisponibilidadMes.get(dia));
        }
    }
////////////////////////////////////////////////////////////////////////////////    
    public void AgregarCliente(){
        boolean existeCliente=false;
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.getInfoCliente();
        for(Cliente c: Clientes){
            if(c.getDui().equals(nuevoCliente.getDui())){
                existeCliente=true;
            }
        }
        if(existeCliente){
            System.out.println("Este cliente ya existia en los registros del hotel");
        }else{
            nuevoCliente.setPaquetes(Paquetes);
            nuevoCliente.setHabitaciones(Habitaciones);
            Clientes.add(nuevoCliente);
        }
    }
////////////////////////////////////////////////////////////////////////////////
    public void MostrarReservacion(){
        for(Cliente c: Clientes){
            c.MostrarReservaciones();
        }
    }
////////////////////////////////////////////////////////////////////////////////
    public void HacerReservacion(){
        Scanner n = new Scanner(System.in);
        String dui;
        boolean existeCliente = false;
        
        System.out.println("Dui: ");
        dui = n.nextLine();
        for(Cliente c: Clientes){
            if(c.getDui().equals(dui)){
                if(c.VerificarReservacion()){
                    existeCliente=true;
                    ComenzarReservacion(c);
                }
                else{
                    System.out.println("El cliente ya tiene mas de 2 reservas");
                } 
            }
        }
        if(!existeCliente){
            System.out.println("Para poder hacer una reserva primero debe agregar al cliente.");
        }
    }
    
    public void ComenzarReservacion(Cliente cliente){
        Scanner n = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean bandera = true;
        String piso="",nombrePaquete = "";
        int numeroHabitacion = 0;
        while(bandera){
            System.out.println("En que piso le gustaria la habitacion(A,B,C,D,E,F): ");
            piso = n.nextLine();
            switch(piso){
                case "A":
                case "B":
                case "C":
                case "D":
                case "E":
                case "F":
                    bandera = false;
                    break;
                default:
                    System.out.println("La letra que digito no corresponde con ninguno de los pisos.");
                    break;
            }
        }
        while(!bandera){
            System.out.println("Que numero de habitacion desea(recuerde las pares son dobles y las impares sencillas): ");
            numeroHabitacion = n.nextInt();
            if(numeroHabitacion >=0 && numeroHabitacion <=10){
                bandera = true;
            }
            else{
                System.out.println("Solo son 10 habitaciones por piso");
            }
        }
        while(bandera){
            MostrarPaquetes();
            System.out.println("¿Que paquete desea? (si no desea ninguno escriba Ninguno) ");
            nombrePaquete = input.nextLine();
            if(PaqueteExiste(nombrePaquete)){
                bandera = false;
            }
            if("Ninguno".equals(nombrePaquete)){
                bandera = false;
            }
            else{
                System.out.println("No se encontro el paquete.");
            }
        }
        cliente.setPaquetes(Paquetes);
        cliente.setHabitaciones(Habitaciones);
        cliente.NuevaReservacion(nombrePaquete, piso, numeroHabitacion);
    }
    
    public void MostrarPaquetes(){
        System.out.println("Los paquetes disponibles son los siguientes: ");
            for(Paquete paquetes:Paquetes){
                System.out.println("Nombre: " + paquetes.getNombrePaquete());
                System.out.println("Contenido: " + paquetes.getContenidoPaquete());
                System.out.println("Precio: " + paquetes.getPrecioPaquete());
            }
    }
    
    public boolean PaqueteExiste(String nombrePaquete){
        for(Paquete paquetes: Paquetes){
            if(paquetes.getNombrePaquete().equals(nombrePaquete)){
                return true;
            }
        }
        return false;
    }
////////////////////////////////////////////////////////////////////////////////
    public void CancelarReservacion(){
        Scanner n = new Scanner(System.in);
        String dui;
        System.out.println("Dui: ");
        dui = n.nextLine();
        for(Cliente cliente:Clientes){
            if(cliente.getDui().equals(dui)){
                cliente.CancelarReservacion();
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////
    public void ModificarReservacion(){
        Scanner n = new Scanner(System.in);
        Scanner f = new Scanner(System.in);        
        String dui,piso;
        int numeroHabitacion;
        System.out.println("Dui: ");
        dui = n.nextLine();
        System.out.println("En cual numero de habitacion se encuentra: ");
        numeroHabitacion = n.nextInt();
        System.out.println("En cual piso se envuentra: ");
        piso = f.nextLine();
        for(Cliente cliente: Clientes){
            if(cliente.getDui().equals(dui)){
                cliente.setPaquetes(Paquetes);
                cliente.setHabitaciones(Habitaciones);
                cliente.ModificarReservacion(cliente.getInfoCliente(),piso,numeroHabitacion);
                Habitaciones = cliente.getHabitaciones();
            }
        }
    }
    
    
    public void ModificarPaquetes(){
        Scanner n = new Scanner(System.in);
        int opcion;
        boolean bandera = true;
        while(bandera){
            System.out.println("1.Mostrar paquetes");
            System.out.println("2.Cambiar precio");
            System.out.println("3.Cambiar contenido");
            System.out.println("4.Salir");
            opcion = n.nextInt();
            switch(opcion){
                case 1:
                    MostrarPaquetes();
                    break;
                case 2:
                    CambiarPrecioPaquete();
                    break;
                case 3:
                    CambiarContenidoPaquete();
                    break;
                case 4:
                    bandera = false;
                    break;
                default:
                    System.out.println("Ha ingresado un opcion invalida");
                    break;
            }
        }
    }
    public void CambiarPrecioPaquete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que paquete desea cambiar? ");
        String n = sc.nextLine();
        Paquetes.forEach((Paquete paque) -> {
            if(paque.nombrePaquete.equals(n)){
                System.out.println("Nuevo precio del paquete: ");
                double precioNuevo = sc.nextDouble();
                paque.precioPaquete = precioNuevo;
            }
            else{
                System.out.println("El paquete que desea no existe o ya no esta disponible");
            }
        });
    }
    
    public void CambiarContenidoPaquete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que paquete desea cambiar? ");
        String n = sc.nextLine();
        Paquetes.forEach((Paquete paque) -> {
            if(paque.nombrePaquete.equals(n)){
                System.out.println("Nuevo contenido del paquete: ");
                String precioNuevo = sc.nextLine();
                paque.contenidoPaquete = precioNuevo;
            }
            else{
                System.out.println("El paquete que desea no existe o ya no esta disponible");
            }
        });
    }
////////////////////////////////////////////////////////////////////////////////
    public void PaquetesPredeterminados(){
        if(Paquetes == null || Paquetes.isEmpty()){
            Paquete paqueteBasico = new Paquete("Basico","Acceso a la pisina y acceso a internet ilimitado",10);
            Paquetes.add(paqueteBasico);
            Paquete paquetePremium = new Paquete("Premium","acceso al buffet de desayuno, acceso ilimitado a la pisina, servicio a la habitacion,"
                    + "acceso ilimitado al minibar y acceso a internet ilimitado",150);
            Paquetes.add(paquetePremium);
        }
    }