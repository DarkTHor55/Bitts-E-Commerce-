package com.Bitts.Service.Cart;

import com.Bitts.Exception.ProductException;
import com.Bitts.Model.Cart;
import com.Bitts.Model.User;
import com.Bitts.Request.AdditemRequest;

public interface CartService {
    public Cart createCart(User user);
    public String addCartItem(Long userId, AdditemRequest request)throws ProductException;

    public Cart findUserCart(Long userId);
}
