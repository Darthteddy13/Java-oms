package com.devmountain.OMS.entities;

import com.devmountain.OMS.dtos.CustDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Customers")
@AllArgsConstructor
@NoArgsConstructor
public class Cust {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @OneToMany(mappedBy = "cust", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference
    private Set<Order> orderSet = new HashSet<>();

    public Cust(CustDto custDto)
    {
        if(custDto.getId() != null)
            this.id = custDto.getId();

        if(custDto.getName() != null)
            this.name = custDto.getName();

        if(custDto.getEmail() != null)
            this.email = custDto.getEmail();

        if(custDto.getPhoneNumber() != null)
            this.phoneNumber = custDto.getPhoneNumber();
    }


}
