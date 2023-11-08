package co.edu.uniquindio.tienda;

import static co.edu.uniquindio.tienda.contantes.TiendaConstante.*;

import co.edu.uniquindio.tienda.model.*;

import static co.edu.uniquindio.tienda.util.CapturaDatosUtil.*;

public class Main {

    /**
     * Función que permite inicializar los datos de prueba de una tienda
     *
     * @return
     */
    public static Tienda inicializarDatosPruebaTienda() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Tienda de Cosmeticos");
        tienda.setTipoTienda("cosmeticos");
        tienda.setUbicacion("CC. Portal del Quindío");

        tienda.crearProducto("001", "Labial", TipoCosmetico.MAQUILLAJE, 2000, 10, 0);
        tienda.crearProducto("002", "Shampoo", TipoCosmetico.CABELLO, 5000, 10, 0);
        tienda.crearProducto("003", "Esmalte Fortalecedor", TipoCosmetico.UÑAS, 1000, 10, 0);
        tienda.crearProducto("004", "Contorno de ojos", TipoCosmetico.CUIDADO_PIEL, 6000, 10, 0);

        tienda.crearCliente("Cliente 1", "Cliente 1", "123", 25);
        tienda.crearCliente("Cliente 2", "Cliente 2", "456", 28);

        tienda.crearVendedor("Vendedor 1", "Vendedor 1", "123", 25);
        tienda.crearVendedor("Vendedor 2", "Vendedor 2", "134", 28);


