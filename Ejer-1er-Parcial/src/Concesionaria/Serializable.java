package Concesionaria;
import java.io.*;


interface Serializable {
    void guardar(String nombreArchivo) throws IOException;

    void cargar(String nombreArchivo) throws IOException, ClassNotFoundException;
}