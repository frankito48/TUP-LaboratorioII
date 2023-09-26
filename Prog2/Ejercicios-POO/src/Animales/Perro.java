package Animales;

 class Perro extends Animal {
     public Perro(String nombre){
         super(nombre);
     }

     public void ladrar(){
         System.out.println(getNombre() + " esta ladrando");
     }
}
