package com.Bitts.ServiceImpl;

import com.Bitts.Model.Orderitem;
import com.Bitts.Repository.OrderItemRepository;
import com.Bitts.Service.OrderService.OrderItemService;
import com.Bitts.Service.OrderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderItemImpl implements OrderItemService {
    @Autowired
    public OrderItemRepository orderItemRepository;
    @Override
    public Orderitem createOrderItem(Orderitem orderItem) {

        return orderItemRepository.save(orderItem);
    }
}
