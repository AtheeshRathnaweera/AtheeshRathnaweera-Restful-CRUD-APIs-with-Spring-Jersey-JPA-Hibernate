package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.PaymentEntity;
import com.atheesh.app.ws.factory.DTOToEntityFactory;
import com.atheesh.app.ws.factory.EntityToDTOFactory;
import com.atheesh.app.ws.repositories.PaymentRepository;
import com.atheesh.app.ws.service.PaymentService;
import com.atheesh.app.ws.shared.dto.OrderDTO;
import com.atheesh.app.ws.shared.dto.PaymentDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("paymentService")
@Transactional(propagation = Propagation.REQUIRED)
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<PaymentEntity> paymentEntityList = paymentRepository.findAll();
        List<PaymentDTO> paymentDTOList = new ArrayList<>();

        for (PaymentEntity paymentEntity : paymentEntityList) {
            paymentDTOList.add(EntityToDTOFactory.payment(paymentEntity));
        }
        return paymentDTOList;
    }

    @Override
    public PaymentDTO getPaymentById(Integer id) {
        Optional<PaymentEntity> paymentEntityOptional = paymentRepository.findById(id);

        if (paymentEntityOptional.isPresent()) {
            return EntityToDTOFactory.payment(paymentEntityOptional.get());
        }
        return null;
    }

    @Override
    public PaymentDTO getPaymentByOrder(Integer orderId) {
        PaymentEntity paymentEntity = paymentRepository.findByOrder_Id(orderId);
        return EntityToDTOFactory.payment(paymentEntity);
    }

    @Override
    public List<PaymentDTO> getPaymentsByUser(UserDTO userDTO) {
        List<PaymentEntity> paymentEntityList = paymentRepository.findPaymentsByUser(userDTO.getId());
        List<PaymentDTO> paymentDTOList = new ArrayList<>();

        for (PaymentEntity paymentEntity : paymentEntityList) {
            paymentDTOList.add(EntityToDTOFactory.payment(paymentEntity));
        }
        return paymentDTOList;
    }

    @Override
    public PaymentDTO save(PaymentDTO paymentDTO) {
        PaymentEntity paymentEntity = DTOToEntityFactory.payment(paymentDTO);
        paymentEntity.setPaymentDate(new Date());

        PaymentEntity paymentEntity1 = paymentRepository.save(paymentEntity);

        System.out.println("rec ent : " + paymentEntity1.toString());
        return EntityToDTOFactory.payment(paymentEntity);
    }

    @Override
    public boolean update(Integer id, PaymentDTO paymentDTO) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        paymentRepository.deleteById(id);
        return true;
    }
}
