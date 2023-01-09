package com.example.restapitest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter // 잠시 사용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(name = "user_order")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime date;

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(User user, OrderItem... orderItems) {
        Order order = new Order();
        order.setUser(user);
        for(OrderItem orderItem : orderItems){
            order.addOrderItem(orderItem);
        }
        order.setDate(LocalDateTime.now());
        return order;
    }

}
