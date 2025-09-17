package com.growza_prueba.growzap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private double monto;

    @PastOrPresent(message = "La fecha no puede ser futura")
    @Column(nullable = false)
    private LocalDate fecha_pago;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private String metodo_pago;

    @NotNull(message = "No puede estar vacío el campo")
    @Column(nullable = false)
    private String estado_pago;

    //! Relaciones
    //* Un pago pertenece a un solo pedido
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedidos pedido;

    //* Constructores
    public Pagos() {
    }

    public Pagos(LocalDate fecha_pago, Long id_pago, double monto, String metodo_pago, String estado_pago) {
        this.fecha_pago = fecha_pago;
        this.id_pago = id_pago;
        this.monto = monto;
        this.metodo_pago = metodo_pago;
        this.estado_pago = estado_pago;
    }

    //* Getter y Setter
    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }
}
