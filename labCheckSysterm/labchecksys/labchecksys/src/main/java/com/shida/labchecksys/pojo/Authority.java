package com.shida.labchecksys.pojo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lab_function")
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "function_id")
    private long functionId;

    @Column(name = "function_name")
    private String functionName;

    //@JsonBackReference主要可以使标注属性避免被json序列化,进而避免多对多关系的查询中出现死循环的情况。
    @JsonBackReference
    @ManyToMany(mappedBy = "authorities")
    private List<Role> roles;

    public long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(long functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        roles = null;
        return "Authority{" +
                "functionId=" + functionId +
                ", functionName='" + functionName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
