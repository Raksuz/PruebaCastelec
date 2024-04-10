package com.prueba.castelec.crudproductos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.castelec.crudproductos.entities.Producto;
import com.prueba.castelec.crudproductos.services.ProductoServiceImpl;
@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoServiceImpl productoService;

    @GetMapping("/obtener")
    public List<Producto> obtenerTodosLosProductos(){
        return productoService.consultarProductos();
    }

    @PostMapping("/crear")
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable("id") Long id){
        productoService.eliminarProducto(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Long id, @RequestBody Producto producto){
        producto.setId(id);
        Producto productoAct = productoService.actualizarProducto(producto);
        return new ResponseEntity<>(productoAct, HttpStatus.OK);
    }

}

