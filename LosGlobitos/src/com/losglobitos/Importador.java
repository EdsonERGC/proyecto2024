package com.losglobitos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Importador {

    public static void importarInventario(Inventario inventario, String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leer y descartar la primera línea (encabezado)
            reader.readLine();

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String nombre = partes[0];
                    String descripcion = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    int cantidad = Integer.parseInt(partes[3]);

                    Producto producto = new Producto(nombre, descripcion, precio);
                    inventario.agregarProducto(producto, cantidad);
                }
            }
            System.out.println("Inventario importado desde " + archivo);
        } catch (IOException e) {
            System.out.println("Error al importar el inventario: " + e.getMessage());
        }
    }
}
