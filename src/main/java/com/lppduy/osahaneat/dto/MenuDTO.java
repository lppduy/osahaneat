package com.lppduy.osahaneat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDTO {
    private String title;
    private String image;
    private boolean isFreeship;
    private String desc;
    private double price;
}
