package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.OrderEntity;
import com.atheesh.app.ws.entities.PaymentEntity;
import com.atheesh.app.ws.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

    PaymentEntity findByOrder_Id(Integer orderId);

//    @Transactional
//    @Query("SELECT p FROM PaymentEntity p INNER JOIN OrderEntity o ON p.order = o.id WHERE o.user=:userId")
  //  List<PaymentEntity> findPaymentsByUser(@Param("userId") UserEntity userId);

    @Query(value = "SELECT * from payment p INNER JOIN orders o ON p.order_id=o.id where o.user_id = ?1", nativeQuery = true)
    List<PaymentEntity> findPaymentsByUser(@Param("userId") Integer userId);
}
