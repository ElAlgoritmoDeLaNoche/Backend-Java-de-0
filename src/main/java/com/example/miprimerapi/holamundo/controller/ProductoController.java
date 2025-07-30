package com.example.miprimerapi.holamundo.controller;

import com.example.miprimerapi.holamundo.model.Producto; // Importa tu clase Producto
import org.springframework.http.ResponseEntity; // Para controlar las respuestas HTTP
import org.springframework.web.bind.annotation.*; // Importa todas las anotaciones web de Spring

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/productos") // Prefijo para todas las rutas de este controlador
public class ProductoController {

  // --- Simulación de base de datos en memoria ---
  private List<Producto> productos = new ArrayList<>();
  private Long nextId = 1L; // Para asignar IDs únicos
  // ---------------------------------------------

  // Constructor para inicializar algunos productos (opcional, para facilitar
  // pruebas)
  public ProductoController() {
    productos.add(new Producto(nextId++, "Laptop Gamer", 1200.50));
    productos.add(new Producto(nextId++, "Teclado Mecánico", 85.00));
    productos.add(new Producto(nextId++, "Monitor Curvo", 350.00));
  }

  // 1. Endpoint POST para crear un producto
  // URL: POST http://localhost:8080/productos
  @PostMapping
  public ResponseEntity<Producto> crearProducto(@RequestBody Producto nuevoProducto) {
    nuevoProducto.setId(nextId++); // Asignar un ID único
    productos.add(nuevoProducto); // Añadir a la lista en memoria
    System.out.println("Producto creado: " + nuevoProducto.toString());
    // Retorna 201 Created y el producto creado
    return ResponseEntity.status(201).body(nuevoProducto);
  }

  // 2. Endpoint GET para obtener todos los productos
  // URL: GET http://localhost:8080/productos
  @GetMapping
  public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
    System.out.println("Solicitando todos los productos. Cantidad: " + productos.size());
    return ResponseEntity.ok(productos); // Retorna 200 OK y la lista de productos
  }

  // 3. Endpoint GET para obtener un producto por ID
  // URL: GET http://localhost:8080/productos/{id}
  @GetMapping("/{id}")
  public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
    Optional<Producto> productoEncontrado = productos.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();

    if (productoEncontrado.isPresent()) {
      System.out.println("Producto encontrado: " + productoEncontrado.get().toString());
      return ResponseEntity.ok(productoEncontrado.get()); // 200 OK y el producto
    } else {
      System.out.println("Producto con ID " + id + " no encontrado.");
      return ResponseEntity.notFound().build(); // 404 Not Found
    }
  }

  // 4. Endpoint PUT para actualizar un producto
  // URL: PUT http://localhost:8080/productos/{id}
  @PutMapping("/{id}")
  public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
    Optional<Producto> productoExistenteOpt = productos.stream()
        .filter(p -> p.getId().equals(id))
        .findFirst();

    if (productoExistenteOpt.isPresent()) {
      Producto productoExistente = productoExistenteOpt.get();
      // Actualizar los campos del producto existente
      productoExistente.setNombre(productoActualizado.getNombre());
      productoExistente.setPrecio(productoActualizado.getPrecio());

      System.out.println("Producto actualizado: " + productoExistente.toString());
      return ResponseEntity.ok(productoExistente); // 200 OK y el producto actualizado
    } else {
      System.out.println("Producto con ID " + id + " no encontrado para actualizar.");
      return ResponseEntity.notFound().build(); // 404 Not Found
    }
  }

  // 5. Endpoint DELETE para eliminar un producto
  // URL: DELETE http://localhost:8080/productos/{id}
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
    boolean removido = productos.removeIf(p -> p.getId().equals(id));

    if (removido) {
      System.out.println("Producto con ID " + id + " eliminado.");
      return ResponseEntity.noContent().build(); // 204 No Content
    } else {
      System.out.println("Producto con ID " + id + " no encontrado para eliminar.");
      return ResponseEntity.notFound().build(); // 404 Not Found
    }
  }
}