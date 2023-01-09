package com.example.restapitest.service;

import com.example.restapitest.data.entity.Order;
import com.example.restapitest.data.entity.OrderItem;
import com.example.restapitest.data.entity.User;
import com.example.restapitest.data.repository.OrderItemRepository;
import com.example.restapitest.data.repository.OrderRepository;
import com.example.restapitest.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final + not null 붙은 것 대신 생성자 생성 -> 의존성 주입
@Transactional
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    public String SaveOrder(Long userId, String item ,int count ){

        User user = userRepository.findOne(userId);

        OrderItem orderItem = OrderItem.createOrderItem(item,count);
        orderItemRepository.save(orderItem);

        Order order = Order.createOrder(user, orderItem);
        orderRepository.save(order);

        return order.getUser().getName();
    }



}
