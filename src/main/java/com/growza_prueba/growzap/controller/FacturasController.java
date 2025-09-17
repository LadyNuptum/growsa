package com.growza_prueba.growzap.controller;

import com.growza_prueba.growzap.model.Facturas;
import com.growza_prueba.growzap.model.Productos;
import com.growza_prueba.growzap.service.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/growza/facturas")
public class FacturasController {
    public FacturasService facturasService;

    @Autowired
    public FacturasController(FacturasService facturasService){
        this.facturasService = facturasService;
    }

    @GetMapping
    public List<Facturas> listaFacturas() {
        return facturasService.mostrarFacturas();
    }

    @GetMapping("/{id}")
    public Optional<Facturas> listaFacturasPorId(@PathVariable Long id) {
        return facturasService.mostrarPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearFacturas(@RequestBody Facturas facturas) {
        facturasService.guardarFactura(facturas);
        return ResponseEntity.ok("Factura creada con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarFacturas(@PathVariable Long id, @RequestBody Facturas facturas) {
        facturasService.editarFactura(id, facturas);
        return ResponseEntity.ok("Factura editada con éxito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarFactura(@PathVariable Long id) {
        facturasService.eliminarFactura(id);
        return ResponseEntity.ok("Factura eliminada con éxito");
    }
}
