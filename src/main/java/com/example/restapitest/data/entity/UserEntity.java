package com.example.restapitest.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter // 얘를 어떻게 해야하나
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
}
