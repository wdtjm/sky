package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;


/**
 * ClassName:DishMapper
 * Package:com.sky.mapper
 * Description:
 *
 * @Author张博文
 * @Create2024/8/39:45
 * @Version1.0
 */
@Mapper
public interface DishMapper {
    @AutoFill(value = OperationType.INSERT)
    void add(Dish dish);

}
