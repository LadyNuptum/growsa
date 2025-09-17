package com.growza_prueba.growzap.controller;

import com.growza_prueba.growzap.model.Pagos;
import com.growza_prueba.growzap.model.Pedidos;
import com.growza_prueba.growzap.service.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/growza/pagos")
public class PagosController {
    public PagosService pagosService;

    @Autowired
    public PagosController(PagosService pagosService){
        this.pagosService = pagosService;
    }

    @GetMapping
    public List<Pagos> listaPagos() {
        return pagosService.obtenerPagos();
    }

    @GetMapping("/{id}")
    public Optional<Pagos> listaPagoPorId(@PathVariable Long id) {
        return pagosService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPago(@RequestBody Pagos pagos) {
        pagosService.guardarPago(pagos);
        return ResponseEntity.ok("Pago creado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPago(@PathVariable Long id, @RequestBody Pagos pagos) {
        pagosService.editarPago(id, pagos);
        return ResponseEntity.ok("Pago editado con éxito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPago(@PathVariable Long id) {
        pagosService.eliminarPago(id);
        return ResponseEntity.ok("Pago eliminado con éxito");
    }
}
