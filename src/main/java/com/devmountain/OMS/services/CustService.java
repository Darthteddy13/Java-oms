package com.devmountain.OMS.services;

import com.devmountain.OMS.dtos.CustDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CustService {

    @Transactional
    List<String> addCust(CustDto custDto);

    @Transactional
    Optional<CustDto> getByName(String name);

    List<CustDto> getAllCustomers();
}
