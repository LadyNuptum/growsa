package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Detalles_Carrito;
import com.growza_prueba.growzap.repository.IDetallesCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCarritoService implements IDetalleCarritoService{
    private IDetallesCarritoRepository detallesCarritoRepository;

    @Autowired
    public DetalleCarritoService(IDetallesCarritoRepository detallesCarritoRepository) {
        this.detallesCarritoRepository = detallesCarritoRepository;
    }


    @Override
    public List<Detalles_Carrito> obtenerDetallesCarrito() {
        return detallesCarritoRepository.findAll();
    }

    @Override
    public Optional<Detalles_Carrito> obtenerPorId(Long id) {
        return detallesCarritoRepository.findById(id);
    }

    @Override
    public void guardarDetalleCarrito(Detalles_Carrito detallesCarrito) {
        detallesCarritoRepository.save(detallesCarrito);
    }

    @Override
    public void editarDetalleCarrito(Long id, Detalles_Carrito detallesCarrito) {
        Optional<Detalles_Carrito> exiteCarrito = detallesCarritoRepository.findById(id);
        if (exiteCarrito.isPresent()){
            Detalles_Carrito editarCarrito = exiteCarrito.get();
            editarCarrito.setCantidad(detallesCarrito.getCantidad());
            detallesCarritoRepository.save(editarCarrito);
        }else{
            throw  new RuntimeException("El detalle del pedido no fue encontrado.");
        }
    }

    @Override
    public void eliminarDetalleCarrito(Long id) {
        Optional<Detalles_Carrito> exiteCarrito = detallesCarritoRepository.findById(id);
        if (exiteCarrito.isPresent()){
            Detalles_Carrito eliminarCarrito = exiteCarrito.get();
            detallesCarritoRepository.delete(eliminarCarrito);
        }else{
            throw  new RuntimeException("El detalle del pedido no fue encontrado.");
        }
    }
}
