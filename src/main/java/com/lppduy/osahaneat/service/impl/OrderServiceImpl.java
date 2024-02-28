package com.lppduy.osahaneat.service.impl;

import com.lppduy.osahaneat.entity.*;
import com.lppduy.osahaneat.entity.keys.KeyOrderItem;
import com.lppduy.osahaneat.payload.request.OrderRequest;
import com.lppduy.osahaneat.repository.OrderItemRepository;
import com.lppduy.osahaneat.repository.OrderRepository;
import com.lppduy.osahaneat.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public boolean insertOrder(OrderRequest orderRequest) {

        try {
            Users users = new Users();
            users.setId(orderRequest.getUserId());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getRestId());

            Orders orders = new Orders();
            orders.setUsers(users);
            orders.setRestaurant(restaurant);

            orderRepository.save(orders);

            List<OrderItem> items = new ArrayList<>();

            for (int idFood : orderRequest.getFoodIds()) {
                Food food = new Food();
                food.setId(idFood);

                OrderItem orderItem = new OrderItem();
                KeyOrderItem keyOrderItem = new KeyOrderItem(orders.getId(), idFood);
                orderItem.setKeyOrderItem(keyOrderItem);
                orderItem.setFood(food);
                orderItem.setOrders(orders);


                items.add(orderItem);
            }

            orderItemRepository.saveAll(items);

            return true;
        } catch (Exception e) {
            System.out.println("Erorr insert order: " + e.getMessage());
            return false;
        }
    }
}
