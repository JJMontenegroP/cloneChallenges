package restaurante;

import java.util.List;

public class Pedido {
    private Usuario cliente;
    private List<Producto> productos;

    public Pedido(Usuario cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int calcularTotal() {
        return Utilidades.calcularTotalProductos(productos);
    }

    public void generarReporte() {
        Utilidades.imprimirReportePedido(cliente.getNombre(), productos, calcularTotal());
    }
}
