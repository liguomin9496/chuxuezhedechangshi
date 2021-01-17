package com.shida.labchecksys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "lab_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    //该注解的strategy属性主要用于设置主键的增长方式，IDENTITY表示主键由数据库自己生成，从1开始单调递增。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "role_id")
    /*
    cascade的注解作用是：group对象的增删改关联到user对象
    fetch是读取查询关联,一对多，一的一方，FetchType默认是LAZY, 多的一方FetchType默认是EAGER
    */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role", //name是表名

            //joinColumns设置的是entity中属性在关系表的映射名称，name是映射表中的字段名
            joinColumns = {@JoinColumn(name = "user_id")},

            //inverseJoinColumns,name是关系实体Role的id在关系表中的名称
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;

    private String department;

}
