package com.lppduy.osahaneat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantDTO {
    private String image;
    private String title;
    private double rating;
    private String subtitle;
    private boolean isFreeShip;
}
