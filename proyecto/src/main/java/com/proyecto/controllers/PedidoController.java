package com.proyecto.controllers;

import java.util.ArrayList;

import com.proyecto.models.PedidoModel;
import com.proyecto.models.ProductoModel;

public class PedidoController {
    private final ArrayList<PedidoModel> pedidos = new ArrayList<>();

    public void agregarPedido(PedidoModel pedido){
        pedidos.add(pedido);
        pedido.setId(pedidos.size());
    }

    public void crearPedido(ArrayList<ProductoModel> productos){
        PedidoModel pedido = new PedidoModel(productos);
        agregarPedido(pedido);
        precioTotal(pedido);
        listarPedido(pedido);
    }

    public ArrayList<ProductoModel> getProductosDelPedido(Integer id) {
        ArrayList<ProductoModel> productos = pedidos.get(id-1).getProductos();
        return productos;
    }

    public void listarPedidos(){
        pedidos.forEach(System.out::println);
    }

    public void precioTotal(PedidoModel pedido){
        Double precioTotal = 0.0;
        for(int i = 0; i < pedido.getProductos().size(); i += 1){
            Double precioProducto = pedido.getProductos().get(i).getPrecio();
            Integer stockProducto = pedido.getProductos().get(i).getStock();
            precioTotal = precioTotal + (precioProducto * stockProducto);
        }
        pedido.setPrecioTotal(precioTotal);
    }

    private void listarPedido(PedidoModel pedido) {
        System.out.println(pedido.toString());
    }

}
