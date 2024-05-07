package com.Bitts.Service.Cart;

import com.Bitts.Exception.CartException;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.Cart;
import com.Bitts.Model.CartItem;
import com.Bitts.Model.Product;

public interface CartItemService {
    public CartItem createCartItem(CartItem cart);
    public CartItem updateCartItem(Long userId,Long itemId,CartItem item)throws CartException, UserException;
    public CartItem IsCartItemExist(Cart cart , Product product,String size, Long userId);
    public void removeCartItem(Long userId,Long CartitemId)throws CartException, UserException;
    public CartItem findCartItemById(Long CartitemId)throws CartException, UserException;

}
