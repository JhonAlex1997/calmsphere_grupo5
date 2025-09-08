package com.example.Category.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer categoriaId;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Constructores
    public Categoria() {
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString para debugging
    @Override
    public String toString() {
        return "Categoria{" +
                "categoriaId=" + categoriaId +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    // equals y hashCode para comparaciones
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;
        return categoriaId != null ? categoriaId.equals(categoria.categoriaId) : categoria.categoriaId == null;
    }

    @Override
    public int hashCode() {
        return categoriaId != null ? categoriaId.hashCode() : 0;
    }
}