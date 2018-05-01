package com.lwb.service.impl;

import com.lwb.bean.po.Person;
import com.lwb.dao.PersonDao;
import com.lwb.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    @Override
    public Person getPersonById(Integer id) {
        return personDao.queryById(id);
    }
}
