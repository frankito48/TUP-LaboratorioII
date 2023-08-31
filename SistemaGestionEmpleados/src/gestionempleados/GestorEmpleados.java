package gestionempleados;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorEmpleados {

    //Atributo de Gestor de Empleados
    private ArrayList<Empleado> empleados;
    private Scanner scanner;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void modificarEmpleado(int indice, Empleado nuevoEmpleado) {
        empleados.set(indice, nuevoEmpleado);
    }

    public void eliminarEmpleado(int indice) {
        empleados.remove(indice);
    }

    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }

    public Empleado obtenerEmpleado(int indice) {
        return empleados.get(indice);
    }

    public int obtenerIndicePorID(int id){
        for (int i = 0; i < empleados.size(); i++){
            if (empleados.get(i).id == id){
                return i;
            }
        }
        return -1;
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println(empleado.nombre + " - Sueldo: " + empleado.calcularSueldo());
        }
    }
}
