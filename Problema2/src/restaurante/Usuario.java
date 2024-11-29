package restaurante;

import java.util.List;

public class Usuario {
    private String nombre;
    private String direccion;
    private List<Pedido> pedidos;

    public Usuario(String nombre, String direccion, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.pedidos = pedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void generarReporte() {
        int total = Utilidades.calcularTotalPedidos(pedidos);
        List<Pedido> pedidosOrdenados = Utilidades.ordenarPedidosPorPrecio(pedidos);
        Utilidades.imprimirReporteUsuario(nombre, total, pedidosOrdenados);
    }
}
