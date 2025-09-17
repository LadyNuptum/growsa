package com.growza_prueba.growzap.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;

    //! Relaciones
    //* Un carrito pertenece a un unico usuario
    @OneToOne
    @JoinColumn(name = "id_usuarios")
    private Usuarios usuarios;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<Detalles_Carrito> detallesCarrito;


    //* Constructores
    public Carrito() {
    }

    public Carrito(Long id_carrito, Usuarios usuarios) {
        this.id_carrito = id_carrito;
    }

    //* Getters and Setters
    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public List<Detalles_Carrito> getDetallesCarrito() {
        return detallesCarrito;
    }

    public void setDetallesCarrito(List<Detalles_Carrito> detallesCarrito) {
        this.detallesCarrito = detallesCarrito;
    }
}