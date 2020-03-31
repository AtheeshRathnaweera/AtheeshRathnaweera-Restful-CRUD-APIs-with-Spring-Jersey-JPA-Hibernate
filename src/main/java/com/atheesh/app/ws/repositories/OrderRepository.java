package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
