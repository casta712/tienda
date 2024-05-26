package com.Sena.App.tienda.controller;

import com.Sena.App.tienda.service.ProductService;
import com.Sena.App.tienda.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Product")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }
}
