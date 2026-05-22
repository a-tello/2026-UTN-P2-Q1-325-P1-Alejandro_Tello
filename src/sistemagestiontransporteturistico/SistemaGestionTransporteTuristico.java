package sistemagestiontransporteturistico;

import java.util.Scanner;

public class SistemaGestionTransporteTuristico {

    public static Scanner scanner = new Scanner(System.in);
    public static EmpresaTurismo empTurismo = new EmpresaTurismo();
    
    public static void main(String[] args) {
        
        
        Vehiculo colectivo = new ColectivoTuristico("AAA111", "VW", 45, 2020, 2);
        Vehiculo van = new VanEjecutiva("AAA222", "Toyota", 20, 215, true);
        Vehiculo lancha = new LanchaTuristica("ASK84", "Mercury", 5, 2022, TipoMotor.DIESEL);
        
        empTurismo.agregarVehiculo(colectivo);
        empTurismo.agregarVehiculo(van);
        empTurismo.agregarVehiculo(lancha);
    
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
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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
            System.out.println("Error. Debe seleccionar un número de opcion");
            System.out.print("Reingrese: ");
            scanner.next();
        }
    }
    
    public static void ingresarDatosVehiculo() {
        System.out.println("\nTIPOS DE VEHICULOS\n");
        System.out.println("1. Colectivo");
        System.out.println("2. Van");
        System.out.println("3. Lancha");
        System.out.print("Seleccione tipo de vehiculo: ");
        
        int vehiculo = scanner.nextInt();
        scanner.hasNext();
        
        System.out.print("Ingrese patente: ");
        String patente = scanner.nextLine();
        System.out.print("Ingrese marca del vehiculo: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese capacidad: ");
        int capacidad = scanner.nextInt();
        System.out.print("Ingrese año de fabricacion: ");
        int fabricacion = scanner.nextInt();
        
        switch (vehiculo) {
            case 1:
                System.out.print("Ingrese cantidad de pisos(1-2): ");
                int pisos = scanner.nextInt();
                Vehiculo colectivo = new ColectivoTuristico(patente, marca, capacidad, fabricacion, pisos);
                empTurismo.agregarVehiculo(colectivo);
                break;
            case 2:
                System.out.print("Ingrese cantidad de pisos(1-2): ");
                String tieneAire = scanner.nextLine();
                boolean aire;
                
                if (tieneAire.equalsIgnoreCase("S")) {
                    aire = true;
                }else {
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
                
                int opcionMotor = scanner.nextInt();
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
