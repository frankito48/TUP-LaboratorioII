package electrodomesticos;

public class Lavarropas extends Electrodomestico {

    private static final double PESO_DEFECTO = 5.00;

    public  Lavarropas(){
        super();
        this.peso = PESO_DEFECTO;
    }
    public Lavarropas(double precioBase, double peso) {
        super(precioBase, peso);
        this.peso = PESO_DEFECTO; // Usamos PESO_DEFECTO en lugar de carga
    }

    public Lavarropas(double precioBase, double peso, char consumoEnergetico, String color) {
        super(precioBase, peso, consumoEnergetico, color);
        this.peso = PESO_DEFECTO; // Usamos PESO_DEFECTO en lugar de carga
    }

    public double getPesoDefecto() {
        return peso;
    }

    @Override
    public double precioFinal() {
        double precio = super.precioFinal();
        if (peso > 30) {
            precio += 50;
        }
        return precio;
    }
}