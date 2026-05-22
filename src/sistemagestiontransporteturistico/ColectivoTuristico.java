package sistemagestiontransporteturistico;

public class ColectivoTuristico extends Vehiculo{
    private int cantidadPisos;

    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros, int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.cantidadPisos = cantidadPisos;
    }
    
    @Override
    protected void mostrarInformacion() {
        System.out.println("Tipo de vehiculo: Colectivo turistico");
        super.mostrarInformacion(); 
        System.out.print("\t\tCantidad de pisos: " + cantidadPisos);
        System.out.println("\n====================================================");
    }
    
}
