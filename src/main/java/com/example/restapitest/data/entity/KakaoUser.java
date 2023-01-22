package com.example.restapitest.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "kakaouser")
public class KakaoUser {

    @Id
    @Column(name="kakaoId")
    private Long id;
    @Column(name = "kakaoName",length = 15, nullable = false)
    private String name;

    @Builder
    public KakaoUser(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
