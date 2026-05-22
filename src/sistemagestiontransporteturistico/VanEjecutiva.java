package sistemagestiontransporteturistico;

public class VanEjecutiva extends Vehiculo {
    private boolean aireAcondicionado;

    public VanEjecutiva(String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    protected void mostrarInformacion() {
        System.out.println("Tipo de vehiculo: Van ejecutiva");
        super.mostrarInformacion(); 
        System.out.print("\t\tTiene aire acondicionado: " + aireAcondicionado);
        System.out.println("\n====================================================");
    }
    
    
    
}
