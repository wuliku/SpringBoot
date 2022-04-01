package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author:
 * @creat 2021-06-09-14:00
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {
    private String id;
    private String name;
    private String salary;
    private Integer age;
    private Date bir;
}
