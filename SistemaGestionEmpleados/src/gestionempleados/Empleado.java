package gestionempleados;

//Atributos superclase
public abstract class Empleado {
    protected String nombre;
    protected int id;
    protected double sueldoBase;

    //Constructores
    public Empleado(String nombre, int id, double sueldoBase) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
    }

    //Metodo Abstracto
    public abstract double calcularSueldo();
}
