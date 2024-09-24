package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @author：Coolice
 * @date：Created in 2024/9/23 16:56
 * @description：
 * @modified By：
 * @version:$
 */
@SuppressWarnings({"all"})

/**
 * 微信登录
 *
 * @param userLoginDTO
 * @return
 */
public interface UserService {
    User wxLogin(UserLoginDTO userLoginDTO);
}
