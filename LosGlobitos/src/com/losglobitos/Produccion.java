package com.losglobitos;

public class Produccion {
    private Producto producto;
    private int cantidad;

    public Produccion(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Métodos para manejar producción
    public void iniciarProduccion() {
        System.out.println("Iniciando producción de " + cantidad + " unidades de " + producto.getNombre());
        // Aquí podrías añadir lógica para actualizar el inventario
    }

    // Getters y setters
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
