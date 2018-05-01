package com.lwb.controller.person.info;

import com.lwb.bean.po.Person;
import com.lwb.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/person" )
public class PersonController {

    @Resource
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        return personService.getPersonById(id);
    }
}
