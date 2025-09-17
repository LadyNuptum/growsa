package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Detalles_Carrito;
import com.growza_prueba.growzap.model.Detalles_Pedidos;

import java.util.List;
import java.util.Optional;

public interface IDetalleCarritoService {

    List<Detalles_Carrito> obtenerDetallesCarrito();
    Optional<Detalles_Carrito> obtenerPorId(Long id);

    void guardarDetalleCarrito (Detalles_Carrito detallesCarrito);
    void editarDetalleCarrito (Long id, Detalles_Carrito detallesCarrito);
    void eliminarDetalleCarrito (Long id);
}
