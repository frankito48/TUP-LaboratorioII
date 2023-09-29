package EjerConcesionaria;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definición de la clase abstracta Vehiculo
abstract class Vehiculo {
    private String marca;
    private String modelo;
    private double precio;

    public Vehiculo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public abstract double calcularImpuesto();

    public abstract void mostrarInformacion();

    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Sobrescribe el método toString
    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Precio: $" + precio;
    }
}

// Clase Coche que hereda de Vehiculo
class Coche extends Vehiculo {
    public Coche(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public double calcularImpuesto() {
        // Impuesto para un coche (por ejemplo, el 10% del precio)
        return getPrecio() * 0.10;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Coche");
        System.out.println(this);
        System.out.println("Impuesto: $" + calcularImpuesto());
    }
}

// Clase Moto que hereda de Vehiculo
class Moto extends Vehiculo {
    public Moto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public double calcularImpuesto() {
        // Impuesto para una moto (por ejemplo, el 5% del precio)
        return getPrecio() * 0.05;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Moto");
        System.out.println(this);
        System.out.println("Impuesto: $" + calcularImpuesto());
    }
}

// Definición de la interfaz Serializable
interface MostrarInfo {
    void guardar(String nombreArchivo) throws IOException;

    void cargar(String nombreArchivo) throws IOException, ClassNotFoundException;
}

// Clase Concesionaria que implementa la interfaz Serializable
class Concesionaria implements Serializable {

    private String nombreConcesionaria;

    private List<Vehiculo> inventario;

    public Concesionaria(String nombreConcesionaria) {
        this.nombreConcesionaria = nombreConcesionaria;
        this.inventario = new ArrayList<>();
    }

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

    // Implementación de los métodos de la interfaz Serializable
    public void guardar(String nombreArchivo) throws IOException {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            salida.writeObject(this);
            System.out.println("Concesionaria guardada en " + nombreArchivo);
        }
    }

    public Concesionaria cargar(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            Concesionaria concesionariaCargada = (Concesionaria) entrada.readObject();
            this.nombreConcesionaria = concesionariaCargada.nombreConcesionaria;
            this.inventario = concesionariaCargada.inventario;
            System.out.println("Concesionaria cargada desde " + nombreArchivo);
            return this; // Devuelve la instancia actual de la concesionaria
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nombreConcesionaria = "";
        try (Scanner entrada = new Scanner(new File("nombreConcesionaria.txt"))) {
            nombreConcesionaria = entrada.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el nombre de la concesionaria desde el archivo." + e.getMessage());
        }
        Concesionaria concesionaria = new Concesionaria(nombreConcesionaria);

        concesionaria.agregarVehiculo((new Vehiculo("Fiat", "Tornado", 20000) {
            @Override
            public double calcularImpuesto() {
                return 0;
            }

            @Override
            public void mostrarInformacion() {

            }
        }));

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar vehículo");
            System.out.println("2. Eliminar vehículo");
            System.out.println("3. Editar precio de vehículo");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Guardar concesionaria");
            System.out.println("6. Cargar concesionaria");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después del número

            switch (opcion) {
                case 1:
                    System.out.print("Tipo de vehículo (Coche/Moto): ");
                    String tipoVehiculo = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();  // Consumir la nueva línea después del precio

                    if ("Coche".equalsIgnoreCase(tipoVehiculo)) {
                        concesionaria.agregarVehiculo(new Coche(marca, modelo, precio));
                    } else if ("Moto".equalsIgnoreCase(tipoVehiculo)) {
                        concesionaria.agregarVehiculo(new Moto(marca, modelo, precio));
                    } else {
                        System.out.println("Tipo de vehículo no válido.");
                    }
                    break;
                case 2:
                    System.out.print("Marca del vehículo a eliminar: ");
                    String marcaEliminar = scanner.nextLine();
                    System.out.print("Modelo del vehículo a eliminar: ");
                    String modeloEliminar = scanner.nextLine();
                    concesionaria.eliminarVehiculo(marcaEliminar, modeloEliminar);
                    break;
                case 3:
                    System.out.print("Marca del vehículo a editar: ");
                    String marcaEditar = scanner.nextLine();
                    System.out.print("Modelo del vehículo a editar: ");
                    String modeloEditar = scanner.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    scanner.nextLine();  // Consumir la nueva línea después del precio
                    concesionaria.editarPrecio(marcaEditar, modeloEditar, nuevoPrecio);
                    break;
                case 4:
                    concesionaria.mostrarInventario();
                    break;
                case 5:
                    try {
                        concesionaria.guardar("concesionaria.dat");
                    } catch (IOException e) {
                        System.out.println("Error al guardar la concesionaria: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        concesionaria = concesionaria.cargar("concesionaria.dat");
                        System.out.println("Concesionaria cargada con éxito.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error al cargar concesionaria desde el archivo: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
