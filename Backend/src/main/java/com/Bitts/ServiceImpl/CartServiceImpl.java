package com.Bitts.ServiceImpl;

import com.Bitts.Exception.ProductException;
import com.Bitts.Model.Cart;
import com.Bitts.Model.CartItem;
import com.Bitts.Model.Product;
import com.Bitts.Model.User;
import com.Bitts.Repository.cart.CartRepository;
import com.Bitts.Request.AdditemRequest;
import com.Bitts.Service.Cart.CartItemService;
import com.Bitts.Service.Cart.CartService;
import com.Bitts.Service.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ProductService productService;


    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AdditemRequest request) throws ProductException {
        Cart cart = cartRepository.findByUserId(userId);
        Product product = productService.findProductById(request.getProductId());
        CartItem isPresent = cartItemService.IsCartItemExist(cart, product, request.getSize(), userId);
        if (isPresent == null) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setUserId(userId);
            int price = request.getQuantity() * product.getDiscountPrice();
            cartItem.setPrice(price);
            cartItem.setSize(request.getSize());
            CartItem createCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createCartItem);

        }
        return "Item Added Successfully";
    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        int totalPrice = 0;
        int totalDiscountPrice = 0;
        int totalItem = 0;
        for (CartItem cartItem : cart.getCartItems()) {
            totalPrice = totalPrice + cartItem.getPrice();
            totalDiscountPrice = totalDiscountPrice + cartItem.getDiscountPrice();
            totalItem = totalItem + cartItem.getQuantity();
        }
        cart.setTotalPrice(totalPrice);
        cart.setTotalDiscountPrice(totalDiscountPrice);
        cart.setTotalItem(totalItem);
        cart.setDiscount(totalPrice - totalDiscountPrice);
        return cartRepository.save(cart);
    }

}
