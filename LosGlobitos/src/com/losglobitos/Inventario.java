package com.losglobitos;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<Producto, Integer> stock;

    public Inventario() {
        this.stock = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        stock.put(producto, stock.getOrDefault(producto, 0) + cantidad);
    }

    public void reducirProducto(Producto producto, int cantidad) {
        if (stock.containsKey(producto)) {
            int nuevaCantidad = stock.get(producto) - cantidad;
            if (nuevaCantidad <= 0) {
                stock.remove(producto);
            } else {
                stock.put(producto, nuevaCantidad);
            }
        }
    }

    public int cantidadDisponible(Producto producto) {
        return stock.getOrDefault(producto, 0);
    }

    public Map<Producto, Integer> getStock() {
        return stock;
    }
}
