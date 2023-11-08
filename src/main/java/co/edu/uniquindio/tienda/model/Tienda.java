package co.edu.uniquindio.tienda.model;

import co.edu.uniquindio.tienda.services.ITienda;

import java.util.ArrayList;
import java.util.List;

public class Tienda implements ITienda {
    private String nombreTienda;
    private String ubicacion;
    private String tipoTienda;
    List<Cliente> listaClientes = new ArrayList<>();
    List<Vendedor> listaVendedores = new ArrayList<>();
    List<Asesoria> listaAsesorias = new ArrayList<>();
    List<Producto> listaProductos = new ArrayList<>();
    List<CompraInventario> listaInventario = new ArrayList<>();

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

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    // =========================== CRUD Cliente ===========================

    /**
     * Método que permite mostrar la información de los clientes relacionados a la tienda
     *
     * @return
     */
    public String mostrarInformacionClientes() {
        String infoClientes = "\n";
        for (Cliente cliente : getListaClientes()) {
            infoClientes += cliente.toString() + "\n";
        }
        return infoClientes;
    }

    /**
     * Método que permite crear un cliente para la tienda
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return
     */
    @Override
    public boolean crearCliente(String nombre, String apellido, String cedula, int edad) {
        Cliente cliente = obtenerCliente(cedula);
        if (cliente == null) {
            cliente = new Cliente(nombre, apellido, cedula, edad);
            cliente.setOwnedByTienda(this);
            getListaClientes().add(cliente);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que permite actualizar un cliente
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return
     */
    @Override
    public boolean actualizarCliente(String nombre, String apellido, String cedula, int edad) {
        Cliente cliente = obtenerCliente(cedula);
        if (cliente != null) {
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCedula(cedula);
            cliente.setEdad(edad);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Método que permite obtener un cliente por su cédula
     *
     * @param cedula
     * @return
     */
    @Override
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
     * Método que permite eliminar un cliente por su cédula
     *
     * @param cedula
     * @return
     */
    @Override
    public boolean eliminarCliente(String cedula) {
        int tamanioLista = getListaClientes().size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getCedula().equalsIgnoreCase(cedula)) {
                getListaClientes().remove(i);
                return true;
            }
        }
        return false;
    }

    // =========================== CRUD Vendedor ===========================

    /**
     * Método que permite obtener la información de los vendedores de la tienda
     *
     * @return
     */
    public String mostrarInformacionVendedores() {
        String infoVendedores = "";
        for (Vendedor vendedor : getListaVendedores()) {
            infoVendedores += vendedor.toString() + "\n";
        }
        return infoVendedores;
    }

    /**
     * Método que permite crear un vendedor para la tienda
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return
     */
    @Override
    public boolean crearVendedor(String nombre, String apellido, String cedula, int edad) {
        Vendedor vendedor = obtenerVendedor(cedula);
        if (vendedor == null) {
            vendedor = new Vendedor(nombre, apellido, cedula, edad);
            vendedor.setOwnedByTienda(this);
            getListaVendedores().add(vendedor);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que permite actualizar un vendedor de la tienda
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param edad
     * @return
     */
    @Override
    public boolean actualizarVendedor(String nombre, String apellido, String cedula, int edad) {
        Vendedor vendedor = obtenerVendedor(cedula);
        if (vendedor != null) {
            vendedor.setNombre(nombre);
            vendedor.setApellido(apellido);
            vendedor.setCedula(cedula);
            vendedor.setEdad(edad);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Método que permite obtener un vendedor de la tienda por su cedula
     *
     * @param cedula
     * @return
     */
    @Override
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
     * Método que permite eliminar un vendedor por su cédula
     *
     * @param cedula
     * @return
     */
    @Override
    public boolean eliminarVendedor(String cedula) {
        int tamanioLista = getListaVendedores().size();
        for (int i = 0; i < tamanioLista; i++) {
            Vendedor vendedor = getListaVendedores().get(i);
            if (vendedor.getCedula().equalsIgnoreCase(cedula)) {
                getListaVendedores().remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Método que permite buscar el vendedor con la mayor edad
     *
     * @return
     */
    public Vendedor buscarVendedorMayorEdad() {
        int tamanioLista = getListaVendedores().size();
        Vendedor vendedorMayorEdad = getListaVendedores().get(0);
        for (int i = 1; i < tamanioLista; i++) {
            Vendedor vendedor = getListaVendedores().get(i);
            if (vendedor.getEdad() > vendedorMayorEdad.getEdad()) {
                vendedorMayorEdad = vendedor;
            }
        }
        return vendedorMayorEdad;
    }

    // =========================== Transacción CRUD Asesoria ===========================

    /**
     * Método que permite crear una asesoría para la tienda
     *
     * @param codigo
     * @param fecha
     * @param codigoProducto
     * @param cedulaCliente
     * @param cedulaVendedor
     * @param tipoAsesoria
     * @return
     */
    @Override
    public boolean crearAsesoria(String codigo, String fecha, String codigoProducto, String cedulaCliente, String cedulaVendedor,
                                 String tipoAsesoria) {

        Cliente cliente = obtenerCliente(cedulaCliente);
        Vendedor vendedor = obtenerVendedor(cedulaVendedor);
        Producto producto = obtenerProducto(codigoProducto);

        if (cliente == null || vendedor == null || producto == null) {
            return false;
        }

        Asesoria asesoria = new Asesoria();
        asesoria.setCodigo(codigo);
        asesoria.setFecha(fecha);
        asesoria.setCliente(cliente);
        asesoria.setVendedor(vendedor);
        asesoria.setProducto(producto);
        asesoria.crearTipoAsesoria(tipoAsesoria);

        listaAsesorias.add(asesoria);
        return true;
    }

    /**
     * Método que permite obtener una asesoría por su código
     *
     * @param codigo
     * @return
     */
    @Override
    public Asesoria obtenerAsesoria(String codigo) {
        Asesoria asesoriaEncontrada = null;
        for (Asesoria asesoria : getListaAsesorias()) {
            if (asesoria.getCodigo().equalsIgnoreCase(codigo)) {
                asesoriaEncontrada = asesoria;
            }
        }
        return asesoriaEncontrada;
    }

    /**
     * Método que permite actualizar la información de una asesoría existente en la tienda
     *
     * @param codigo
     * @param fecha
     * @param codigoProducto
     * @param tipoAsesoria
     * @return
     */
    @Override
    public boolean actualizarAsesoria(String codigo, String fecha, String codigoProducto, String tipoAsesoria) {
        Asesoria asesoria = obtenerAsesoria(codigo);
        if (asesoria != null) {
            Producto producto = obtenerProducto(codigoProducto);

            if (producto == null) {
                return false;
            }

            asesoria.setFecha(fecha);
            asesoria.setProducto(producto);
            asesoria.crearTipoAsesoria(tipoAsesoria);
            return true;
        }

        return false;
    }

    /**
     * Método que permite eliminar una asesoría de la lista de asesorias de la tienda
     *
     * @param codigo
     * @return
     */
    @Override
    public boolean eliminarAsesoria(String codigo) {
        boolean eliminado = false;
        for (Asesoria asesoria : getListaAsesorias()) {
            if (asesoria.getCodigo().equalsIgnoreCase(codigo)) {
                getListaAsesorias().remove(asesoria);
                eliminado = true;
            }
        }

        return eliminado;
    }

    // =========================== Transacción CRUD Producto ===========================

    /**
     * Método que permite crear un producto para la tienda
     *
     * @param codigo
     * @param nombre
     * @param clasificacion
     * @param precio
     * @param inventario
     * @param inventarioVendido
     * @return
     */
    @Override
    public boolean crearProducto(String codigo, String nombre, TipoCosmetico clasificacion, double precio,
                                 int inventario, int inventarioVendido) {
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
     * Método que permite actualizar la información de un producto existente en la tienda
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param inventario
     * @param inventarioVendido
     * @return
     */
    @Override
    public boolean actualizarProducto(String codigo, String nombre, double precio, int inventario, int inventarioVendido) {
        Producto producto = obtenerProducto(codigo);
        if (producto != null) {
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setInventario(inventario);
            producto.setInventarioVendido(inventarioVendido);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que permite obtener un producto ofrecido por la tienda por su codigo
     *
     * @param codigo
     * @return
     */
    @Override
    public Producto obtenerProducto(String codigo) {
        Producto productoEncontrado = null;
        for (Producto producto : getListaProductos()) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                productoEncontrado = producto;
                break;
            }
        }

        return productoEncontrado;
    }

    /**
     * Método que permite eliminar un producto de la lista de productos de la tienda
     *
     * @param codigo
     * @return
     */
    @Override
    public boolean eliminarProducto(String codigo) {
        boolean eliminado = false;
        for (Producto producto : getListaProductos()) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                eliminado = true;
            }
        }

        return eliminado;
    }

    /**
     * Método que permite obtener la información de todos los productos ofrecidos por la tienda
     *
     * @return
     */
    public String obtenerInformacionProductosOfrecidos() {
        String infoProductosOfrecidos = "\n";

        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = getListaProductos().get(i);
            infoProductosOfrecidos += producto.toString();
        }
        return infoProductosOfrecidos;
    }

    // ===================== Gestionar compra producto =====================

    /**
     * Método que permite crear una instancia de CompraInventario
     *
     * @param producto
     * @param proveedor
     * @param cantidad
     */
    public void crearCompraInventario(Producto producto, Proveedor proveedor, int cantidad) {
        CompraInventario nuevaCompraInventario = new CompraInventario(producto, this, proveedor, cantidad);
        listaInventario.add(nuevaCompraInventario);
    }

    /**
     * Método que permite realizar la compra de un producto seleccionado a un proveedor
     *
     * @param productoComprado
     * @param cantidad
     * @return
     */
    public boolean comprarProductoProveedor(Producto productoComprado, int cantidad) {
        Producto producto = obtenerProducto(productoComprado.getCodigo());
        if (producto == null) {
            this.crearProducto(productoComprado.getCodigo(), productoComprado.getNombre(),
                    productoComprado.getClasificacion(), productoComprado.getPrecio(), cantidad, 0);
        } else {
            cantidad += producto.getInventario();
            this.actualizarProducto(producto.getCodigo(), productoComprado.getNombre(), productoComprado.getPrecio(),
                    cantidad, 0);
        }

        this.crearCompraInventario(producto, productoComprado.getOwnedByProvedor(), cantidad);
        return true;
    }
}

