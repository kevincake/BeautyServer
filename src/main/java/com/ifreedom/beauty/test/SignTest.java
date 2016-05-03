package com.ifreedom.beauty.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.UserEntity;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    @Test
    public void testSignUp(){
        String url = TestConstants.BASE_URL+ TestConstants.SIGN+"/signUp";
        Map<String,String> params = new HashMap<String,String>();
        params.put(HttpConstants.NAME,"testSignUp");
        params.put(HttpConstants.PASSWORD,111111+"");
        params.put(HttpConstants.AVATAR,"avatar");
        params.put(HttpConstants.PHONE,"18311362506");
        params.put(HttpConstants.SEX,1+"");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Map<String,String>> request = new HttpEntity<Map<String,String>>(
                params, headers);
//        HttpEntity<Object> entity = new HttpEntity<Object>(params);
        HttpResult forObject = template.postForObject(url, request, HttpResult.class);

    }
}
