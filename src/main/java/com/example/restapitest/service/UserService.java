package com.example.restapitest.service;

import com.example.restapitest.data.dto.UserSaveRequestDTO;
import com.example.restapitest.data.entity.User;
import com.example.restapitest.data.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

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

    public String getKaKaoAccessToken(String code){ // 카카오 토큰 받는 기능
        String access_Token=""; // 초기화
        String refresh_Token =""; // 초기화
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try{
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=a91d97f1d08c184bf4385f5553d57b6a"); // TODO REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:8080/api/users/kakao"); // TODO 인가코드 받은 redirect_uri 입력
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);
            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
    }



}
