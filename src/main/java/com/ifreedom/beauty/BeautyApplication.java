package com.ifreedom.beauty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by eavawu on 4/26/16.
 */
@SpringBootApplication
public class BeautyApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeautyApplication.class, args);
    }
}
