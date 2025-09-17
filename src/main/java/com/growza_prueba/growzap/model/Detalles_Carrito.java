package com.growza_prueba.growzap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Detalles_Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_carrito;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private int cantidad;

    //* Ralaciones
    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos producto;

    //* Constructores
    public Detalles_Carrito() {
    }

    public Detalles_Carrito(Long id_detalle_carrito, int cantidad, Productos producto) {
        this.id_detalle_carrito = id_detalle_carrito;
        this.cantidad = cantidad;
    }

    //* Getter y Setter

    public Long getId_detalle_carrito() {
        return id_detalle_carrito;
    }

    public void setId_detalle_carrito(Long id_detalle_carrito) {
        this.id_detalle_carrito = id_detalle_carrito;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
