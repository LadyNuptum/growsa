package com.growza_prueba.growzap.controller;

import com.growza_prueba.growzap.model.Categorias;
import com.growza_prueba.growzap.model.Detalles_Carrito;
import com.growza_prueba.growzap.service.DetalleCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/growza/detallecarrito")
public class DetalleCarritoController {
    private DetalleCarritoService detalleCarritoService;
    @Autowired
    public DetalleCarritoController(DetalleCarritoService detalleCarritoService) {
        this.detalleCarritoService = detalleCarritoService;
    }

    @GetMapping
    public List<Detalles_Carrito> listaDetallesCarrito(){
        return detalleCarritoService.obtenerDetallesCarrito();
    }

    @GetMapping("/{id}")
    public Object ListaDetallesCarritoID (@PathVariable Long id){
        return  detalleCarritoService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarDetalleCarrito (@RequestBody Detalles_Carrito detallesCarrito){
        detalleCarritoService.guardarDetalleCarrito(detallesCarrito);
        return ResponseEntity.ok("categorias Guardada con exito []~(￣▽￣)~*");
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity <String> editarDetalleCarrito (@PathVariable Long id, @RequestBody Detalles_Carrito detallesCarrito){
        detalleCarritoService.editarDetalleCarrito(id,detallesCarrito);
        return ResponseEntity.ok("Categoria editado con exito []~(￣▽￣)~*");
    }

    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity <String> eliminarDetalleCarrito (@PathVariable Long id ){
        detalleCarritoService.eliminarDetalleCarrito(id);
        return ResponseEntity.ok("Categoria eliminado con exito ");
    }


}
