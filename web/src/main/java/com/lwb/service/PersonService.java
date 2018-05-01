package com.lwb.service;

import com.lwb.bean.po.Person;

public interface PersonService {

    /**
     * 根据id查询person信息
     * @param id
     * @return
     */
    Person getPersonById(Integer id);
}
