package sistemagestiontransporteturistico;

import java.util.ArrayList;

public class EmpresaTurismo {
    private ArrayList<Vehiculo> vehiculos;

    public EmpresaTurismo() {
        this.vehiculos = new ArrayList<>();
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
                
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(vehiculo.getPatente())){
                System.out.println("Error. Ya existe un vehiculo con esa patente\n\n");
                return;
            }
        }
    
        vehiculos.add(vehiculo);
        System.out.println("Vehiculo agregado correctamente\n");
    }
    
    
    public void mostrarVehiculos() {
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados");
            return;
        }
        System.out.println("\nVEHICULOS REGISTRADOS\n");
        for (Vehiculo v : vehiculos) {
            v.mostrarInformacion();
        }
        
    }
    
    public void iniciarServicioTuristico() {
         for (Vehiculo v : vehiculos) {
             if (v instanceof ServicioTuristico) {
                 ((ServicioTuristico) v).realizarServicio();
             } else {
                 System.out.println("La van de patente " + v.getPatente() + " no realiza serivicios turisticos");
             }
            
        }
         System.out.println("==========================================================\n");
    }
    public void buscarPorPatente(String patente) {
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados");
            return;
        }
        
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)){
                System.out.println("\n\nVEHICULO ENCONTRADO CON PATENTE " + patente);
                v.mostrarInformacion();
                System.out.println();
                return;
            }
        }
        System.out.println("No existe ningun vehiculo registrado con esa patente\n\n");
    }
    
    public void mostrarVehiculosConCapacidad(int capacidad) {
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados");
            return;
        }
        int encontrados = 0;
        for (Vehiculo v : vehiculos) {
            if (v.getCapacidadPasajeros() > capacidad) {
                    v.mostrarInformacion();
                    encontrados++;
            }
        }
        System.out.println();        
        if (encontrados == 0) {
            System.out.println("No se encontraron vehiculos con capacidad para mas de " + capacidad + " personas\n\n");
        }
        
    }
            
}
