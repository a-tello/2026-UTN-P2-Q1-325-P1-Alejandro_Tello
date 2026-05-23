package sistemagestiontransporteturistico;

import java.util.Scanner;

public class SistemaGestionTransporteTuristico {

    public static Scanner scanner = new Scanner(System.in);
    public static EmpresaTurismo empTurismo = new EmpresaTurismo();
    
    public static void main(String[] args) {
        
//       Vehiculos creados para prueba
//       Vehiculo colectivo = new ColectivoTuristico("AAA111", "VW", 45, 2020, 2);
//       Vehiculo van = new VanEjecutiva("AAA222", "Toyota", 20, 215, true);
//       Vehiculo lancha = new LanchaTuristica("ASK84", "Mercury", 5, 2022, TipoMotor.DIESEL);
        
//        empTurismo.agregarVehiculo(colectivo);
//        empTurismo.agregarVehiculo(van);
//        empTurismo.agregarVehiculo(lancha);
    
        while (true){
            mostrarMenu();
            System.out.println("\nSeleccione una opcion: ");
            validarEntero();
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    ingresarDatosVehiculo();
                    break;
                case 2:
                    empTurismo.mostrarVehiculos();
                    break;
                case 3:
                    empTurismo.iniciarServicioTuristico();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("\nIngrese la patente del vehiuclo buscado: ");
                    String patente = validarString("La patente no puede estar vacia");
                    empTurismo.buscarPorPatente(patente);
                    break;
                case 5:
                    System.out.print("\n\nIngrese capacidad minima de los vehiculos: ");
                    validarEntero();
                    int capacidad = scanner.nextInt();
                    empTurismo.mostrarVehiculosConCapacidad(capacidad);
                    break;
                case 6:
                    empTurismo.mostrarOrdenadosPor(Vehiculo.POR_ANIO_DESC);
                    break;
                case 7:
                    empTurismo.mostrarOrdenadosPor(Vehiculo.POR_CAPACIDAD_DESC);
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Error. Debe ingresar una opcion entre 1-8\n");
                    break;   
            }
        }
    
    
    }
    
    public static void mostrarMenu() {
        System.out.println("BIENVENIDO A NUESTRA EMPRESA TURISTICA\n");
        System.out.println("1. Agregar vehiculo");
        System.out.println("2. Mostrar todos los vehiculos");
        System.out.println("3. Realizar servicios turisticos");
        System.out.println("4. Buscar vehiculo por patente");
        System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor ingresado");
        System.out.println("6. Mostrar vehiculos ordenados por año de fabricacion descendente");
        System.out.println("7. Mostrar vehiculos ordenados por capacidad de pasajeros descendente");
        System.out.println("8. Salir");
    }
    
    public static void validarEntero() {
        
        while (!scanner.hasNextInt()) {
            System.out.println("Error. Debe seleccionar un número valido");
            System.out.print("Reingrese: ");
            scanner.next();
        }
    }
    
    public static int validarEnteroRango(int min, int max, String mensajeError) {
        int dato;
        do {
            validarEntero();
            dato = scanner.nextInt();
            if (dato < min || dato > max) {
                System.out.println(mensajeError);
                System.out.print("Reingrese: ");
            }
        } while (dato < min || dato > max);
        return dato;
    }
    
    public static String validarString(String mensajeError) {
        String ingreso;
        do {
            ingreso = scanner.nextLine();
            if (ingreso.isEmpty()) {
                System.out.println(mensajeError);
                System.out.print("Reingrese: ");
            }
        } while (ingreso.isEmpty());
        return ingreso;
    }
    
    public static String validarRespuestaS_N() {
        String ingreso;
        do {
            ingreso = scanner.nextLine();
            
            if (!ingreso.equalsIgnoreCase("S") && !ingreso.equalsIgnoreCase("N")) {
                System.out.println("Debe seleccionar una respuesta S o N");
                System.out.print("Reingrese: ");
            }
        } while (!ingreso.equalsIgnoreCase("S") && !ingreso.equalsIgnoreCase("N"));
        return ingreso;
    }
    
    public static void ingresarDatosVehiculo() {
        System.out.println("\nTIPOS DE VEHICULOS\n");
        System.out.println("1. Colectivo");
        System.out.println("2. Van");
        System.out.println("3. Lancha");
        System.out.print("Seleccione tipo de vehiculo: ");
        
        int vehiculo = validarEnteroRango(1, 3, "Error. Debe elegir el numero de los vehiculos mostrados");
        
        scanner.nextLine();
        
        System.out.print("Ingrese patente: ");
        String patente = validarString("La patente no puede estar vacia");
        
        System.out.print("Ingrese marca del vehiculo: ");
        String marca = scanner.nextLine();
        
        System.out.print("Ingrese capacidad: ");
        int capacidad = scanner.nextInt();
        if (capacidad < 1) {
            System.out.println("ERROR. La cantidad de pasajeros debe ser mayor a 0. Intente una nueva carga\n\n");
            return;
        }
        
        System.out.print("Ingrese año de fabricacion: ");
        int fabricacion = validarEnteroRango(1990, 2026, "El año ingresado debe estar entre 1990 y 2026");
        
        switch (vehiculo) {
            case 1:
                System.out.print("Ingrese cantidad de pisos(1-2): ");
                int pisos = validarEnteroRango(1, 2, "La cantidad de pisos debe estar entre 1 y 2");
                Vehiculo colectivo = new ColectivoTuristico(patente, marca, capacidad, fabricacion, pisos);
                empTurismo.agregarVehiculo(colectivo);
                break;
            case 2:
                System.out.print("Tiene aire acondicionado? (S/N): ");
                scanner.nextLine();
                String tieneAire = validarRespuestaS_N();
                boolean aire;
                
                if (tieneAire.equalsIgnoreCase("S")) {
                    aire = true;
                } else {
                    aire = false;
                }
                
                Vehiculo van = new VanEjecutiva(patente, marca, capacidad, fabricacion, aire);
                empTurismo.agregarVehiculo(van);
                break;
            case 3:
                System.out.println("\nTIPO DE MOTOR\n");
                System.out.println("1. Nafta");
                System.out.println("2. Diesel");
                System.out.println("3. Electrico");
                System.out.print("Ingrese tipo de motor: ");
                
                int opcionMotor = validarEnteroRango(1, 3, "Error. Debe seleccionar unos de los 3 tipos de motores");
                TipoMotor tipo;
                if (opcionMotor == 1) {
                    tipo = TipoMotor.NAFTA;
                } else if (opcionMotor == 2) {
                    tipo = TipoMotor.DIESEL;
                } else {
                    tipo = TipoMotor.ELECTRICO;
                }
                
                Vehiculo lancha = new LanchaTuristica(patente, marca, capacidad, fabricacion, tipo);
                empTurismo.agregarVehiculo(lancha);
                break;
        }
    }
    
}
