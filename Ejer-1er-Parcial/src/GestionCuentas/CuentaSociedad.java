package GestionCuentas;

class CuentaSociedad extends Cuenta {
    private String nombreEmpresa;
    private String tipoEmpresa;

    public CuentaSociedad(String numeroCuenta, double saldo, String nombreEmpresa, String tipoEmpresa) {
        super(numeroCuenta, saldo);
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
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
        System.out.println("Nombre de la Empresa: " + nombreEmpresa);
        System.out.println("Tipo de Empresa: " + tipoEmpresa);
        System.out.println("Saldo: " + saldo);
    }
}
