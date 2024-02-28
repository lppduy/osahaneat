package com.lppduy.osahaneat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "res_id")
    private Restaurant restaurant;

    @Column(name = "creat_date")
    private Date creatDate;

    @OneToMany(mappedBy = "orders")
    private Set<OrderItem> listOrderItem;
}
