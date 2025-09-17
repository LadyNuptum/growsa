package com.growza_prueba.growzap.service;
import com.growza_prueba.growzap.model.Detalles_Pedidos;


import java.util.List;
import java.util.Optional;

public interface IDetallesPedidosService {
    List<Detalles_Pedidos> obtenerDetallesPedidos();
    Optional<Detalles_Pedidos> obtenerPorId(Long id);

    void guardarDetallePedido (Detalles_Pedidos detallesPedidos);
    void editarDetallePedido (Long id, Detalles_Pedidos detallesPedidos);
    void eliminarDetallePedido (Long id);

}
