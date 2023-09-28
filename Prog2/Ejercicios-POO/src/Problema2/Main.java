package Problema2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI: ");
        String DNI = scanner.nextLine();

        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la edad: ");
        int edad = scanner.nextInt();

        scanner.nextLine(); // Consumir la línea en blanco en el búfer

        System.out.println("Ingrese el sexo: ");
        char sexo = scanner.next().charAt(0);

        System.out.println("Ingrese el peso: ");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese la altura: ");
        double altura = scanner.nextDouble();

        // Crear objetos de la clase Persona
        Persona persona1 = new Persona(45374402, "Franco", "Romero", 19,'H', 75, 1.70);
        Persona persona2 = new Persona(45374403, "Leo", "Brabo", 20, 'H', 78, 1.70);
        Persona persona3 = new Persona(45374404, "Manu", "Sanchez", 21, 'H', 80, 1.75);


        // Comprobar el peso ideal, mostrar el IMC y si es mayor de edad
        comprobarPesoYEdad(persona1);
        mostrarIMC(persona1);
        mostrarMayorOMenorEdad(persona1);

        comprobarPesoYEdad(persona2);
        mostrarIMC(persona2);
        mostrarMayorOMenorEdad(persona2);

        comprobarPesoYEdad(persona3);
        mostrarIMC(persona3);
        mostrarMayorOMenorEdad(persona3);
    }

    public static void comprobarPesoYEdad(Persona persona) {
        int imc = persona.calcularIMC();
        boolean esMayorDeEdad = persona.esMayorDeEdad();

        if (imc == -1) {
            System.out.println("La persona está por debajo de su peso ideal.");
        } else if (imc == 0) {
            System.out.println("La persona está en su peso ideal.");
        } else {
            System.out.println("La persona tiene sobrepeso.");
        }
    }

    public static void mostrarIMC(Persona persona) {
        int imc = persona.calcularIMC();
        String mensaje = "";

        if (imc == -1) {
            mensaje = "Bajo peso.";
        } else if (imc == 0) {
            mensaje = "Peso ideal.";
        } else {
            mensaje = "Sobrepeso.";
        }

        System.out.println("IMC: " + mensaje);
    }

    public static void mostrarMayorOMenorEdad(Persona persona) {
        if (persona.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad.");
        } else {
            System.out.println("La persona es menor de edad.");
        }
    }
}
