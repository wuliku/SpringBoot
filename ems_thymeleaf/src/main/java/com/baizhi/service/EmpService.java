package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

/**
 * @author:
 * @creat 2021-06-09-14:06
 * @description:
 */
public interface EmpService {
    List<Emp> findAll();

    void save(Emp emp);

    void delete(String id);

    Emp find(String id);

    void update(Emp emp);
}
