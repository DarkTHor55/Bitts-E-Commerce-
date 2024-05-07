package com.Bitts.ServiceImpl;

import com.Bitts.Exception.OrderException;
import com.Bitts.Model.*;
import com.Bitts.Repository.AddressRepository;
import com.Bitts.Repository.OrderItemRepository;
import com.Bitts.Repository.UserRepository;
import com.Bitts.Repository.cart.CartRepository;
import com.Bitts.Repository.OrderRepository;
import com.Bitts.Service.Cart.CartService;
import com.Bitts.Service.OrderService.OrderService;
import com.Bitts.Service.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartServiceImpl carService;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Order createOrder(User user, Address shippingAddress) throws OrderException {
         shippingAddress.setUser(user);
        shippingAddress.setFirstName(user.getFirstName());
        shippingAddress.setLastName(user.getLastName());
        Address address=addressRepository.save(shippingAddress);
        user.getAddress().add(address);

        userRepository.save(user);
        Cart cart = carService.findUserCart(user.getId());
        List<Orderitem> orderitems=new ArrayList<>();
        for (CartItem item : cart.getCartItems()){
            Orderitem orderitem=new Orderitem();
            orderitem.setProduct(item.getProduct());
            orderitem.setPrice(item.getPrice());
            orderitem.setDiscountPrice(item.getDiscountPrice());
            orderitem.setQuantity(item.getQuantity());
            orderitem.setSize(item.getSize());
            orderitem.setUserId(user.getId());

            Orderitem createsOrder= orderItemRepository.save(orderitem);
            orderitems.add(createsOrder);
        }
        Order createOrder = new Order();
        createOrder.setUser(user);
        createOrder.setOderitems(orderitems);
        createOrder.setTotalPrice(cart.getTotalPrice());
        createOrder.setTotalDiscountPrice(cart.getTotalDiscountPrice());
        createOrder.setDicount(cart.getDiscount());
        createOrder.setShippingAddress(address);
        createOrder.setOrderDate(LocalDateTime.now());
        createOrder.setOederStatus("PENDING");
        createOrder.getPaymentDetails().setPatmentStatus("PENDING");
        createOrder.setCreateAt(LocalDateTime.now());
        Order savedOrder=orderRepository.save(createOrder);
        for(Orderitem item:orderitems){
            item.setOrder(savedOrder);
            orderItemRepository.save(item);
        }
        return savedOrder;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        Order order = orderRepository.findById(orderId).orElseThrow();
        return order;
    }

    @Override
    public List<Order> userOrderHistory(long orderId) throws OrderException {
        List<Order> orders=orderRepository.getUsersOrders(orderId);
        return orders;
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        Order   order=findOrderById(orderId);
        order.setOederStatus("PLACED");
        order.getPaymentDetails().setPatmentStatus("COMPLETED");
        return order;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        Order   order=findOrderById(orderId);
        order.setOederStatus("CONFIRMED");
        return orderRepository.save(order);
    }

    @Override
    public Order shippedOrder(long orderId) throws OrderException {
        Order   order=findOrderById(orderId);
        order.setOederStatus("SHIPPED");
        return orderRepository.save(order);
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        Order   order=findOrderById(orderId);
        order.setOederStatus("DELIVERED");
        return orderRepository.save(order);
    }

    @Override
    public Order cancelOrder(Long orderId) throws OrderException {
        Order   order=findOrderById(orderId);
        order.setOederStatus("CANCELLED");
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() throws OrderException {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long orderId) throws OrderException {
        Order   order=findOrderById(orderId);
        orderRepository.deleteById(orderId);
    }
}
