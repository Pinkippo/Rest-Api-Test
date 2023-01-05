package com.example.restapitest.controller;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/post1")
    public void postuser(@RequestBody UserSaveRequestDTO userSaveRequestDTO){

       userService.saveUser(userSaveRequestDTO);

    }

}
