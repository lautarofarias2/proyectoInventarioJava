package com.proyecto;

import java.util.ArrayList;
import java.util.Scanner;

import com.proyecto.controllers.PedidoController;
import com.proyecto.controllers.ProductoController;
import com.proyecto.models.ProductoModel;

public class InventarioApp {
    private static final ProductoController productoController = new ProductoController();
    private static final PedidoController pedidoController = new PedidoController();
    private static final Menu menu = new Menu();

    public static void main(String[] args) throws Exception {
        menu();
    }

    private static void menu() throws Exception{
        Scanner sc = new Scanner(System.in);
        Boolean salir = Boolean.FALSE;
        while(!salir){        
            menu.menuPrincipal();
            Integer opcion = sc.nextInt();
            sc.nextLine();
            salir = opciones(opcion, sc);
        }
    }

    private static Boolean opciones(Integer opcion, Scanner sc) throws Exception{
        Boolean salir = Boolean.FALSE;
        switch (opcion) {
            case 1 ->{
                System.out.println("--- Agregar producto ---");
                System.out.println("Ingrese el nombre del producto: ");
                String nombre = sc.nextLine();
                System.out.println("Ingrese el precio del producto: ");
                Double precio = sc.nextDouble();
                System.out.println("Ingrese el stock del producto: ");
                Integer stock = sc.nextInt();
                ProductoModel producto = new ProductoModel();
                productoController.agregarProducto(producto);
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setStock(stock);
                System.out.println(producto);
                    }
            case 2 ->{
                System.out.println("--- Listar productos ---");
                productoController.listarProductos();
            }
            case 3 ->{
                System.out.println("--- Buscar producto ---");
                productoController.listarProductos();
                System.out.println("Ingrese el id del producto: ");
                Integer id = sc.nextInt();
                ProductoModel producto = productoController.buscarProducto(id);
                if(producto != null){
                    System.out.println(producto);
                    Boolean salirActualizar = Boolean.FALSE;
                    while(!salirActualizar){
                    menu.menuActualizar();
                    Integer opcionActualizar = sc.nextInt();
                    switch (opcionActualizar) {
                        case 1 ->{
                            System.out.println("Ingrese el precio del producto: ");
                            Double precio = sc.nextDouble();
                            producto.setPrecio(precio);
                            System.out.println(producto);
                        }
                        case 2 ->{
                            System.out.println("Ingrese el stock del producto: ");
                            Integer stock = sc.nextInt();
                            producto.setStock(stock);
                            System.out.println(producto);
                        }
                        case 3 ->{
                            salirActualizar = Boolean.TRUE;
                        }
                        default->{
                            System.out.println("Opcion no valida");
                        }
                    }
                    }
                }
                else{
                    System.out.println("Producto no encontrado");
                }
            }
            case 4 ->{
                System.out.println("--- Eliminar producto ---");
                System.out.println("Ingrese el id del producto: ");
                Integer id = sc.nextInt();
                ProductoModel producto = productoController.buscarProducto(id);
                    if(producto != null){
                        Boolean salirEliminar= Boolean.FALSE;
                        while(!salirEliminar){
                        menu.menuEliminar();
                        Integer opcionEliminar= sc.nextInt();
                        switch (opcionEliminar) {
                            case 1 ->{
                                productoController.eliminarProducto(id);
                                System.out.println("Producto eliminado correctamente");
                                salirEliminar = Boolean.TRUE;
                                }
                            case 2 ->{
                                salirEliminar = Boolean.TRUE;
                            }
                            default->{
                                System.out.println("Opcion no valida");
                            }
                            }
                            }
                    }
                    else{
                        System.out.println("Producto no encontrado");
                    }
            }
            case 5 ->{
                System.out.println("--- Crear un pedido ---");
                Boolean salirPedido = Boolean.FALSE;
                ArrayList<ProductoModel> productosDelPedido = new ArrayList<>();
                while(!salirPedido){
                    productoController.listarProductos();
                    System.out.println("Ingresar el id del producto: ");
                    Integer idProducto = sc.nextInt();
                    ProductoModel producto = productoController.buscarProducto(idProducto);
                    if(producto != null){
                        System.out.println("Ingrese la cantidad del producto: ");
                        Integer cantidad = sc.nextInt();
                        productosDelPedido.add(productoController.crearProductoPedido(idProducto, cantidad));
                    }
                    else{
                        System.out.println("El producto no existe");
                    }
                    menu.menuCrearPedido();
                    Integer opcionPedido = sc.nextInt();
                    switch (opcionPedido) {
                        case 1->{
                            salirPedido = Boolean.FALSE;
                        }
                        case 2 ->{
                            pedidoController.crearPedido(productosDelPedido);
                            salirPedido = Boolean.TRUE;
                        }
                        case 3 ->{
                            salirPedido = Boolean.TRUE;
                        }
                        default->{
                            System.out.println("Opcion no valida");
                        }
                    }
            }
            }
            case 6 ->{
                System.out.println("--- Listar pedidos ---");
                pedidoController.listarPedidos();
            }
            case 7 ->{
                salir = Boolean.TRUE;
            }
            default -> {
                System.out.println("Opcion no valida");
            }
        }
        return salir;
    }
}