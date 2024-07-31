package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName:CategoryMapper
 * Package:com.sky.mapper
 * Description:
 *
 * @Author张博文
 * @Create2024/7/2620:02
 * @Version1.0
 */
@Mapper
public interface CategoryMapper {

    @Insert("insert into category (id,type,name,sort,status,create_time,update_time,create_user,update_user) " +
    "values (#{id},#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void add(Category category);


    void update(Category category);

    @Delete("delete from category where id = #{id}")
    void delete(Long id);

    List<Category> querryBySort(Integer sort);

    Page<Category> pageQuerry(CategoryPageQueryDTO categoryPageQueryDTO);
}
