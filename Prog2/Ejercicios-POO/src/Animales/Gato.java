package Animales;

 class Gato extends Animal {
     public Gato(String nombre){
         super(nombre);
     }

     @Override
     public void comer(){
         System.out.println(getNombre() + " esta comiendo");
     }
}
