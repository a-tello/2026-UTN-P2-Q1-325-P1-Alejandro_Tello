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
                System.out.println("Error. Ya existe un vehiculo con esa patente");
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
//    public Vehiculo buscarPorPatente(String patente) {
//        for (Vehiculo v : vehiculos) {
//            if (v.getPatente().equals(patente)){
//                return v;
//            }
//        }
//    }
            
}
