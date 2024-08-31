package com.losglobitos;

import java.util.Map;

public class Factura {
    private Pedido pedido;
    private double total;

    public Factura(Pedido pedido, double total) {
        this.pedido = pedido;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura\n");
        sb.append("Cliente: ").append(pedido.getCliente().getNombre()).append("\n");
        sb.append("Dirección: ").append(pedido.getCliente().getDireccion()).append("\n");
        sb.append("Productos:\n");

        // Usar el Map<Producto, Integer> para mostrar productos y sus cantidades
        for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            sb.append("- ").append(producto.getNombre()).append(" (Cantidad: ").append(cantidad).append(", Precio Unitario: ").append(producto.getPrecio()).append(", Subtotal: ").append(producto.getPrecio() * cantidad).append(")\n");
        }

        sb.append("Total: ").append(total).append("\n");
        return sb.toString();
    }
}
