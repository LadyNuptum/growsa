package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Detalles_Pedidos;
import com.growza_prueba.growzap.repository.IDetallesPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService implements  IDetallesPedidosService{

    private IDetallesPedidoRepository detallesPedidoRepository;
    @Autowired
    public DetallePedidoService(IDetallesPedidoRepository detallesPedidoRepository) {
        this.detallesPedidoRepository = detallesPedidoRepository;
    }

    @Override
    public List<Detalles_Pedidos> obtenerDetallesPedidos() {
        return detallesPedidoRepository.findAll();
    }

    @Override
    public Optional<Detalles_Pedidos> obtenerPorId(Long id) {
        return detallesPedidoRepository.findById(id);
    }

    @Override
    public void guardarDetallePedido(Detalles_Pedidos detallesPedidos) {
        detallesPedidoRepository.save(detallesPedidos);
    }

    @Override
    public void editarDetallePedido(Long id, Detalles_Pedidos detallesPedidos) {
        Optional<Detalles_Pedidos> exiteDetalle = detallesPedidoRepository.findById(id);
        if (exiteDetalle.isPresent()){
            Detalles_Pedidos editarDetalle = exiteDetalle.get();
            editarDetalle.setCantidad(detallesPedidos.getCantidad());
            editarDetalle.setPrecio_unitario(detallesPedidos.getPrecio_unitario());
            detallesPedidoRepository.save(editarDetalle);
        }else{
            throw  new RuntimeException("El detalle del pedido no fue encontrado.");
        }

    }

    @Override
    public void eliminarDetallePedido(Long id) {
        Optional<Detalles_Pedidos> exiteDetalle = detallesPedidoRepository.findById(id);
        if (exiteDetalle.isPresent()){
            Detalles_Pedidos eliminarDetalle = exiteDetalle.get();
            detallesPedidoRepository.delete(eliminarDetalle);
        }else{
            throw  new RuntimeException("El detalle del pedido no fue encontrado.");
        }
    }
}
