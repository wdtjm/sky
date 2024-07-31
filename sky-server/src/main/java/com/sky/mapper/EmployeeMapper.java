package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 新增员工
     * @param employeeDTO
     */
    @AutoFill(value = OperationType.INSERT)
    @Insert("insert into employee (id,name,username,password,phone,sex,id_number,status,create_time,update_time,create_user,update_user) "+
    "values(#{id},#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{create_time},#{update_time},#{create_user},#{update_user})")
    void save(EmployeeDTO employeeDTO);

    /**
     * 员工分页查询
     * @param employeePageQueryDTO
     * @return
     */
    Page<Employee> querryPage(EmployeePageQueryDTO employeePageQueryDTO);


    @AutoFill(value = OperationType.UPDATE)
    void update(Employee employee);

    @Select("select * from employee where id = #{id};")
    Employee querryEmpById(Long id);
}
