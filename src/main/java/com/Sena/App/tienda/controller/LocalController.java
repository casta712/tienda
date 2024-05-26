package com.Sena.App.tienda.controller;

import com.Sena.App.tienda.service.LocalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Sena.App.tienda.entity.Local;

@RestController
@RequestMapping("api/local")
public class LocalController {
    
    @Autowired
    private LocalService localService;
    
    @GetMapping("/findAll")
    public List<Local> findAll(){
        return localService.findAll();
    }

    @PostMapping("/save")
    public Local save(@RequestBody Local local) {
        return localService.save(local);
    }

}
