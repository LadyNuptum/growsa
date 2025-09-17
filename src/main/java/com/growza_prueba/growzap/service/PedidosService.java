package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Pedidos;
import com.growza_prueba.growzap.repository.IPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PedidosService implements IPedidosService{
    private IPedidosRepository pedidosRepository;
    @Autowired
    public PedidosService(IPedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }


    @Override
    public List<Pedidos> obtenerPedidos() {
        return pedidosRepository.findAll();
    }

    @Override
    public Optional<Pedidos> obtenerPorId(Long id) {
        return pedidosRepository.findById(id);
    }

    @Override
    public void guardarPedidos(Pedidos pedidos) {
        pedidosRepository.save(pedidos);
    }

    @Override
    public void editarPedidos(Long id, Pedidos pedidos) {
        Optional<Pedidos> exitePedido = pedidosRepository.findById(id);
        if (exitePedido.isPresent()){
            Pedidos peidoActualizar = exitePedido.get();
            peidoActualizar.setFecha_pedido(pedidos.getFecha_pedido());
            peidoActualizar.setTotal(pedidos.getTotal());
            peidoActualizar.setEstado(pedidos.getEstado());
            pedidosRepository.save(peidoActualizar);
        }else {
            throw new RuntimeException("El pedido no fue encontrado.");
        }
    }

    @Override
    public void eliminarPedidos(Long id) {
        Optional<Pedidos> exitePedido = pedidosRepository.findById(id);
        if (exitePedido.isPresent()){
            Pedidos peidoEliminar = exitePedido.get();
            pedidosRepository.delete(peidoEliminar);
        }else {
            throw new RuntimeException("El pedido no fue encontrado.");
        }
    }
}
