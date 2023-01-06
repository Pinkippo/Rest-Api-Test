package com.example.restapitest.controller;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.UserEntity;
import com.example.restapitest.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/post1")
    public void PostUser(@RequestBody UserSaveRequestDTO userSaveRequestDTO){

       userService.saveUser(userSaveRequestDTO);

    }

    @PutMapping("/put/{id}")
    public void updateUser(@PathVariable("id") Long id,
                             @RequestBody UpdateUserRequest request ){
        userService.update(id, request.getName(), request.getPassword());
    }

    @Data
    static class UpdateUserRequest {
        private String name;
        private String password;

    }



}
