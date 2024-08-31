package com.losglobitos;

import java.util.Map;

public class Controlador {
    private Inventario inventario;

    public Controlador() {
        this.inventario = new Inventario();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void realizarPedido(Pedido pedido) {
        for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            if (inventario.cantidadDisponible(producto) < cantidad) {
                System.out.println("No hay suficiente stock para " + producto.getNombre());
                return;
            }
        }

        for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            inventario.reducirProducto(producto, cantidad);
        }

        double total = calcularTotal(pedido);
        Factura factura = new Factura(pedido, total);
        System.out.println(factura);
    }

    public void inventarioGltt() {
        System.out.println("Inventario actual:");
        for (Map.Entry<Producto, Integer> entry : inventario.getStock().entrySet()) {
            Producto producto = entry.getKey();
            Integer cantidad = entry.getValue();
            System.out.println(producto + " - Cantidad: " + cantidad);
        }
    }

    private double calcularTotal(Pedido pedido) {
        double total = 0;
        for (Map.Entry<Producto, Integer> entry : pedido.getProductos().entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.getPrecio() * cantidad;
        }
        return total;
    }
}
