package com.gzy.crud.service;


import com.gzy.crud.model.Clazz;
import com.gzy.crud.repository.ClazzRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClazzService {

    @Resource
    ClazzRepository clazzRepository;

    public Clazz create(Clazz para) {
        para.setId(null);
        para.setMark("");

        // 对 para 做保存操作

        return clazzRepository.save(para);
    }
}
