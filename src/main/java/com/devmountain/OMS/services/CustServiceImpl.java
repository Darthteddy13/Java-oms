package com.devmountain.OMS.services;

import com.devmountain.OMS.dtos.CustDto;
import com.devmountain.OMS.dtos.OrderDto;
import com.devmountain.OMS.entities.Cust;
import com.devmountain.OMS.entities.Order;
import com.devmountain.OMS.repos.CustRepository;
import com.devmountain.OMS.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustServiceImpl implements CustService {

    @Autowired
    private CustRepository custRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public List<String> addCust(CustDto custDto)
    {
        List<String> response = new ArrayList<>();
        Cust cust = new Cust(custDto);

        System.out.println(cust);

        custRepository.saveAndFlush(cust);
        response.add("Customer added!");
        return response;
    }

    @Override
    @Transactional
    public Optional<CustDto> getByName(String name)
    {
        Optional<Cust> custOptional = custRepository.findByName(name);

        if(custOptional.isPresent())
            return Optional.of(new CustDto(custOptional.get()));

        return Optional.empty();

    }

    @Override
    public List<CustDto> getAllCustomers()
    {
        List<Cust> custList = custRepository.findAll();
        return custList.stream().map(cust -> new CustDto(cust)).collect(Collectors.toList());
    }
}
