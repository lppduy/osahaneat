package com.lppduy.osahaneat.entity;

import com.lppduy.osahaneat.entity.keys.KeyOrderItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "OrderItem")
public class OrderItem {

    @EmbeddedId
    KeyOrderItem keys;

    @ManyToOne
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "food_id",insertable = false,updatable = false)
    private Food food;

    @Column(name = "creat_date")
    private Date creatDate;
}
