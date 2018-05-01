package com.lwb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwb.bean.po.Person;
import com.lwb.dao.PersonDao;
import com.lwb.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    @Override
    public Person getPersonById(Integer id) {
        return personDao.queryById(id);
    }

    @Override
    public PageInfo<Person> getPagePerson(Integer pageNum,
                                      Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Person> list = personDao.queryPage();
        PageInfo pageInfo = PageInfo.of(list);
        return pageInfo;
    }
}
