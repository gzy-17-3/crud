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

//    - id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    - sid str

    @Column(length = 100)
    private String sid;
//        - 学号
//        - 数字 ~~Long~~
//        - 递增
//        - 唯一
//        1. 数据库表是 InnoDB
//        2. table uniqueConstraints
//        3. utf8mb4  len <= 191
//        - 不可变
//    - name str
    private String name;
//    - age unsint
    private Integer age;
//    - gender  int
    private Integer gender;
//        - __未知__ 0 女 1 男 2
//    - 20+
//    - mark str
    private String mark;
}
