package com.devmountain.OMS.repos;

import com.devmountain.OMS.entities.Cust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devmountain.OMS.entities.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByCustEquals(Cust cust);
}
