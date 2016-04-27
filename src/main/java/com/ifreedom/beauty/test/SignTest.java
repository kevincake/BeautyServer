package com.ifreedom.beauty.test;

import com.ifreedom.beauty.BeautyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class SignTest {
    private RestTemplate template = new TestRestTemplate();
    @Test
    public void testSignIn(){
        String url = TestConstants.BASE_URL+ TestConstants.SIGN+"/1";
        Map paramMap = new HashMap<String,Long>();
        String result = template.getForObject(url, String.class,paramMap);
        System.out.println(result);
    }
}
