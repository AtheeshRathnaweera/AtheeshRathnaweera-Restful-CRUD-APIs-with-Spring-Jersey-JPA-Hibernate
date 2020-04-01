package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findAllByUser_Id(Integer userId);
}
