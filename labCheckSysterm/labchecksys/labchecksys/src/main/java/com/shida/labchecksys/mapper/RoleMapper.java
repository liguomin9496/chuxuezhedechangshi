package com.shida.labchecksys.mapper;

import com.shida.labchecksys.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleMapper extends JpaRepository<Role, Integer> {

    //根据角色名称roleName查找所有信息
    public List<Role> findAllByRoleName(String roleName);

    //根据角色roleId删除角色
    public void deleteByRoleName(String roleName);

    //根据角色roleId查找所有信息
    public List<Role> findAllByRoleId(long roleId);


}
