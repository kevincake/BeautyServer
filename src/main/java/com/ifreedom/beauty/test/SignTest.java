package com.ifreedom.beauty.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifreedom.beauty.entity.UserEntity;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class SignTest {
    private RestTemplate template = new TestRestTemplate();
    @Test
    public void testSignIn(){
        String url = TestConstants.BASE_URL+ TestConstants.SIGN+"/signUp";
        UserEntity userEntity = new UserEntity();
        userEntity.setId(111L);
        userEntity.setName("hello world");
        ObjectMapper mapper = new ObjectMapper();
        String jsonData = "";
        try {
          jsonData =    mapper.writeValueAsString(userEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        UserEntity  forObject = template.getForObject(url, UserEntity.class, jsonData);
        System.out.println(forObject.toString());
    }
}
