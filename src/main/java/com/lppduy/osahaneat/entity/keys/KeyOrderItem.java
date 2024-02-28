package com.lppduy.osahaneat.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
public class KeyOrderItem implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "food_id")
    private int foodId;

    public KeyOrderItem() {
    }

    public KeyOrderItem(int orderId, int foodId) {
        this.orderId = orderId;
        this.foodId = foodId;
    }
}
