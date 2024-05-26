
package com.Sena.App.tienda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "tbl_products")
@Data

public class Product {
    
    @Id
    private Long IdProducto;
    private String name;
    private String brand;
    private boolean expired;
     private float price;
     
     @ManyToOne
     @JoinColumn(
             name = "id",
             referencedColumnName = "id_Local"
     
     )
     private Local Local;
    
    
    
}
