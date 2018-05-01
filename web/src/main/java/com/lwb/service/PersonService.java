package com.lwb.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lwb.bean.po.Person;

import java.util.List;

public interface PersonService {

    /**
     * 根据id查询person信息
     * @param id
     * @return
     */
    Person getPersonById(Integer id);

    /**
     * 分页查询person信息
     * @param pageNum
     * @param pageSize
     */
    PageInfo<Person> getPagePerson(Integer pageNum,
                           Integer pageSize);
}
