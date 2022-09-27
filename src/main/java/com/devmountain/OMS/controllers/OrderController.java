package com.devmountain.OMS.controllers;

import com.devmountain.OMS.dtos.OrderDto;
import com.devmountain.OMS.entities.Order;
import com.devmountain.OMS.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/cust/{custId}")
    public List<OrderDto> getOrdersByCust(@PathVariable Long custId)
    {
        return orderService.getAllOrderByCustId(custId);
    }

    @PostMapping("cust/{custId}")
    public void addOrder(@PathVariable Long custId) { orderService.addOrder(custId); }

    @DeleteMapping("/{orderId}")
    public void deleteOrderById(@PathVariable Long orderId)
    {
        orderService.deleteOrderById(orderId);
    }

    @PutMapping
    public void updateOrder(@RequestBody OrderDto orderDto)
    {
        orderService.updateOrderById(orderDto);
    }

    @GetMapping("/{orderId}")
    public Optional<OrderDto> getOrderById(@PathVariable Long orderId)
    {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/orders")
    public List<OrderDto> getAllOrders() { return orderService.getAllOrders(); }


}
