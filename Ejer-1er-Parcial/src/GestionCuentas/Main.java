package GestionCuentas;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorCuentas gestor = new GestorCuentas();

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar cuenta de persona");
            System.out.println("2. Agregar cuenta de sociedad");
            System.out.println("3. Eliminar cuenta de persona");
            System.out.println("4. Eliminar cuenta de sociedad");
            System.out.println("5. Editar saldo de cuenta de persona");
            System.out.println("6. Editar saldo de cuenta de sociedad");
            System.out.println("7. Mostrar todas las cuentas");
            System.out.println("8. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después del número

            switch (opcion) {
                case 1:
                    System.out.print("Número de Cuenta: ");
                    String numCuenta = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldoPersona = scanner.nextDouble();
                    CuentaPersona cuentaPersona = new CuentaPersona(numCuenta, saldoPersona, nombre, apellido);
                    gestor.agregarCuentaPersona(cuentaPersona);
                    break;
                case 2:
                    System.out.print("Número de Cuenta: ");
                    String numCuentaSociedad = scanner.nextLine();
                    System.out.print("Nombre de la Empresa: ");
                    String nombreEmpresa = scanner.nextLine();
                    System.out.print("Tipo de Empresa: ");
                    String tipoEmpresa = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldoSociedad = scanner.nextDouble();
                    CuentaSociedad cuentaSociedad = new CuentaSociedad(numCuentaSociedad, saldoSociedad, nombreEmpresa, tipoEmpresa);
                    gestor.agregarCuentaSociedad(cuentaSociedad);
                    break;
                case 3:
                    System.out.print("Número de Cuenta de persona a eliminar: ");
                    String numCuentaEliminarPersona = scanner.nextLine();
                    gestor.eliminarCuentaPersona(numCuentaEliminarPersona);
                    break;
                case 4:
                    System.out.print("Número de Cuenta de sociedad a eliminar: ");
                    String numCuentaEliminarSociedad = scanner.nextLine();
                    gestor.eliminarCuentaSociedad(numCuentaEliminarSociedad);
                    break;
                case 5:
                    System.out.print("Número de Cuenta de persona a editar: ");
                    String numCuentaEditarPersona = scanner.nextLine();
                    System.out.print("Nuevo saldo: ");
                    double nuevoSaldoPersona = scanner.nextDouble();
                    gestor.editarCuentaPersona(numCuentaEditarPersona, nuevoSaldoPersona);
                    break;
                case 6:
                    System.out.print("Número de Cuenta de sociedad a editar: ");
                    String numCuentaEditarSociedad = scanner.nextLine();
                    System.out.print("Nuevo saldo: ");
                    double nuevoSaldoSociedad = scanner.nextDouble();
                    gestor.editarCuentaSociedad(numCuentaEditarSociedad, nuevoSaldoSociedad);
                    break;
                case 7:
                    gestor.mostrarTodasLasCuentas();
                    break;
                case 8:
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