package com.example.restapitest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class KakaoProfileDTO{ // 카카오 프로필 저장 내장 DTO
    private Long id;
    private String name;

}
