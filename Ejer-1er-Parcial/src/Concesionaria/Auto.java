package Concesionaria;

class Auto extends Vehiculo {
    public Auto(String marca, String modelo, double precio) {
        super(marca, modelo, precio);
    }

    @Override
    public double calcularImpuesto() {
        // Impuesto para un coche (por ejemplo, el 10% del precio)
        return getPrecio() * 0.10;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Coche");
        System.out.println(this);
        System.out.println("Impuesto: $" + calcularImpuesto());
    }
}