package co.edu.uniquindio.tienda;

import co.edu.uniquindio.tienda.model.*;
import co.edu.uniquindio.tienda.modelDto.ClienteDto;
import co.edu.uniquindio.tienda.modelDto.VendedorDto;

import java.util.List;

import static co.edu.uniquindio.tienda.util.CapturaDatosUtil.*;

public class Main {

    /**
     * Función que permite inicializar los datos de prueba de una tienda
     * @return
     */
    public static Tienda inicializarDatosPruebaTienda() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Tienda de Cosmeticos");
        tienda.setTipoTienda("cosmeticos");
        tienda.setUbicacion("CC. Portal del Quindío");

        return tienda;
    }

    /**
     * Función que permite inicializar datos de prueba de un proveedor con productos
     * @return
     */
    public static Proveedor inicializarDatosPruebaProveedor() {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProvedor("Cosmeticos del Quindío");
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
     * Función para gestionar la creación de un vendedor
     *
     * @param vendedorDto
     * @param tienda
     * @return
     */
    public static Vendedor crearVendedor(VendedorDto vendedorDto, Tienda tienda) {
        Vendedor vendedor = tienda.crearVendedor(vendedorDto);
        return vendedor;
    }

    public static void actualizarVendedor(VendedorDto vendedorDto, Tienda tienda) {
        tienda.actualizarVendedor(vendedorDto);
    }

    public static void buscarVendedor(String cedula, Tienda tienda) {
        Vendedor vendedor = tienda.obtenerVendedor(cedula);
        if (vendedor != null) {
            imprimir(vendedor.toString());
        } else {
            imprimir("El Vendedor no existe");
        }
    }

    public static void eliminarVendedor(String cedula, Tienda tienda) {
        tienda.eliminarVendedor(cedula);
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
    public static void buscarAsesoria(){

    }

    public static void actualizarAsesoria(){

    }

    public static void eliminarAsesoria(){

    }



    public static Cliente crearCliente(ClienteDto clienteDto, Tienda tienda) {
        Cliente cliente = tienda.crearCliente(clienteDto);
        return cliente;
    }

    public static void actualizarCliente(ClienteDto personaDto, Tienda tienda) {
        tienda.actualizarCliente(personaDto);
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

    public static void actualizarProducto(String nombre, TipoCosmetico clasificación, double precio, int inventario, int codigo, Proveedor proveedor) {
        //proveedor.actualizarProducto(nombre, clasificación, precio, inventario, codigo);
    }

    public static Producto buscarProducto(Proveedor proveedor, int codigo){
       Producto productoBuscado = proveedor.buscarProducto(codigo);
        return productoBuscado;

    }
    public static void eliminarProducto(int codigo, Proveedor proveedor) {
        proveedor.eliminarProducto(codigo);
    }

    public static void gestionarMenuTienda(Tienda tienda){
        int opcion;
        do {
            opcion = leerEnteroVentana("Ingrese la opción: \n1. Gestionar menú cliente\n2. Gestionar menú vendedor\n3. Gestionar menú asesoria\n0.  salir" );
            switch (opcion) {
                case 1:
                    gestionarMenuCliente(tienda);
                    break;
                case 2:
                    gestionarMenuVendedor(tienda);
                    break;
                case 3:
                    //gestionarMenuAsesoria();
                    break;
            }

        } while (opcion != 0);
    }


    public static  void gestionarMenuCliente(Tienda tienda){
        int opcion;

        do{
            opcion = leerEnteroVentana("Ingrese la opción: \n1. Crear Cliente\n2. Buscar cliennte\n3. Actualizar cliente\n4. Eliminar cliente\n0. salir" );
            switch (opcion) {
                case 1:
                    String nombreCliente = leerStringVentana("Ingrese el nombre del cliente");
                    String apellidoCliente = leerStringVentana("Ingrese el apellido del cliente");
                    String cedulaCliente = leerStringVentana("Ingrese la cédula del cliente");
                    int edadCliente = leerEnteroVentana("Ingrese la edad del cliente");
                    ClienteDto clienteDto = new ClienteDto(nombreCliente, apellidoCliente, cedulaCliente, edadCliente);
                    crearCliente(clienteDto, tienda);
                    break;
                case 2:
                    //obtenerCliente(tienda);
                    break;
                case 3:
                    //actualizarCliente(tienda);
                    break;
                case 4:
                    //eliminarCliente(tienda);
                    break;
            }
        } while (opcion != 0);
    }

    public static  void gestionarMenuVendedor(Tienda tienda){
        int opcion;

        do{
            opcion = leerEnteroVentana("Ingrese la opción: \n1. Crear vendedor\n2. Buscar vendedor\n3. Actualizar vendedor\n4. Eliminar vendedor\n0. salir" );
            switch (opcion) {
                case 1:
                    //crearVendedor(tienda);
                    break;
                case 2:
                    //buscarVendedor(tienda);
                    break;
                case 3:
                    //actualizarVendedor(tienda);
                    break;
                case 4:
                    //eliminarVendedor(tienda);
                    break;
            }
        } while (opcion != 0);
    }


    public static  void gestionarMenuAsesoria(Tienda tienda){
        int opcion;

        do{
            opcion = leerEnteroVentana("Ingrese la opción: \n1. Crear asesoria\n2. Buscar asesoria\n3. Actualizar asesoria\n4. Eliminar asesoria\n0. salir" );
            switch (opcion) {
                case 1:
                    //crearAsesoria(tienda);
                    break;
                case 2:
                    //buscarAsesoria(tienda);
                    break;
                case 3:
                    //actualizarAsesoria(tienda);
                    break;
                case 4:
                    //eliminarAsesoria(tienda);
                    break;
            }
        } while (opcion != 0);
    }


    public static  void gestionarMenuProveedor(Proveedor proveedor){
        int opcion;

        do{
            opcion = leerEnteroVentana("Ingrese la opción: \n1. Crear producto\n2. Buscar producto\n3. Actualizar producto\n4. Eliminar producto\n0. salir" );
            switch (opcion) {
                case 1:
                    //crearProducto(tienda);
                    break;
                case 2:
                    //obtenerProducto(tienda);
                    break;
                case 3:
                    //actualizarProducto(tienda);
                    break;
                case 4:
                    //eliminarProducto(tienda);
                    break;
            }
        } while (opcion != 0);
    }



    public static void main(String[] args) {
        Tienda tienda = inicializarDatosPruebaTienda();
        Proveedor proveedor = inicializarDatosPruebaProveedor();

        /*tienda.comprarProductosInventario(proveedor);

        List<Producto> productosAsesoria = new ArrayList<>();
        productosAsesoria.add(tienda.obtenerProductos().get(0));

        ClienteDto clienteDto = new ClienteDto("Valentina","Garzón","123",26);
        VendedorDto vendedorDto = new VendedorDto("Juan","Lopez","1432",24);

        Cliente cliente = crearCliente(clienteDto, tienda);
        Vendedor vendedor = crearVendedor(vendedorDto, tienda);
        Asesoria asesoria = crearAsesoria(123, TipoCosmetico.MAQUILLAJE, "16-10-2023", vendedor,
                cliente, productosAsesoria, tienda);

        System.out.println("Nueva asesoría: " + asesoria.toString());*/


        int opcion;
        do {
            opcion = leerEnteroVentana("Ingrese la opción: \n1. Gestionar Tienda\n2. Gestionar Proveedor\n0. Salir");

            switch (opcion) {
                case 1:
                    gestionarMenuTienda(tienda);
                    break;
                case 2:
                    gestionarMenuProveedor(proveedor);
                    break;
            }

        } while (opcion != 0);
    }
}