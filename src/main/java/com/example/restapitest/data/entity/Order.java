package com.example.restapitest.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter // 잠시 사용
@NoArgsConstructor
@Entity
@ToString
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime date;

    public static Order createOrder(User user) {
        Order order = new Order();
        order.setUser(user);
        order.setDate(LocalDateTime.now());
        return order;
    }

}
