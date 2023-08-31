package gestionempleados;

public class EmpleadoPorHoras extends Empleado implements Impuesto {
    public int horasTrabajadas;

    //Constructor de la subclase
    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    //Metodo heredado de la superclase
    public double calcularSueldo(){
        return this.sueldoBase * this.horasTrabajadas;
    }

    //Metodo implementado de la interfaz de Impuesto
    @Override
    public double calcularImpuesto() {
        return 0.05;
    }
}
