package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.service.PaymentService;
import com.atheesh.app.ws.shared.dto.PaymentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("paymentService")
@Transactional(propagation= Propagation.REQUIRED)
public class PaymentServiceImpl implements PaymentService {

    @Override
    public List<PaymentDTO> getAllPayments() {
        return null;
    }

    @Override
    public PaymentDTO getPaymentById(Integer id) {
        return null;
    }

    @Override
    public PaymentDTO save(PaymentDTO paymentDTO) {
        return null;
    }

    @Override
    public boolean update(Integer id, PaymentDTO paymentDTO) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
