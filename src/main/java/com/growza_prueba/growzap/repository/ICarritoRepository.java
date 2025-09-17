package com.growza_prueba.growzap.repository;

import com.growza_prueba.growzap.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarritoRepository extends JpaRepository<Carrito, Long> {
}
