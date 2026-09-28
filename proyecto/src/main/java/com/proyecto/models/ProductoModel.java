package com.proyecto.models;

public class ProductoModel implements Cloneable{
    private String nombre;
    private Double precio;
    private Integer stock;
    private Integer id;

    public ProductoModel(String nombre, Double precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    

    public ProductoModel(String nombre, Double precio, Integer stock, Integer id) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.id = id;
    }



    public ProductoModel() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append(" id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new ProductoModel(nombre,precio,stock,id);
        }
    }

    
}
