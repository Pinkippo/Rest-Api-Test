package com.example.restapitest.service;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.User;
import com.example.restapitest.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final + not null 붙은 것 대신 생성자 생성 -> 의존성 주입
@Transactional
public class UserService {

    private final UserRepository userRepository; // 레파지토리 연결

    @Transactional
    public String saveUser(UserSaveRequestDTO userSaveRequestDTO){

            userRepository.save(userSaveRequestDTO.toEntity());
            return userSaveRequestDTO.getName();
    }

    public User getUser(Long id){
        User user = userRepository.findOne(id);
        return user;
    }

    public String UpdateUser(Long id, UserSaveRequestDTO userSaveRequestDTO){ // 유저 정보 수정

        User user = userRepository.findOne(id);
        user.changeUserInfo(userSaveRequestDTO.getName(),userSaveRequestDTO.getPassword());
        return user.getName();

    }

    public List<User> findMembers() {
        return userRepository.findAll();
    }

    @Transactional
    public void update(Long id, String name, String password){
        User user = userRepository.findOne(id);
        user.changeUserInfo(name, password);
    }
}
