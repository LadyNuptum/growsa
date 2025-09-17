package com.growza_prueba.growzap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @NotNull(message = "No puede estar vacio el campo")
    @Column(nullable = false)
    private String nombre_categoria;

    //! Relaciones
    //* Una catregoria puede tener muchos productos
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Productos> productos;

    //* Constructores
    public Categorias() {
    }

    public Categorias(String nombre_categoria, Long id_categoria) {
        this.nombre_categoria = nombre_categoria;
        this.id_categoria = id_categoria;
    }

    //* Getter y Setter

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
}
