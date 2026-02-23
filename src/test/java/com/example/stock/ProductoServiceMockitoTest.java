package com.example.stock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

/**
 * Test de ProductService usando Mockito para simular el comportamiento del logger.
 */
public class ProductoServiceMockitoTest {
    @Test
    void tetstCrearProducto() {
        ProductLogger mockLogger = mock(ProductLogger.class); // creamos un objeto falso de ProductLogger usando Mockito
        ProductService service = new ProductService(mockLogger); // inyectamos el mock(objeto falso) en el servicio

        service.añadirProductoLog(new Product("Pan", 10, 1.5));

        verify(mockLogger).log("Añadido: Pan"); // verificamos que el método log del mockLogger fue llamado con el mensaje esperado
    }

    /**
     * Test para verificar que añadirProducto lanza una excepción al intentar añadir un producto null.
      * Esto es importante para asegurar que el método maneja correctamente los casos de entrada inválida.
     */
    @Test
    void testAñadirProductoNull() {
        ProductLogger mockLogger = mock(ProductLogger.class);
        ProductService service = new ProductService(mockLogger);

        try {
            service.añadirProducto(null); // intentamos añadir un producto null, lo que debería lanzar una excepción
        } catch (IllegalArgumentException e) {
            // Verificamos que el mensaje de la excepción es el esperado
            assert(e.getMessage().equals("El producto no puede ser nulo."));
        }
    }

    /**
     * Test para verificar que crearProducto lanza una excepción al intentar crear un producto con nombre vacío.
     */
    @Test
    void testCrearProductoNombreVacio() {
        ProductLogger mockLogger = mock(ProductLogger.class);
        ProductService service = new ProductService(mockLogger);
        try {
            service.crearProducto("   ", 10, 1.5); // intentamos crear un producto con nombre vacío (solo espacios), lo que debería lanzar una excepción
        } catch (IllegalArgumentException e) {
            // Verificamos que el mensaje de la excepción es el esperado
            assert(e.getMessage().equals("El nombre del producto no puede estar vacío."));
        }
    }

    /**
     * Test para verificar que crearProducto lanza una excepción al intentar crear un producto con cantidad negativa.
     */
    @Test
    void testCrearProductoCantidadNegativa() {
        ProductLogger mockLogger = mock(ProductLogger.class);
        ProductService service = new ProductService(mockLogger);
        try {
            service.crearProducto("Leche", -5, 1.5); // intentamos crear un producto con cantidad negativa, lo que debería lanzar una excepción
        } catch (IllegalArgumentException e) {
            // Verificamos que el mensaje de la excepción es el esperado
            assert(e.getMessage().equals("La cantidad debe ser mayor que cero."));  
        }
    }
}
