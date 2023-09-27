package GestionCuentas;

class CuentaPersona extends Cuenta {
    private String nombre;
    private String apellido;

    public CuentaPersona(String numeroCuenta, double saldo, String nombre, String apellido) {
        super(numeroCuenta, saldo);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
        } else {
            System.out.println("Saldo insuficiente para retirar esa cantidad.");
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Saldo: " + saldo);
    }
}