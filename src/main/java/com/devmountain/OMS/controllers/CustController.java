package com.devmountain.OMS.controllers;


import com.devmountain.OMS.dtos.CustDto;
import com.devmountain.OMS.dtos.OrderDto;
import com.devmountain.OMS.services.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Cust")
public class CustController {

    @Autowired
    private CustService custService;

    @PostMapping("/register")
    public List<String> addCust(@RequestBody CustDto custDto)
    {
        return custService.addCust(custDto);
    }

}
