package com.example.restapitest.data.repository;

import com.example.restapitest.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByUser(String name);


}
