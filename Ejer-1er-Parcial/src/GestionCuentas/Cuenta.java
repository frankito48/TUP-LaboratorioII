package GestionCuentas;

abstract class Cuenta {
    protected String numeroCuenta;
    protected double saldo;

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public abstract void depositar(double cantidad);

    public abstract void retirar(double cantidad);

    public abstract void mostrarInformacion();
}