import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pedido {
    private String nombreCliente;
    private LinkedList<Producto> productos;

    public Pedido(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.productos = new LinkedList<>();
    }

    public void agregarProducto(String nombreProducto, int cantidad) {
        productos.add(new Producto(nombreProducto, cantidad));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(nombreCliente).append("\n");
        for (Producto producto : productos) {
            sb.append(producto).append("\n");
        }
        return sb.toString();
    }
}

class Producto {
    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String toString() {
        return nombre + " x" + cantidad;
    }
}

public class SistemaCafeteria {
    private static Queue<Pedido> pedidos = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
                case 1 : registrarPedido();
                break;
                case 2 : atenderPedido();
                break;
                case 3 : verPedidosPendientes();
                break;
                case 4 : System.out.println("Saliendo del sistema...");
                break;
                default : System.out.println("Opción no válida. Intente nuevamente.");
                
            }
        } while (opcion != 4);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión de Pedidos ---");
        System.out.println("1. Registrar un Pedido");
        System.out.println("2. Atender el Próximo Pedido");
        System.out.println("3. Ver Pedidos Pendientes");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarPedido() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        Pedido pedido = new Pedido(nombreCliente);

        boolean agregarMasProductos;
        do {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            pedido.agregarProducto(nombreProducto, cantidad);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            agregarMasProductos = scanner.nextLine().equalsIgnoreCase("s");
        } while (agregarMasProductos);

        pedidos.add(pedido);
        System.out.println("Pedido registrado exitosamente.");
    }

    private static void atenderPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            Pedido pedido = pedidos.poll();
            System.out.println("Atendiendo pedido de:");
            System.out.println(pedido);
        }
    }

    private static void verPedidosPendientes() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("\nPedidos Pendientes:");
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }
}
