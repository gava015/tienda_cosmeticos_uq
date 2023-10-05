package model;

public class Producto {
    private String nombre;

    private TipoCosmetico clasificacion;
    private double precio;
    private int inventario;

    private int inventarioVendido ;

    public Producto() {
    }

    public Producto(String nombre, TipoCosmetico clasificación, double precio, int inventario) {
        this.nombre = nombre;
        this.clasificacion = clasificación;
        this.precio = precio;
        this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public TipoCosmetico getClasificacion() {
        return clasificacion;
    }

    public int getInventarioVendido() {
        return inventarioVendido;
    }

    public void setInventarioVendido(int inventarioVendido) {
        this.inventarioVendido = inventarioVendido;
    }

    /*Metodo para contar la cantidad de productos vendidos

     */
    public void contarProducto() {
        this.inventarioVendido += 1;
    }

    public double totalProductoVendido (){
         double calcularTotalInventarioVendido = this.inventarioVendido * this.precio;
         return calcularTotalInventarioVendido;
    }
}


