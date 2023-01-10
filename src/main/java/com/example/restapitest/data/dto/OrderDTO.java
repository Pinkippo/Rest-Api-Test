package com.example.restapitest.data.dto;

import com.example.restapitest.data.entity.Order;
import com.example.restapitest.data.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class OrderDTO {
    private Long id;

    private List<OrderItem> orderItems;


    public OrderDTO(Optional<Order> order){
        id = order.get().getId();
        orderItems = order.get().getOrderItems();
    }

}
