package co.edu.uniquindio.tienda.model;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    private int codigo;
    private String nombreProveedor;
    List<Producto> listaProductos = new ArrayList<>();

    public Proveedor() {
    }

    public Proveedor(String nombreProveedor, int codigo) {
        this.nombreProveedor = nombreProveedor;
        this.codigo = codigo;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProvedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Método que permite crear un producto para el proveedor
     *
     * @param nombre
     * @param clasificacion
     * @param precio
     * @param inventario
     * @param codigo
     * @return
     */
    public boolean crearProducto(String nombre, String clasificacion, double precio, int inventario, String codigo) {
        Producto producto = obtenerProducto(codigo);
        if (producto == null) {
            producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setInventario(inventario);
            producto.setOwnedByProveedor(this);
            producto.modificarTipoClasificacion(clasificacion);
            getListaProductos().add(producto);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Método que permite crear un producto recibiendo más información para su creación (Sobrecarga de método)
     *
     * @param nombre
     * @param clasificacion
     * @param precio
     * @param inventario
     * @param codigo
     * @param inventarioVendido
     * @return
     */
    public boolean crearProducto(String nombre, TipoCosmetico clasificacion, double precio, int inventario,
                                 String codigo, int inventarioVendido) {
        Producto producto = obtenerProducto(codigo);
        if (producto == null) {
            producto = new Producto(codigo, nombre, clasificacion, precio, inventario, inventarioVendido);
            getListaProductos().add(producto);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Método que permite actualizar la información de un producto.
     *
     * @param
     */
    public boolean actualizarProducto(String codigo, String nombre, String clasificacion, double precio, int inventario) {
        Producto producto = obtenerProducto(codigo);
        if (producto != null) {
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.modificarTipoClasificacion(clasificacion);
            producto.setPrecio(precio);
            producto.setInventario(inventario);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que permite buscar un producto por código
     *
     * @param codigo
     * @return
     */
    public Producto obtenerProducto(String codigo) {
        Producto productoEncontrado = null;
        for (Producto producto : getListaProductos()) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                productoEncontrado = producto;
            }
        }
        return productoEncontrado;
    }

    /**
     * Método que permite eliminar un producto por código
     *
     * @param codigo
     */
    public boolean eliminarProducto(String codigo) {
        int tamanioLista = getListaProductos().size();
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                getListaProductos().remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Producto> ofrecerProductos() {
        return getListaProductos();
    }

    /**
     * Método que permite obtener la información de los productos relacionados a un proveedor
     * @return
     */
    public String obtenerInformacionMenuProducto() {
        String infoProductosEnVenta = "\n";

        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = getListaProductos().get(i);
            infoProductosEnVenta += producto.toString();
        }
        return infoProductosEnVenta;
    }

    /**
     * Método que permite vender un producto seleccionado por su codigo
     *
     * @param codigo
     * @param cantidad
     * @return
     */
    public Producto venderProducto(String codigo, int cantidad) {
        Producto producto = obtenerProducto(codigo);

        if (producto == null || cantidad > (producto.obtenerInventarioDisponible())) {
            return null;
        }

        producto.setInventarioVendido(producto.getInventarioVendido() + cantidad);
        return producto;
    }

    /**
     * Método que permite calcular los ingresos por ventas del proveedor
     *
     * @return
     */
    public double calcularIngresosPorVentas() {
        double ingresos = 0;
        for (Producto producto : getListaProductos()) {
            ingresos += producto.calcularTotalInventarioVendido();
        }

        return ingresos;
    }

    /**
     * Método que permite buscar el producto más costoso
     *
     * @return
     */
    public Producto buscarProductoMayorPrecio() {
        int tamanioLista = getListaProductos().size();
        Producto productoMayorPrecio = getListaProductos().get(0);
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            if (producto.getPrecio() >= productoMayorPrecio.getPrecio()) {
                productoMayorPrecio = producto;
            }
        }
        return productoMayorPrecio;
    }

    /**
     * Método que permite buscar el producto más vendido
     * @return
     */
    public Producto buscarProductoMasVendido() {
        int tamanioLista = getListaProductos().size();
        Producto productoMasVendido = getListaProductos().get(0);
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            if (producto.getInventarioVendido() > productoMasVendido.getInventarioVendido()) {
                productoMasVendido = producto;
            }
        }
        return productoMasVendido;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombreProveedor='" + nombreProveedor + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
