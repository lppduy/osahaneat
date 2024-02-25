package com.lppduy.osahaneat.entity;

import com.lppduy.osahaneat.entity.keys.KeyMenuRestaurant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class MenuRestaurant {

    @EmbeddedId
    KeyMenuRestaurant keys;

    @ManyToOne
    @JoinColumn(name = "cate_id",insertable = false,updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id",insertable = false,updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Date createDate;
}
