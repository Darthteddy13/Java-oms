package com.devmountain.OMS.controllers;

import com.devmountain.OMS.dtos.OrderDto;
import com.devmountain.OMS.entities.Order;
import com.devmountain.OMS.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/cust/{custId}")
    public List<OrderDto> getOrdersByCust(@PathVariable Long id)
    {
        return orderService.getAllOrderByCustId(id);
    }

    @PostMapping("cust/{custId}")
    public void addOrder(@RequestBody OrderDto orderDto, @PathVariable Long id)
    {
        orderService.addOrder(orderDto, id);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrderById(@PathVariable Long id)
    {
        orderService.deleteOrderById(id);
    }

    @PutMapping
    public void updateOrder(@RequestBody OrderDto orderDto)
    {
        orderService.updateOrderById(orderDto);
    }

    @GetMapping("/{orderId}")
    public Optional<OrderDto> getOrderById(@PathVariable Long id)
    {
        return orderService.getOrderById(id);
    }



}
