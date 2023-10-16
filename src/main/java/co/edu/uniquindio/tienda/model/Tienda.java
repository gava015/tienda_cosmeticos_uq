package co.edu.uniquindio.tienda.model;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombreTienda;
    private String ubicacion;
    private String tipoTienda;

    List<Cliente> listaClientes = new ArrayList<>();

    List<Vendedor> listaVendedores = new ArrayList<>();

    List<Producto> listaProductos = new ArrayList<>();

    List<Asesoria> listaAsesorias = new ArrayList<>();


    //Constructor tienda
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


    //Get & Set LISTAS


    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Asesoria> getListaAsesorias() {
        return listaAsesorias;
    }

    public void setListaAsesorias(List<Asesoria> listaAsesorias) {
        this.listaAsesorias = listaAsesorias;
    }


    /*CRUD CLIENTE*/
    /**
     * Crear Cliente
     */
    public boolean crearCliente(String nombre, String apellido, String cedula) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);

        getListaClientes().add(cliente);

        return true;
    }

    /**
     * Actualizar Cliente
     */
    public void actualizarCliente(String nombre, String apellido, String cedula) {
        int tamanioLista = getListaProductos().size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setCedula(cedula);
                getListaClientes().add(i, cliente);
            }
        }
    }

    /**
     * Obtener Cliente
     */
    public Cliente obtenerCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        for(int i=0; i <tamanioLista; i++){
           Cliente cliente = getListaClientes().get(i);
            if(cliente.getCedula().equalsIgnoreCase(cedula)){
                return cliente;

            }
        }
        return  null;
    }

    /**
     * Eliminar
     */
    public void eliminarCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                getListaClientes().remove(i);
                break;
            }
        }
    }


    /* CRUD VENDEDOR */

    /**
     *
     CREAR
     */
    public boolean crearVendedor(String nombreCompleto, String cedula, int edad) {
        Vendedor vendedor = new Vendedor(nombreCompleto, cedula, edad);
        vendedor.setOwnedByTienda(this);
        getListaVendedores().add(vendedor);

        return true;
    }

    /**
     *Actualizar
     */

    public void actualizarEmpleado(String nombre, String cedula, int edad) {
        int tamanioLista = getListaProductos().size();
        for (int i = 0; i < tamanioLista; i++) {
            Vendedor vendedor = getListaVendedores().get(i);
            if (vendedor.getCedula().equalsIgnoreCase(cedula)) {
                vendedor.setNombre(nombre);
                vendedor.setEdad(edad);
                vendedor.setCedula(cedula);
                getListaVendedores().add(i, vendedor);
            }
        }
    }


    /**
     * Obtener
     */
    public Vendedor obtenerVendedor(String cedula) {
        int tamanioLista = getListaVendedores().size();
        for(int i=0; i <tamanioLista; i++){
           Vendedor vendedor = getListaVendedores().get(i);
            if(vendedor.getCedula().equalsIgnoreCase(cedula)){
                return vendedor;
            }
        }
        return  null;
    }

    /**
     *
     Eliminar
     */
    public void eliminarEmpleado(String cedula) {
        int tamanioLista = getListaVendedores().size();
        for (int i = 0; i < tamanioLista; i++) {
            Vendedor vendedor = getListaVendedores().get(i);
            if (vendedor.getCedula().equalsIgnoreCase(cedula)) {
                getListaVendedores().remove(i);
                break;
            }
        }
    }

    /**
     * Crear producto
     */
    public boolean crearProducto(String nombre, TipoCosmetico clasificación, double precio, int inventario, int codigo) {
        Producto producto = new Producto(nombre, clasificación, precio, inventario, codigo);
        producto.setOwnedByTienda(this);
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


    /*
    CRUD ASESORIA
     */

    /**
     *
    Crear
     */
    public boolean crearAsesoria(String tipoAsesoria, String fechaAsesoria, Vendedor vendedor, Cliente cliente, int codigo, List listaProductos) {
        Asesoria asesoria = new Asesoria(tipoAsesoria, fechaAsesoria, vendedor, cliente, codigo);
        asesoria.setTipoAsesoria(tipoAsesoria);
        asesoria.setFechaAsesoria(fechaAsesoria);
        asesoria.setVendedor(vendedor);
        asesoria.setCliente(cliente);
        asesoria.setCodigo(codigo);
        asesoria.setProductos(listaProductos);

        getListaAsesorias().add(asesoria);
        return true;
    }

    /**
     *
     Actualizar
     */

    public void actualizarAsesoria(String tipoAsesoria, String fechaAsesoria, Vendedor vendedor, Cliente cliente, int codigo) {
        int tamanioLista = getListaAsesorias().size();
        for (int i = 0; i < tamanioLista; i++) {
            Asesoria asesoria = getListaAsesorias().get(i);
            if (asesoria.getCodigo() == (codigo)) {
                asesoria.setTipoAsesoria(tipoAsesoria);
                asesoria.setFechaAsesoria(fechaAsesoria);
                asesoria.setVendedor(vendedor);
                asesoria.setCliente(cliente);
                asesoria.setCodigo(codigo);

                getListaAsesorias().add(i, asesoria);
            }
        }
    }

    /**
     * Obtener
     * @return
     */
    public Asesoria obtenerAsesorias(int codigo) {
        int tamanioLista = getListaProductos().size();
        for(int i=0; i <tamanioLista; i++){
           Asesoria asesoria = getListaAsesorias().get(i);
            if(asesoria.getCodigo() == (codigo)){
                return asesoria;
            }
        }
        return  null;
    }


    /**
     * Eliminar
     * @param codigo
     */
    public void eliminarAsesoria(int codigo) {
        int tamanioLista = getListaAsesorias().size();
        for (int i = 0; i < tamanioLista; i++) {
            Asesoria asesoria = getListaAsesorias().get(i);
            if (asesoria.getCodigo() == (codigo)) {
                getListaAsesorias().remove(i);
                break;
            }
        }
    }


    public void venderProducto(Producto producto) {

        if (producto.getInventarioVendido() + 1 > producto.getInventario()) {
            System.out.println("Ya no hay inventario de " + producto.getNombre());
        } else {
            producto.contarProducto();
        }
    }


    public double calcularTotalVendido() {
        double total = 0;
        int tamanioLista = getListaProductos().size();
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            total += producto.totalProductoVendido();
        }
        return total;
    }
}

