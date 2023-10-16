package co.edu.uniquindio.tienda.model;

import java.util.List;

public class Asesoria {
    private String tipoAsesoria;
    private String fechaAsesoria;
    private Vendedor vendedor;
    private Cliente cliente;
    private  List<Producto> Productos;

    private int codigo;

    private Tienda ownedByTienda;

    public Asesoria(String tipoAsesoria, String fechaAsesoria, Vendedor vendedor,Cliente cliente, int codigo) {
        this.tipoAsesoria = tipoAsesoria;
        this.fechaAsesoria = fechaAsesoria;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.codigo = codigo;
    }

    public String getTipoAsesoria() {
        return tipoAsesoria;
    }

    public void setTipoAsesoria(String tipoAsesoria) {
        this.tipoAsesoria = tipoAsesoria;
    }

    public String getFechaAsesoria() {
        return fechaAsesoria;
    }

    public void setFechaAsesoria(String fechaAsesoria) {
        this.fechaAsesoria = fechaAsesoria;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> productos) {
        Productos = productos;
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    @Override
    public String toString() {
        return "Asesoria{" +
                "tipoAsesoria='" + tipoAsesoria + '\'' +
                ", fechaAsesoria='" + fechaAsesoria + '\'' +
                ", vendedor=" + vendedor +
                ", cliente=" + cliente +
                '}';
    }
}
