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
    void agregarProducto(Long id_usuario, Long id_producto, int cantidad);
    void eliminarProducto(Long id_usuario, Long id_producto);
    Double calcularTotal(Long id_usuario);
    void vaciarCarrito(Long id_usuario);
    Carrito obtenerCarritoDeUsuario(Long id_usuario);
    void crearCarritoParaUsuario(Long id_usuario);
}
