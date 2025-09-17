package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Carrito;


import java.util.List;
import java.util.Optional;

public interface ICarritoService {

    List<Carrito> obtenerCarrito();
    Optional<Carrito> obtenerPorId(Long id);

    void guardarCarrito (Carrito carrito);
    void editarCarrito (Long id, Carrito carrito);
    void eliminarCarrito (Long id);
}
