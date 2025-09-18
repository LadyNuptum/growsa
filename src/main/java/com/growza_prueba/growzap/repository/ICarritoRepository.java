package com.growza_prueba.growzap.repository;

import com.growza_prueba.growzap.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICarritoRepository extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findByUsuariosId(Long id_usuario);
}
