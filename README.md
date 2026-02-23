# Manegador de Stock  FX

Aplicación de escritorio desarrollada en **JavaFX** para la gestión de productos en el stock de una tienda.

Permite crear productos con validaciones de seguridad y visualizarlos en una interfaz gráfica sencilla.

---

## Características

Interfaz gráfica con JavaFX  
Arquitectura MVC  
Validación de datos del usuario  
Manejo de errores mediante alertas  
Proyecto Maven estructurado  
Uso de FXML y CSS  
Preparado para pruebas unitarias con JUnit y Mockito  

---

## Arquitectura del proyecto
```
practica10
├── src/main/java/com/example/stock
│ ├── MainApp.java → Punto de entrada de la aplicación
│ ├── Product.java → Modelo de datos
│ ├── ProductService.java → Lógica de negocio y validaciones
│ ├── ProductController.java→ Controlador de la interfaz
│ └── ProductLogger.java→ intefaz para loggear producto 
│
├── src/main/resources
│ ├── productView.fxml → Interfaz gráfica
│ └── css/styles.css → Estilos visuales
│
├── src/test/java/com/example/stock
│ ├── ProductServiceTest.java
│ ├── SecurityTests.java
│ └──ProductServiceMockitoTest.java
│
└── pom.xml

```
---

## Interfaz de usuario

La aplicación permite:

- Introducir nombre del producto
- Seleccionar cantidad
- Introducir precio
- Guardar el producto
- Visualizar los productos añadidos

---

## Modelo de datos

### `Product`

Representa un producto con los siguientes atributos:

- **nombre**
- **cantidad**
- **precio**

Incluye constructor, getters y setters.

---

## Lógica de negocio

### `ProductService`

Valida los datos introducidos antes de crear un producto:

- X Nombre vacío o nulo  
- X Cantidad menor o igual a 0  
- X Precio menor o igual a 0  

Si los datos no son válidos se lanza:

```java
IllegalArgumentException

```

## Autor

Zacaria Daghri

## Licence

This project is licensed under the MIT License.

