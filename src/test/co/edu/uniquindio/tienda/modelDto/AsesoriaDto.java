package co.edu.uniquindio.tienda.modelDto;

import co.edu.uniquindio.tienda.model.Cliente;
import co.edu.uniquindio.tienda.model.Vendedor;

public record AsesoriaDto(String codigo, String fechaAsesoria, String tipoAsesoria, Vendedor vendedor, Cliente cliente) {
}
