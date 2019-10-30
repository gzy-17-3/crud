package com.gzy.crud.repository;

import com.gzy.crud.model.Clazz;
import com.gzy.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClazzRepository extends JpaRepository<Clazz,Long> {

}
