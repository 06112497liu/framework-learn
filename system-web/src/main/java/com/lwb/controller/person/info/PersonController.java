package com.lwb.controller.person.info;

import com.github.pagehelper.PageInfo;
import com.lwb.vo.PersonVO;
import com.lwb.service.person.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Resource
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public PersonVO getPersonById(@PathVariable("id") Integer id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/page/{pageNum}/{pageSize}")
    public PageInfo<PersonVO> getPagePerson(@PathVariable("pageNum") Integer pageNum,
                                            @PathVariable("pageSize") Integer pageSize) {
        PageInfo<PersonVO> rs = personService.getPagePerson(pageNum, pageSize);
        return rs;
    }
}