package com.growza_prueba.growzap.controller;

import com.growza_prueba.growzap.model.Pedidos;
import com.growza_prueba.growzap.model.Productos;
import com.growza_prueba.growzap.service.PedidosService;
import com.growza_prueba.growzap.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/growza/pedidos")
public class PedidosController {
    public PedidosService pedidosService;

    @Autowired
    public PedidosController(PedidosService pedidosService) {
        this.pedidosService =pedidosService;
    }

    @GetMapping
    public List<Pedidos> listaPedidos() {
        return pedidosService.obtenerPedidos();
    }

    @GetMapping("/{id}")
    public Optional<Pedidos> listaPedidosPorId(@PathVariable Long id) {
        return pedidosService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPedido(@RequestBody Pedidos pedidos) {
        pedidosService.guardarPedidos(pedidos);
        return ResponseEntity.ok("Pedido creado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPedido(@PathVariable Long id, @RequestBody Pedidos pedidos) {
        pedidosService.editarPedidos(id, pedidos);
        return ResponseEntity.ok("Pedido editado con éxito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable Long id) {
        pedidosService.eliminarPedidos(id);
        return ResponseEntity.ok("Pedido eliminado con éxito");
    }
}
