package co.edu.uniquindio.tienda.model;

import co.edu.uniquindio.tienda.modelDto.ProductoDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProveedorTest {

    @Test
    public void testAgregarProducto() {
        Proveedor proveedor = new Proveedor("test", 12345);

        ProductoDto productoDto = new ProductoDto("123","test", 1000, 10, 0,  "1");
        proveedor.crearProducto(productoDto.nombre(), productoDto.clasificacion(), productoDto.precio(),
                productoDto.inventario(), productoDto.codigo());

        assertEquals(1, proveedor.getListaProductos().size());
        assertEquals("123", proveedor.getListaProductos().get(0).getCodigo());
    }

    @Test
    public void testAgregarProductoExistente() {
        Proveedor proveedor = new Proveedor("test", 12345);

        ProductoDto productoDto = new ProductoDto("123","test", 1000, 10, 0,  "1");
        proveedor.crearProducto(productoDto.nombre(), productoDto.clasificacion(), productoDto.precio(),
                productoDto.inventario(), productoDto.codigo());

        assertFalse(proveedor.crearProducto(productoDto.nombre(), productoDto.clasificacion(), productoDto.precio(),
                productoDto.inventario(), productoDto.codigo()));
        assertEquals(1, proveedor.getListaProductos().size());
    }

    @Test
    public void testVenderProducto() {
        Proveedor proveedor = new Proveedor("test", 12345);

        ProductoDto productoDto = new ProductoDto("123","test", 1000, 10, 0,  "1");
        proveedor.crearProducto(productoDto.nombre(), productoDto.clasificacion(), productoDto.precio(),
                productoDto.inventario(), productoDto.codigo());

        Producto productoComprado = proveedor.venderProducto(productoDto.codigo(), 5);
        assertEquals(productoDto.nombre(), productoComprado.getNombre());
        assertEquals(5, proveedor.getListaProductos().get(0).getInventarioVendido());
    }

    @Test
    public void testCalcularIngresosPorVentas() {
        Proveedor proveedor = new Proveedor("test", 12345);

        ProductoDto producto1 = new ProductoDto("123", "test", 1000, 100, 5, "1");
        proveedor.crearProducto(producto1.nombre(), producto1.clasificacion(), producto1.precio(),
                producto1.inventario(), producto1.codigo());
        Producto productoActualizado1 = proveedor.obtenerProducto(producto1.codigo());
        productoActualizado1.setInventarioVendido(producto1.inventarioVendido());

        ProductoDto producto2 = new ProductoDto("456", "test", 5000, 50, 10, "1");
        proveedor.crearProducto(producto2.nombre(), producto2.clasificacion(), producto2.precio(),
                producto2.inventario(), producto2.codigo());
        Producto productoActualizado2 = proveedor.obtenerProducto(producto2.codigo());
        productoActualizado2.setInventarioVendido(producto2.inventarioVendido());

        double ingresosPorVentas = proveedor.calcularIngresosPorVentas();
        assertEquals(55000, ingresosPorVentas);
    }

    @Test
    public void testBuscarProductoMayorPrecio() {
        Proveedor proveedor = new Proveedor("test", 12345);

        ProductoDto producto1 = new ProductoDto("123", "test", 1000, 100, 5, "1");
        proveedor.crearProducto(producto1.nombre(), producto1.clasificacion(), producto1.precio(),
                producto1.inventario(), producto1.codigo());

        ProductoDto producto2 = new ProductoDto("456", "test", 5000, 50, 10, "1");
        proveedor.crearProducto(producto2.nombre(), producto2.clasificacion(), producto2.precio(),
                producto2.inventario(), producto2.codigo());

        Producto producto = proveedor.buscarProductoMayorPrecio();
        assertEquals(producto2.codigo(), producto.getCodigo());
    }

    @Test
    public void testBuscarProductoMasVendido() {
        Proveedor proveedor = new Proveedor("test", 12345);

        ProductoDto producto1 = new ProductoDto("123", "test", 1000, 100, 50, "1");
        proveedor.crearProducto(producto1.nombre(), producto1.clasificacion(), producto1.precio(),
                producto1.inventario(), producto1.codigo());
        Producto productoActualizado1 = proveedor.obtenerProducto(producto1.codigo());
        productoActualizado1.setInventarioVendido(producto1.inventarioVendido());

        ProductoDto producto2 = new ProductoDto("456", "test", 5000, 50, 10, "1");
        proveedor.crearProducto(producto2.nombre(), producto2.clasificacion(), producto2.precio(),
                producto2.inventario(), producto2.codigo());
        Producto productoActualizado2 = proveedor.obtenerProducto(producto2.codigo());
        productoActualizado2.setInventarioVendido(producto2.inventarioVendido());

        Producto producto = proveedor.buscarProductoMasVendido();
        assertEquals(producto1.codigo(), producto.getCodigo());
    }
}
