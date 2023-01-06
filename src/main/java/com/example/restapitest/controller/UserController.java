package com.example.restapitest.controller;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.UserEntity;
import com.example.restapitest.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController // Controller + RequestBody
@RequestMapping(value = "/api/user") // 이 컨트롤러의 기본 URL 잡기
public class UserController {

    private final UserService userService; // 서비스 객체 생성

    public UserController(UserService userService){ // 생성자로 의존성 주입
        this.userService = userService;
    }

    @PostMapping("/post1") // POST 방식 DB 저장(INSERT)
    public void PostUser(@RequestBody UserSaveRequestDTO userSaveRequestDTO){

       userService.saveUser(userSaveRequestDTO);

    }

    @PutMapping("/put/{id}") // 특정 아이디의 정보를 변경
    public void updateUser(@PathVariable("id") Long id,
                             @RequestBody UpdateUserRequest request ){
        userService.update(id, request.getName(), request.getPassword());
    }

    @Data
    static class UpdateUserRequest { // 내부 DTO
        private String name;
        private String password;

    }

    @GetMapping("/v1/users")
    public List<UserEntity> userV1(){ // 응답 값 엔티티를 직접 외부에 노출 -> 안된다
        return userService.findMembers();
    }

    @GetMapping("/v2/users")
    public Result userV2(){
        List<UserEntity> findUsers = userService.findMembers();
        List<UserDTO> collect = findUsers.stream()
                .map(m -> new UserDTO( Long.toString(m.getId()),m.getName(),m.getPassword()))
                .collect(Collectors.toList());

        return new Result(collect.size(),collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{ //한번 감싸줘야함

        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class UserDTO{
        private String id;
        private String name;
        private String password;
    }

}
