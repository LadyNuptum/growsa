package com.growza_prueba.growzap.controller;

import com.growza_prueba.growzap.model.Carrito;
import com.growza_prueba.growzap.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/growza/carrito")
public class CarritoController {

    private  CarritoService carritoService;
    @Autowired
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }
    @GetMapping
    public List<Carrito> listaCarrito(){
        return carritoService.obtenerCarrito();
    }

    @GetMapping("/{id}")
    public Object ListaCarritoID (@PathVariable Long id){
        return  carritoService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarCarrito (@RequestBody Carrito carrito){
        carritoService.guardarCarrito(carrito);
        return ResponseEntity.ok("Carrito Guardado con exito []~(￣▽￣)~*");
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity <String> editarCarrito (@PathVariable Long id, @RequestBody Carrito carrito){
        carritoService.editarCarrito(id,carrito);
        return ResponseEntity.ok("Carrito editado con exito []~(￣▽￣)~*");
    }

    @DeleteMapping ("/eliminar/{id}")
    public ResponseEntity <String> eliminarCarrito (@PathVariable Long id ){
        carritoService.eliminarCarrito(id);
        return ResponseEntity.ok("Carrito eliminado con exito ");
    }

    @GetMapping("/carro-usuario/{id_usuario}")
    public ResponseEntity<Carrito> obtenerCarritoDeUsuario(@PathVariable Long id_usuario) {
        Carrito carrito = carritoService.obtenerCarritoDeUsuario(id_usuario);
        return ResponseEntity.ok(carrito);
    }

    @PostMapping("/agregar-producto")
    public ResponseEntity<String> agregarProductoAlCarrito(@RequestBody Map<String, Object> payload) {
        Long id_usuario = Long.valueOf(payload.get("id_usuario").toString());
        Long id_producto = Long.valueOf(payload.get("id_producto").toString());
        Integer cantidad = Integer.valueOf(payload.get("cantidad").toString());
        carritoService.agregarProducto(id_usuario, id_producto, cantidad);
        return ResponseEntity.ok("Producto agregado con éxito");
    }

}
