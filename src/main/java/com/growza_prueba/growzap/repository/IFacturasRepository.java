package com.growza_prueba.growzap.repository;

import com.growza_prueba.growzap.model.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturasRepository extends JpaRepository<Facturas, Long> {
}
