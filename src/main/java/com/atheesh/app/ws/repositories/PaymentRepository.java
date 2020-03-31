package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
}
