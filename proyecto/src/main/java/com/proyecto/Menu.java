package com.proyecto;

public class Menu {

    public void menuPrincipal(){
                System.out.print("""
                        *** SISTEMA DE GESTIÓN ***
                        \n1. Agregar producto
                        \n2. Listar productos
                        \n3. Buscar/Actualizar producto
                        \n4. Eliminar producto
                        \n5. Crear un pedido
                        \n6. Listar pedidos
                        \n7. Salir
                        \nSeleccione una opcion:
        """);
    }

    public void menuAgregarProducto(){
                System.out.println("""
                        --- TIPO DE PRODUCTO --- ***
                        \n1. Bebida
                        \n2. Comestible
                        \n3. Otro
                        \nSeleccione una opcion:""");
    }

    public void menuActualizar(){
                System.out.println("""
                        --- ACTUALIZAR --- ***
                        \n1. Actualizar precio
                        \n2. Actualizar stock
                        \n3. Salir
                        \nSeleccione una opcion:""");
    }

    public void menuEliminar(){
                System.out.println("""
                        --- ELIMINAR --- ***
                        \n1. Confirmar
                        \n2. Cancelar
                        \nSeleccione una opcion:""");
    }

    public void menuCrearPedido() {
                System.out.println("""
                        ***
                        \n1. Agregar otro producto
                        \n2. Finalizar pedido
                        \n3. Cancelar pedido
                        \nSeleccione una opcion:""");    }
}
