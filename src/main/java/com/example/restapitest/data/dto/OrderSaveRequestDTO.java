package com.example.restapitest.data.dto;

import com.example.restapitest.data.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class OrderSaveRequestDTO {

    private Long userId;
    private String name;
    private List<OrderItemDTO> orderItems;

    private int count;



}
