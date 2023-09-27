package GestionCuentas;
import java.util.ArrayList;
class GestorCuentas {
    private ArrayList<CuentaPersona> cuentasPersonas;
    private ArrayList<CuentaSociedad> cuentasSociedades;

    public GestorCuentas() {
        cuentasPersonas = new ArrayList<>();
        cuentasSociedades = new ArrayList<>();
    }

    public void agregarCuentaPersona(CuentaPersona cuenta) {
        cuentasPersonas.add(cuenta);
    }

    public void agregarCuentaSociedad(CuentaSociedad cuenta) {
        cuentasSociedades.add(cuenta);
    }

    public void eliminarCuentaPersona(String numeroCuenta) {
        cuentasPersonas.removeIf(cuenta -> cuenta.numeroCuenta.equals(numeroCuenta));
    }

    public void eliminarCuentaSociedad(String numeroCuenta) {
        cuentasSociedades.removeIf(cuenta -> cuenta.numeroCuenta.equals(numeroCuenta));
    }

    public void editarCuentaPersona(String numeroCuenta, double nuevoSaldo) {
        for (CuentaPersona cuenta : cuentasPersonas) {
            if (cuenta.numeroCuenta.equals(numeroCuenta)) {
                cuenta.saldo = nuevoSaldo;
                break;
            }
        }
    }

    public void editarCuentaSociedad(String numeroCuenta, double nuevoSaldo) {
        for (CuentaSociedad cuenta : cuentasSociedades) {
            if (cuenta.numeroCuenta.equals(numeroCuenta)) {
                cuenta.saldo = nuevoSaldo;
                break;
            }
        }
    }

    public void mostrarTodasLasCuentas() {
        System.out.println("Cuentas de Personas:");
        for (CuentaPersona cuenta : cuentasPersonas) {
            cuenta.mostrarInformacion();
            System.out.println();
        }

        System.out.println("Cuentas de Sociedades:");
        for (CuentaSociedad cuenta : cuentasSociedades) {
            cuenta.mostrarInformacion();
            System.out.println();
        }
    }
}