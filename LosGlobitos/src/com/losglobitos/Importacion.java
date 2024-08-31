package com.losglobitos;

public class Importacion {
    private Producto producto;
    private int cantidad;
    private double costo;

    public Importacion(Producto producto, int cantidad, double costo) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public void registrarImportacion() {
        System.out.println("Importando " + cantidad + " unidades de " + producto.getNombre() + " a un costo de " + costo);
    }

    // Getters y setters
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
}
