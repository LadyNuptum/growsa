package com.growza_prueba.growzap.repository;

import com.growza_prueba.growzap.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICarritoRepository extends JpaRepository<Carrito, Long> {
    @Query("SELECT c FROM Carrito c WHERE c.usuarios.id_usuario = :id_usuario")
    Optional<Carrito> findByUsuariosId(@Param("id_usuario") Long id_usuario);
}

