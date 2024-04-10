package com.prueba.castelec.crudproductos.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nombreCat;
}
