package com.example.miprimerapi.holamundo.model;

// Aunque no es estrictamente necesario para esta clase simple,
// es una práctica común para serialización/deserialización JSON.
// También se puede usar @Data de Lombok para reducir el boilerplate.
import java.io.Serializable;

public class Producto implements Serializable { // Implementar Serializable es buena práctica para DTOs

  private Long id;
  private String nombre;
  private double precio;

  // Constructor vacío (necesario para la deserialización de JSON por
  // Spring/Jackson)
  public Producto() {
  }

  // Constructor con todos los campos
  public Producto(Long id, String nombre, double precio) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
  }

  // Getters y Setters para cada campo
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  // Opcional: Método toString para una fácil depuración (generado automáticamente
  // por IDEs)
  @Override
  public String toString() {
    return "Producto{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", precio=" + precio +
        '}';
  }
}