package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
     * 根据菜品id删除对应的口味数据
     *
     * @param disId
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * 根据菜品id批量删除菜品关联的口味数据
     *
     * @param ids
     */
    void deleteByDishIds(List<Long> dishIds);

    /**
     * 批量插入口味数据
     *
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id查询对应的口味数据
     *
     * @param dishId
     * @return
     */
    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);

}
