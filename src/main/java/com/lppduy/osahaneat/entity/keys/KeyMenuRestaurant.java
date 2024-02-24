package com.lppduy.osahaneat.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class KeyMenuRestaurant implements Serializable {

    @Column(name = "cate_id")
    private int cateId;


    @Column(name = "res_id")
    private int resId;


}
