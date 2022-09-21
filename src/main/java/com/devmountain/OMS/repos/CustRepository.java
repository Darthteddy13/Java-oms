package com.devmountain.OMS.repos;

import com.devmountain.OMS.entities.Cust;
import com.devmountain.OMS.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustRepository extends JpaRepository<Cust, Long> {

    Optional<Cust> findByName(String name);

}
