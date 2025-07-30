package com.example.miprimerapi.holamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam; // <-- Asegúrate de que esta esté
import org.springframework.web.bind.annotation.RestController;

// Quitamos @RequestMapping("/productos") de aquí para que las rutas sean directas
@RestController
public class HelloController {

  @GetMapping("/hello") // Mapea las peticiones GET a la ruta /hello
  public String hello() {
    return "¡Hola desde Spring Boot con VS Code!";
  }

  @GetMapping("/saludo") // Mapea peticiones GET a la ruta /saludo
  public String saludo() {
    return "Un cordial saludo desde mi primera API Java Backend!";
  }

  // Endpoint de saludo con @RequestParam
  @GetMapping("/saludar")
  public String saludar(
      @RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre) {
    return "¡Hola, " + nombre + "!";
  }

  // Endpoint con @PathVariable
  @GetMapping("/mensaje/{id}")
  public String obtenerMensajePorId(@PathVariable String id) {
    return "Has solicitado el mensaje con ID: " + id;
  }
}