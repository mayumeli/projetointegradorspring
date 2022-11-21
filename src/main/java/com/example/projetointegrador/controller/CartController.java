package com.example.projetointegrador.controller;

import com.example.projetointegrador.dto.CartDTO;
import com.example.projetointegrador.dto.CartStatusDTO;
import com.example.projetointegrador.exceptions.ExpiredProductException;
import com.example.projetointegrador.exceptions.InsufficientStockException;
import com.example.projetointegrador.exceptions.ProductNotFoundException;
import com.example.projetointegrador.exceptions.UserUNotFoundException;
import com.example.projetointegrador.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/orders")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * Create a new cart based in the CartDTO parameter.
     * @param cartDTO Contains the date, userId, status and the products to be added to the cart.
     * @return Return the total value of the purchase.
     * @throws UserUNotFoundException
     * @throws InsufficientStockException
     * @throws ProductNotFoundException
     * @throws ExpiredProductException
     */
    @PostMapping
    public ResponseEntity<Double> createCart(@RequestBody CartDTO cartDTO) throws UserUNotFoundException, InsufficientStockException, ProductNotFoundException, ExpiredProductException {
         return new ResponseEntity<>(cartService.createCart(cartDTO), HttpStatus.CREATED);
    }

    /**
     * Update the status of a cart by id.
     * @param cartId Id of the cart to be updated.
     * @param cartStatusDTO Contains the new status of the cart.
     * @return The cart with status updated.
     */
    @PutMapping("/{cartId}")
    public ResponseEntity<String> changeCartStatus(@PathVariable Long cartId, @RequestBody CartStatusDTO cartStatusDTO){
        return new ResponseEntity<>(cartService.changeCartStatus(cartId, cartStatusDTO), HttpStatus.OK);
    }
}
