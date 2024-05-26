package com.Sena.App.tienda.service;

import com.Sena.App.tienda.repository.LocalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sena.App.tienda.entity.Local;

@Service
public class LocalServiceImpl implements LocalService {
    
    @Autowired
    private LocalRepository repository;
    
    @Override
    public List<Local> findAll(){
        return repository.findAll();
    }
    @Override
    public Local save(Local local) {
        return repository.save(local);
    }
}
