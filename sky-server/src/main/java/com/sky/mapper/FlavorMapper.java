package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:FlavorMapper
 * Package:com.sky.mapper
 * Description:
 *
 * @Author张博文
 * @Create2024/8/39:46
 * @Version1.0
 */
@Mapper
public interface FlavorMapper {

    void add(List<DishFlavor> flavors);
}
