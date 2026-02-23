package com.example.stock;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Pruebas de seguridad para ProductService.
 * Verifica que se lanzan excepciones al intentar crear productos con datos no válidos o al añadir productos nulos.
 */
public class SecurityTests {

    /**
     * Intenta crear un producto con un nombre nulo y verifica que se lanza una IllegalArgumentException.
     */
    @Test
    void crearProducto_nombreNull_lanzaExcepcion() {
        ProductService service = new ProductService();
        assertThrows(IllegalArgumentException.class,
                () -> service.crearProducto(null, 1, 1.0));
    }


    /**
     * Intenta añadir un producto nulo y verifica que se lanza una IllegalArgumentException.
     */
    @Test
    void añadirProducto_null_lanzaExcepcion() {
        ProductService service = new ProductService();
        assertThrows(IllegalArgumentException.class,
                () -> service.añadirProducto(null));
    }
}
