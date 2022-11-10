package com.example.projetointegrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetointegrador.dto.BatchDTO;
import com.example.projetointegrador.model.Batch;
import com.example.projetointegrador.service.interfaces.IBatchService;

@RestController
@RequestMapping("api/v1/batch")
public class BatchController {
    
    @Autowired
    private IBatchService batchService;

    @PostMapping
    public ResponseEntity<Batch> create(@RequestBody BatchDTO batchDTO){
        return new ResponseEntity<>(batchService.createBatch(batchDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Batch> update(@PathVariable Long id, @RequestBody BatchDTO batchDTO) {
        return new ResponseEntity<Batch>(batchService.update(id, batchDTO), HttpStatus.ACCEPTED);
    }
}
