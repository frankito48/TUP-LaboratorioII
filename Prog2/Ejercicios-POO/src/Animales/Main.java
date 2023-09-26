package Animales;

public class Main {
    public static void main(String[] args) {

        Delfin delfin = new Delfin("Flipper");
        Aguila aguila = new Aguila("Aguila Real");
        Gato gato = new Gato("Garfield");
        Perro perro = new Perro("Fatiga");


        delfin.nadar();
        aguila.volar();
        gato.comer();
        perro.ladrar();
    }
}