package sistemagestiontransporteturistico;

import java.util.Comparator;

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

    public static Comparator<Vehiculo> POR_ANIO_DESC = new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo v1, Vehiculo v2) {
                return Integer.compare(v2.anioFabricacion,v1.anioFabricacion);
            }
    };
    
    public static Comparator<Vehiculo> POR_CAPACIDAD_DESC = new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo v1, Vehiculo v2) {
                return Integer.compare(v2.capacidadPasajeros,v1.capacidadPasajeros);
            }
    };
    
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
