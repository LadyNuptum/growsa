package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Usuarios;

import java.util.List;
import java.util.Optional;

public interface IUsuariosService {
    List<Usuarios> traerTodosLosUsuarios();
    Optional<Usuarios> traerUsuarioPorEmail(String correo); // ← recibe el correo
    Optional<Usuarios> traerUsuarioPorCorreo(String correo);
    List<Usuarios> traerUsuarioPorNombre(String nombre); // ← recibe el nombre
    void crearUsuario(Usuarios usuario);
    void editarUsuario(Long id, Usuarios usuarioActualizado);
    void eliminarUsuarios(Long id);
}
