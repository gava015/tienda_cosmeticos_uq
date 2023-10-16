package co.edu.uniquindio.tienda;

import co.edu.uniquindio.tienda.model.Cliente;
import co.edu.uniquindio.tienda.model.Tienda;
import co.edu.uniquindio.tienda.model.TipoCosmetico;
import co.edu.uniquindio.tienda.model.Vendedor;

import java.util.List;

import static co.edu.uniquindio.tienda.util.CapturaDatosUtil.*;

public class Main {

    public static Tienda inicializarDatosPrueba() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Tienda de Cosmeticos");
        tienda.setTipoTienda("cosmeticos");
        tienda.setUbicacion("cc.Portal del quindio");
        return tienda;
    }

    public static Vendedor crearVendedor(String nombre, String cedula, int edad) {
        Vendedor vendedor = new Vendedor(nombre, cedula, edad);

        return vendedor;
    }

    public static void crearProducto(String nombre, TipoCosmetico clasificación, double precio, int inventario, int codigo, Tienda tienda) {
        tienda.crearProducto(nombre, clasificación, precio, inventario, codigo);
    }


    public static void crearAsesoria(String tipoAsesoria, String fechaAsesoria, Vendedor vendedor, Cliente cliente, int codigo, Tienda tienda, List listaProductos) {
        tienda.crearAsesoria(tipoAsesoria, fechaAsesoria, vendedor, cliente, codigo, listaProductos);
    }


    public static void crearCliente(String nombre, String apellido, String cedula, Tienda tienda) {
        tienda.crearCliente(nombre, apellido, cedula);
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

    public static void actualizarProducto(String nombre, TipoCosmetico clasificación, double precio, int inventario, int codigo, Tienda tienda) {
        tienda.actualizarProducto(nombre, clasificación, precio, inventario, codigo);
    }

    public static void eliminarProducto(int codigo, Tienda tienda) {
        tienda.eliminarProducto(codigo);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("1 - Gestionar clientes");
        System.out.println("2 - Gestionar Vendedores");
        System.out.println("3 - Gestionar asesorias");

    }

    private static void mostrarMenuCrudCliente() {
        System.out.println("1 - Crear clientes");
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

        Tienda tienda = inicializarDatosPrueba();

        crearProducto("Labial", TipoCosmetico.MAQUILLAJE, 2000, 3, 123, tienda);
        crearProducto("Base Crema", TipoCosmetico.MAQUILLAJE, 1000, 2, 456, tienda);
        crearProducto("Shampoo", TipoCosmetico.CABELLO, 4000, 4, 789, tienda);
        crearProducto("Esmalte Fortalecedor", TipoCosmetico.UÑAS, 50000, 2, 101, tienda);
        crearProducto("Serum Hidratante", TipoCosmetico.CUIDADO_PIEL, 180000, 3, 102, tienda);
        crearProducto("Contorno de ojos", TipoCosmetico.CUIDADO_PIEL, 120000, 2, 103, tienda);


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