package com.Bitts.Controller;

import com.Bitts.Exception.CartException;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.CartItem;
import com.Bitts.Model.User;
import com.Bitts.Service.Cart.CartItemService;
import com.Bitts.ServiceImpl.CardItemSerivceImpl;
import com.Bitts.ServiceImpl.UserServiceaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart/item")
public class CartItemController {
    @Autowired
    private CardItemSerivceImpl cartItemService;
    @Autowired
    private UserServiceaImpl userService;

//    @PostMapping("/create")
//    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
//        CartItem cartItem1=cartItemService.createCartItem(cartItem);
//        return ResponseEntity.ok(cartItem1);
//    }
//    @PutMapping("/update/{itemId}")
//    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem,@RequestHeader("Authorization") String jwt,@PathVariable Long itemId) throws UserException, CartException {
//        User user =userService.findUserProfileByJwt(jwt);
//        CartItem cartItem1=cartItemService.updateCartItem(user.getId(),itemId,cartItem);
//        return ResponseEntity.ok(cartItem1);
//    }
//    @DeleteMapping("/delete/cartItemId/{cartitemId}")
//    public ResponseEntity<String> deleteCartItem(@RequestHeader("Authorization") String jwt,@PathVariable Long cartitemId) throws UserException, CartException {
//        User user =userService.findUserProfileByJwt(jwt);
//        cartItemService.removeCartItem(user.getId(),cartitemId);
//        return ResponseEntity.ok("Cart Item Deleted Successfully");
//
//    }
//    @GetMapping("/item/id/{id}")
//    public ResponseEntity<CartItem> findCartItemById(@PathVariable Long id) throws UserException, CartException {
//        CartItem cartItem=cartItemService.findCartItemById(id);
//        return ResponseEntity.ok(cartItem);
//    }
    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<String> deleteCartItem(@RequestHeader("Authorization") String jwt,@PathVariable Long cartItemId) throws UserException, CartException {
       jwt=jwt.substring(7);
        User user =userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(),cartItemId);
        return ResponseEntity.ok("Cart Item Deleted Successfully");
    }
    @PutMapping("/cartItemId")
    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem,@PathVariable Long cartItemId,@RequestHeader("Authorization") String jwt) throws UserException, CartException {
        jwt=jwt.substring(7);
        User user =userService.findUserProfileByJwt(jwt);
        CartItem cartItem1=cartItemService.updateCartItem(user.getId(),cartItemId,cartItem);
        return ResponseEntity.ok(cartItem1);
    }

}
