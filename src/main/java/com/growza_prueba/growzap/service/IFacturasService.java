package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Facturas;

import java.util.List;
import java.util.Optional;

public interface IFacturasService {

    List<Facturas> mostrarFacturas();
    Optional<Facturas> mostrarPorId (Long id);

    void guardarFactura (Facturas factura);
    void editarFactura (Long id, Facturas factura);
    void eliminarFactura (Long id);

}
