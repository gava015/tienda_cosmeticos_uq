package co.edu.uniquindio.tienda.model;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombreTienda;
    private String ubicacion;
    private String tipoTienda;

    List<Cliente> listaClientes = new ArrayList<>();

    List<Vendedor> listaVendedores = new ArrayList<>();

    List<CompraInventario> listaInventario = new ArrayList<>();

    List<Asesoria> listaAsesorias = new ArrayList<>();

    /**
     * Constructor Tienda
     */
    public Tienda() {

    }

    /**
     * Constructor Tienda con parámetros
     *
     * @param nombreTienda
     * @param ubicacion
     * @param tipoTienda
     */
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

    public List<CompraInventario> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<CompraInventario> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public List<Asesoria> getListaAsesorias() {
        return listaAsesorias;
    }

    public void setListaAsesorias(List<Asesoria> listaAsesorias) {
        this.listaAsesorias = listaAsesorias;
    }


    /*CRUD CLIENTE*/

    /**
     * Crear cliente
     */
    public Cliente crearCliente(String nombre, String apellido, String cedula) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        getListaClientes().add(cliente);

        return cliente;
    }

    /**
     * Actualizar cliente
     */
    public void actualizarCliente(String nombre, String apellido, String cedula) {
        int tamanioLista = getListaClientes().size();
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
     * Obtener cliente
     */
    public Cliente obtenerCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                return cliente;

            }
        }
        return null;
    }

    /**
     * Eliminar cliente
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
     * Crear vendedor
     */
    public Vendedor crearVendedor(String nombreCompleto, String cedula, int edad) {
        Vendedor vendedor = new Vendedor(nombreCompleto, cedula, edad);
        vendedor.setOwnedByTienda(this);
        getListaVendedores().add(vendedor);
        return vendedor;
    }

    /**
     * Actualizar vendedor
     */
    public void actualizarEmpleado(String nombre, String cedula, int edad) {
        int tamanioLista = getListaVendedores().size();
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
     * Obtener vendedor
     */
    public Vendedor obtenerVendedor(String cedula) {
        int tamanioLista = getListaVendedores().size();
        for (int i = 0; i < tamanioLista; i++) {
            Vendedor vendedor = getListaVendedores().get(i);
            if (vendedor.getCedula().equalsIgnoreCase(cedula)) {
                return vendedor;
            }
        }
        return null;
    }

    /**
     * Eliminar vendedor
     */
    public void eliminarVendedor(String cedula) {
        int tamanioLista = getListaVendedores().size();
        for (int i = 0; i < tamanioLista; i++) {
            Vendedor vendedor = getListaVendedores().get(i);
            if (vendedor.getCedula().equalsIgnoreCase(cedula)) {
                getListaVendedores().remove(i);
                break;
            }
        }
    }

    /* CRUD ASESORIA */

    /**
     * Crear asesoría
     */
    public Asesoria crearAsesoria(TipoCosmetico tipoAsesoria, String fechaAsesoria, Vendedor vendedor, Cliente cliente, int codigo, List listaProductos) {
        Asesoria asesoria = new Asesoria();
        asesoria.setTipoAsesoria(tipoAsesoria);
        asesoria.setFechaAsesoria(fechaAsesoria);
        asesoria.setVendedor(vendedor);
        asesoria.setCliente(cliente);
        asesoria.setCodigo(codigo);
        asesoria.setProductos(listaProductos);
        getListaAsesorias().add(asesoria);

        return asesoria;
    }

    /**
     * Actualizar asesoría
     */
    public void actualizarAsesoria(TipoCosmetico tipoAsesoria, String fechaAsesoria, Vendedor vendedor, Cliente cliente, int codigo) {
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
     * Obtener asesoría
     *
     * @return
     */
    public Asesoria obtenerAsesorias(int codigo) {
        int tamanioLista = getListaAsesorias().size();
        for (int i = 0; i < tamanioLista; i++) {
            Asesoria asesoria = getListaAsesorias().get(i);
            if (asesoria.getCodigo() == (codigo)) {
                return asesoria;
            }
        }
        return null;
    }

    /**
     * Eliminar asesoría
     *
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

    public CompraInventario crearCompraInventario(String codigo, String fecha, Proveedor proveedor) {
        CompraInventario nuevaCompraInventario = new CompraInventario();
        nuevaCompraInventario.setTienda(this);
        nuevaCompraInventario.setFechaInventario(fecha);
        nuevaCompraInventario.setProvedor(proveedor);

        return nuevaCompraInventario;
    }

    /**
     * Método que permite realizar la compra de productos para el inventario de la tienda
     *
     * @param proveedor
     */
    public void comprarProductosInventario(Proveedor proveedor) {
        List<Producto> listaProductosOfrecidos = proveedor.ofrecerProductos();

        CompraInventario nuevaCompraInventario = crearCompraInventario("123", "16-07-2023", proveedor);

        for (int i = 0; i < listaProductosOfrecidos.size(); i++) {
            Producto productoOfrecido = listaProductosOfrecidos.get(i);
            agregarProductoCompradoAInventario(nuevaCompraInventario, productoOfrecido);
            productoOfrecido.setInventarioVendido(productoOfrecido.getInventario());
        }
        listaInventario.add(nuevaCompraInventario);
        proveedor.setListaProductos(listaProductosOfrecidos);
    }

    public void agregarProductoCompradoAInventario(CompraInventario compraInventario, Producto productoOfrecido) {
        Producto productoComprado = new Producto();
        productoComprado.setNombre(productoOfrecido.getNombre());
        productoComprado.setCodigo(productoOfrecido.getCodigo());
        productoComprado.setClasificacion(productoOfrecido.getClasificacion());
        compraInventario.getListaProductos().add(productoComprado);
    }

    public List<Producto> obtenerProductos() {
        List<Producto> productosALaVenta = new ArrayList<>();

        for (int i = 0; i < listaInventario.size(); i++) {
            CompraInventario compraInventario = listaInventario.get(i);
            List<Producto> productos = compraInventario.getListaProductos();
            for (int j = 0; j < productos.size(); j++) {
                Producto productoComprado = productos.get(j);
                productosALaVenta.add(productoComprado);
            }
        }

        return productosALaVenta;
    }
}

