package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Usuarios;
import com.growza_prueba.growzap.repository.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements IUsuariosService {

    private final IUsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosService(IUsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public List<Usuarios> traerTodosLosUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> traerUsuarioPorEmail(String correo) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuarios> traerUsuarioPorCorreo(String correo) {
        return usuariosRepository.findByCorreo(correo);
    }

    @Override
    public List<Usuarios> traerUsuarioPorNombre(String nombre) {
        return usuariosRepository.findByNombre(nombre);
    }

    @Override
    public void crearUsuario(Usuarios usuario) {
        usuariosRepository.save(usuario);
    }

    @Override
    public void editarUsuario(Long id, Usuarios usuarioActualizado) {
        Optional<Usuarios> usuarioExistente = usuariosRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuarios usuario = usuarioExistente.get();
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setContraseña(usuarioActualizado.getContraseña());
            usuario.setFecha_registro(usuarioActualizado.getFecha_registro());
            usuariosRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminarUsuarios(Long id) {
        if (usuariosRepository.existsById(id)) {
            usuariosRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontró el usuario con ID: " + id);
        }
    }
}