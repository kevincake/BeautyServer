package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.bean.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eavawu on 4/26/16.
 */

@RestController
@RequestMapping("/sign")
public class SignController {
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public UserEntity signUp(@PathVariable("id") Long id){
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(1);
        userEntity.setName("abc");
        return userEntity;

    }

    @RequestMapping(value = "/signIn",method = RequestMethod.GET)
    public String signIn(){
        return "signIn";
    }
}
