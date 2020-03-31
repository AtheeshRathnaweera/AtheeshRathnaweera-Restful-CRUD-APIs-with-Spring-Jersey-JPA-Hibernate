package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    List<PaymentDTO> getAllPayments();
    PaymentDTO getPaymentById(Integer id);
    PaymentDTO save(PaymentDTO paymentDTO);
    boolean update(Integer id, PaymentDTO paymentDTO);
    boolean delete(Integer id);
}
