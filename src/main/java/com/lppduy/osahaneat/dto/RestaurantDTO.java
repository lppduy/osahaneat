package com.lppduy.osahaneat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RestaurantDTO {
    private String image;
    private String title;
    private double rating;
    private String subtitle;
    private boolean isFreeShip;
    private Date openDate;
    private String desc;
    List<CategoryDTO> categories;
}
