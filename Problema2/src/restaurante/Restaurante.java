package restaurante;

import java.util.List;
import java.util.ArrayList;

public class Restaurante {
    private List<Producto> productos;
    private List<Pedido> pedidos;
    private List<Usuario> usuarios;

    public Restaurante(List<Producto> productos, List<Pedido> pedidos, List<Usuario> usuarios) {
        this.productos = productos;
        this.pedidos = pedidos;
        this.usuarios = usuarios;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void generarReporte() {
        int total = Utilidades.calcularTotalPedidos(pedidos);
        List<Pedido> pedidosOrdenados = Utilidades.ordenarPedidosPorPrecio(pedidos);
        System.out.println("------------------------");
        System.out.println("El total de ventas para el restaurante es: " + total);
        for (Pedido pedido : pedidosOrdenados) {
            pedido.generarReporte();
        }
    }

    public static void main(String[] args) {
        // Crear productos
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Hamburguesa", 100));
        productos.add(new Producto("Papas", 50));
        productos.add(new Producto("Refresco", 30));
        productos.add(new Producto("Helado", 20));

        // Crear usuarios
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Juan", "Calle 1", new ArrayList<>()));
        usuarios.add(new Usuario("Pedro", "Calle 2", new ArrayList<>()));

        // Crear listas de productos para los pedidos
        ArrayList<Producto> productosPedido1 = new ArrayList<>();
        productosPedido1.add(productos.get(0)); // Hamburguesa
        productosPedido1.add(productos.get(1)); // Papas

        ArrayList<Producto> productosPedido2 = new ArrayList<>();
        productosPedido2.add(productos.get(2)); // Refresco
        productosPedido2.add(productos.get(3)); // Helado

        ArrayList<Producto> productosPedido3 = new ArrayList<>();
        productosPedido3.add(productos.get(0)); // Hamburguesa
        productosPedido3.add(productos.get(1)); // Papas
        productosPedido3.add(productos.get(2)); // Refresco

        // Crear pedidos
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(usuarios.get(0), productosPedido1));
        pedidos.add(new Pedido(usuarios.get(0), productosPedido2));
        pedidos.add(new Pedido(usuarios.get(1), productosPedido3));

        // Asignar pedidos a los usuarios
        ArrayList<Pedido> pedidosUsuario1 = new ArrayList<>();
        pedidosUsuario1.add(pedidos.get(0));
        pedidosUsuario1.add(pedidos.get(1));
        usuarios.get(0).setPedidos(pedidosUsuario1);

        ArrayList<Pedido> pedidosUsuario2 = new ArrayList<>();
        pedidosUsuario2.add(pedidos.get(2));
        usuarios.get(1).setPedidos(pedidosUsuario2);

        // Crear restaurante
        Restaurante restaurante = new Restaurante(productos, pedidos, usuarios);

        // Generar reportes
        System.out.println("REPORTE DEL RESTAURANTE:");
        restaurante.generarReporte();

        System.out.println("\nREPORTE DEL USUARIO 1:");
        usuarios.get(0).generarReporte();

        System.out.println("\nREPORTE DEL USUARIO 2:");
        usuarios.get(1).generarReporte();
    }
}
