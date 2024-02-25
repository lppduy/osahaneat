package com.lppduy.osahaneat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "create_date")
    private String createDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    Set<RatingFood> listRatingFood;

    @OneToMany(mappedBy = "users")
    Set<RatingRestaurant> listRatingRestaurant;

    @OneToMany(mappedBy = "users")
    Set<Orders> listOrder;
}
