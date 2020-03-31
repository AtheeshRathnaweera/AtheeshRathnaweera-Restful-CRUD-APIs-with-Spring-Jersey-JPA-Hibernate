package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();
    OrderDTO getOfferById(Integer id);
    OrderDTO save(OrderDTO orderDTO);
    boolean update(Integer id, OrderDTO orderDTO);
    boolean delete(Integer id);
}
