package com.shida.labchecksys.util;

import java.util.ArrayList;
import java.util.List;

public enum RoleEnum {

    Student("学生"),

    Teacher("老师"),

    Lab_User("实验室使用人员"),

    Lab_Safer("实验室安全管理员"),

    Department_Leader("部门分管领导"),

    Sys_safer("系统管理员"),

    Inspector("督察员");


    private String role;

    public String getRole() {
        return role;
    }

    RoleEnum(String role) {
        this.role = role;
    }

    /**
     * 获取所有角色列表
     *
     * @return ["管理员","学生",.....]
     */
    public static List<String> getRolesList() {
        List<String> list = new ArrayList<>();
        for (RoleEnum roleEnum : RoleEnum.values()) {
            list.add(roleEnum.getRole());
        }
        return list;
    }

    /**
     * 判断当前输入角色字串是否存在
     *
     * @param role 输入角色字串
     * @return 是否存在的布尔值
     */
    public static boolean hasRole(String role) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断当前枚举是否与角色（字符串）相同
     *
     * @param role 字符串类型的角色
     * @return 是否相同的布尔值
     */
    public boolean equals(String role) {
        if (this.getRole().equals(role)) {
            return true;
        }
        return false;
    }
}

