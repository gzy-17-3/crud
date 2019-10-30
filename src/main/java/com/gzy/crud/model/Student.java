package com.gzy.crud.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *  类名 java 大驼峰命名规则
 *  首字母大写
 *
 *  变量名 小驼峰
 *  studentStudent
 *
 *  数据模型 类名 名词
 *
 */


@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"sid"})
        }
)
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String sid;
    private String name;
    private Integer age;
    private Integer gender;
    private String mark;
}
