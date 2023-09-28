package electrodomesticos;

public class Electrodomestico {

    protected double precioBase;
    protected char consumoEnergetico;
    protected String color;
    protected double peso;

    private static final char CONSUMO_DEFECTO = 'F';
    private static final String COLOR_DEFECTO = "Blanco";
    private static final double PRECIO_DEFECTO = 100.00;
    private static final double PESO_DEFECTO = 5.00;

    private char[] consumos = {'A', 'B', 'C', 'D', 'E', 'F'};

    public Electrodomestico() {
        this.precioBase = PRECIO_DEFECTO;
        this.color = COLOR_DEFECTO;
        this.consumoEnergetico = CONSUMO_DEFECTO;
        this.peso = PESO_DEFECTO;
    }

    public Electrodomestico(double precioBase, double peso) {
        this();
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Electrodomestico(double precioBase, double peso, char consumoEnergetico, String color) {
        this();
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoEnergetico = consumoEnergetico;
        this.color = color;
        comprobarConsumoEnergetico(consumoEnergetico);
        comprobarColor(color);
    }

    private void comprobarConsumoEnergetico(char letra) {
        boolean encontrado = false;
        for (char consumo : consumos) {
            if (consumo == letra) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            this.consumoEnergetico = CONSUMO_DEFECTO;
        }
    }

    private void comprobarColor(String color) {
        String[] coloresDisponibles = {"blanco", "negro", "rojo", "azul", "gris"};
        boolean encontrado = false;
        for (String colorDisponible : coloresDisponibles) {
            if (colorDisponible.equalsIgnoreCase(color)) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            this.color = COLOR_DEFECTO;
        }
    }

    public double precioFinal() {
        double precio = precioBase + precioSegunConsumo() + precioSegunPeso();
        return precio;
    }

    private double precioSegunConsumo() {
        double adicion = 0;
        switch (consumoEnergetico) {
            case 'A':
                adicion = 100;
                break;
            case 'B':
                adicion = 80;
                break;
            case 'C':
                adicion = 60;
                break;
            case 'D':
                adicion = 50;
                break;
            case 'E':
                adicion = 30;
                break;
            case 'F':
                adicion = 10;
                break;
        }
        return adicion;
    }

    private double precioSegunPeso() {
        double adicion = 0;
        if (peso >= 0 && peso < 20) {
            adicion = 10;
        } else if (peso >= 20 && peso < 50) {
            adicion = 50;
        } else if (peso >= 50 && peso < 80) {
            adicion = 80;
        } else if (peso >= 80) {
            adicion = 100;
        }
        return adicion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public String getColor() {
        return color;
    }

    public double getPeso() {
        return peso;
    }
}
