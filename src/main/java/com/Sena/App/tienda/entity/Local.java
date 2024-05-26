package com.Sena.App.tienda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "tbl_local")
public class Local {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_Local")
    
    private Long id;
    private String name;
    private String floor;
    
    
}
