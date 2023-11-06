package co.edu.uniquindio.tienda.modelDto;
import co.edu.uniquindio.tienda.model.TipoCosmetico;

public record ProductoDto(int codigo, String nombre, double precio,
       int inventario, int inventarioVendido, TipoCosmetico clasificacion) {
}
