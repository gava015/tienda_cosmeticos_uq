package co.edu.uniquindio.tienda.model;

import co.edu.uniquindio.tienda.modelDto.AsesoriaDto;
import co.edu.uniquindio.tienda.modelDto.ClienteDto;
import co.edu.uniquindio.tienda.modelDto.ProductoDto;
import co.edu.uniquindio.tienda.modelDto.VendedorDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    @Test
    public void testObtenerVendedor() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Test");
        tienda.setTipoTienda("Tienda maquillaje");

        VendedorDto vendedorTest = new VendedorDto("Test", "test", "12345", 28);
        tienda.crearVendedor(vendedorTest.nombre(), vendedorTest.apellido(), vendedorTest.cedula(), vendedorTest.edad());

        Vendedor vendedorBuscado = tienda.obtenerVendedor(vendedorTest.cedula());
        assertEquals(vendedorTest.cedula(), vendedorBuscado.getCedula());
        assertEquals(1, tienda.getListaVendedores().size());
    }

    @Test
    public void testEliminarCliente() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Test");
        tienda.setTipoTienda("Tienda maquillaje");

        ClienteDto clienteTest = new ClienteDto("test", "test", "12345", 20);
        tienda.crearCliente(clienteTest.nombre(), clienteTest.apellido(), clienteTest.cedula(), clienteTest.edad());

        assertTrue(tienda.eliminarCliente(clienteTest.cedula()));
        assertEquals(0, tienda.getListaClientes().size());
    }

    @Test
    public void testActualizarAsesoriaNoExistente() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Test");
        tienda.setTipoTienda("Tienda maquillaje");

        ProductoDto productoDto = new ProductoDto("123","test", 1000, 10, 0, "1");
        tienda.crearProducto(productoDto.codigo(), productoDto.nombre(), TipoCosmetico.MAQUILLAJE, productoDto.precio(),
                productoDto.inventario(), productoDto.inventarioVendido());

        Vendedor vendedorTest = new Vendedor("Test", "test", "12345", 28);
        Cliente clienteTest = new Cliente("Test", "test", "89345", 20);
        AsesoriaDto asesoriaDto = new AsesoriaDto("123", "17/11/2023", "1", vendedorTest, clienteTest);

        boolean asesoriaActualizada = tienda.actualizarAsesoria(asesoriaDto.codigo(), asesoriaDto.fechaAsesoria(),
                productoDto.codigo(),asesoriaDto.tipoAsesoria());

        assertFalse(asesoriaActualizada);
    }

    @Test
    public void testActualizarAsesoriaExistente() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Test");
        tienda.setTipoTienda("Tienda maquillaje");

        ProductoDto productoDto = new ProductoDto("123","test", 1000, 10, 0, "1");
        tienda.crearProducto(productoDto.codigo(), productoDto.nombre(), TipoCosmetico.MAQUILLAJE, productoDto.precio(),
                productoDto.inventario(), productoDto.inventarioVendido());

        VendedorDto vendedorTest = new VendedorDto("Test", "test", "12345", 28);
        tienda.crearVendedor(vendedorTest.nombre(), vendedorTest.apellido(), vendedorTest.cedula(), vendedorTest.edad());

        ClienteDto clienteTest = new ClienteDto("Test", "test", "89345", 20);
        tienda.crearCliente(clienteTest.nombre(), clienteTest.apellido(), clienteTest.cedula(), clienteTest.edad());

        AsesoriaDto asesoriaDto = new AsesoriaDto("123", "17/11/2023", "1", null,null);
        tienda.crearAsesoria(asesoriaDto.codigo(), asesoriaDto.fechaAsesoria(), productoDto.codigo(),
                clienteTest.cedula(), vendedorTest.cedula(), asesoriaDto.tipoAsesoria());

        boolean asesoriaActualizada = tienda.actualizarAsesoria(asesoriaDto.codigo(), asesoriaDto.fechaAsesoria(),
                productoDto.codigo(),asesoriaDto.tipoAsesoria());

        assertTrue(asesoriaActualizada);
    }

    @Test
    public void testComprarProductoProveedor() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Test");
        tienda.setTipoTienda("Tienda maquillaje");

        Proveedor proveedor = new Proveedor("test", 12345);

        ProductoDto productoDto = new ProductoDto("123","test", 1000, 10, 0,  "1");
        proveedor.crearProducto(productoDto.nombre(), productoDto.clasificacion(), productoDto.precio(),
                productoDto.inventario(), productoDto.codigo());

        Producto productoComprado = proveedor.obtenerProducto(productoDto.codigo());
        boolean compraProducto = tienda.comprarProductoProveedor(productoComprado, 10);

        assertTrue(compraProducto);
        assertEquals(1, tienda.getListaInventario().size() );
    }

    @Test
    public void testBuscarVendedorMayorEdad() {
        Tienda tienda = new Tienda();
        tienda.setNombreTienda("Test");
        tienda.setTipoTienda("Tienda maquillaje");

        Proveedor proveedor = new Proveedor("test", 12345);

        VendedorDto vendedorTest1 = new VendedorDto("Test", "test", "12345", 18);
        tienda.crearVendedor(vendedorTest1.nombre(), vendedorTest1.apellido(), vendedorTest1.cedula(), vendedorTest1.edad());

        VendedorDto vendedorTest2 = new VendedorDto("Test", "test", "12345", 28);
        tienda.crearVendedor(vendedorTest2.nombre(), vendedorTest2.apellido(), vendedorTest2.cedula(), vendedorTest2.edad());

        Vendedor vendedor = tienda.buscarVendedorMayorEdad();
        assertEquals(vendedorTest2.cedula(), vendedor.getCedula());
    }

}
