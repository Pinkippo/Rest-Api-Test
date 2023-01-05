package com.example.restapitest.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity
@Builder
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
}
