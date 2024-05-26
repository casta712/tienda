package com.Sena.App.tienda.service;

import com.Sena.App.tienda.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sena.App.tienda.entity.Product;




@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductRepository repository;
    
    @Override
    public List<Product> findAll(){
        return repository.findAll();
    }
    
}
