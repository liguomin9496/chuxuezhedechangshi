package com.shida.labchecksys.service.Impl;


import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.mapper.*;
import com.shida.labchecksys.pojo.Role;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired UserService userService;


    @Override
    public User login(String userName,String passWord) {
        User user = userMapper.login(userName,passWord);
        return user;
    }

    @Override
    public User getSessionUserInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println(user.getDepartment());
        return user;
    }

    //查询用户所有信息
    @Override
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    //根据用户Id查询所有信息
    @Override
    public List<User> findAllUserById(long userId){
        return userRepository.findAllUsersByUserId(userId);
    }

    //根据用户姓名username查询所有信息
    @Override
    public List<User> findAllByUserName(String userName){
        return userRepository.findAllByUserName(userName);
    }

    //根据用户userId获取指定的 角色id 和 角色名 ，用HashMap键值对的形式存储(假设一个用户只有一个角色，也就是代表map只有一组键值)
    @Override
    public HashMap<Long, String> findRoleIdAndRoleNameByUserId(long userId){
        HashMap<Long,String> map = new HashMap<Long,String>();
        User user = userRepository.findAllUsersByUserId(userId).get(0);
        //根据假设一个用户只有一个角色
        Role role = user.getRoles().get(0);
        map.put(role.getRoleId(),role.getRoleName());
        return map;
    }

    //根据用户userId获取指定的 角色id 和 角色名 ，用HashMap键值对的形式存储(假设一个用户有多重角色，代表map中不止一组键值)
    @Override
    public HashMap<Long, String> findAllRoleIdAndRoleNameByUserId(long userId) {
        HashMap<Long,String> map = new HashMap<Long,String>();
        User user = userRepository.findAllUsersByUserId(userId).get(0);
        List<Role> roles = user.getRoles();
        for(Role role : roles){
            map.put(role.getRoleId(),role.getRoleName());
        }
        return map;
    }

    //根据用户userId获取指定的 用户名 和 角色名 ，用HashMap键值对的形式存储(假设一个用户只有一个角色，也就是代表map只有一组键值)
    @Override
    public HashMap<String, String> findUserNameAndRoleNameByUserId(long userId){
        HashMap<String,String> map = new HashMap<String,String>();
        User user = userRepository.findAllUsersByUserId(userId).get(0);
        //根据假设一个用户只有一个角色
        Role role = user.getRoles().get(0);
        map.put(user.getUserName(),role.getRoleName());
        return map;
    }

    //根据用户userId获取指定的 用户名 和 角色名 ，用HashMap键值对的形式存储(假设一个用户有多重角色，代表map中不止一组键值)
    @Override
    public HashMap<String, String> findAllUserNameAndRoleNameByUserId(long userId) {
        HashMap<String,String> map = new HashMap<String,String>();
        User user = userRepository.findAllUsersByUserId(userId).get(0);
        List<Role> roles = user.getRoles();
        for(Role role : roles){
            map.put(user.getUserName(),role.getRoleName());
        }
        return map;
    }

    //保存信息
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    //根据用户username删除指定用户
    @Override
    public void deleteUser(String userName){
        List<User> users = userRepository.findAllByUserName(userName);
        for(User user : users) {
            user.getRoles().clear();
            userRepository.save(user); //执行save()之后才会保存到数据库中
        }
        userRepository.deleteByUserName(userName);
    }




    //2021/1/5修改了register

    @Override
    public int register(String userName,String passWord,String department) {
        User user=userMapper.getByUsername(userName);
        if (user==null){
            userMapper.register(userName,passWord,department);
            return 1;
        }
        return -1;
    }



    //2021/1/5添加
    @Override
    public String findUserNameByUserId(Long userId) {
        User user = userRepository.findAllUsersByUserId(userId).get(0);
        return user.getUserName();
    }

    @Override
    public long findUserIdByUserName(String userName) {
        User user = userRepository.findAllByUserName(userName).get(0);
        return user.getUserId();
    }

    @Override
    public JsonResponse registerRole(long userId, long roleId) {
        userMapper.registerRole(userId,roleId);
        return JsonResponse.toSuccess("注册成功");
    }

    @Override
    public JsonResponse updateRoleId(long roleId,long userId) {
        userMapper.updateRoleId(userId,roleId);
        return JsonResponse.toSuccess("成功修改");
    }

}
