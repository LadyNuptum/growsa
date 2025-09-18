package com.growza_prueba.growzap.service;

import com.growza_prueba.growzap.model.Carrito;
import com.growza_prueba.growzap.model.Detalles_Carrito;
import com.growza_prueba.growzap.model.Productos;
import com.growza_prueba.growzap.repository.ICarritoRepository;
import com.growza_prueba.growzap.repository.IDetallesCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService implements  ICarritoService {
    private ICarritoRepository carritoRepository;
    private IUsuariosService usuariosService;
    private IDetallesCarritoRepository iDetallesCarritoRepository;
    private ProductosService productosService;

    @Autowired
    public CarritoService(ICarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    @Override
    public List<Carrito> obtenerCarrito() {
        return carritoRepository.findAll();
    }

    @Override
    public Optional<Carrito> obtenerPorId(Long id) {
        return carritoRepository.findById(id);
    }

    @Override
    public void guardarCarrito(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    public void editarCarrito(Long id, Carrito carrito) {
        Optional<Carrito> existeCarrito = carritoRepository.findById(id);
        if (existeCarrito.isPresent()) {
            Carrito editarCarrito = existeCarrito.get();
            editarCarrito.setDetallesCarrito(carrito.getDetallesCarrito());
            editarCarrito.setUsuarios(carrito.getUsuarios());

            carritoRepository.save(editarCarrito);
        } else {
            throw new RuntimeException("No se encuentra el carrito");
        }
    }

    @Override
    public void eliminarCarrito(Long id) {
        Optional<Carrito> existeCarrito = carritoRepository.findById(id);
        if (existeCarrito.isPresent()) {
            Carrito eliminarCarrito = existeCarrito.get();
            carritoRepository.delete(eliminarCarrito);
        } else {
            throw new RuntimeException("No se encuentra el carrito");
        }
    }

    @Override
    public void agregarProducto(Long id_usuario, Long id_producto, int cantidad) {
        Carrito carrito = obtenerCarritoDeUsuario(id_usuario);
        Optional<Productos> producto = productosService.obtenerPorId(id_producto);

        Optional<Detalles_Carrito> detalleExistente = carrito.getDetallesCarrito().stream()
                .filter(dc -> dc.getProducto().getId_producto().equals(id_producto))
                .findFirst();

        if (detalleExistente.isPresent()) {
            Detalles_Carrito detalle = detalleExistente.get();
            detalle.setCantidad(detalle.getCantidad() + cantidad);
            iDetallesCarritoRepository.save(detalle);
        } else {
            Detalles_Carrito nuevoDetalle = new Detalles_Carrito();
            nuevoDetalle.setCarrito(carrito);
            nuevoDetalle.setProducto(producto.orElse(null));
            nuevoDetalle.setCantidad(cantidad);

            carrito.getDetallesCarrito().add(nuevoDetalle);

            iDetallesCarritoRepository.save(nuevoDetalle);
        }

    }

    @Override
    public void eliminarProducto(Long id_usuario, Long id_producto) {

    }

    @Override
    public Double calcularTotal(Long id_usuario) {
        return 0.0;
    }

    @Override
    public void vaciarCarrito(Long id_usuario) {

    }

    @Override
    public Carrito obtenerCarritoDeUsuario(Long id_usuario) {
        return carritoRepository.findByUsuariosId_usuario(id_usuario)
                .orElseThrow(() -> new RuntimeException("No se encontró el carrito para el usuario"));
    }
    @Override
    public void crearCarritoParaUsuario(Long id_usuario) {

    }


}
