package com.example.restapitest.data.repository;

import com.example.restapitest.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> { //상속 받아서 인터페이스로 사용
    Order findById(String name); // 이름으로 찾기

    Optional<Order> findById(Long id); //특정 아이디로 찾기
    

}
