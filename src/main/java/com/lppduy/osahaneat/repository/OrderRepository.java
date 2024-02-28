package com.lppduy.osahaneat.repository;

import com.lppduy.osahaneat.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
