package com.losglobitos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Exportador {

    public static void exportarInventario(Inventario inventario, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.append("Nombre,Descripción,Precio,Cantidad\n");
            for (Map.Entry<Producto, Integer> entry : inventario.getStock().entrySet()) {
                Producto producto = entry.getKey();
                Integer cantidad = entry.getValue();
                writer.append(producto.getNombre()).append(",")
                      .append(producto.getDescripcion()).append(",")
                      .append(String.valueOf(producto.getPrecio())).append(",")
                      .append(String.valueOf(cantidad)).append("\n");
            }
            System.out.println("Inventario exportado a " + archivo);
        } catch (IOException e) {
            System.out.println("Error al exportar el inventario: " + e.getMessage());
        }
    }
}
