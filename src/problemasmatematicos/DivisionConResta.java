package problemasmatematicos;

public class DivisionConResta {

    // Enfoque recursivo para la división
    public static int divisionRecursiva(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        if (dividend < divisor) {
            return 0;
        }
        return 1 + divisionRecursiva(dividend - divisor, divisor);
    }

    // Enfoque iterativo para la división utilizando restas sucesivas
    public static int divisionIterativa(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        int quotient = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }
        return quotient;
    }

    public static void main(String[] args) {
        int dividend = 25;
        int divisor = 5;

        System.out.println("División recursiva: " + divisionRecursiva(dividend, divisor));
        System.out.println("División iterativa: " + divisionIterativa(dividend, divisor));
    }
}
