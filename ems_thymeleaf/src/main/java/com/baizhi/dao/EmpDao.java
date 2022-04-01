package com.baizhi.dao;

import com.baizhi.entity.Emp;

import java.util.List;

/**
 * @author:
 * @creat 2021-06-09-14:02
 * @description:
 */
public interface EmpDao {
    List<Emp> findAll();

    void save(Emp emp);

    void delete(String id);

    Emp find(String id);

    void update(Emp emp);

}
