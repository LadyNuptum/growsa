package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Categorias;
import com.growza_prueba.growzap.model.Productos;
import com.growza_prueba.growzap.repository.IProductosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService implements IProductosService{
    private IProductosRepository productosRepository;
    private  ICategoriasService categoriasService;

    @Autowired
    public ProductosService(IProductosRepository productosRepository, ICategoriasService categoriasService) {
        this.productosRepository = productosRepository;
        this.categoriasService = categoriasService;
    }


    @Override
    public List<Productos> obtenerProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Optional<Productos> obtenerPorId(Long id) {
        return productosRepository.findById(id);
    }

    @Override
    public void guardarProducto(Productos producto) {
        productosRepository.save(producto);
    }

    @Override
    public void editarProducto(Long id, Productos producto) {
        Optional<Productos> productoExiste = productosRepository.findById(id);
        if (productoExiste.isPresent()){
            Productos editarProducto = productoExiste.get();
            editarProducto.setNombre_producto(producto.getNombre_producto());
            editarProducto.setDescripcion(producto.getDescripcion());
            editarProducto.setPrecio(producto.getPrecio());
            editarProducto.setStock(producto.getStock());
            productosRepository.save(editarProducto);
        }else {
            throw new RuntimeException("El Producto no fue encontrado.");
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        Optional<Productos> productoExiste = productosRepository.findById(id);
        if (productoExiste.isPresent()){
            Productos eliminarProducto = productoExiste.get();
            productosRepository.delete(eliminarProducto);
        }else {
            throw new RuntimeException("El Producto no fue encontrado.");
        }
    }

    @Override
    @Transactional
    public void asignarCategoriaAProducto(Long id_producto, Long id_categoria) {
        // Obtiene los objetos, lanzando una excepción si no se encuentran
        Productos producto = productosRepository.findById(id_producto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado."));
        Categorias categoria = categoriasService.obtenerPorId(id_categoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada."));
        // Asigna la categoría al producto. Esta es la única línea que necesitas.
        producto.setCategoria(categoria);
        // Guarda el producto. JPA se encarga de actualizar la clave foránea en la tabla.
        productosRepository.save(producto);
    }


}
