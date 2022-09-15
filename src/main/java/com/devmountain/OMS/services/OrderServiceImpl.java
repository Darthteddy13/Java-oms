package com.devmountain.OMS.services;

import com.devmountain.OMS.dtos.OrderDto;
import com.devmountain.OMS.entities.Cust;
import com.devmountain.OMS.entities.Order;
import com.devmountain.OMS.repos.CustRepository;
import com.devmountain.OMS.repos.ItemRepository;
import com.devmountain.OMS.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustRepository custRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void addOrder(OrderDto orderDto, long id)
    {
        Optional<Cust> custOptional = custRepository.findById(id);
        Order order = new Order(orderDto);
        custOptional.ifPresent(order::setCust);
        orderRepository.saveAndFlush(order);
    }

    @Override
    @Transactional
    public void deleteOrderById(Long id)
    {
        Optional<Order> orderOptional = orderRepository.findById(id);
        orderOptional.ifPresent(orderRepository::delete);
    }

    @Override
    public List<OrderDto> getAllOrderByCustId(Long id)
    {
        Optional<Cust> custOptional = custRepository.findById(id);
        if(custOptional.isPresent())
        {
            List<Order> orderList = orderRepository.findAllByCustEquals(custOptional.get());
            return orderList.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<OrderDto> getOrderById(long id)
    {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if(orderOptional.isPresent())
            return Optional.of(new OrderDto(orderOptional.get()));

        return Optional.empty();
    }

    @Override
    public void updateOrderById(OrderDto orderDto)
    {
        Optional<Order> orderOptional = orderRepository.findById(orderDto.getId());
        orderOptional.ifPresent(order ->
        {
            order.setCust(orderDto.getCust());
            order.setId(orderDto.getId());
            order.setItemList(orderDto.getItemList());
            orderRepository.saveAndFlush(order);
        });
    }



}
