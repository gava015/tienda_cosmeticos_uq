package co.edu.uniquindio.tienda.modelDto;

public record ProductoDto(String codigo, String nombre, double precio,
       int inventario, int inventarioVendido, String clasificacion) {
}
