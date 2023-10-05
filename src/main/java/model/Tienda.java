package model;

public class Tienda {
    private String nombreTienda;
    private String ubicacion;
    private String tipoTienda;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private Producto producto4;
    private Producto producto5;
    private Producto producto6;
    private Vendedor vendeddor;


    public Tienda() {

    }

    public Tienda(String nombreTienda, String ubicacion, String tipoTienda) {
        this.nombreTienda = nombreTienda;
        this.ubicacion = ubicacion;
        this.tipoTienda = tipoTienda;

    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(String tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Producto getProducto2() {
        return producto2;
    }

    public void setProducto2(Producto producto2) {
        this.producto2 = producto2;
    }

    public Producto getProducto3() {
        return producto3;
    }

    public void setProducto3(Producto producto3) {
        this.producto3 = producto3;
    }

    public Producto getProducto4() {
        return producto4;
    }

    public void setProducto4(Producto producto4) {
        this.producto4 = producto4;
    }

    public Producto getProducto5() {
        return producto5;
    }

    public void setProducto5(Producto producto5) {
        this.producto5 = producto5;
    }

    public Producto getProducto6() {
        return producto6;
    }

    public void setProducto6(Producto producto6) {
        this.producto6 = producto6;
    }

    public Vendedor getVendeddor() {
        return vendeddor;
    }

    public void setVendeddor(Vendedor vendeddor) {
        this.vendeddor = vendeddor;
    }

    public void contratarVendedor(Vendedor vendedor) {
        this.vendeddor = vendedor;
    }


    public void venderProducto(Producto producto) {

       if(producto.getInventarioVendido() + 1 > producto.getInventario()){
           System.out.println("Ya no hay inventario de " + producto.getNombre());
       }else{
           producto.contarProducto();
       }
    }


    public double calcularTotalVendido() {
        double total = this.producto1.totalProductoVendido() + this.producto2.totalProductoVendido()
                + this.producto3.totalProductoVendido() + this.producto4.totalProductoVendido() +
                this.producto5.totalProductoVendido() + this.producto6.totalProductoVendido();

        return total;
    }
}
