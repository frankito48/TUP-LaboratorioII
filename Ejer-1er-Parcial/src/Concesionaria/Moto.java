package Concesionaria;

class Moto extends Vehiculo {
    public Moto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public double calcularImpuesto() {
        // Impuesto para una moto (por ejemplo, el 5% del precio)
        return getPrecio() * 0.05;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Moto");
        System.out.println(this);
        System.out.println("Impuesto: $" + calcularImpuesto());
    }
}