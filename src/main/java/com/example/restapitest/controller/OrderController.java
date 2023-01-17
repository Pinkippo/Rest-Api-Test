package com.example.restapitest.controller;


import com.example.restapitest.data.dto.OrderDTO;
import com.example.restapitest.data.dto.OrderItemDTO;
import com.example.restapitest.data.entity.Order;
import com.example.restapitest.data.entity.OrderItem;
import com.example.restapitest.service.OrderService;
import com.example.restapitest.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    private final OrderService orderService; //서비스 연결
    private final UserService userService; // 서비스 연결

    public OrderController(OrderService orderService, UserService userService){ // 생성자로 의존성 주입
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping(value = "/get/{id}") // 특정 아이디로 주문 정보 가져오기
    public OrderDTO getO(@PathVariable Long id){
        return orderService.getOrder(id);
    }

    @PostMapping(value = "/post1") // 주문 생성 API
    public void order(@RequestBody OrderRequestDTO orderDTO){   // 객
        orderService.SaveOrder(orderDTO.getId(), orderDTO.getItem() , orderDTO.getCount());
        // 서비스의 주문 저장 메소드 호출
    }

    @PutMapping(value = "/put/order")
    public List<OrderItem> Updateorder(@RequestBody OrderUpdateDTO orderDTO){

        return orderService.ChangeOrder
                (orderDTO.getOrderid(),orderDTO.getUserid(),orderDTO.getItem(), orderDTO.getCount());

    }


    @GetMapping(value = "/get/orders") //주문 리스트 select
    public List<OrderResponseDTO> orders(){
        List<Order> orders = orderService.findorders();
        List<OrderResponseDTO> collect = orders.stream().
                map(m -> new OrderResponseDTO(Long.toString(m.getId()),m.getOrderItems()))
                .collect(Collectors.toList());

        return collect;
    }

    @GetMapping(value = "/get/v2/orders")
    public List<OrderResponseDTO> orderas(){ // 한방쿼리 -> fetch join 사용
        List<Order> orders = orderService.findorderall();
        List<OrderResponseDTO> collet = orders.stream().
                map(m -> new OrderResponseDTO(Long.toString(m.getId()),m.getOrderItems()))
                .collect(Collectors.toList());

        return collet;
    }


    @Data
    @AllArgsConstructor
    static class OrderResponseDTO{ // 주문 응답 내무 DTO
        String id;
        List<OrderItem> orderItems;

    }

    @Data
    static class OrderRequestDTO { // 주문 요청 내부 DTO
        private Long id;
        private String item;
        private int count;

    }

    @Data
    static class OrderUpdateDTO { // 주문 요청 내부 DTO
        private Long userid;
        private Long orderid;
        private String item;
        private int count;

    }

}
