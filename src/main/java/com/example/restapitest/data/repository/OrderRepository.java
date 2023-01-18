package com.example.restapitest.data.repository;

import com.example.restapitest.data.entity.Order;
import jakarta.persistence.Id;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> { //상속 받아서 인터페이스로 사용
    Order findById(String name); // 이름으로 찾기

    @Query("select o from Order o where o.id = :id")
    Order findOne(@Param("id") Long id);

    Optional<Order> findById(Long id); //특정 아이디로 찾기



    @Query("select o from Order o join fetch o.user join fetch o.orderItems")
    List<Order> findAllItem();

}
