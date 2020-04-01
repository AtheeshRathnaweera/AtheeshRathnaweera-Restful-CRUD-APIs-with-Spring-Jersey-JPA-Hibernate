package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.OrderEntity;
import com.atheesh.app.ws.factory.DTOToEntityFactory;
import com.atheesh.app.ws.factory.EntityToDTOFactory;
import com.atheesh.app.ws.repositories.OrderRepository;
import com.atheesh.app.ws.service.OrderService;
import com.atheesh.app.ws.shared.dto.OrderDTO;
import com.atheesh.app.ws.shared.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("orderService")
@Transactional(propagation= Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for(OrderEntity orderEntity : orderEntityList){
            orderDTOList.add(EntityToDTOFactory.order(orderEntity));
        }
        return orderDTOList;
    }

    @Override
    public OrderDTO getOderById(Integer id) {
        Optional<OrderEntity> orderEntityOptional = orderRepository.findById(id);

        if(orderEntityOptional.isPresent()){
            return EntityToDTOFactory.order(orderEntityOptional.get());
        }
        return null;
    }

    @Override
    public List<OrderDTO> getOrdersByUser(Integer userId) {
        List<OrderEntity> orderEntityList = orderRepository.findAllByUser_Id(userId);
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for(OrderEntity orderEntity : orderEntityList){
            orderDTOList.add(EntityToDTOFactory.order(orderEntity));
        }
        return orderDTOList;
    }


    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Date date = new Date();
        OrderEntity orderEntity = DTOToEntityFactory.order(orderDTO);
        orderEntity.setCreatedDate(date);
        orderEntity.setUpdatedDate(date);

        OrderEntity savedOrder = orderRepository.save(orderEntity);

        return EntityToDTOFactory.order(savedOrder);
    }

    @Override
    public boolean update(Integer id, OrderDTO orderDTO) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        orderRepository.deleteById(id);
        return true;
    }
}
