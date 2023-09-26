package Animales;

public class Animal {
    private String nombre;

    public Animal(){
        this.nombre = "Desconocido";
    }

    public Animal(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void comer(){
        System.out.println(nombre + "Esta comiendo");
    }
}
