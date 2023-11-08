package co.edu.uniquindio.tienda.services;

import co.edu.uniquindio.tienda.model.*;

public interface ITienda {
    boolean crearAsesoria(
            String codigo,
            String fecha,
            String codigoProducto,
            String cedulaCliente,
            String cedulaVendedor,
            String tipoAsesoria
    );
    Asesoria obtenerAsesoria(String codigo);
    boolean actualizarAsesoria(String codigo, String fecha, String codigoProducto, String tipoAsesoria);
    boolean eliminarAsesoria(String codigo);

    boolean crearProducto(
            String codigo,
            String nombre,
            TipoCosmetico clasificacion,
            double precio,
            int inventario,
            int inventarioVendido
    );

    boolean actualizarProducto(String codigo, String nombre, double precio, int inventario, int inventarioVendido);

    Producto obtenerProducto(String codigo);

    boolean eliminarProducto(String codigo);

    boolean crearCliente(String nombre, String apellido, String cedula, int edad);

    Cliente obtenerCliente(String cedula);

    boolean eliminarCliente(String cedula);

    boolean actualizarCliente(String nombre, String apellido, String cedula, int edad);


    boolean crearVendedor(String nombre, String apellido, String cedula, int edad);

    boolean actualizarVendedor(String nombre, String apellido, String cedula, int edad);

    Vendedor obtenerVendedor(String cedula);

    boolean eliminarVendedor(String cedula);







}
