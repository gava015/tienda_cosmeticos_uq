package co.edu.uniquindio.tienda.model;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {

    private String nombreProveedor;
    private int codigo;
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
     * Crear producto
     */
    public boolean crearProducto(String nombre, TipoCosmetico clasificación, double precio, int inventario, int codigo) {
        Producto producto = new Producto(nombre, clasificación, precio, inventario, codigo);
        producto.setOwnedByProveedor(this);
        getListaProductos().add(producto);
        return true;
    }

    /**
     * Actualizar
     */
    public void actualizarProducto(String nombre, TipoCosmetico clasificación, double precio, int inventario, int codigo) {
        int tamanioLista = getListaProductos().size();
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            if (producto.getCodigo() == (codigo)) {
                producto.setNombre(nombre);
                producto.setClasificacion(clasificación);
                producto.setPrecio(precio);
                producto.setInventario(inventario);
                producto.setCodigo(codigo);

                getListaProductos().add(i, producto);
            }
        }
    }

    /**
     *
     OBTENER
     */
    public Producto obtenerProducto(int codigo) {
        int tamanioLista = getListaProductos().size();
        for(int i=0; i <tamanioLista; i++){
            Producto producto = getListaProductos().get(i);
            if(producto.getCodigo() == codigo){
                return producto;

            }
        }
        return  null;
    }

    /**
     *Eliminar
     */
    public void eliminarProducto(int codigo) {
        int tamanioLista = getListaProductos().size();
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            if (producto.getCodigo() == (codigo)) {
                getListaProductos().remove(i);
                break;
            }
        }
    }


   public List<Producto> ofrecerProductos(){
        return getListaProductos();
   }

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombreProveedor='" + nombreProveedor + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}
