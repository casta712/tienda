package com.Sena.App.tienda.service;

import java.util.List;
import com.Sena.App.tienda.entity.Local;


public interface LocalService {
    
    List<Local> findAll();
    Local save(Local local); 
}