package com.growza_prueba.growzap.repository;

import com.growza_prueba.growzap.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categorias, Long> {
}
