package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Pagos;

import java.util.List;
import java.util.Optional;

public interface IPagosService {
    List<Pagos> obtenerPagos();
    Optional<Pagos> obtenerPorId(Long id);

    void guardarPago (Pagos pago);
    void editarPago (Long id, Pagos pago);
    void eliminarPago (Long id);
}
