package gestionempleados;

public class EmpleadoAsalariado extends Empleado implements Impuesto{

    //Constructores
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    //Metodo heredado de la superclase Empleado
    public double calcularSueldo(){
        return this.sueldoBase;
    }


    //Metodo implementado, Interfaz de Impuesto
    @Override
    public double calcularImpuesto(){
        return 0.1;
    }
}
