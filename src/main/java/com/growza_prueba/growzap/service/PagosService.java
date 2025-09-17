package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Pagos;
import com.growza_prueba.growzap.repository.IPagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagosService implements IPagosService{
    private IPagosRepository pagosRepository;

    @Autowired
    public PagosService(IPagosRepository pagosRepository) {
        this.pagosRepository = pagosRepository;
    }

    @Override
    public List<Pagos> obtenerPagos() {
        return pagosRepository.findAll();
    }

    @Override
    public Optional<Pagos> obtenerPorId(Long id) {
        return pagosRepository.findById(id);
    }

    @Override
    public void guardarPago(Pagos pago) {
        pagosRepository.save(pago);
    }

    @Override
    public void editarPago(Long id, Pagos pago) {
        Optional<Pagos> exitePago = pagosRepository.findById(id);
        if (exitePago.isPresent()){
            Pagos editarPago = exitePago.get();
            editarPago.setMonto(pago.getMonto());
            editarPago.setEstado_pago(pago.getEstado_pago());
            editarPago.setFecha_pago(pago.getFecha_pago());
            editarPago.setMetodo_pago(pago.getMetodo_pago());
            pagosRepository.save(editarPago);
        } else {
            throw new RuntimeException("El pago no fue encontrado.");
        }

    }

    @Override
    public void eliminarPago(Long id) {
        Optional<Pagos> exitePago = pagosRepository.findById(id);
        if (exitePago.isPresent()){
            Pagos eliminarPago = exitePago.get();
            pagosRepository.delete(eliminarPago);
        } else {
            throw new RuntimeException("El pago no fue encontrado.");
        }
    }
}
