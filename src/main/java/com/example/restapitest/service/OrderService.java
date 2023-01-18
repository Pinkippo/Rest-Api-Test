package com.example.restapitest.service;

import com.example.restapitest.data.dto.OrderDTO;
import com.example.restapitest.data.entity.Order;
import com.example.restapitest.data.entity.OrderItem;
import com.example.restapitest.data.entity.User;
import com.example.restapitest.data.repository.OrderItemRepository;
import com.example.restapitest.data.repository.OrderRepository;
import com.example.restapitest.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // final + not null 붙은 것 대신 생성자 생성 -> 의존성 주입
@Transactional
public class OrderService {

    private final UserRepository userRepository; // 레파지토리 연결
    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    public String SaveOrder(Long userId, String item ,int count ){ // 주문 저장 메소드

        User user = userRepository.findOne(userId); // 유저아이디로 엔티티 받아옴

        OrderItem orderItem = OrderItem.createOrderItem(item,count); // 아이템이랑 수량 받아서 엔티티 생성
        orderItemRepository.save(orderItem); // 디비에 저장

        Order order = Order.createOrder(user, orderItem); // 주문 엔티티 생성
        orderRepository.save(order); // 디비에 저장

        return order.getUser().getName(); // 주문의 유저의 이름 반환
    }

    public List<OrderItem> ChangeOrder(Long orderid, String item, int count){

        Order order = orderRepository.findById(orderid).orElse(null);
        OrderItem orderItem = OrderItem.createOrderItem(item,count);

        order.changeOrderItem(orderItem);

        return orderItem.getOrder().getOrderItems();

    }

    public OrderDTO getOrder(Long id){
        Optional<Order> order = orderRepository.findById(id);
        OrderDTO orderDTO = new OrderDTO(order);
        return orderDTO;
    }

    public List<Order> findorders(){
        return orderRepository.findAll();
    }

    public List<Order> findorderall(){
        return orderRepository.findAllItem();
    }

}
