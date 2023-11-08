package co.edu.uniquindio.tienda.model;

public class Vendedor extends Persona {
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

    /**
     * Método que permite obtener la información del nombre completo
     *
     * @return
     */
    @Override
    public String obtenerNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "edad=" + edad +
                ", nombre='" + obtenerNombreCompleto() + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
