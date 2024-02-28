package com.lppduy.osahaneat.service;

import com.lppduy.osahaneat.dto.RestaurantDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantService {
    boolean insertRestaurant(
            MultipartFile file,
            String title,
            String subtitle,
            String description,
            boolean isFreeship,
            String address,
            String open_date
    );
    List<RestaurantDTO> getHomeRestaurant();
    RestaurantDTO getDetailRestaurant(int id);
}
