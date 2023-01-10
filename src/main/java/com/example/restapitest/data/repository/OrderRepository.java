package com.example.restapitest.data.repository;

import com.example.restapitest.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> { //상속 받아서 인터페이스로 사용
    Order findByUser(String name);


}
