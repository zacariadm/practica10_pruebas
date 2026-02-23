package com.example.stock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductController {

    // Servicio con lista en memoria
    private final ProductService productService = new ProductService();

    // Lista observable que vive durante toda la app
    private final ObservableList<Product> listaProductos = FXCollections.observableArrayList();


    @FXML
    private Button buttonGuardar;

    @FXML
    private TextField fieldNombre;

    @FXML
    private ListView<Product> listViewProductos;

    @FXML
    private Spinner<Integer> spinnerCantidad;

    @FXML
    private Spinner<Double> spinnerPrecio;


    /**
     * Inicializa el controlador y configura los Spinners para cantidad y precio.
     */
    @FXML
    void initialize() {
        
        // Configuramos los Spinners para cantidad y precio
        spinnerCantidad.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999, 1)
        );

        spinnerPrecio.setValueFactory(
            new SpinnerValueFactory.DoubleSpinnerValueFactory(0.01,1000.00, 0.01)
        );

        listViewProductos.setItems(listaProductos);

    }

    /**
     * Maneja el evento de clic en el botón "Guardar Producto". Crea un nuevo producto con los valores ingresados y lo agrega a la lista de productos.
     * @param event
     */
    @FXML
    void guardarProducto(ActionEvent event) {
        String nombre = fieldNombre.getText();
        int cantidad = spinnerCantidad.getValue();
        double precio = spinnerPrecio.getValue();

        try {
            Product nuevoProducto = productService.crearProducto(nombre, cantidad, precio);
            
             // Añadimos producto a la lista del servicio para tenerlo en memoria (aunque no es estrictamente necesario para esta app, lo hacemos
            productService.añadirProducto(nuevoProducto);
            

            // Para mostrar los productos sen la ListView
            listViewProductos.setItems(FXCollections.observableList(productService.obtenerProductos()));

             // Limpiamos los campos después de guardar el producto
            fieldNombre.clear();
            spinnerCantidad.getValueFactory().setValue(1);
            spinnerPrecio.getValueFactory().setValue(0.01);
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al crear el producto");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }
    }

    // No damos la Opción a ELiminar por ahora

}

