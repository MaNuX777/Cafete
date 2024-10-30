import java.util.LinkedList;

public class Pedido {
    private String nombreCliente;
    private LinkedList<Producto> productos;
    
    public class Producto {
        private String nombre;
        private int cantidad;
        
        public Producto(String nombre, int cantidad) {
            this.nombre = nombre;
            this.cantidad = cantidad;
        }
        public String toString() {
            return nombre + " (Cantidad: " + cantidad + ")";
        }
    }
    public Pedido(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.productos = new LinkedList<>();
    }

    public void agregarProducto(String nombre, int cantidad) {
        productos.add(new Producto(nombre, cantidad));
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }
    public String toString() {
        StringBuilder detalles = new StringBuilder("Cliente: " + nombreCliente + "\nProductos:\n");
        for (Producto producto : productos) {
            detalles.append("- ").append(producto).append("\n");
        }
        return detalles.toString();
    }
}
