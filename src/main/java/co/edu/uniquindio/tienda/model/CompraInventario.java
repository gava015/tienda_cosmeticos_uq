package co.edu.uniquindio.tienda.model;

import java.util.ArrayList;
import java.util.List;

public class CompraInventario {
    private Producto producto;
    private Tienda tienda;
    private  Proveedor proveedor;
    private int cantidad;
    private List <Producto> listaProductos = new ArrayList<>();

    public CompraInventario() {
    }

    public CompraInventario(Producto producto, Tienda tienda, Proveedor proveedor, int cantidad) {
        this.producto = producto;
        this.tienda = tienda;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProvedor(Proveedor proveedor) {
        proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "CompraInventario{" +
                "tienda=" + tienda +
                ", Provedor=" + proveedor +
                ", cantidad=" + cantidad +
                ", listaProductos=" + listaProductos +
                '}';
    }
}
