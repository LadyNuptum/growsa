package com.growza_prueba.growzap.controller;

import com.growza_prueba.growzap.model.Detalles_Carrito;
import com.growza_prueba.growzap.model.Detalles_Pedidos;
import com.growza_prueba.growzap.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/growza/detallepedido")
public class DetallesPedidosController {
    private DetallePedidoService detallePedidoService;

    @Autowired
    public DetallesPedidosController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }
    @GetMapping
    public List<Detalles_Pedidos> listaDetallesPedidos(){
        return detallePedidoService.obtenerDetallesPedidos();
    }

    @GetMapping("/{id}")
    public Object ListaDetallesPedidoID (@PathVariable Long id){
        return  detallePedidoService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarDetallePedido (@RequestBody Detalles_Pedidos detallesPedidos){
        detallePedidoService.guardarDetallePedido(detallesPedidos);
        return ResponseEntity.ok("categorias Guardada con exito []~(￣▽￣)~*");
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity <String> editarDetallePedido (@PathVariable Long id, @RequestBody Detalles_Pedidos detallesPedidos){
        detallePedidoService.editarDetallePedido(id,detallesPedidos);
        return ResponseEntity.ok("Categoria editado con exito []~(￣▽￣)~*");
    }

    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity <String> eliminarDetallePedido (@PathVariable Long id ){
        detallePedidoService.eliminarDetallePedido(id);
        return ResponseEntity.ok("Categoria eliminado con exito ");
    }


}
