package com.example.restapitest.controller;


import com.example.restapitest.service.OrderService;
import com.example.restapitest.service.UserService;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService){
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping(value = "/post1")
    public void order(@RequestBody OrderDTO orderDTO){
        orderService.SaveOrder(orderDTO.getId(), orderDTO.getItem() , 1);
    }

    @Data
    static class OrderDTO { // 내부 DTO
        private Long id;
        private String item;

    }

}
