package com.shida.labchecksys.controller;


import com.shida.labchecksys.pojo.Authority;
import com.shida.labchecksys.pojo.Role;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.AuthorityService;
import com.shida.labchecksys.service.RoleService;
import com.shida.labchecksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Authority/")
public class UserAuthorityController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    AuthorityService authorityService;

    public User getUser(HttpSession request) {

        User user = (User) request.getAttribute("user");
        return user;
    }


    /*
        用户功能板块
     */

    //查询指定姓名的用户信息
    @RequestMapping("/finduser")
    public User findByName(@RequestParam(value = "userName") String userName) {
        System.out.println("success");
        User user = userService.findAllByUserName(userName).get(0);
        return user;
    }

    //2021-1-7 修改人：龚剑波
    @RequestMapping("/showuser")
    public User showUser(HttpSession session) {
        User user = getUser(session);
        return user;
    }

    //查询所有用户信息
    @RequestMapping("/findalluser")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    //根据userId返回用户名和用户角色名
    @RequestMapping("/findusernameandrolename")
    public String findAuthByRoleId(@RequestParam(value = "userId") int userId) {
        HashMap<String, String> map = userService.findUserNameAndRoleNameByUserId(userId);
        String[] list = map.keySet().toArray(new String[0]);
        String roleName = map.get(list[0]);
        return list[0] + " " + roleName;
    }

    @RequestMapping("/adduser")
    public List<User> addUser(@RequestParam(value = "userName") String userName,
                              @RequestParam(value = "roleName") String roleName,
                              @RequestParam(value = "password") String password) {
        User user = new User();
        Role role = roleService.findAllByRoleName(roleName).get(0);
        user.setUserName(userName);
        user.setPassWord(password);
        user.setRoles(new ArrayList<>());
        user.getRoles().add(role);//给用户设置角色
        userService.save(user);
        return userService.findAllUser();
    }


    /*
        角色功能板块
     */

    //查询所有的角色信息
    @RequestMapping("/findallrole")
    public List<Role> findAllRole() {
        return roleService.findAllRole();
    }

    @RequestMapping("/findallfunctionbyroleid")
    public String findAllFunctionByRoleId(@RequestParam(value = "roleId") long roleId) {
        String s = "";
        HashMap<Long, String> map = roleService.findAllFunctionIdAndFunctionNameByRoleId(roleId);
        Integer[] list = map.keySet().toArray(new Integer[0]);
        for (int i = 0; i < list.length; i++) {
            s += "functionId：" + list[i] + " " + "functionName：" + map.get(list[i]) + "<br/>";
        }
        return s;
    }

    //2021-1-7 修改人：龚剑波
    @RequestMapping("findrolename")
    public String findRoleName(HttpSession session){
        User user = getUser(session);
        return user.getRoles().get(0).getRoleName();
    }



    /*
        权限功能板块
    */
    @RequestMapping("/findallauth")
    public List<Authority> findAllAuthority() {
        return authorityService.findAllFunction();
    }


}
