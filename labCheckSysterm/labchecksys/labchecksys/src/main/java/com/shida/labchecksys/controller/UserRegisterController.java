package com.shida.labchecksys.controller;


import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@ResponseBody
@RestController
public class UserRegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/Register")
    public JsonResponse register(String userName,String passWord,String roleName,String department){

        Integer result=userService.register(userName,passWord,department);
        switch (result){
            case 1:
                if(roleName.equals("学生")){
                    long roleId=1;
                    long userId=userService.findUserIdByUserName(userName);
                    userService.registerRole(userId,roleId);
                }
                if (roleName.equals("老师")){
                    long roleId=2;
                    long userId=userService.findUserIdByUserName(userName);
                    userService.registerRole(userId,roleId);
                }
                return JsonResponse.toSuccess("注册成功");
            case -1:
                return JsonResponse.toFailed("用户已存在");
        }
        return JsonResponse.toFailed("注册失败");
    }
}