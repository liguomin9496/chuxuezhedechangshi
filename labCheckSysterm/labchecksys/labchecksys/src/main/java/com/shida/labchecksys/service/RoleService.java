package com.shida.labchecksys.service;

import com.shida.labchecksys.pojo.Role;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public interface RoleService {

    //查询所有角色信息
    List<Role> findAllRole();

    //根据角色Id查询所有信息
    List<Role> findAllById(Long roleId);

    //根据角色名称RoleName查找所有信息
    List<Role> findAllByRoleName(String roleName);

    //根据roleId返回指定角色所有的 功能Id 和 功能名称，用map存储
    HashMap<Long, String> findAllFunctionIdAndFunctionNameByRoleId(long roleId);

    //保存信息
    @Transactional
    void save(Role role);

    //根据角色名称roleName删除指定角色
    @Transactional
    void deleteRole(String roleName);
}
