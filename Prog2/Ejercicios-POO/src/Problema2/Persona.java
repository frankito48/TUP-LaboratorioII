package Problema2;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected int DNI;
    protected char sexo;
    protected double peso;
    protected double altura;

    // Constructor con DNI y nombre
    public Persona(int DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = "";
        this.edad = 0;
        this.sexo = 'H';
        this.peso = 0.0;
        this.altura = 0.0;
    }

    // Constructor con DNI, nombre, apellido, edad y sexo
    public Persona(int DNI, String nombre, String apellido, int edad, char sexo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = 0.0;
        this.altura = 0.0;
    }

    // Constructor con todos los atributos
    public Persona(int DNI, String nombre, String apellido, int edad, char sexo, double peso, double altura) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    // Métodos get
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getDNI() {
        return DNI;
    }

    public char getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    // Métodos set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Método para calcular IMC
    public int calcularIMC() {
        double imc = peso / Math.pow(altura, 2);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    // Método para verificar si es mayor de edad
    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    // Método para comprobar el sexo
    public void comprobarSexo(char sexo) {
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = 'H';
        } else {
            this.sexo = sexo;
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre= '" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad= " + edad +
                ", DNI= '" + DNI + '\'' +
                ", sexo= " + sexo +
                ", peso= " + peso +
                ", altura= " + altura +
                '}';
    }
}

