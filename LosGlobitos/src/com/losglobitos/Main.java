package com.losglobitos;

import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner scanner = new Scanner(System.in);

        // Inicializar datos de prueba
        controlador.getInventario().agregarProducto(new Producto("Sombrilla", "Sombrilla con logo", 25.0), 10);
        controlador.getInventario().agregarProducto(new Producto("Bolígrafo", "Bolígrafo con logo", 2.0), 50);

        boolean running = true;

        while (running) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Ver inventario");
            System.out.println("2. Agregar producto al inventario");
            System.out.println("3. Realizar un pedido");
            System.out.println("4. Exportar inventario");
            System.out.println("5. Importar inventario");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    controlador.inventarioGltt();
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Ingrese la descripción del producto: ");
                    String descripcionProducto = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    double precioProducto = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad a agregar: ");
                    int cantidadProducto = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea

                    Producto nuevoProducto = new Producto(nombreProducto, descripcionProducto, precioProducto);
                    controlador.getInventario().agregarProducto(nuevoProducto, cantidadProducto);
                    System.out.println("Producto agregado al inventario.");
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese la dirección del cliente: ");
                    String direccionCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nombreCliente, direccionCliente);

                    Pedido pedido = new Pedido(cliente);

                    boolean addingProducts = true;
                    while (addingProducts) {
                        System.out.print("Ingrese el nombre del producto para el pedido (o 'terminar' para finalizar): ");
                        String nombreProductoPedido = scanner.nextLine();
                        if (nombreProductoPedido.equalsIgnoreCase("terminar")) {
                            addingProducts = false;
                        } else {
                            Producto productoPedido = buscarProducto(controlador, nombreProductoPedido);
                            if (productoPedido != null) {
                                System.out.print("Ingrese la cantidad del producto: ");
                                int cantidad = scanner.nextInt();
                                scanner.nextLine();  // Consumir el salto de línea

                                if (cantidad > 0) {
                                    pedido.agregarProducto(productoPedido, cantidad);
                                    System.out.println("Producto añadido al pedido.");
                                } else {
                                    System.out.println("La cantidad debe ser mayor que 0.");
                                }
                            } else {
                                System.out.println("Producto no encontrado.");
                            }
                        }
                    }

                    controlador.realizarPedido(pedido);
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del archivo para exportar: ");
                    String archivoExportar = scanner.nextLine();
                    Exportador.exportarInventario(controlador.getInventario(), archivoExportar);
                    break;

                case 5:
                    System.out.print("Ingrese el nombre del archivo para importar: ");
                    String archivoImportar = scanner.nextLine();
                    Importador.importarInventario(controlador.getInventario(), archivoImportar);
                    break;

                case 6:
                    running = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private static Producto buscarProducto(Controlador controlador, String nombreProducto) {
        for (Entry<Producto, Integer> entry : controlador.getInventario().getStock().entrySet()) {
            if (entry.getKey().getNombre().equalsIgnoreCase(nombreProducto)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
