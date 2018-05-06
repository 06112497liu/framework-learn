package com.lwb.service.person;

import com.github.pagehelper.PageInfo;
import com.lwb.vo.PersonVO;

public interface PersonService {

    /**
     * 根据id查询person信息
     * @param id          person id
     * @return
     */
    PersonVO getPersonById(Integer id);

    /**
     * 分页查询person信息
     * @param pageNum     页码
     * @param pageSize    每页数量
     */
    PageInfo<PersonVO> getPagePerson(Integer pageNum,
                                     Integer pageSize);
}
