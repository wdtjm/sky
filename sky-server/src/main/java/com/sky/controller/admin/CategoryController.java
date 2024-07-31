package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:CategoryController
 * Package:com.sky.controller.admin
 * Description:
 *
 * @Author张博文
 * @Create2024/7/2619:56
 * @Version1.0
 */
@ApiModel("分类管理")
@RestController
@RequestMapping("admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService ;

    @PostMapping
    @ApiOperation("新增分类")
    public Result addCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.addCategory(categoryDTO);
        return Result.success();
    };

    @PutMapping
    @ApiOperation("修改分类")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    };

    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result changeStatus(Long id,@PathVariable Integer status){
        categoryService.changeStatus(id,status);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result deleteById(Long id){
        categoryService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据分类查询套餐")
    public Result<List<Category>> querryBySort(Integer sort){
        return Result.success(categoryService.querryBySort(sort));
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<PageResult> pageQuerry(CategoryPageQueryDTO categoryPageQueryDTO){
        return Result.success(categoryService.pageQuerry(categoryPageQueryDTO));
    }


}
