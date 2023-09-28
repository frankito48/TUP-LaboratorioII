package electrodomesticos;

public class Main {

    public static void main(String[] args) {
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        electrodomesticos[0] = new Lavarropas(100, 5.00, 'A', "Gris"); // Corrección aquí
        electrodomesticos[1] = new Television(20, false, 10.00, 19.00, 'F', "Azul"); // Corrección aquí
        // Agrega más objetos según tus necesidades...

        double precioTotalElectrodomesticos = 0;
        double precioTotalLavadoras = 0;
        double precioTotalTelevisores = 0;

        for (Electrodomestico electrodomestico : electrodomesticos) {
            if (electrodomestico != null) { // Verifica si la posición del array contiene un objeto
                if (electrodomestico instanceof Lavarropas) {
                    precioTotalLavadoras += electrodomestico.precioFinal();
                } else if (electrodomestico instanceof Television) {
                    precioTotalTelevisores += electrodomestico.precioFinal();
                }
                precioTotalElectrodomesticos += electrodomestico.precioFinal();
            }
        }

        System.out.println("Precio total de Electrodomésticos: $" + precioTotalElectrodomesticos);
        System.out.println("Precio total de Lavarropas: USD$ " + precioTotalLavadoras);
        System.out.println("Precio total de Televisores: USD$ " + precioTotalTelevisores);
    }
}
