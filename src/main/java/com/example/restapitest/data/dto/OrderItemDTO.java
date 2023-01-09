package com.example.restapitest.data.dto;

import com.example.restapitest.data.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderItemDTO {

    private String itemName;
    private int count;

    public OrderItemDTO(OrderItem orderItem){
        itemName = orderItem.getItem();
        count = orderItem.getCount();
    }

}
