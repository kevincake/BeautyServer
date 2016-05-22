package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.authorization.annotation.Authorization;
import com.ifreedom.beauty.authorization.annotation.CurrentUser;
import com.ifreedom.beauty.bean.HttpResult;
import com.ifreedom.beauty.constants.DataBaseConstants;
import com.ifreedom.beauty.constants.HttpConstants;
import com.ifreedom.beauty.entity.LikeEntity;
import com.ifreedom.beauty.entity.UserEntity;
import com.ifreedom.beauty.service.LikeService;
import com.ifreedom.beauty.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @atuhor:eavawu
 * @date:5/13/16
 * @todo:
 */
@RestController
@RequestMapping(HttpConstants.SOCIAL_CONTROL_PATH)
public class SocialController {
    @Autowired
    SocialService socialService;
    @Autowired
    LikeService likeService;
    @Authorization
    @ResponseBody
    @RequestMapping(value =HttpConstants.GET_SOCIALS,method = RequestMethod.GET)
    public HttpResult getSocialDetails(@CurrentUser UserEntity user){
        HttpResult result = new HttpResult();
        result.getData().put(HttpConstants.SOCIAL_DETAILS,socialService.getSocialDetails(user.getId()));
        result.setResultCode(HttpConstants.SUCCESS);
        return  result;
    }

    @Authorization
    @ResponseBody
    @RequestMapping(value =HttpConstants.LIKE_PATH,method = RequestMethod.POST)
    public HttpResult likeStatus(@CurrentUser UserEntity user, @RequestParam(HttpConstants.STATUS)int status,@RequestParam(HttpConstants.SOCIAL_ID)long socialId){
        HttpResult result = new HttpResult();

        if (status== DataBaseConstants.LIKE){
            LikeEntity likeEntity = new LikeEntity();
            likeEntity.setSocialId(socialId);
            likeEntity.setUserId(user.getId());
            likeService.addLike(likeEntity);
        }else{
            LikeEntity like = likeService.getLike(socialId, user.getId());
            likeService.deleteLike(like.getId());

        }
        result.setResultCode(HttpConstants.SUCCESS);
        return  result;
    }

    @Authorization
    @ResponseBody
    @RequestMapping(value ="/getMineSocial",method = RequestMethod.POST)
    public HttpResult getMineSocial(@CurrentUser UserEntity userEntity){
        HttpResult result = new HttpResult();
        result.setResultCode(HttpConstants.SUCCESS);
        result.getData().put(HttpConstants.SOCIAL_DETAILS,socialService.getMineSocial(userEntity.getId()));
        return result;
    }

}
