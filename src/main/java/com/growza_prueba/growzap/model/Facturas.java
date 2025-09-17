package com.growza_prueba.growzap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    @PastOrPresent(message = "La fecha no puede ser futura")
    @Column(nullable = false)
    private LocalDate fecha_emision;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private double numero_factura;

    //! Relaciones
    //* Una factura pertenece a un solo pedido
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedidos pedido;

    //* Constructores
    public Facturas() {
    }

    public Facturas(Long id_factura, LocalDate fecha_emision, double numero_factura) {
        this.id_factura = id_factura;
        this.fecha_emision = fecha_emision;
        this.numero_factura = numero_factura;

    }

    //* Getter y Setter
    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public double getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(double numero_factura) {
        this.numero_factura = numero_factura;
    }

}
