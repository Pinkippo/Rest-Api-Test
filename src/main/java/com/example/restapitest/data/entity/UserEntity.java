package com.example.restapitest.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Entity
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 30, nullable = false)
    String name;

    @Column(length = 30, nullable = false)
    String password;

    @Builder
    public UserEntity(Long id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void changeUserInfo(String name, String password){
        this.name = name;
        this.password = password;
    }

}
