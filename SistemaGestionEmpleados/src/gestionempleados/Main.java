package gestionempleados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("1. Agregar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                Empleado empleado = null;

                //"Menu" Principal
                switch (opcion) {
                    case 1:
                        // Agregar empleado
                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese el ID del empleado: ");
                        int id = scanner.nextInt();

                        System.out.print("Ingrese el sueldo base del empleado: ");
                        double sueldoBase = scanner.nextDouble();

                        System.out.println("Seleccione el tipo de empleado:");
                        System.out.println("1. Por horas");
                        System.out.println("2. Asalariado");
                        System.out.println("3. Por comisión");
                        int tipoEmpleado = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea


                        //2do "Menu" para clasificar a los empleados
                        switch (tipoEmpleado) {
                            case 1:
                                System.out.print("Ingrese las horas trabajadas: ");
                                int horasTrabajadas = scanner.nextInt();
                                empleado = new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas);
                                break;
                            case 2:
                                empleado = new EmpleadoAsalariado(nombre, id, sueldoBase);
                                break;
                            case 3:
                                System.out.print("Ingrese las ventas realizadas: ");
                                double ventasRealizadas = scanner.nextDouble();
                                empleado = new EmpleadoComision(nombre, id, sueldoBase, ventasRealizadas);
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }

                        if (empleado != null) {
                            gestor.agregarEmpleado(empleado);
                            System.out.println("Empleado agregado con éxito.");
                        }
                        break;

                    case 2:
                        // Modificar empleado
                        System.out.print("Ingrese el ID del empleado a modificar: ");
                        int idModificar = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        int indiceModificar = gestor.obtenerIndicePorID(idModificar);

                        if (indiceModificar != -1) {
                            Empleado empleadoExistente = gestor.obtenerEmpleado(indiceModificar);

                            System.out.println("Seleccione el dato que desea modificar:");
                            System.out.println("1. Nombre");
                            System.out.println("2. Sueldo base");

                            if (empleadoExistente instanceof EmpleadoPorHoras) {
                                System.out.println("3. Horas trabajadas");
                            }

                            int opcionModificar = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            //3er "Menu" para seleccionar que dato modifiacar del empleado elegido.
                            switch (opcionModificar) {
                                case 1:
                                    System.out.print("Ingrese el nuevo nombre del empleado: ");
                                    String nuevoNombre = scanner.nextLine();
                                    empleadoExistente.nombre = nuevoNombre;
                                    break;

                                case 2:
                                    System.out.print("Ingrese el nuevo sueldo base del empleado: ");
                                    double nuevoSueldoBase = scanner.nextDouble();
                                    empleadoExistente.sueldoBase = nuevoSueldoBase;
                                    break;

                                case 3:
                                    if (empleadoExistente instanceof EmpleadoPorHoras) {
                                        System.out.print("Ingrese las nuevas horas trabajadas: ");
                                        int nuevasHorasTrabajadas = scanner.nextInt();
                                        ((EmpleadoPorHoras) empleadoExistente).horasTrabajadas = nuevasHorasTrabajadas;
                                    } else {
                                        System.out.println("Opción no válida para este tipo de empleado.");
                                    }
                                    break;

                                default:
                                    System.out.println("Opción no válida.");
                            }

                            gestor.modificarEmpleado(indiceModificar, empleadoExistente);
                            System.out.println("Empleado modificado con éxito.");
                        } else {
                            System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                        }
                        break;

                    case 3:
                        // Eliminar empleado
                        System.out.print("Ingrese el ID del empleado a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        int indiceEliminar = gestor.obtenerIndicePorID(idEliminar);
                        if (indiceEliminar != -1){
                            gestor.eliminarEmpleado(indiceEliminar);
                            System.out.println("Empleado eliminado con éxito.");
                        } else {
                            System.out.println("No se encontró ningún empleado con el ID proporcionado.");
                        }
                        break;

                    case 4:
                        // Mostrar empleados
                        gestor.mostrarEmpleados();
                        break;

                    case 5:
                        System.out.println("¡Hasta luego!");
                        scanner.close();
                        System.exit(0);
                        break;



                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
    }
}
