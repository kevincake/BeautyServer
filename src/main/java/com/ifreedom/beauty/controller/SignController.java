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
        userEntity.setSignature("signtureDefault");
        UserEntity saveUser = userService.saveUser(userEntity);
        if (userName == null || StringUtils.isEmpty(userName)) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("userNameNotNull"));
        } else if (StringUtils.isEmpty(userEntity.getPhone())) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg("phoneNotNull");
        } else if (StringUtils.isEmpty(userEntity.getAvatar())) {
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg("avatarNotNull");
        } else {
            result.setResultCode(HttpConstants.SUCCESS);
            result.getData().put(HttpConstants.USER, saveUser);
        }
        return result;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn() {
        return "signIn";
    }

    @ResponseBody
    @RequestMapping(value = "/isPhoneRegister", method = RequestMethod.GET)
    public HttpResult getIsPhoneRegister(@RequestParam("phone") String phone){
        HttpResult result = new HttpResult();
        boolean isRegister =  userService.isPhoneRegister(phone);
        if (isRegister){
            result.setResultCode(HttpConstants.FAILED);
            result.setMsg(PropertyUtil.getProperty("phoneHasRegister"));
        }else{
            result.setResultCode(HttpConstants.SUCCESS);

        };
        return result;
    }

}
