package com.lppduy.osahaneat.controller;

import com.lppduy.osahaneat.payload.ResponseData;
import com.lppduy.osahaneat.service.FileService;
import com.lppduy.osahaneat.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    FileService fileService;

    @Autowired
    RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<?> createRestaurant(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String subtitle,
            @RequestParam String description,
            @RequestParam(value = "is_freeship") boolean isFreeship,
            @RequestParam String address,
            @RequestParam(value = "open_date") String openDate
    ) {

        ResponseData responseData = new ResponseData();

        boolean isSuccess = restaurantService.insertRestaurant(
                file, title, subtitle, description, isFreeship, address, openDate);

        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getHomeRestaurant() {

        ResponseData responseData = new ResponseData();



        responseData.setData(restaurantService.getHomeRestaurant());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFileRestaurant(@PathVariable String filename) {
        Resource resource = fileService.loadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
