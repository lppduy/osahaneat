package com.lppduy.osahaneat.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lppduy.osahaneat.dto.CategoryDTO;
import com.lppduy.osahaneat.dto.MenuDTO;
import com.lppduy.osahaneat.entity.Category;
import com.lppduy.osahaneat.entity.Food;
import com.lppduy.osahaneat.repository.CategoryRepository;
import com.lppduy.osahaneat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RedisTemplate redisTemplate;

    private Gson gson = new Gson();

//    @Cacheable("categoryHome")
    @Override
    public List<CategoryDTO> getCategoryHomePage() {

        String dataRedis = (String) redisTemplate.opsForValue().get("category");
        List<CategoryDTO> categoryDTOList = new ArrayList<>();


        if (dataRedis == null) {
            System.out.println("Do not have data");

            PageRequest pageRequest = PageRequest.of(0,3, Sort.by("id"));
            Page<Category> categoryPage = categoryRepository.findAll(pageRequest);

            for (Category data : categoryPage) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(data.getNameCate());

                List<MenuDTO> menuDTOList = new ArrayList<>();

                for (Food dataFood : data.getListFood()) {
                    MenuDTO menuDTO = new MenuDTO();
                    menuDTO.setTitle(dataFood.getTitle());
                    menuDTO.setFreeship(dataFood.isFreeship());
                    menuDTO.setImage(dataFood.getImage());

                    menuDTOList.add(menuDTO);
                }

                categoryDTO.setMenus(menuDTOList);
                categoryDTOList.add(categoryDTO);
            }

            String dataJson = gson.toJson(categoryDTOList);
            redisTemplate.opsForValue().set("category",dataJson);

        } else {
            System.out.println("Do have data");
            Type listType = new TypeToken<List<CategoryDTO>>() {}.getType();
            categoryDTOList = gson.fromJson(dataRedis,listType);
        }




        return categoryDTOList;
    }
}
