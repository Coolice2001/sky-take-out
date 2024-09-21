package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author：Coolice
 * @date：Created in 2024/9/21 12:06
 * @description：店铺状态控制器
 * @modified By：
 * @version:$
 */
@SuppressWarnings({"all"})
@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    //提取常量
    private static final String key = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置店铺营业状态
     *
     * @param status
     * @return
     */
    @GetMapping("/status")
    @ApiOperation(value = "获取店铺的营业状态")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get("key");
        log.info("获取到店铺的营业状态为：{}", status == 1 ? "营业中" : "打样了");
        return Result.success(status);
    }
}
