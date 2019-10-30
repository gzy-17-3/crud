package com.gzy.crud.controller;

import com.gzy.crud.model.Clazz;
import com.gzy.crud.model.Student;
import com.gzy.crud.repository.ClazzRepository;
import com.gzy.crud.repository.StudentRepository;
import com.gzy.crud.service.ClazzService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Resource
    ClazzService clazzService;

    @PostMapping
    Object create(@Valid @RequestBody Clazz para) {
        return clazzService.create(para);
    }

}
