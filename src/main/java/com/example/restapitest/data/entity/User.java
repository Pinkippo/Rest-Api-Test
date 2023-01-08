package com.example.restapitest.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    @Column(name = "user_name",length = 30, nullable = false)
    private String name;

    @Column(name="user_password",length = 30, nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public User(Long id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void changeUserInfo(String name, String password){
        this.name = name;
        this.password = password;
    }

}
