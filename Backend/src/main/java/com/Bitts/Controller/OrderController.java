package com.Bitts.Controller;

import com.Bitts.Exception.OrderException;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.Address;
import com.Bitts.Model.Order;
import com.Bitts.Model.User;
import com.Bitts.ServiceImpl.OrderServiceImpl;
import com.Bitts.ServiceImpl.UserServiceaImpl;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private UserServiceaImpl userService;

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Address shippingAddress,@RequestHeader("Authorization") String jwt) throws UserException, OrderException {
        jwt=jwt.substring(7);
        User user=userService.findUserProfileByJwt(jwt);
        Order order = orderService.createOrder(user,shippingAddress);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<List<Order>> findUserOrderHistory(@RequestHeader("Authorization") String jwt) throws UserException, OrderException {
        jwt=jwt.substring(7);
        User user = userService.findUserProfileByJwt(jwt);
        List<Order> orders = orderService.userOrderHistory(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> findOrderById(@PathVariable Long orderId) throws OrderException, UserException {
        Order order = orderService.findOrderById(orderId);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
