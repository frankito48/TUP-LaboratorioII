package Problema1;

public class Cuenta {
    // Atributos
    private String titular;
    private double cantidad;

    // Constructores
    public Cuenta(String titular) {
        this.titular = titular;
        this.cantidad = 0.0; // Por defecto, la cantidad se inicializa en 0
    }

    public Cuenta(String titular, double cantidadInicial) {
        this.titular = titular;
        if (cantidadInicial >= 0) {
            this.cantidad = cantidadInicial;
        } else {
            this.cantidad = 0.0;
        }
    }

    // Métodos get y set
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            this.cantidad = 0.0;
        }
    }

    // Método para ingresar dinero a la cuenta
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }

    // Método para retirar dinero de la cuenta
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            double nuevoSaldo = this.cantidad - cantidad;
            if (nuevoSaldo < 0) {
                this.cantidad = 0;
            } else {
                this.cantidad = nuevoSaldo;
            }
        }
    }

    // Método toString para representar la cuenta como una cadena
    @Override
    public String toString() {
        return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
    }
}
