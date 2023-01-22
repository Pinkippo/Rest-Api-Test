package com.example.restapitest.controller;


import com.example.restapitest.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class Kakao {


    private final UserService userService;

    public Kakao(UserService userService){ // 생성자로 의존성 주입
        this.userService = userService;
    }

    @ResponseBody // 접근 링크 : https://kauth.kakao.com/oauth/authorize?client_id=a91d97f1d08c184bf4385f5553d57b6a&redirect_uri=http://localhost:8080/api/users/kakao&response_type=code
    @GetMapping("/kakao")
    public String kakaoCallback(@RequestParam String code) throws Exception{

        userService.getKaKaoAccessToken(code);
        return "확인되었습니다";

    }
}
