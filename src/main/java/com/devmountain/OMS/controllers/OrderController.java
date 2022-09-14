package com.devmountain.OMS.controllers;

import com.devmountain.OMS.dtos.OrderDto;
import com.devmountain.OMS.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/cust/{custId}")
    public List<OrderDto> getOrdersByCust(@PathVariable Long id)
    {
        return orderService.getAllOrderByCustId(id);
    }
}
