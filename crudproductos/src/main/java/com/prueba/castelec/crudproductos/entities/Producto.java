package com.prueba.castelec.crudproductos.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "productos")
public class Producto implements Serializable{

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
    
}
