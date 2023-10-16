package co.edu.uniquindio.tienda.model;

public class Vendedor {
    private String nombre;

    private String Apellido;
    private String cedula;
    private int edad;

    private Tienda ownedByTienda;



    public Vendedor(String nombre,String cedula,int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }
    public void setOwnedByPrestamoUq(Tienda ownedByPrestamoUq) {
        this.ownedByTienda = ownedByTienda;
    }


    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                '}';
    }
}
