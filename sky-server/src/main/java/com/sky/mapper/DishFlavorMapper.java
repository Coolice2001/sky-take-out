package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author：Coolice
 * @date：Created in 2024/9/9 16:59
 * @description：
 * @modified By：
 * @version:$
 */
@SuppressWarnings({"all"})
@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);
}
