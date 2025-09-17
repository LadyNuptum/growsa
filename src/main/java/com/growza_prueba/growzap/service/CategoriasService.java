package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Categorias;
import com.growza_prueba.growzap.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService implements ICategoriasService{
    private ICategoriaRepository categoriaRepository;

    @Autowired
    public CategoriasService(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    @Override
    public List<Categorias> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categorias> obtenerPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void guardarCategorias(Categorias categorias) {
        categoriaRepository.save(categorias);
    }

    @Override
    public void editarCategoria(Long id, Categorias categorias) {
        Optional<Categorias> exiteCategorias = categoriaRepository.findById(id);
        if (exiteCategorias.isPresent()){
            Categorias editarCategoria = exiteCategorias.get();
            editarCategoria.setNombre_categoria(categorias.getNombre_categoria());
            categoriaRepository.save(editarCategoria);
        }else{
            throw  new RuntimeException("El detalle del pedido no fue encontrado.");
        }
    }

    @Override
    public void eliminarCategoria(Long id) {
        Optional<Categorias> exiteCategorias = categoriaRepository.findById(id);
        if (exiteCategorias.isPresent()){
            Categorias eliminarCategoria = exiteCategorias.get();
            categoriaRepository.delete(eliminarCategoria);
        }else{
            throw  new RuntimeException("El detalle del pedido no fue encontrado.");
        }
    }
}
