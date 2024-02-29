package com.lppduy.osahaneat.controller;

import com.lppduy.osahaneat.payload.ResponseData;
import com.lppduy.osahaneat.service.CategoryService;
import com.lppduy.osahaneat.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping
    public ResponseEntity<?> getHomeRestaurant() {

        ResponseData responseData = new ResponseData();

        responseData.setData(categoryService.getCategoryHomePage());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @CacheEvict(value = "categoryHome",allEntries = true)
    @GetMapping("/clear-cache")
    public String clearCache() {
        return "Clear cache success";
    }

}
