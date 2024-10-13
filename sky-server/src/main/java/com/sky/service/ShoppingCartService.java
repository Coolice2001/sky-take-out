package com.sky.service;

import com.sky.dto.ShoppingCartDTO;

/**
 * @author：Coolice
 * @date：Created in 2024/10/12 11:35
 * @description：
 * @modified By：
 * @version:$
 */
@SuppressWarnings({"all"})
public interface ShoppingCartService {

    /**
     * 添加购物车
     *
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

}
