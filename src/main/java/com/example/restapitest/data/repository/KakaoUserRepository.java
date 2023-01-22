package com.example.restapitest.data.repository;

import com.example.restapitest.data.entity.KakaoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoUserRepository extends JpaRepository<KakaoUser, Long> {

}
