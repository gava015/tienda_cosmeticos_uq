package co.edu.uniquindio.tienda.model;

public class Asesoria {
    private String codigo;
    private String fecha;
    private Vendedor vendedor;
    private Cliente cliente;
    private Producto Producto;
    private TipoCosmetico tipoAsesoria;
    private Tienda ownedByTienda;

    public Asesoria() {
    }

    public Asesoria(String codigo, String fechaAsesoria, TipoCosmetico tipoAsesoria, Vendedor vendedor, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fechaAsesoria;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.tipoAsesoria = tipoAsesoria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }

    public TipoCosmetico getTipoAsesoria() {
        return tipoAsesoria;
    }

    public void setTipoAsesoria(TipoCosmetico tipoAsesoria) {
        this.tipoAsesoria = tipoAsesoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fechaAsesoria) {
        this.fecha = fechaAsesoria;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(co.edu.uniquindio.tienda.model.Producto producto) {
        Producto = producto;
    }
    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }

    public void setOwnedByTienda(Tienda ownedByTienda) {
        this.ownedByTienda = ownedByTienda;
    }

    public void crearTipoAsesoria(String tipoAsesoria){
        switch (tipoAsesoria){
            case "1":
                setTipoAsesoria(TipoCosmetico.MAQUILLAJE);
                break;
            case "2":
                setTipoAsesoria(TipoCosmetico.CUIDADO_PIEL);
                break;
            case "3":
                setTipoAsesoria(TipoCosmetico.CABELLO);
                break;
            case "4":
                setTipoAsesoria(TipoCosmetico.UÑAS);
                break;
        }
    }

    @Override
    public String toString() {
        return "Asesoria{" +
                "codigo=" + codigo +
                ", fechaAsesoria='" + fecha + '\'' +
                ", vendedor=" + vendedor.getCedula()+" - "+vendedor.getNombre() +
                ", cliente=" + cliente.getCedula() + " - " +cliente.getNombre() +
                ", Producto=" + Producto +
                ", tipoAsesoria=" + tipoAsesoria +
                '}';
    }
}
