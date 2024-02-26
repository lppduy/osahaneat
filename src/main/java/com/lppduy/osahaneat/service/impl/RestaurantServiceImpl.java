package com.lppduy.osahaneat.service.impl;

import com.lppduy.osahaneat.dto.RestaurantDTO;
import com.lppduy.osahaneat.entity.RatingRestaurant;
import com.lppduy.osahaneat.entity.Restaurant;
import com.lppduy.osahaneat.repository.RestaurantRepository;
import com.lppduy.osahaneat.service.FileService;
import com.lppduy.osahaneat.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FileService fileService;

    @Override
    public boolean insertRestaurant(MultipartFile file,
                                    String title,
                                    String subtitle,
                                    String description,
                                    boolean isFreeship,
                                    String address,
                                    String openDateString) {

        boolean isInsertSuccess = false;

        try {
            boolean isSaveFileSuccess = fileService.saveFile(file);
            if (isSaveFileSuccess) {
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDesc(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setFreeship(isFreeship);
                restaurant.setAddress(address);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date openDate = simpleDateFormat.parse(openDateString);
                restaurant.setOpenDate(openDate);

                restaurantRepository.save(restaurant);
                isInsertSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Error insert restaurant: " + e.getMessage());
        }

        return isInsertSuccess;
    }

    @Override
    public List<RestaurantDTO> getHomeRestaurant() {

        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();

        PageRequest pageRequest = PageRequest.of(0,6);
        Page<Restaurant> listData = restaurantRepository.findAll(pageRequest);

        for (Restaurant data : listData) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setSubtitle(data.getSubtitle());
            restaurantDTO.setImage(data.getImage());
            restaurantDTO.setFreeShip(data.isFreeship());
            restaurantDTO.setRating(calculateRating(data.getListRatingRestaurant()));

            restaurantDTOList.add(restaurantDTO);
        }
        return restaurantDTOList;
    }

    private double calculateRating(Set<RatingRestaurant> listRating) {

        double totalPoint = 0;

        for (RatingRestaurant data : listRating) {
            totalPoint += data.getRatePoint();
        }

        return totalPoint / listRating.size();
    }
}
