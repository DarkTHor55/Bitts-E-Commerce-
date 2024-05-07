package com.Bitts.ServiceImpl;

import com.Bitts.Exception.CartException;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.Cart;
import com.Bitts.Model.CartItem;
import com.Bitts.Model.Product;
import com.Bitts.Model.User;
import com.Bitts.Repository.cart.CartItemRepository;
import com.Bitts.Repository.cart.CartRepository;
import com.Bitts.Service.Cart.CartItemService;
import com.Bitts.Service.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardItemSerivceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartService cartService;

    @Autowired
    private UserServiceaImpl userService;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountPrice( cartItem.getProduct().getDiscountPrice() * cartItem.getQuantity());
        CartItem createdCartItem = cartItemRepository.save(cartItem);

        return createdCartItem;
    }



    @Override
    public CartItem updateCartItem(Long userId, Long itemId, CartItem item) throws CartException, UserException {
        CartItem item1 = findCartItemById(itemId);
        if (item1 == null) {
            User user =userService.findUserById(userId);
            if(user.getId().equals(userId)) {
                Cart cart1 = cartService.findUserCart(userId);

                item1.setCart(cart1);
                item1.setProduct(item.getProduct());
                item1.setSize(item.getSize());
                item1.setQuantity(item.getQuantity());
                item1.setPrice(item.getProduct().getPrice()*item.getQuantity());
                item1.setDiscountPrice(item.getProduct().getDiscountPrice() * item.getQuantity());
                item1.setUserId(userId);

            }
        }
        return cartItemRepository.save(item1);

    }

    @Override
    public CartItem IsCartItemExist(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);
        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartitemId) throws CartException, UserException {
        CartItem cartItem = findCartItemById(cartitemId);
        if (cartItem == null) {
            User user =userService.findUserById(cartItem.getUserId());
            User reqUser =userService.findUserById(userId);
            if(user.getId().equals(reqUser.getId())) {
                cartItemRepository.deleteById(cartitemId);
            }
            else {
                throw new CartException("CartItem not found ID :"+cartitemId);
            }
        }
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem findCartItemById(Long CartitemId) throws CartException, UserException {

        CartItem opt = cartItemRepository.findById(CartitemId).orElseThrow();
        if(opt != null) {
            return opt;
        }else   {
            throw new CartException("CartItem not found");
        }
    }
}
