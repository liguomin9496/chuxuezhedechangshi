package com.shida.labchecksys.service.Impl;

import com.shida.labchecksys.mapper.AuthorityMapper;
import com.shida.labchecksys.mapper.RoleMapper;
import com.shida.labchecksys.mapper.UserRepository;
import com.shida.labchecksys.pojo.Authority;
import com.shida.labchecksys.pojo.Role;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthorityMapper authorityRepository;


    //查询所有角色信息
    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAll();
    }

    //根据角色Id查询所有信息
    @Override
    public List<Role> findAllById(Long roleId) {
        return roleMapper.findAllByRoleId(roleId);
    }

    //根据角色名称RoleName查找所有信息
    @Override
    public List<Role> findAllByRoleName(String roleName) {
        return roleMapper.findAllByRoleName(roleName);
    }

    //根据roleId返回指定角色所有的 功能Id 和 功能名称，用map存储
    @Override
    public HashMap<Long, String> findAllFunctionIdAndFunctionNameByRoleId(long roleId) {
        HashMap<Long, String> map = new HashMap<Long, String>();
        List<Role> roles = roleMapper.findAllByRoleId(roleId);
        for (Role role : roles) {
            List<Authority> authorities = role.getAuthorities();
            for (Authority authority : authorities) {
                map.put(authority.getFunctionId(), authority.getFunctionName());
            }
        }
        return map;
    }

    //保存信息
    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }

    //根据角色名称roleName删除指定角色
    @Override
    public void deleteRole(String roleName) {
        List<User> users = userRepository.findAll();
        List<Role> roles = roleMapper.findAllByRoleName(roleName);
        for (User user : users) {
            List<Role> userRole = user.getRoles();
            for (Role role : roles) {
                if (userRole.contains(role)) {
                    userRole.remove(role);
                }
                role.getAuthorities().clear();
                roleMapper.save(role);
            }
            roleMapper.deleteByRoleName(roleName);
        }
    }
}
