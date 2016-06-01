package com.ifreedom.beauty.controller;

import com.ifreedom.beauty.bean.HttpResult;
import org.springframework.web.bind.annotation.*;

/**
 * @atuhor:eavawu
 * @date:6/1/16
 * @todo:
 */
@RestController
@RequestMapping("/shopCar")
public class ShopCarController {
    @ResponseBody
    @RequestMapping(value = "/addGoods2ShopCar", method = RequestMethod.GET)
    public HttpResult addGoods2ShopCar(@RequestParam("goodsId") Long goodsId, @RequestParam("userId") Long userId) {

        HttpResult result = new HttpResult();
        return result;
    }

    ;
}
