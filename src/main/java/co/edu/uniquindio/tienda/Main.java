package co.edu.uniquindio.tienda;

import co.edu.uniquindio.tienda.model.*;

import java.util.ArrayList;
import java.util.List;

import static co.edu.uniquindio.tienda.util.CapturaDatosUtil.*;

public class Main {

    /**
     * Función que permite inicializar datos de prueba de un proveedor
     * @return
     */
    public static Proveedor inicializarDatosPruebaProveedor() {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProvedor("Cosmeticos del Quindio");
        proveedor.setCodigo(12345);

        crearProducto("Labial", TipoCosmetico.MAQUILLAJE, 2000, 10, 123, proveedor);
        crearProducto("Base Crema", TipoCosmetico.MAQUILLAJE, 1000, 10, 456, proveedor);
        crearProducto("Shampoo", TipoCosmetico.CABELLO, 4000, 10, 789, proveedor);
        crearProducto("Esmalte Fortalecedor", TipoCosmetico.UÑAS, 50000, 10, 101, proveedor);
        crearProducto("Serum Hidratante", TipoCosmetico.CUIDADO_PIEL, 180000, 10, 102, proveedor);
        crearProducto("Contorno de ojos", TipoCosmetico.CUIDADO_PIEL, 120000, 10, 103, proveedor);
        return proveedor;
    }

    /**
     * Función que permite inicializar los datos de prueba de una tienda
     * @return
     */
    public static Tienda inicializarDatosPruebaTienda() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Tienda de Cosmeticos");
        tienda.setTipoTienda("cosmeticos");
        tienda.setUbicacion("cc.Portal del quindio");

        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProvedor("Cosmeticos del Quindio");
        proveedor.setCodigo(12345);

        return tienda;
    }

    /**
     * Función para gestionar la creación de un vendedor
     *
     * @param nombre
     * @param cedula
     * @param edad
     * @param tienda
     * @return
     */
    public static Vendedor crearVendedor(String nombre, String cedula, int edad, Tienda tienda) {
        Vendedor vendedor = tienda.crearVendedor(nombre, cedula, edad);
        return vendedor;
    }

    /**
     * Función para gestionar la creación de un producto
     *
     * @param nombre
     * @param clasificación
     * @param precio
     * @param inventario
     * @param codigo
     * @param proveedor
     */
    public static void crearProducto(String nombre, TipoCosmetico clasificación, double precio, int inventario,
                                     int codigo, Proveedor proveedor) {
        proveedor.crearProducto(nombre, clasificación, precio, inventario, codigo);
    }

    /**
     * Función que permite gestionar la creación de una asesoría
     *
     * @param codigo
     * @param tipoAsesoria
     * @param fechaAsesoria
     * @param vendedor
     * @param cliente
     * @param listaProductos
     * @param tienda
     * @return
     */
    public static Asesoria crearAsesoria(int codigo, TipoCosmetico tipoAsesoria, String fechaAsesoria, Vendedor vendedor,
                                     Cliente cliente, List<Producto> listaProductos, Tienda tienda) {
        Asesoria asesoria = tienda.crearAsesoria(tipoAsesoria, fechaAsesoria, vendedor, cliente, codigo, listaProductos);
        return asesoria;
    }

    public static Cliente crearCliente(String nombre, String apellido, String cedula, Tienda tienda) {
        Cliente cliente = tienda.crearCliente(nombre, apellido, cedula);
        return cliente;
    }

    public static void actualizarCliente(String nombre, String apellido, String cedula, Tienda tienda) {
        tienda.actualizarCliente(nombre, apellido, cedula);
    }

    public static void obtenerCliente(String cedula, Tienda tienda) {
        Cliente cliente = tienda.obtenerCliente(cedula);
        if (cliente != null) {
            imprimir(cliente.toString());
        } else {
            imprimir("El cliente no existe");
        }
    }

    public static void eliminarCliente(String cedula, Tienda tienda) {
        tienda.eliminarCliente(cedula);
    }

    public static void actualizarProducto(String nombre, TipoCosmetico clasificación, double precio, int inventario, int codigo, Proveedor proveedor) {
        proveedor.actualizarProducto(nombre, clasificación, precio, inventario, codigo);
    }

    public static void eliminarProducto(int codigo, Proveedor proveedor) {
        proveedor.eliminarProducto(codigo);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("1 - Gestionar clientes");
        System.out.println("2 - Gestionar Vendedores");
        System.out.println("3 - Gestionar asesorias");
    }

    private static void mostrarMenuCrudCliente() {
        System.out.println("1 - Crear cliente");
        System.out.println("2 - Actualizar cliente");
        System.out.println("3 - Buscar cliente");
        System.out.println("4 - Eliminar cliente");
        System.out.println("0 - Salir");
    }

    private static void gestionarMenuCliente(Tienda tienda) {
        int opcion = 0;
        do {
            mostrarMenuCrudCliente();
            opcion = leerEnteroVentana("Ingrese la opción");
            switch (opcion) {
                case 1:
                    crearCliente("Valentina", "Grazon", "123", tienda);
                    break;
                case 2:
                    String cedulaClienteEliminar = String.valueOf(leerEnteroVentana("Ingrese la cédula del cliente que desea eliminar"));
                    eliminarCliente(cedulaClienteEliminar, tienda);
                    break;
                case 3:
                    String cedula = String.valueOf(leerEnteroVentana("Ingrese la cédula del cliente buscado"));
                    obtenerCliente(cedula, tienda);
                    break;
            }

        } while (opcion != 0);
    }

    public static void main(String[] args) {
        Tienda tienda = inicializarDatosPruebaTienda();
        Proveedor proveedor = inicializarDatosPruebaProveedor();
        tienda.comprarProductosInventario(proveedor);

        List<Producto> productosAsesoria = new ArrayList<>();
        productosAsesoria.add(tienda.obtenerProductos().get(0));

        Cliente cliente = crearCliente("Valentina", "Grazon", "123", tienda);
        Vendedor vendedor = crearVendedor("Juan", "12345", 30, tienda);
        Asesoria asesoria = crearAsesoria(123, TipoCosmetico.MAQUILLAJE, "16-10-2023", vendedor,
                cliente, productosAsesoria, tienda);

        System.out.println("Nueva asesoría: " + asesoria.toString());

        int opcion = 0;
        do {
            mostrarMenuPrincipal();
            opcion = leerEnteroVentana("Ingrese la opción");

            switch (opcion) {
                case 1:
                    gestionarMenuCliente(tienda);
                    break;
                case 2:
                    break;
                case 3:
            }

        } while (opcion != 0);
    }
}