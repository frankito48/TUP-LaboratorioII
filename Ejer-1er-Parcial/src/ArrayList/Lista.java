import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lista {
    public static void main(String[] args) {
        ArrayList<Integer> miLista = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Inicializa miLista con 5 números enteros de ejemplo
        miLista.add(10);
        miLista.add(20);
        miLista.add(30);
        miLista.add(40);
        miLista.add(50);

        // Lee un número entero n y agrégalo al final de miLista
        try {
            System.out.print("Ingrese un número entero para agregar al final de la lista: ");
            int n = scanner.nextInt();
            miLista.add(n);
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero válido.");
            return;
        }

        // Lee un número entero posición y muestra el elemento en esa posición
        try {
            System.out.print("Ingrese una posición para obtener el elemento: ");
            int posicion = scanner.nextInt();
            if (posicion < 0 || posicion >= miLista.size()) {
                System.out.println("Error: La posición ingresada no es válida.");
            } else {
                int elemento = miLista.get(posicion);
                System.out.println("Elemento en la posición " + posicion + ": " + elemento);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero válido.");
        }

        // Lee un número entero índice y elimina el elemento en esa posición
        try {
            System.out.print("Ingrese un índice para eliminar un elemento: ");
            int indice = scanner.nextInt();
            if (indice < 0 || indice >= miLista.size()) {
                System.out.println("Error: El índice ingresado no es válido.");
            } else {
                miLista.remove(indice);
                System.out.println("Elemento en la posición " + indice + " eliminado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero válido.");
        }

        // Muestra el contenido actual de miLista
        System.out.println("Contenido actual de la lista:");
        for (int elemento : miLista) {
            System.out.print(elemento + " ");
        }

        // Cierra el scanner
        scanner.close();
    }
}
