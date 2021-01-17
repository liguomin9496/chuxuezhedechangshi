package com.shida.labchecksys.controller;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.ReformNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/MessageForwarding/")
public class MessageForwardingController {

    public User getUser(HttpSession request) {

        User user = (User) request.getAttribute("user");
        return user;
    }

    @Autowired
    ReformNoteService reformNoteService;

    @RequestMapping("forwardingMessage")
    public JsonResponse forwardingMessage(HttpSession session,String remark) {//使用人员填写日查

        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验，检验是否是使用人员
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        if(remark == null){
            return JsonResponse.toFailed("无跳转信息！");
        }
        String [] strings = remark.split(" ");
        int id = Integer.parseInt(strings[1]);
        if(strings[0].equals("A")){
            return reformNoteService.findById(id);
        }
        else if(strings[0].equals("B")){
            return JsonResponse.toFailed("跳转失败");
        }
        return JsonResponse.toFailed("跳转失败");
    }



}
