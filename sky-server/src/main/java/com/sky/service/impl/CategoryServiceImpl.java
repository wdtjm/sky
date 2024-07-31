package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName:CategoryServiceImpl
 * Package:com.sky.service.impl
 * Description:
 *
 * @Author张博文
 * @Create2024/7/2619:59
 * @Version1.0
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper ;

    @Override
    public void addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setCreateUser(BaseContext.getCurrentId());
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateUser(BaseContext.getCurrentId());
        category.setUpdateTime(LocalDateTime.now());
        category.setStatus(StatusConstant.ENABLE);
        categoryMapper.add(category);
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        category.setUpdateUser(BaseContext.getCurrentId());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);
    }

    @Override
    public void changeStatus(Long id, Integer status) {
        Category category = new Category();
        category.setId(id);
        category.setUpdateUser(BaseContext.getCurrentId());
        category.setUpdateTime(LocalDateTime.now());
        category.setStatus(status);
        categoryMapper.update(category);
    }

    @Override
    public void deleteById(Long id) {
        //TODO 删除时要检测套餐的状态
        categoryMapper.delete(id);
    }

    @Override
    public List<Category> querryBySort(Integer sort) {
        return categoryMapper.querryBySort(sort);
    }

    @Override
    public PageResult pageQuerry(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult = new PageResult();
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.pageQuerry(categoryPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
