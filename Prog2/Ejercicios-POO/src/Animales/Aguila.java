package Animales;

 class Aguila extends Animal{
     public Aguila(String nombre){
         super(nombre);
     }

     public void volar(){
         System.out.println(getNombre() + " esta volando en el cielo");
     }
}
