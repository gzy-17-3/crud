package com.gzy.crud.controller;

import com.gzy.crud.model.Student;
import com.gzy.crud.repository.StudentRepository;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    Object findAll(Integer page){
        // 如果 page == null 则 获取所有
        int size = 5;

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
    Object delete(String sid){
        return null;
    }

    @PutMapping("/{sid}")
    Object update(String sid){
        return null;
    }
}
