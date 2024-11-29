package restaurante;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utilidades {

    public static int calcularTotalProductos(List<Producto> productos) {
        return productos.stream().mapToInt(Producto::getPrecio).sum();
    }

    public static int calcularTotalPedidos(List<Pedido> pedidos) {
        return pedidos.stream().mapToInt(Pedido::calcularTotal).sum();
    }

    public static List<Pedido> ordenarPedidosPorPrecio(List<Pedido> pedidos) {
        pedidos.sort(Comparator.comparingInt(Pedido::calcularTotal));
        Collections.reverse(pedidos); // Orden descendente
        return pedidos;
    }

    public static void imprimirReportePedido(String cliente, List<Producto> productos, int total) {
        System.out.println("------------------------");
        System.out.println("Pedido de " + cliente);
        System.out.println("Productos:");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - " + producto.getPrecio());
        }
        System.out.println("Total: " + total);
    }

    public static void imprimirReporteUsuario(String nombre, int total, List<Pedido> pedidos) {
        System.out.println("------------------------");
        System.out.println("El total de compras para " + nombre + " es: " + total);
        for (Pedido pedido : pedidos) {
            pedido.generarReporte();
        }
    }
}
