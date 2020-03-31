package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.service.OrderService;
import com.atheesh.app.ws.shared.dto.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional(propagation= Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService{

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public OrderDTO getOfferById(Integer id) {
        return null;
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public boolean update(Integer id, OrderDTO orderDTO) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
