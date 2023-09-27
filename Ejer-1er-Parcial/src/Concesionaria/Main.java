package Concesionaria;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concesionaria concesionaria = new Concesionaria();

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
                        concesionaria.agregarVehiculo(new Auto(marca, modelo, precio));
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
                        concesionaria.guardar("concesionaria.ser");
                    } catch (IOException e) {
                        System.out.println("Error al guardar la concesionaria: " + e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        concesionaria.cargar("concesionaria.ser");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error al cargar la concesionaria: " + e.getMessage());
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