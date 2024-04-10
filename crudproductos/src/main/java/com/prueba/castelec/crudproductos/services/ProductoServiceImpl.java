package com.prueba.castelec.crudproductos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.castelec.crudproductos.entities.Producto;
import com.prueba.castelec.crudproductos.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    private ProductoRepository productoRepo;

    @Override
    public List<Producto> consultarProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        Producto productoEx = productoRepo.findById(producto.getId()).get();
        if (productoEx != null) {
            productoEx.setNombre(producto.getNombre());
            productoEx.setDescripcion(producto.getDescripcion());
            productoEx.setPrecio(producto.getPrecio());
            productoEx.setCategoria(producto.getCategoria());
            return productoRepo.save(productoEx);
        }else{
            return null;
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepo.deleteById(id);
    }

}
