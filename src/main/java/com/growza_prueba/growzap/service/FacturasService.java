package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Facturas;
import com.growza_prueba.growzap.repository.IFacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturasService implements  IFacturasService{
    private IFacturasRepository facturasRepository;

    @Autowired
    public FacturasService(IFacturasRepository facturasRepository) {
        this.facturasRepository = facturasRepository;
    }


    @Override
    public List<Facturas> mostrarFacturas() {
        return facturasRepository.findAll();
    }

    @Override
    public Optional<Facturas> mostrarPorId(Long id) {
        return facturasRepository.findById(id);
    }

    @Override
    public void guardarFactura(Facturas factura) {
        facturasRepository.save(factura);
    }

    @Override
    public void editarFactura(Long id, Facturas factura) {
        Optional<Facturas> existeFactura = facturasRepository.findById(id);
        if (existeFactura.isPresent()){
            Facturas facturaEditar = existeFactura.get();
            facturaEditar.setNumero_factura(factura.getNumero_factura());
            facturaEditar.setFecha_emision(factura.getFecha_emision());

            facturasRepository.save(facturaEditar);
        }else {
            throw new RuntimeException("La factura no fue encontrada");
        }
    }

    @Override
    public void eliminarFactura(Long id) {
        Optional<Facturas> existeFactura = facturasRepository.findById(id);
        if (existeFactura.isPresent()){
            Facturas facturaEliminar = existeFactura.get();
            facturasRepository.delete(facturaEliminar);
        }else {
            throw new RuntimeException("La factura no fue encontrada");
        }
    }
}
