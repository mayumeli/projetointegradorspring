package com.example.projetointegrador.controller;

import com.example.projetointegrador.dto.BatchDTO;
import com.example.projetointegrador.exceptions.*;
import com.example.projetointegrador.model.Batch;
import com.example.projetointegrador.model.BatchProduct;
import com.example.projetointegrador.service.interfaces.IBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/batch")
public class BatchController {
    
    @Autowired
    private IBatchService batchService;

    @PostMapping
    public ResponseEntity<Batch> create(@RequestBody BatchDTO batchDTO) throws SectionInvalidException, ProductNotFoundException, CategoryInvalidException, InsuficientVolumeException, StorageInvalidException {
        return new ResponseEntity<>(batchService.createBatch(batchDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Batch> update(@PathVariable Long id, @RequestBody Set<BatchProduct> batchProductList) throws BatchInvalidException, ProductNotFoundException, InsuficientVolumeException, SectionInvalidException {
        return new ResponseEntity<>(batchService.update(id, batchProductList), HttpStatus.ACCEPTED);
    }
}