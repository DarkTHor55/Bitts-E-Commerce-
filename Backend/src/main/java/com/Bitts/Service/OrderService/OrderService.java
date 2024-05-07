package com.Bitts.Service.OrderService;

import com.Bitts.Exception.OrderException;
import com.Bitts.Model.Address;
import com.Bitts.Model.Order;
import com.Bitts.Model.User;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user , Address shippingAddress)throws OrderException;
    public Order findOrderById(Long orderId)throws OrderException;
    public List<Order> userOrderHistory(long orderId)throws OrderException;
    public Order placedOrder(Long orderId)throws OrderException;
    public Order confirmedOrder(Long orderId)throws OrderException;
    public Order shippedOrder(long orderId)throws OrderException;
    public Order deliveredOrder(Long orderId)throws OrderException;
    public Order cancelOrder(Long orderId)throws OrderException;
    public List<Order> getAllOrders()throws OrderException;
    public void deleteOrder(Long orderId)throws OrderException;

}
