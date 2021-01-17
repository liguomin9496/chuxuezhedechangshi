package com.shida.labchecksys.service;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public interface UserService {

    //登陆
    User login(String userName, String passWord);

    User getSessionUserInfo(HttpSession session);

    //查询用户所有信息
    List<User> findAllUser();

    //根据用户Id查询所有信息
    List<User> findAllUserById(long userId);

    //根据用户姓名username查询所有信息
    List<User> findAllByUserName(String userName);

    //根据用户userId获取指定的 角色id 和 角色名 ，用HashMap键值对的形式存储(假设一个用户只有一个角色，也就是代表map只有一组键值)
    HashMap<Long, String> findRoleIdAndRoleNameByUserId(long userId);

    //根据用户userId获取指定的 角色id 和 角色名 ，用HashMap键值对的形式存储(假设一个用户有多重角色，代表map中不止一组键值)
    HashMap<Long, String> findAllRoleIdAndRoleNameByUserId(long userId);

    //根据用户userId获取指定的 用户名 和 角色名 ，用HashMap键值对的形式存储(假设一个用户只有一个角色，也就是代表map只有一组键值)
    HashMap<String, String> findUserNameAndRoleNameByUserId(long userId);

    //根据用户userId获取指定的 用户名 和 角色名 ，用HashMap键值对的形式存储(假设一个用户有多重角色，代表map中不止一组键值)
    HashMap<String, String> findAllUserNameAndRoleNameByUserId(long userId);

    //保存信息
    @Transactional
    void save(User user);

    //根据用户username删除指定用户
    @Transactional
    void deleteUser(String userName);




    //2021/1/5添加


    //修改了register
    //注册
    int register(String userName, String passWord, String department);

    //通过userId查找userName
    String findUserNameByUserId(Long userId);

    //通过userName查找userId
    long findUserIdByUserName(String userName);

    //注册用户之后注册角色信息
    JsonResponse registerRole(long userId, long roleId);

    //修改roleId
    JsonResponse updateRoleId(long roleId, long userId);
}
