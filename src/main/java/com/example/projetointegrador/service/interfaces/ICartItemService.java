package com.example.projetointegrador.service.interfaces;

import com.example.projetointegrador.model.CartItem;

import java.util.List;

public interface ICartItemService {
    List<CartItem> getCartItems(Long cartId);
}