        return tienda;
    }

    /**
     * Función que permite inicializar datos de prueba de un proveedor con productos
     *
     * @return
     */
    public static Proveedor inicializarDatosPruebaProveedor() {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProvedor("Cosmeticos del Quindío");
        proveedor.setCodigo(12345);

        crearProducto("Labial", TipoCosmetico.MAQUILLAJE, 2000, 100, 10, "001", proveedor);
        crearProducto("Shampoo", TipoCosmetico.CABELLO, 4000, 50, 25, "002", proveedor);
        crearProducto("Esmalte Fortalecedor", TipoCosmetico.UÑAS, 5000, 200, 30, "003", proveedor);
        crearProducto("Serum Hidratante", TipoCosmetico.CUIDADO_PIEL, 3000, 100, 40, "004", proveedor);
        crearProducto("Contorno de ojos", TipoCosmetico.CUIDADO_PIEL, 6000, 100, 20, "005", proveedor);
        return proveedor;
    }

    public static void crearAsesoria(Tienda tienda) {
        String infoProductosOfrecidos = tienda.obtenerInformacionProductosOfrecidos();
        String codigo = leerStringVentana(INGRESE_CODIGO_ASESORIA);
        String fechaAsesoria = leerStringVentana(INGRESE_FECHA_ASESORIA);
        String tipoAsesoria = leerStringVentana(INGRESE_TIPO_ASESORIA);
        String codigoProducto = leerStringVentana( INGRESE_CODIGO_PRODUCTO + infoProductosOfrecidos);
        String cedulaCliente = leerStringVentana(INGRESE_CEDULA_CLIENTE);
        String cedulaVendedor = leerStringVentana(INGRESE_CEDULA_VENDEDOR);

        boolean asesoriaCreada = tienda.crearAsesoria(codigo, fechaAsesoria, codigoProducto, cedulaCliente,
                cedulaVendedor, tipoAsesoria);

        if (asesoriaCreada == true) {
            mostrarMensaje(ASESORIA_COMPLETADA);
        } else {
            mostrarMensaje(ASESORIA_NO_COMPLETADA);
        }
    }

    public static void buscarAsesoria(Tienda tienda) {
        String codigo = leerStringVentana(INGRESE_CODIGO_ASESORIA);

        Asesoria asesoria = tienda.obtenerAsesoria(codigo);
        if (asesoria != null) {
            mostrarMensaje("Asesoría: \n" + asesoria);
        } else {
            mostrarMensaje(ASESORIA_NO_CREADA);
        }
    }

    public static void actualizarAsesoria(Tienda tienda) {
        String infoProductosOfrecidos = tienda.obtenerInformacionProductosOfrecidos();
        String codigo = leerStringVentana(INGRESE_CODIGO_ASESORIA);
        String nuevaFechaAsesoria = leerStringVentana(INGRESE_FECHA_ASESORIA);
        String tipoAsesoria = leerStringVentana(INGRESE_TIPO_ASESORIA);
        String codigoProducto = leerStringVentana(INGRESE_CODIGO_PRODUCTO + infoProductosOfrecidos);

        boolean asesoriaActualizada = tienda.actualizarAsesoria(codigo, nuevaFechaAsesoria, codigoProducto, tipoAsesoria);
        if (asesoriaActualizada == true) {
            mostrarMensaje(ASESORIA_ACTUALIZACION_COMPLETADA);
        } else {
            mostrarMensaje(ASESORIA_NO_CREADA);
        }
    }

    public static void eliminarAsesoria(Tienda tienda) {
        String codigo = leerStringVentana(INGRESE_CODIGO_ASESORIA);

        boolean asesoriaEliminada = tienda.eliminarAsesoria(codigo);
        if (asesoriaEliminada == true) {
            mostrarMensaje(ASESORIA_ELIMINACION_COMPLETADA);
        } else {
            mostrarMensaje(ASESORIA_NO_CREADA);
        }
    }

    public static void crearCliente(Tienda tienda) {
        String nombre = leerStringVentana(INGRESE_NOMBRE_CLIENTE);
        String apellido = leerStringVentana(INGRESE_APELLIDO_CLIENTE);
        String cedula = leerStringVentana(INGRESE_CEDULA_CLIENTE);
        int edad = leerEnteroVentana(INGRESE_EDAD_CLIENTE);

        boolean clienteCreado = tienda.crearCliente(nombre, apellido, cedula, edad);
        if (clienteCreado == true) {
            mostrarMensaje(CLIENTE_COMPLETADA);
        } else {
            mostrarMensaje(CLIENTE_SI_EXISTE);
        }
    }

    public static void actualizarCliente(Tienda tienda) {
        String nombre = leerStringVentana(INGRESE_NOMBRE_CLIENTE);
        String apellido = leerStringVentana(INGRESE_APELLIDO_CLIENTE);
        String cedula = leerStringVentana(INGRESE_CEDULA_CLIENTE);
        int edad = leerEnteroVentana(INGRESE_EDAD_CLIENTE);

        boolean clienteActualizado = tienda.actualizarCliente(nombre, apellido, cedula, edad);
        if (clienteActualizado == true) {
            mostrarMensaje(CLIENTE_ACTUALIZACION_COMPLETADA);
        } else {
            mostrarMensaje(CLIENTE_NO_EXISTE);
        }
    }

    public static void buscarCliente(Tienda tienda) {
        String cedula = leerStringVentana(INGRESE_CEDULA_CLIENTE);

        Cliente cliente = tienda.obtenerCliente(cedula);
        if (cliente != null) {
            mostrarMensaje("Cliente\n" + cliente);
        } else {
            mostrarMensaje(CLIENTE_NO_EXISTE);
        }
    }

    public static void eliminarCliente(Tienda tienda) {
        String cedula = leerStringVentana(INGRESE_CEDULA_CLIENTE);

        boolean clienteEliminado = tienda.eliminarCliente(cedula);
        if (clienteEliminado == true) {
            mostrarMensaje(CLIENTE_ELIMINACION_COMPLETADA);
        } else {
            mostrarMensaje(CLIENTE_NO_EXISTE);
        }
    }

    public static void crearVendedor(Tienda tienda) {
        String nombre = leerStringVentana(INGRESE_NOMBRE_VENDEDOR);
        String apellido = leerStringVentana(INGRESE_APELLIDO_VENDEDOR);
        String cedula = leerStringVentana(INGRESE_CEDULA_VENDEDOR);
        int edad = leerEnteroVentana(INGRESE_EDAD_VENDEDOR);

        boolean vendedorCreado = tienda.crearVendedor(nombre, apellido, cedula, edad);
        if (vendedorCreado == true) {
            mostrarMensaje(VENDEDOR_COMPLETADA);
        } else {
            mostrarMensaje(VENDEDOR_SI_EXISTE);
        }
    }

    public static void actualizarVendedor(Tienda tienda) {
        String nombre = leerStringVentana(INGRESE_NOMBRE_VENDEDOR);
        String apellido = leerStringVentana(INGRESE_APELLIDO_VENDEDOR);
        String cedula = leerStringVentana(INGRESE_CEDULA_VENDEDOR);
        int edad = leerEnteroVentana(INGRESE_EDAD_VENDEDOR);

        boolean vendedorActualizado = tienda.actualizarVendedor(nombre, apellido, cedula, edad);
        if (vendedorActualizado == true) {
            mostrarMensaje(VENDEDOR_ACTUALIZACION_COMPLETADA);
        } else {
            mostrarMensaje(VENDEDOR_NO_EXISTE);
        }
    }

    public static void buscarVendedor(Tienda tienda) {
        String cedula = leerStringVentana(INGRESE_CEDULA_VENDEDOR);

        Vendedor vendedor = tienda.obtenerVendedor(cedula);
        if (vendedor != null) {
            mostrarMensaje("Vendedor\n" + vendedor);
        } else {
            mostrarMensaje(VENDEDOR_NO_EXISTE);
        }
    }

    public static void eliminarVendedor(Tienda tienda) {
        String cedula = leerStringVentana(INGRESE_CEDULA_VENDEDOR);

        boolean vendedorEliminado = tienda.eliminarVendedor(cedula);
        if (vendedorEliminado == true) {
            mostrarMensaje(VENDEDOR_ELIMINACION_COMPLETADA);
        } else {
            mostrarMensaje(VENDEDOR_NO_EXISTE);
        }
    }


    /**
     * Función para gestionar la creación de un producto
     */
    public static void crearProducto(String nombre, TipoCosmetico clasificacion, double precio, int inventario,
                                     int inventarioVendido, String codigo, Proveedor proveedor) {
        proveedor.crearProducto(nombre, clasificacion, precio, inventario, codigo, inventarioVendido);
    }


    public static void crearProducto(Proveedor proveedor) {
        String nombre = leerStringVentana(INGRESE_NOMBRE_PRODUCTO);
        String clasificacion = leerStringVentana(INGRESE_TIPO_PRODUCTO);
        double precio = leerDouble(INGRESE_PRECIO_PRODUCTO);
        int inventario = leerEnteroVentana(INGRESE_INVENTARIO_PRODUCTO);
        String codigo = leerStringVentana(INGRESE_CODIGO_PRODUCTO);

        boolean productoCreado = proveedor.crearProducto(nombre, clasificacion, precio, inventario, codigo);
        if (productoCreado == true) {
            mostrarMensaje(PRODUCTO_CREADO);
        } else {
            mostrarMensaje(PRODCUTO_SI_EXISTE);
        }
    }

    public static void obtenerProducto(Proveedor proveedor) {
        String codigo = leerStringVentana(INGRESE_CODIGO_PRODUCTO);
        Producto producto = proveedor.obtenerProducto(codigo);
        if (producto != null) {
            mostrarMensaje("Producto\n" + producto);
        } else {
            mostrarMensaje(PRODUCTO_NO_EXISTE);
        }
    }


    public static void actualizarProducto(Proveedor proveedor) {
        String nombre = leerStringVentana(INGRESE_NOMBRE_PRODUCTO);
        String clasificacion = leerStringVentana(INGRESE_TIPO_PRODUCTO);
        double precio = leerDouble(INGRESE_PRECIO_PRODUCTO);
        int inventario = leerEnteroVentana(INGRESE_INVENTARIO_PRODUCTO);
        String codigo = leerStringVentana(INGRESE_CODIGO_PRODUCTO);
        ;
        boolean productoActualizado = proveedor.actualizarProducto(codigo, nombre, clasificacion, precio, inventario);
        if (productoActualizado == true) {
            mostrarMensaje(PRODUCTO_ACTUALIZACION_COMPLETADA);
        } else {
            mostrarMensaje(PRODUCTO_NO_EXISTE);
        }
    }

    public static void eliminarProducto(Proveedor proveedor) {
        String codigo = leerStringVentana(INGRESE_CODIGO_PRODUCTO);

        boolean productoEliminado = proveedor.eliminarProducto(codigo);
        if (productoEliminado == true) {
            mostrarMensaje(PRODUCTO_ELIMINACION_COMPLETADA);
        } else {
            mostrarMensaje(PRODUCTO_NO_EXISTE);
        }
    }

    public static void gestionarMenuProveedor(Proveedor proveedor, Tienda tienda) {
        int opcion;

        do {
            opcion = leerEnteroVentana("Ingrese la opción: \n1. Obtener total ingresos ventas \n2. Gestionar venta" +
                    "\n3. Gestionar productos\n0. Salir");
            switch (opcion) {
                case 1:
                    mostrarMensaje("Ingreso total: " + proveedor.calcularIngresosPorVentas());
                    break;
                case 2:
                    gestionarVentaProducto(proveedor, tienda);
                    break;
                case 3:
                    gestionarMenuProducto(proveedor);
                    break;
            }
        } while (opcion != 0);
    }

    public static void gestionarMenuProducto(Proveedor proveedor) {
        int opcion;

        do {
            opcion = leerEnteroVentana("Ingrese la opción: \n1. Crear producto\n2. Buscar producto\n" +
                    "3. Actualizar producto\n4. Eliminar producto\n5. Buscar producto mayor precio\n6." +
                    " Buscar producto más vendido\n0. salir");
            switch (opcion) {
                case 1:
                    crearProducto(proveedor);
                    break;
                case 2:
                    obtenerProducto(proveedor);
                    break;
                case 3:
                    actualizarProducto(proveedor);
                    break;
                case 4:
                    eliminarProducto(proveedor);
                    break;
                case 5:
                    mostrarMensaje("Producto mayor precio: " + proveedor.buscarProductoMayorPrecio());
                    break;
                case 6:
                    mostrarMensaje("Producto más vendido: " + proveedor.buscarProductoMasVendido());
                    break;
            }
        } while (opcion != 0);
    }

    public static void gestionarVentaProducto(Proveedor proveedor, Tienda tienda) {
        String codigoProducto;

        do {
            String informacionProductos = proveedor.obtenerInformacionMenuProducto();
            codigoProducto = leerStringVentana("Ingrese la opción: " + informacionProductos + "0. Salir");
            if (codigoProducto.equals("0")) {
                break;
            }

            int cantidad = leerEnteroVentana("Ingrese la cantidad del producto seleccionado");

            Producto producto = proveedor.venderProducto(codigoProducto, cantidad);
            if (producto == null) {
                mostrarMensajeAlerta("Lamentamos informarle que actualmente no disponemos de inventario para el producto.");

            } else {
                boolean compraProductoExitosa = tienda.comprarProductoProveedor(producto, cantidad);
                if (compraProductoExitosa == true) {
                    mostrarMensaje("La compra del producto se ha completado con éxito.");
                }
            }

        } while (!codigoProducto.equals("0"));
    }

    public static void gestionarMenuTienda(Tienda tienda) {
        int opcion;
        do {
            opcion = leerEnteroVentana("Menú gestión Tienda\nIngrese la opción: \n1. Menú asesoria." +
                    "\n2. Menú cliente\n3. Menú vendedor\n0. Salir");
            switch (opcion) {
                case 1:
                    gestionarMenuAsesoria(tienda);
                    break;
                case 2:
                    gestionarMenuCliente(tienda);
                    break;
                case 3:
                    gestionarMenuVendedor(tienda);
                    break;
            }
        } while (opcion != 0);
    }

    public static void gestionarMenuAsesoria(Tienda tienda) {
        int opcion;
        do {
            opcion = leerEnteroVentana("Menú gestion Asesoría\n Ingrese la opción: \n1. Crear asesoria" +
                    "\n2. Buscar asesoria\n3. Actualizar asesoria\n4. Eliminar asesoria\n0. salir");
            switch (opcion) {
                case 1:
                    crearAsesoria(tienda);
                    break;
                case 2:
                    buscarAsesoria(tienda);
                    break;
                case 3:
                    actualizarAsesoria(tienda);
                    break;
                case 4:
                    eliminarAsesoria(tienda);
                    break;
            }
        } while (opcion != 0);
    }

    public static void gestionarMenuCliente(Tienda tienda) {
        int opcion;

        do {
            opcion = leerEnteroVentana("Menú gestión cliente\n Ingrese la opción: \n1.Mostrar información clientes\n" +
                    "2. Crear Cliente\n3. Buscar cliente\n4. Actualizar cliente\n5. Eliminar cliente\n0. salir");
            switch (opcion) {
                case 1:
                    mostrarMensaje(tienda.mostrarInformacionClientes());
                    break;
                case 2:
                    crearCliente(tienda);
                    break;
                case 3:
                    buscarCliente(tienda);
                    break;
                case 4:
                    actualizarCliente(tienda);
                    break;
                case 5:
                    eliminarCliente(tienda);
                    break;
            }
        } while (opcion != 0);
    }

    public static void gestionarMenuVendedor(Tienda tienda) {
        int opcion;

        do {
            opcion = leerEnteroVentana("Menú gestión vendedor\n Ingrese la opción: \n1. Mostrar información vendedores\n" +
                    "2. Crear vendedor\n3. Buscar vendedor\n4. Actualizar vendedor\n5. Eliminar vendedor\n" +
                    "6. Buscar vendedor con mayor edad\n0. . Salir");
            switch (opcion) {
                case 1:
                    mostrarMensaje(tienda.mostrarInformacionVendedores());
                    break;
                case 2:
                    crearVendedor(tienda);
                    break;
                case 3:
                    buscarVendedor(tienda);
                    break;
                case 4:
                    actualizarVendedor(tienda);
                    break;
                case 5:
                    eliminarVendedor(tienda);
                    break;
                case 6:
                    mostrarMensaje("Vendedor con mayor edad: " + tienda.buscarVendedorMayorEdad());
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        Tienda tienda = inicializarDatosPruebaTienda();
        Proveedor proveedor = inicializarDatosPruebaProveedor();

        int opcion;
        do {
            opcion = leerEnteroVentana("¿Qué quieres hacer?\n1. Gestionar Tienda\n2. Gestionar Proveedor\n0. Salir");

            switch (opcion) {
                case 1:
                    gestionarMenuTienda(tienda);
                    break;
                case 2:
                    gestionarMenuProveedor(proveedor, tienda);
                    break;
            }

        } while (opcion != 0);
    }
}