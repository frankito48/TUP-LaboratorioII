package Animales;

 class Delfin extends Animal implements Acuaticos {
     public Delfin(String nombre){
         super(nombre);
     }

     @Override
     public void nadar() {
         System.out.println(getNombre() + " esta nadando en el mar");
     }
 }
