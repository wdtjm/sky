package com.sky.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * ClassName:EmployUpdateDTO
 * Package:com.sky.dto
 * Description:
 *
 * @Author张博文
 * @Create2024/7/2611:08
 * @Version1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("修改员工信息")
public class EmployUpdateDTO {
    private Long id;
    private String idNumber;
    private String name;
    private String phone;
    private String sex;
    private String username;
}
