package com.shida.labchecksys.service;

import com.shida.labchecksys.pojo.Authority;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface AuthorityService {


    //查询所有功能信息
    List<Authority> findAllFunction();

    //根据权限Id查询所有功能信息
    List<Authority> findAllFunctionByFunctionId(int functionId);

    //根据权限名称functionName查询所有功能信息
    List<Authority> findAllFunctionByFunctionName(String functionName);

    //保存信息
    @Transactional
    void save(Authority authority);

    //根据功能名称functionName删除指定功能
    @Transactional
    void deleteAuthority(String functionName);

}
