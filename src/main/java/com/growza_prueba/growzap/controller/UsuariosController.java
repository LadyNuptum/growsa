package com.growza_prueba.growzap.controller;

import com.growza_prueba.growzap.model.Usuarios;
import com.growza_prueba.growzap.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/growza/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> listaUsuarios() {
        return usuariosService.traerTodosLosUsuarios();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Usuarios> listaUsuariosPorNombre(@PathVariable String nombre) {
        return usuariosService.traerUsuarioPorNombre(nombre);
    }

    @GetMapping("/correo/{correo}")
    public Optional<Usuarios> listaUsuariosPorCorreo(@PathVariable String correo) {
        return usuariosService.traerUsuarioPorCorreo(correo);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuarios usuarios) {
        usuariosService.crearUsuario(usuarios);
        return ResponseEntity.ok("Usuario creado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarUsuario(@PathVariable Long id, @RequestBody Usuarios usuarioActualizado) {
        usuariosService.editarUsuario(id, usuarioActualizado);
        return ResponseEntity.ok("Usuario editado con éxito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        usuariosService.eliminarUsuarios(id);
        return ResponseEntity.ok("Usuario eliminado con éxito");
    }
}