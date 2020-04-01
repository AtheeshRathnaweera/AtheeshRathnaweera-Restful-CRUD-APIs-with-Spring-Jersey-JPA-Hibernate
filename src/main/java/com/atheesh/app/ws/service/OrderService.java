package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.OrderDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();
    OrderDTO getOderById(Integer id);
    OrderDTO save(OrderDTO orderDTO);
    List<OrderDTO> getOrdersByUser(Integer userId);
    boolean update(Integer id, OrderDTO orderDTO);
    boolean delete(Integer id);
}
