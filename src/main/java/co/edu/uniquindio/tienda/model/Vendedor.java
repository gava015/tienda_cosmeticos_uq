package co.edu.uniquindio.tienda.model;

public class Vendedor extends Persona{

    private int edad;

    public Vendedor(String nombre, String apellido, String cedula, int edad) {
        super(nombre, apellido, cedula, edad);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
