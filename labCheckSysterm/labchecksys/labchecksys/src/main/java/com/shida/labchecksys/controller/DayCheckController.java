package com.shida.labchecksys.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.shida.labchecksys.pojo.DayCheck;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.DayCheckService;
import com.shida.labchecksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shida.labchecksys.common.JsonResponse;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/DayCheck/")
public class DayCheckController {

    public User getUser(HttpSession request) {

        User user = (User) request.getAttribute("user");
        return user;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCurrentTime() {

        Date date = new Date();
        System.out.println(date);
        return date;
    }


    @Autowired
    DayCheckService dayCheckService;

    @Autowired
    UserService userService;

    @RequestMapping("dayCheck")
    public JsonResponse dayCheck(HttpSession session, DayCheck dayCheck) {//使用人员填写日查

        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验，检验是否是使用人员
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        Date currentTime = getCurrentTime();
        int isDanger = 1;

        //2021-1-7 修改人：龚剑波
        String department = user.getDepartment();
        long checker = user.getUserId();
        return dayCheckService.addDayCheck(user, checker, department, currentTime, dayCheck.getCheckObject(), dayCheck.getDanger(), dayCheck.getSuggestions(), isDanger);
    }

    @RequestMapping("safeSave")
    public JsonResponse safeSave(HttpSession session, String checkObject) {//需要权限检验

        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        long checker = user.getUserId();
        String department = user.getDepartment();
        Date checkTime = getCurrentTime();
        String danger = "无安全隐患";
        String suggestions = "无整改措施";
        int isDanger = 0;//0是没有危险，1是有危险
        return dayCheckService.safeSave(user, checker, department, checkTime, checkObject, danger, suggestions, isDanger);
    }

    @RequestMapping("showSelf")
    public JsonResponse showSelf(HttpSession session) {//需要权限检验

        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        return dayCheckService.showSelf(user.getUserId());
    }

}
