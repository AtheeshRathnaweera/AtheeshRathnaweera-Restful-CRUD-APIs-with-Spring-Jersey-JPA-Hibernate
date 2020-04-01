package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.PaymentDTO;

public interface EmailService {

    void sendTextMail(String to, String subject, String body);
    void sendOrderConfirmationMail(String to, String subject, PaymentDTO paymentDTO);
}
