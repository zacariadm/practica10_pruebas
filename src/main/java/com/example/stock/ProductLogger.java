package com.example.stock;

/**
 * Interfaz para el logger de productos. Permite registrar mensajes relacionados con las operaciones de productos.
 * creado solo para usar Mock en las pruebas unitarias.
 */
public interface ProductLogger {
    void log(String message);
}
