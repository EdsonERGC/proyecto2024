package com.losglobitos;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Cliente cliente;
    private Map<Producto, Integer> productos;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (cantidad > 0) {
            productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
        }
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
