package com.example.projetointegrador.repository;

import com.example.projetointegrador.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch, Long> {
    
}
