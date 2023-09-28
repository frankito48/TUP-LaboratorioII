package Problema1;

public class Main {
    public static void main(String[] args) {
        // Crear una cuenta con saldo inicial
        Cuenta cuenta1 = new Cuenta("Juan", 1000.0);

        // Ingresar dinero en la cuenta
        cuenta1.ingresar(500.0);

        // Retirar dinero de la cuenta
        cuenta1.retirar(200.0);

        // Mostrar información de la cuenta
        System.out.println(cuenta1);
    }
}

