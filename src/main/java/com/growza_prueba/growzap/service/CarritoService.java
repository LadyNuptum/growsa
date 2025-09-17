package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Carrito;
import com.growza_prueba.growzap.repository.ICarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService implements  ICarritoService{
    private ICarritoRepository carritoRepository;
    @Autowired
    public CarritoService(ICarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    @Override
    public List<Carrito> obtenerCarrito() {
        return carritoRepository.findAll();
    }

    @Override
    public Optional<Carrito> obtenerPorId(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public void guardarCarrito(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    public void editarCarrito(Long id, Carrito carrito) {
        Optional<Carrito> existeCarrito = carritoRepository.findById(id);
        if (existeCarrito.isPresent()){
            Carrito editarCarrito= existeCarrito.get();
            editarCarrito.setDetallesCarrito(carrito.getDetallesCarrito());
            editarCarrito.setUsuarios(carrito.getUsuarios());

            carritoRepository.save(editarCarrito);
        }else {
            throw new RuntimeException("No se encuentra el carrito");
        }
    }

    @Override
    public void eliminarCarrito(Long id) {
        Optional<Carrito> existeCarrito = carritoRepository.findById(id);
        if (existeCarrito.isPresent()){
            Carrito eliminarCarrito= existeCarrito.get();
            carritoRepository.delete(eliminarCarrito);
        }else {
            throw new RuntimeException("No se encuentra el carrito");
        }
    }
}
