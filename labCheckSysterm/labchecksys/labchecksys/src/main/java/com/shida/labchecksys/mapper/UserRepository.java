package com.shida.labchecksys.mapper;

import com.shida.labchecksys.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //根据userId查找所有信息
    public List<User> findAllUsersByUserId(long userId);

    //根据用户username查找所有信息
    public List<User> findAllByUserName(String userName);

    //根据用户userId删除用户
    public void deleteByUserName(String userName);

}
