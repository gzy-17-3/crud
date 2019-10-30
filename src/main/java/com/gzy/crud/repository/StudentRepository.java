package com.gzy.crud.repository;

import com.gzy.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findBySid(String sid);
}
