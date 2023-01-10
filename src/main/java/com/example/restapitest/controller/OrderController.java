package com.example.restapitest.controller;


import com.example.restapitest.service.OrderService;
import com.example.restapitest.service.UserService;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    private final OrderService orderService; //서비스 연결
    private final UserService userService; // 서비스 연결

    public OrderController(OrderService orderService, UserService userService){ // 생성자로 의존성 주입
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping(value = "/post1") // 주문 생성 API
    public void order(@RequestBody OrderDTO orderDTO){   // 객
        orderService.SaveOrder(orderDTO.getId(), orderDTO.getItem() , orderDTO.getCount());
        // 서비스의 주문 저장 메소드 호출
    }

    @Data
    static class OrderDTO { // 클래스 내부 DTO
        private Long id;
        private String item;
        private int count;

    }

}
