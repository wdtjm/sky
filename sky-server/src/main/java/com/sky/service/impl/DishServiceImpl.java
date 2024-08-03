package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishMapper;
import com.sky.mapper.FlavorMapper;
import com.sky.service.DishService;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:DishServiceImpl
 * Package:com.sky.service.impl
 * Description:
 *
 * @Author张博文
 * @Create2024/8/39:45
 * @Version1.0
 */
@Service
public class DishServiceImpl implements DishService {
    @Autowired
    DishMapper dishMapper;
    @Autowired
    FlavorMapper flavorMapper;
    @Override
    public void add(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        dishMapper.add(dish);
        List<DishFlavor> flavors = dishDTO.getFlavors();
        flavors.forEach(flavor -> {
            flavor.setDishId(dish.getId());
        });
        flavorMapper.add(dishDTO.getFlavors());
    }
}
