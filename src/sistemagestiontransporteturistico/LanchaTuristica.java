package sistemagestiontransporteturistico;

public class LanchaTuristica extends Vehiculo{
    private TipoMotor tipoMotor;

    public LanchaTuristica(String patente, String marca, int capacidadPasajeros, int anioFabricacion, TipoMotor tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.tipoMotor = tipoMotor;
    }

    @Override
    protected void mostrarInformacion() {
        System.out.println("Tipo de vehiculo: Lancha Turistica");
        super.mostrarInformacion(); 
        System.out.print("\t\tTipo de motor: " + tipoMotor);
        System.out.println("\n====================================================");
    }
    
    
}
