package com.lppduy.osahaneat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "passwod")
    private String passwod;

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
