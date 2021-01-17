package com.shida.labchecksys.controller;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.MonthReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/MonthReport/")
public class MonthReportController {

    @Autowired
    MonthReportService monthReportService;

    public User getUser(HttpSession request) {
        User user = (User) request.getAttribute("user");
        return user;
    }

    public boolean isLogin(User user){
        if(user.getUserName() == null){
            return false;
        }
        return true;
    }


    @RequestMapping("/showAll")
    public JsonResponse showAllOrderByMonth(HttpSession session){
        User user = getUser(session);
        if(isLogin(user) == false){
            return JsonResponse.toFailed("用户未登录!");
        }
        monthReportService.extract();       //提取
        return monthReportService.showAllByPermission(user);
    }

    @RequestMapping("/isExamine")
    public JsonResponse examine(HttpSession session, int id){
        User user = getUser(session);
        if(isLogin(user) == false){
            return JsonResponse.toFailed("用户未登录!");
        }
        monthReportService.isExamine(user,id);
        return monthReportService.showAllByPermission(user);
    }

    //复核并给出意见
    @RequestMapping("/suggestion")
    public JsonResponse suggestion(HttpSession session, int id, String suggestion){
        User user = getUser(session);
        if(isLogin(user) == false){
            return JsonResponse.toFailed("用户未登录!");
        }
        monthReportService.suggestion(suggestion,user,id);
        return monthReportService.showAllByPermission(user);
    }

    //提交单独一个
    @RequestMapping("/isSubmit")
    public JsonResponse submit(HttpSession session,int id,String labName){
        User user = getUser(session);
        if(isLogin(user) == false){
            return JsonResponse.toFailed("用户未登录!");
        }
        monthReportService.isSubmit(user,id,labName);
        return monthReportService.showAllByPermission(user);
    }

    //提交所有
    @RequestMapping("submitAll")
    public JsonResponse submitAll(HttpSession session){
        User user = getUser(session);
        if(isLogin(user) == false){
            return JsonResponse.toFailed("用户未登录!");
        }
        monthReportService.submitAll(user);
        return monthReportService.showAllByPermission(user);
    }
}
