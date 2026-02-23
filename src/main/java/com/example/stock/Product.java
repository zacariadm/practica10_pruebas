package com.example.stock;

public class Product {

    private String nombre;
    private Integer cantidad;
    private Double precio;

    public Product(String nombre, Integer cantidad, Double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Product [nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }
}
