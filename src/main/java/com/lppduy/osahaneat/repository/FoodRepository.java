package com.lppduy.osahaneat.repository;

import com.lppduy.osahaneat.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
