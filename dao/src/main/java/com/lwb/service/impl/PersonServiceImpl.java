package com.lwb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwb.bean.po.Person;
import com.lwb.bean.vo.PersonVO;
import com.lwb.dao.PersonDao;
import com.lwb.service.PersonService;
import com.lwb.utils.BeanMapperUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    @Override
    public PersonVO getPersonById(Integer id) {
        Person po = personDao.queryById(id);
        return BeanMapperUtil.map(po, PersonVO.class);
    }

    @Override
    public PageInfo<PersonVO> getPagePerson(Integer pageNum,
                                            Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<Person> list = personDao.queryPage();
        PageInfo pageInfo = PageInfo.of( BeanMapperUtil.mapList(list, PersonVO.class) );
        return pageInfo;
    }
}
