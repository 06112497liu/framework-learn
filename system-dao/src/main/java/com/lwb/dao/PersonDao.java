package com.lwb.dao;

import com.lwb.bean.po.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonDao {
    /**
     * 根据id查询person信息
     * @param id
     * @return
     */
    Person queryById(@Param("id") Integer id);

    /**
     * 分页查询person信息
     * @return
     */
    List<Person> queryPage();
}
