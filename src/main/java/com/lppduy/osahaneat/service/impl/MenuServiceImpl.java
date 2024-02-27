package com.lppduy.osahaneat.service.impl;

import com.lppduy.osahaneat.entity.Category;
import com.lppduy.osahaneat.entity.Food;
import com.lppduy.osahaneat.entity.Restaurant;
import com.lppduy.osahaneat.repository.FoodRepository;
import com.lppduy.osahaneat.service.FileService;
import com.lppduy.osahaneat.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    FileService fileService;

    @Autowired
    FoodRepository foodRepository;

    @Override
    public boolean createMenu(MultipartFile file, String title, boolean isFreeship, String timeShip, double price, int cateId) {
        boolean isInsertSuccess = false;

        try {
            boolean isSaveFileSuccess = fileService.saveFile(file);
            if (isSaveFileSuccess) {
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(timeShip);
                food.setPrice(price);

                Category category = new Category();
                category.setId(cateId);

                food.setCategory(category);

                foodRepository.save(food);

                isInsertSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Error insert restaurant: " + e.getMessage());
        }

        return isInsertSuccess;

    }
}
