package com.Bitts.Controller.Admin;

import com.Bitts.Exception.OrderException;
import com.Bitts.Model.Order;
import com.Bitts.Request.ApiResponse;
import com.Bitts.Service.OrderService.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin/orders")

public class AdminOrderController {
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrderHandler() throws OrderException {
        List<Order>orders=orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
    }
    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> ConfirmedOrderHandler(@PathVariable  Long orderId,@RequestHeader("Authorization") String jwt) throws OrderException {
        Order order=orderService.confirmedOrder(orderId);
        return new ResponseEntity<Order>(order,HttpStatus.OK);
    }
    @PutMapping("/{orderId}/ship")
    public ResponseEntity<Order> ShipOrderHandler(@PathVariable Long orderId,@RequestHeader("Authorization")String jwt) throws OrderException {
        Order order=orderService.shippedOrder(orderId);
        return new ResponseEntity<Order>(order,HttpStatus.OK);

    }
    @PutMapping("/{orderId}/deliver")
    public ResponseEntity<Order> DeliveredOrderHandler(@PathVariable Long orderId,@RequestHeader("Authorization")String jwt) throws OrderException {
        Order order=orderService.deliveredOrder(orderId);
        return new ResponseEntity<Order>(order,HttpStatus.OK);
    }
    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> CancelOrderHandler(@PathVariable Long orderId,@RequestHeader("Authorization")String jwt) throws OrderException {
        Order order=orderService.cancelOrder(orderId);
        return new ResponseEntity<Order>(order,HttpStatus.OK);
    }
    @PutMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> DeleteOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization")String jwt) throws OrderException {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Order is deleted Successfiully ",true),HttpStatus.OK);
    }



}
