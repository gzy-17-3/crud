package com.gzy.crud.controller;

import com.gzy.crud.model.Student;
import com.gzy.crud.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    StudentRepository studentRepository;

    @PostMapping
    Object create(Student student){
        // id
        student.setId(null);
        Student s = studentRepository.save(student);
        s.setSid(s.getId().toString());
        return studentRepository.save(s);
    }

    @GetMapping("/{sid}")
    Object find(@PathVariable(name = "sid") String sid){
        Student bySid = studentRepository.findBySid(sid);
        if (bySid != null) {
            return bySid;
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    Object findAll(@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "10") Integer size){
        // 如果 page == null 则 获取所有

//        Sort.Direction.DESC
//        Sort.Direction.ASC

//        Horizontal
//        Vertical

        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(page,size,sort);

        Page<Student> all = studentRepository.findAll(pageable);
        return all;
    }

    @DeleteMapping("/{sid}")
    Object delete(@PathVariable(name = "sid") String sid){

        Student bySid = studentRepository.findBySid(sid);

        if (bySid != null){
            studentRepository.delete(bySid);
        }

        return ResponseEntity.noContent().build();
    }

    /**
     *
     * @param sid
     * @return
     */
    @PutMapping("/{sid}")
    Object update(@PathVariable(name = "sid")String sid,@RequestBody Student studentPara){

        Student bySid = studentRepository.findBySid(sid);

        if (bySid == null) {
            return ResponseEntity.notFound().build();
        }

        // 局部更新 和 全部更新
//        private String name;
//        private Integer age;
//        private Integer gender;
//        private String mark;

        studentPara.setId(null);
        studentPara.setSid(null);

        String[] nullPropertyNames = getNullPropertyNames(studentPara);
        BeanUtils.copyProperties(studentPara,bySid, nullPropertyNames);

        return studentRepository.save(bySid);
    }



    /**
     * 获取空 属性名
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}
