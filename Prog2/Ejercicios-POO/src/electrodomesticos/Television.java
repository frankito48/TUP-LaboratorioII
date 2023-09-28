package electrodomesticos;

public class Television extends Electrodomestico {

    private double resolucion;
    private boolean sintonizadorTDT;
    private static final double RESOLUCION_DEFECTO = 20;
    private static final boolean SINTONIZADOR_DEFECTO = false;

    public Television() {
        super();
        this.resolucion = RESOLUCION_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_DEFECTO;
    }

    public Television(double precioBase, double peso) {
        super(precioBase, peso);
        this.resolucion = RESOLUCION_DEFECTO;
        this.sintonizadorTDT = SINTONIZADOR_DEFECTO;
    }

    public Television(double resolucion, boolean sintonizadorTDT, double precioBase, double peso, char consumoEnergetico, String color) {
        super(precioBase, peso, consumoEnergetico, color);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public double getResolucion() {
        return resolucion;
    }

    public boolean hasSintonizadorTDT() {
        return sintonizadorTDT;
    }

    @Override
    public double precioFinal() {
        double precio = super.precioFinal();
        if (resolucion > 40) {
            precio *= 1.3;
        }
        if (sintonizadorTDT) {
            precio += 50;
        }
        return precio;
    }
}
