package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Pedidos;

import java.util.List;
import java.util.Optional;

public interface IPedidosService {
    List<Pedidos> obtenerPedidos();
    Optional<Pedidos> obtenerPorId (Long id);
    void guardarPedidos (Pedidos pedidos);
    void editarPedidos (Long id , Pedidos pedidos);
    void eliminarPedidos (Long id);
}
