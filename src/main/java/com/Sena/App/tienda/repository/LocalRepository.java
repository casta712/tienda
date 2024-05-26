
package com.Sena.App.tienda.repository;

import com.Sena.App.tienda.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long > {
    
}
