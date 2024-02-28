package com.lppduy.osahaneat.repository;

import com.lppduy.osahaneat.entity.OrderItem;
import com.lppduy.osahaneat.entity.keys.KeyOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, KeyOrderItem> {
}
