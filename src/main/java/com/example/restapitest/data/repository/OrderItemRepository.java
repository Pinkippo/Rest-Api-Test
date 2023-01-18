package com.example.restapitest.data.repository;

import com.example.restapitest.data.entity.Order;
import com.example.restapitest.data.entity.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> { // 상속 받아 사용

    @Query("update OrderItem o set o.item = ?1, o.count = ?2 where o.order.id= ?3")
    OrderItem updateOne(String item, int count, Long orderid);

    @Query("select o from OrderItem o where o.order = ?1")
    OrderItem findByOrderId(Order order);

}
