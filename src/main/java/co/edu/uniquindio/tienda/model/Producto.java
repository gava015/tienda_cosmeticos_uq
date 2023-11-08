package co.edu.uniquindio.tienda.model;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int inventario;
    private int inventarioVendido;
    private TipoCosmetico clasificacion;
    private Proveedor ownedByProveedor;

    public Producto() {
    }

    public Producto(String  codigo, String nombre, TipoCosmetico clasificacion, double precio, int inventario,int inventarioVendido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.inventario = inventario;
        this.inventarioVendido = inventarioVendido;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Proveedor getOwnedByProvedor() {
        return ownedByProveedor;
    }

    public void setOwnedByProveedor(Proveedor ownedByProvedor) {
        this.ownedByProveedor = ownedByProvedor;
    }

    public double calcularTotalInventarioVendido() {
        double inventarioVendido = this.inventarioVendido * this.precio;
        return inventarioVendido;
    }

    public int obtenerInventarioDisponible(){
        int inventario = this.getInventario() - this.getInventarioVendido();
        if(inventario < 0){
            inventario = 0;
        }
        return inventario;
    }

    public void modificarTipoClasificacion(String tipoClasificacion){
        switch (tipoClasificacion){
            case "1":
               setClasificacion(TipoCosmetico.MAQUILLAJE);
                break;
            case "2":
                setClasificacion(TipoCosmetico.CUIDADO_PIEL);
                break;
            case "3":
                setClasificacion(TipoCosmetico.CABELLO);
                break;
            case "4":
                setClasificacion(TipoCosmetico.UÑAS);
                break;
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "; Precio: " + precio + "; Producto: " + nombre + "["+ obtenerInventarioDisponible() +"]\n" ;
    }
}


