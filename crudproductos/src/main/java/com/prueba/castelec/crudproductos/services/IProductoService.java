package com.prueba.castelec.crudproductos.services;

import java.util.List;

import com.prueba.castelec.crudproductos.entities.Producto;

public interface IProductoService {
    List<Producto> consultarProductos();
    Producto crearProducto(Producto producto);
    Producto obtenerPorId(Long id);
    Producto actualizarProducto(Producto producto);
    void eliminarProducto(Long id);


}
