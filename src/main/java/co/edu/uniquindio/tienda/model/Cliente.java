package co.edu.uniquindio.tienda.model;

public class Cliente extends Persona {
    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apellido, String cedula, int edad) {
        super(nombre, apellido, cedula, edad);
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
}
