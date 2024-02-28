package com.lppduy.osahaneat.service.impl;

import com.lppduy.osahaneat.dto.CategoryDTO;
import com.lppduy.osahaneat.dto.MenuDTO;
import com.lppduy.osahaneat.entity.Category;
import com.lppduy.osahaneat.entity.Food;
import com.lppduy.osahaneat.repository.CategoryRepository;
import com.lppduy.osahaneat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getCategoryHomePage() {

        PageRequest pageRequest = PageRequest.of(0,3);
        Page<Category> categoryPage = categoryRepository.findAll(pageRequest);
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

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

        return categoryDTOList;
    }
}
