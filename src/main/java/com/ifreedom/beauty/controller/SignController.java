package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.service.UserService;
import com.ifreedom.beauty.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by eavawu on 4/26/16.
 */

@RestController
@RequestMapping("/sign")
public class SignController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public HttpResult signUp(@RequestParam Map<String, String> params) {
        HttpResult result = new HttpResult();
        String userName = params.get(HttpConstants.NAME);
        String phone = params.get(HttpConstants.PHONE);
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userName);
        userEntity.setPhone(phone);
        userEntity.setSex(Integer.parseInt(params.get(HttpConstants.SEX)));
        userEntity.setAvatar(params.get(HttpConstants.AVATAR));
        userEntity.setSignature("你什么也没留下");
        UserEntity saveUser = userService.saveUser(userEntity);
        if (userName==null|| StringUtils.isEmpty(userName)){
            result.setResult(HttpConstants.FAILED);
            result.setErrorMsg("用户名不能为空哦");
        }else if(StringUtils.isEmpty(userEntity.getPhone())){
            result.setResult(HttpConstants.FAILED);
            result.setErrorMsg("手机号不能为空哦");
        }else if(StringUtils.isEmpty(userEntity.getAvatar())){
            result.setResult(HttpConstants.FAILED);
            result.setErrorMsg("头像不能为空哦");
        }
        else{
            result.setResult(HttpConstants.SUCCESS);
            result.getData().put(HttpConstants.USER,saveUser);
        }
        return result;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn() {
        return "signIn";
    }
}
