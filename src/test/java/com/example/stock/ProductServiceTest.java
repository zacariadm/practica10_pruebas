package com.example.stock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Pruebas unitarias para ProductService.
 * 
 * Verifica:
 * - Creación de productos
 * - Validaciones de datos
 * - Almacenamiento en memoria
 * - Eliminación de productos
 */
public class ProductServiceTest {

    // Instancia del servicio que se va a probar
    private ProductService service;

    // Antes de cada test, inicializamos el servicio y limpiamos el stock para asegurar un estado limpio
    @BeforeEach
    void setUp() {
        service = new ProductService();
        service.limpiarStock();
    }

    /**
     * Crea un producto con datos válidos y verifica que se crea correctamente.
     * Verifica que el producto no sea nulo y que sus atributos coincidan con los valores proporcionados.
     */
    @Test
    void crearProducto_datosValidos_creaProducto() {
        Product p = service.crearProducto("Pan", 3, 1.50);

        assertNotNull(p);
        assertEquals("Pan", p.getNombre());
        assertEquals(3, p.getCantidad());
        assertEquals(1.50, p.getPrecio());
    }


    /**
     * Intenta crear un producto con un nombre nulo y verifica que se lanza una IllegalArgumentException.
     */
    @Test
    void crearProducto_nombreVacio_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> service.crearProducto("   ", 1, 1.0));
    }

    /**
     * Intenta crear un producto con una cantidad no válida (0 o negativa) y verifica que se lanza una IllegalArgumentException.
     */
    @Test
    void crearProducto_cantidadNoValida_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> service.crearProducto("Pan", -3, 1.0));
    }

    /**
     * Intenta crear un producto con un precio no válido (0 o negativo) y verifica que se lanza una IllegalArgumentException.
     */
    @Test
    void crearProducto_precioNoValido_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> service.crearProducto("Pan", 1, 0.0));
    }

    /**
     * Añade un producto al servicio y verifica que se guarda correctamente en memoria.
     * Verifica que la lista de productos tenga el tamaño esperado y que el producto añadido sea el mismo que el creado.
     */
    @Test
    void añadirProducto_seGuardaEnMemoria() {
        Product p = service.crearProducto("Leche", 2, 2.20);

        service.añadirProducto(p);

        assertEquals(1, service.obtenerProductos().size());
        assertSame(p, service.obtenerProductos().get(0));
    }

    /**
     * Añade un producto al servicio, luego lo elimina y verifica que ya no esté en la lista de productos.
     * Verifica que la lista de productos esté vacía después de eliminar el producto.
     */
    @Test
    void eliminarProducto_loEliminaDeLaLista() {
        Product p = service.crearProducto("Huevos", 6, 3.40);
        service.añadirProducto(p);

        service.eliminarProducto(p);

        assertTrue(service.obtenerProductos().isEmpty());
    }
}