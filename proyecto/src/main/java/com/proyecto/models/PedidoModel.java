package com.proyecto.models;

import java.util.ArrayList;

public class PedidoModel {
    private ArrayList<ProductoModel> productos = new ArrayList<>();
    private Integer id;
    private Double precioTotal;

    public PedidoModel(ArrayList<ProductoModel> productos){
        this.productos = productos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<ProductoModel> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoModel> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido{");
        sb.append("Id=").append(id);
        sb.append(", Productos=").append(productos);
        sb.append(", Precio Total=").append(precioTotal);
        sb.append('}');
        return sb.toString();
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

}
