package com.Bitts.Controller;

import com.Bitts.Exception.ProductException;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.Cart;
import com.Bitts.Model.User;
import com.Bitts.Request.AdditemRequest;
import com.Bitts.Request.ApiResponse;
import com.Bitts.Service.Cart.CartService;
import com.Bitts.Service.UserService.UserService;
import com.Bitts.ServiceImpl.CartServiceImpl;
import com.Bitts.ServiceImpl.UserServiceaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private UserServiceaImpl userService;



    @GetMapping("/")
    public ResponseEntity<Cart>findUserCart(@RequestHeader ("Authorization") String jwt) throws UserException {
        jwt=jwt.substring(7);
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
  public ResponseEntity<ApiResponse>addItemToCart(@RequestBody AdditemRequest request , @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        jwt=jwt.substring(7);
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        cartService.addCartItem(user.getId(),request);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Item added to cart successfully",true
        ),HttpStatus.OK);
    }


}
