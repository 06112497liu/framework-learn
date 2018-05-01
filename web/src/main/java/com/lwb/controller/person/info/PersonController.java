package com.lwb.controller.person.info;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lwb.bean.po.Person;
import com.lwb.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/person" )
public class PersonController {

    @Resource
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/page/{pageNum}/{pageSize}")
    public PageInfo<Person> getPagePerson(@PathVariable("pageNum") Integer pageNum,
                                  @PathVariable("pageSize") Integer pageSize) {
        return personService.getPagePerson(pageNum, pageSize);
    }
}
