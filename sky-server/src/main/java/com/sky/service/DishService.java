package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * @author：Coolice
 * @date：Created in 2024/9/9 15:42
 * @description：
 * @modified By：
 * @version:$
 */
@SuppressWarnings({"all"})
public interface DishService {

    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
