package com.devmountain.OMS.services;

import com.devmountain.OMS.dtos.OrderDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    @Transactional
    void addOrder(OrderDto orderDto, long id);

    @Transactional
    void deleteOrderById(Long id);

    List<OrderDto> getAllOrderByCustId(Long id);

    Optional<OrderDto> getOrderById(long id);

    void updateOrderById(OrderDto orderDto);

    List<OrderDto> getAllOrders();
}
