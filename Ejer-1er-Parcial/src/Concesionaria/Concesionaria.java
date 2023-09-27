package Concesionaria;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Concesionaria implements Serializable {
    private ArrayList<Vehiculo> inventario = new ArrayList<>();

    public void agregarVehiculo(Vehiculo vehiculo) {
        inventario.add(vehiculo);
    }

    public void eliminarVehiculo(String marca, String modelo) {
        inventario.removeIf(v -> v.getMarca().equals(marca) && v.getModelo().equals(modelo));
    }

    public void editarPrecio(String marca, String modelo, double nuevoPrecio) {
        for (Vehiculo vehiculo : inventario) {
            if (vehiculo.getMarca().equals(marca) && vehiculo.getModelo().equals(modelo)) {
                vehiculo.setPrecio(nuevoPrecio);
                break;
            }
        }
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("La concesionaria está vacía.");
        } else {
            System.out.println("Inventario de la Concesionaria:");
            for (Vehiculo vehiculo : inventario) {
                vehiculo.mostrarInformacion();
                System.out.println();
            }
        }
    }

    // Implementación de los métodos de la interfaz Serializable
    @Override
    public void guardar(String nombreArchivo) throws IOException {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
            System.out.println("Concesionaria guardada en " + nombreArchivo);
        }
    }

    @Override
    public void cargar(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Concesionaria concesionaria = (Concesionaria) entrada.readObject();
            this.inventario = concesionaria.inventario;
            System.out.println("Concesionaria cargada desde " + nombreArchivo);
        }
    }
}
