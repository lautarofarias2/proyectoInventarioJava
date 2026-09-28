package com.proyecto.controllers;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.models.ProductoModel;

public class ProductoController {
    private final List<ProductoModel> productos = new ArrayList<>();

    public void disminuirStock(ProductoModel producto, Integer cantidad) throws Exception{
        if (producto.getStock() > 0 && producto.getStock() >= cantidad) {
            producto.setStock(producto.getStock() - cantidad);
        }
        else{
            throw new ArithmeticException("Insuficiente stock");
        }
    }

    public void aumentarStock(ProductoModel producto, Integer cantidad){
        producto.setStock(producto.getStock() + cantidad);
    }

    public void cambiarPrecio(ProductoModel producto, Double precio){
        producto.setPrecio(precio);
    }

    public void cambiarNombre(ProductoModel producto, String nombre){
        producto.setNombre(nombre);
    }

    //caso 1
    public void agregarProducto(ProductoModel producto){
        productos.add(producto);
        producto.setId(productos.size());
    }

    //caso 2
    public void listarProductos(){
        productos.forEach(System.out::println);
    }

    //caso 3
    public ProductoModel buscarProducto(Integer id) throws Exception{
        ProductoModel producto = productos.get(id-1);
        if(producto != null){
        return producto;
        }
        else{
            throw new Exception("El producto no existe");
        }
    }

    //caso 4
    public void eliminarProducto(Integer id) throws Exception{
        productos.remove(buscarProducto(id));
    }

    public ProductoModel crearProductoPedido(Integer id, Integer cantidad) throws Exception {
        ProductoModel producto = buscarProducto(id);
        disminuirStock(producto, cantidad);
        return (ProductoModel) producto.clone();
    }
}
