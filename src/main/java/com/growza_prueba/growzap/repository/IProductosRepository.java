package com.growza_prueba.growzap.repository;

import com.growza_prueba.growzap.model.Productos;
import com.growza_prueba.growzap.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductosRepository extends JpaRepository <Productos, Long> {

}
