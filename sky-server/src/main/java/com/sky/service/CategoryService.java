package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

/**
 * ClassName:CategoryService
 * Package:com.sky.service
 * Description:
 *
 * @Author张博文
 * @Create2024/7/2619:59
 * @Version1.0
 */
public interface CategoryService {
    /**
     * 添加分类
     * @param categoryDTO
     */
    void addCategory(CategoryDTO categoryDTO);

    /**
     * 修改分类
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);


    /**
     * 启用禁用分类
     * @param id
     * @param status
     */
    void changeStatus(Long id, Integer status);

    /**
     * 根据id删除分类
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据分类查询
     * @param sort
     * @return
     */
    List<Category> querryBySort(Integer sort);

    /**
     * 分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuerry(CategoryPageQueryDTO categoryPageQueryDTO);
}
