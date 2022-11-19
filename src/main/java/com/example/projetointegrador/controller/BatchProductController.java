package com.example.projetointegrador.controller;

import com.example.projetointegrador.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetointegrador.dto.ProductInBatchDTO;
import com.example.projetointegrador.dto.ReportBatchProductDTO;
import com.example.projetointegrador.service.interfaces.IBatchProductService;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class BatchProductController {

    @Autowired
    private IBatchProductService batchProductService;

    @GetMapping("/due-date")
    public ResponseEntity<ReportBatchProductDTO> getBatchProductExpiring(@RequestParam Long days,
            @RequestParam Long sectionId) {
        return new ResponseEntity<>(batchProductService.getBatchProductExpiring(days, sectionId), HttpStatus.OK);
    }

    @GetMapping("/due-date/list")
    public ResponseEntity<ReportBatchProductDTO> getBatchProductExpiringOrdered(@RequestParam Long days,
            @RequestParam Long categoryId, @RequestParam String order) {
        return new ResponseEntity<>(batchProductService.getBatchProductExpiringOrdered(days, categoryId, order),
                HttpStatus.OK);
    }

    @GetMapping("/list/{productId}")
    public ResponseEntity<ProductInBatchDTO> findAllByProductId(@PathVariable Long productId) throws ProductNotFoundException {
        return new ResponseEntity<>(batchProductService.findAllByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("/list/{productId}/{order}")
    public ResponseEntity<ProductInBatchDTO> findAllByProductIdOrdered(@PathVariable Long productId,
            @PathVariable String order) throws ProductNotFoundException {
        return new ResponseEntity<>(batchProductService.findAllByProductIdOrdered(productId, order), HttpStatus.OK);
    }
}