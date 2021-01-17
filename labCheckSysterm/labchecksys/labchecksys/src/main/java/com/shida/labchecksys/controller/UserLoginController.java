package com.shida.labchecksys.controller;


import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@ResponseBody
@Controller
public class    UserLoginController {

    public User getUser(HttpSession request) {

        User user = (User) request.getAttribute("user");
        return user;
    }


    @Autowired
    private UserService userService;

    @RequestMapping("/Login")
    public JsonResponse login(HttpSession session, String userName, String passWord) {
        //检验参数是否合法有效
        if (userName != null && passWord != null) {
            User user = userService.login(userName, passWord);
            if (user != null) {

                //2021 1-7 修改人：龚剑波
                User user1 = userService.findAllByUserName(user.getUserName()).get(0);
                session.setAttribute("user", user1);
                System.out.println(user1 + "    Login");

                return JsonResponse.toSuccess("登陆成功！");
            } else {
                return JsonResponse.toFailed("登陆失败！");
            }
        }
        return JsonResponse.toFailed("用户名或者密码不能为空！");
    }
    @RequestMapping("/updateRoleId")
    public JsonResponse updateRoleId(HttpSession session,long roleId,long userId){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        return JsonResponse.toSuccess(userService.updateRoleId(userId,roleId));
    }
}
