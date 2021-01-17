package com.shida.labchecksys.pojo.dto;

import lombok.Data;

import java.io.Serializable;

//发送消息页面，用户综合搜索结果的封装
@Data
public class UserSendTo implements Serializable {

    /**
     * 主键id，自增
     */
    protected Long id;

    /**
     * 用户名，唯一，姓名+学号或者工号
     */
    private String userName;

    /**
     * 用户身份,"安全管理员","学院分管领导"。。。。。。
     */
    private String userRole;

    /**
     * 用户对应的所属部门
     */
    private String department;
}