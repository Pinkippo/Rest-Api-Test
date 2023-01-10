package com.example.restapitest.data.dto;

import com.example.restapitest.data.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderItemDTO {

    private Long id;
    private String itemName;


    public OrderItemDTO(OrderItem orderItem){
        id = orderItem.getId();
        itemName = orderItem.getItem();
    }

}
