package gestionempleados;

public class EmpleadoComision extends Empleado implements Impuesto {

    //Atributo propio de la subclase
    private double ventasRealizadas;


    //Constructor
    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    //Metodo heredad de la superclase Empleado
    public double calcularSueldo() {
        return this.sueldoBase + ventasRealizadas;
    }

    //Metodo implementado, Interfaz de Impuesto
    @Override
    public double calcularImpuesto() {
        return 0.08;
    }
}
