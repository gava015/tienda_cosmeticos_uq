import model.Producto;
import model.Tienda;
import model.TipoCosmetico;
import model.Vendedor;

public class Main {



    public static Vendedor crearVendedor (String nombre, String cedula, int edad) {
        Vendedor vendedor = new Vendedor(nombre,cedula,edad);

        return vendedor;
    }

    public static Producto cerarProducto (String nombre, TipoCosmetico clasificación, double precio, int inventario ) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setInventario(inventario);

        return  producto;
    }

    public static void main(String[] args) {

        Tienda tienda = new Tienda("Cosmeticos Del Quindio", "CC. Portal del Quindio",
                "Tienda de productos para belleza");


        Producto producto1 = cerarProducto("Labial",TipoCosmetico.MAQUILLAJE,2000,3);
        Producto producto2 = cerarProducto("Base Crema",TipoCosmetico.MAQUILLAJE,1000,2);
        Producto producto3 = cerarProducto("Shampoo",TipoCosmetico.CABELLO,4000,4);
        Producto producto4 = cerarProducto("Esmalte Fortalecedor",TipoCosmetico.UÑAS,50000,2);
        Producto producto5 = cerarProducto("Serum Hidratante",TipoCosmetico.CUIDADO_PIEL,180000,3);
        Producto producto6 = cerarProducto("Contorno de ojos",TipoCosmetico.CUIDADO_PIEL,120000,2);

        tienda.setProducto1(producto1);
        tienda.setProducto2(producto2);
        tienda.setProducto3(producto3);
        tienda.setProducto4(producto4);
        tienda.setProducto5(producto5);
        tienda.setProducto6(producto6);

        Vendedor vendedor1 = crearVendedor("Valentina","10944",26);
        tienda.contratarVendedor(vendedor1);

        //Vender producto Labial

        tienda.venderProducto(producto1);
        tienda.venderProducto(producto1);
        tienda.venderProducto(producto1);
        tienda.venderProducto(producto1);

        tienda.venderProducto(producto2);
        tienda.venderProducto(producto2);

        System.out.println("Se han vendido " + producto1.getInventarioVendido() + " unidades de " + tienda.getProducto1().getNombre());
        System.out.println("Se han vendido " + producto2.getInventarioVendido() + " unidades de " + tienda.getProducto2().getNombre());

        System.out.println("Valor total de venta: " + tienda.calcularTotalVendido());


    }
}
