package co.edu.uniquindio.tienda.model;

public class Producto {
    private String nombre;
    private double precio;
    private TipoCosmetico clasificacion;

    private int inventario;

    private int inventarioVendido ;

    private int codigo;

    private Tienda ownedByTienda;

    public Producto() {
    }

    public Producto(String nombre, TipoCosmetico clasificación, double precio, int inventario, int codigo) {
        this.nombre = nombre;
        this.clasificacion = clasificación;
        this.precio = precio;
        this.inventario = inventario;
        this.codigo= codigo;
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

    public void setClasificacion(TipoCosmetico clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
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

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", clasificacion=" + clasificacion +
                ", inventario=" + inventario +
                ", inventarioVendido=" + inventarioVendido +
                ", codigo=" + codigo +
                '}';
    }
}


