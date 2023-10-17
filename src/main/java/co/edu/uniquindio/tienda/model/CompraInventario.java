package co.edu.uniquindio.tienda.model;

import java.util.ArrayList;
import java.util.List;

public class CompraInventario {
    private String codigo;
    private String fechaInventario;
    private  Proveedor Provedor;
    private Tienda tienda;
    private List <Producto> listaProductos = new ArrayList<>();

    public CompraInventario() {
    }

    public CompraInventario(String fechaInventario, Proveedor provedor, Tienda tienda) {
        this.fechaInventario = fechaInventario;
        Provedor = provedor;
        this.tienda = tienda;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaInventario() {
        return fechaInventario;
    }

    public void setFechaInventario(String fechaInventario) {
        this.fechaInventario = fechaInventario;
    }

    public Proveedor getProvedor() {
        return Provedor;
    }

    public void setProvedor(Proveedor provedor) {
        Provedor = provedor;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
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
                "codigo'" + codigo + '\'' +
                "fechaInventario='" + fechaInventario + '\'' +
                ", Provedor=" + Provedor.getNombreProveedor() +
                ", tienda=" + tienda.getNombreTienda() +
                '}';
    }
}
