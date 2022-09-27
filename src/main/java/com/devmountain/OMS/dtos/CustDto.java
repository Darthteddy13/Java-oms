package com.devmountain.OMS.dtos;


import com.devmountain.OMS.entities.Cust;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustDto implements Serializable {

    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    public CustDto(Cust cust)
    {
        if(cust.getId() != null)
            this.id = cust.getId();

        if(cust.getName() !=null)
            this.name = cust.getName();

        if(cust.getPhoneNumber() != null)
            this.phoneNumber = cust.getPhoneNumber();

        if(cust.getEmail() != null)
            this.email = cust.getEmail();
    }
}
