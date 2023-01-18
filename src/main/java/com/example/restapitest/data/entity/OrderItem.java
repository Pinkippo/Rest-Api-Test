package com.example.restapitest.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 다른 패키지에 소속된 클래스 (상속 제외)
@AllArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderItemId")
    private Long id;

    private String item;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    private int count;

    public static OrderItem createOrderItem(String item, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);
        return orderItem;
    }

    public void updateItem(String item, int count){
        this.item = item;
        this.count = count;

    }

}
