package com.shida.labchecksys.service.Impl;

import com.shida.labchecksys.mapper.AuthorityMapper;
import com.shida.labchecksys.mapper.RoleMapper;
import com.shida.labchecksys.mapper.UserRepository;
import com.shida.labchecksys.pojo.Authority;
import com.shida.labchecksys.pojo.Role;
import com.shida.labchecksys.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthorityMapper authorityRepository;

    //查询所有功能信息
    @Override
    public List<Authority> findAllFunction() {
        return authorityRepository.findAll();
    }

    //根据权限Id查询所有功能信息
    @Override
    public List<Authority> findAllFunctionByFunctionId(int functionId) {
        return authorityRepository.findAllByFunctionId(functionId);
    }

    //根据权限名称functionName查询所有功能信息
    @Override
    public List<Authority> findAllFunctionByFunctionName(String functionName) {
        return authorityRepository.findAllByFunctionName(functionName);
    }


    //保存信息
    @Override
    public void save(Authority authority) {
        authorityRepository.save(authority);
    }

    //根据功能名称functionName删除指定功能
    @Override
    public void deleteAuthority(String functionName) {
        List<Authority> authorities = authorityRepository.findAllByFunctionName(functionName);
        List<Role> roles = roleMapper.findAll();
        //如果删除被维护端的数据，则把用户（维护端）的List中要移除的角色（被维护端）都remove掉
        for (Role role : roles) {
            List<Authority> roleAuthorities = role.getAuthorities();
            for (Authority authority : authorities) {
                if (roleAuthorities.contains(authority)) {
                    roleAuthorities.remove(authority);
                }
            }
            roleMapper.save(role);
        }
        authorityRepository.deleteByFunctionName(functionName);
    }
}
