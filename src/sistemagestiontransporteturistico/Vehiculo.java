package sistemagestiontransporteturistico;

public abstract class Vehiculo {
    protected String patente;
    protected String marca;
    protected int capacidadPasajeros;
    protected int anioFabricacion;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }

    public String getPatente() {
        return patente;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }
    
    
    protected void mostrarInformacion() {
        System.out.print("Patente: " + patente);
        System.out.print("\t\tMarca: " + marca);
        System.out.println("\tCapacidadPasajeros: " + capacidadPasajeros);
        System.out.print("Año de fabricacion: " + anioFabricacion);
    }
    
    
}
