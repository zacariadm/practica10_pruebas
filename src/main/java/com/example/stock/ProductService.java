package com.example.stock;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> productos = new ArrayList<>();

    /**
     * Crea un nuevo producto
     * 
     */
    public Product crearProducto(String nombre, int cantidad, double precio){
        if (nombre == null || nombre.trim().isEmpty()) { // trim para eliminar espacios en blanco (lo dectecte con la prueba de nombre vacío)
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");

        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        return new Product(nombre, cantidad, precio);
    }

    /**
     * Añade un producto a la lista de productos para tenerlo en memoria
     * @param producto
     * @return
     */
    public List<Product> añadirProducto(Product producto) {
        if(producto == null) { // si el producto es null, lanzamo sexcepción (lo detecto con la prueba de añadir producto null)
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        productos.add(producto);
        return productos;
    }

    /**
     * Devuelve la lista de productos (solo lectura)
     */
    public List<Product> obtenerProductos() {
       return this.productos;
    }

    /**
     * Elimina un producto del stock
     */
    public void eliminarProducto(Product producto) {
        productos.remove(producto);
    }

    /**
     * Limpia el stock (útil para tests)
     */
    public void limpiarStock() {
        productos.clear();
    }

}
