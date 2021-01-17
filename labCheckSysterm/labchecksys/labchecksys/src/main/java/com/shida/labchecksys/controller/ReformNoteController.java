package com.shida.labchecksys.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.SpotCheck;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.ReformNoteService;
import com.shida.labchecksys.service.SpotCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/Note")
//学校巡查和不定期的抽查
public class ReformNoteController {
    public User getUser(HttpSession request) {

        User user = (User)request.getAttribute("user");
        return user;
    }


    @Autowired
    ReformNoteService reformNoteService;

    @Autowired
    SpotCheckService spotCheckService;


    /**
     *
     * 2021/1/10修改
     * 2021/1/10修改
     * 2021/1/10修改
     */
    //根据checkId生成整改通知书
    @RequestMapping("/addReformNote")
    private JsonResponse addReformNote(HttpSession session, long checkId){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        SpotCheck spotCheck=spotCheckService.findByCheckId(checkId);
        reformNoteService.addReformNote(user,spotCheck);
        return JsonResponse.toSuccess(reformNoteService.findLabReformNoteByCheckId(spotCheck.getId()),"成功添加整改通知书");
    }


    //展示所有的整改通知书
    @RequestMapping("/showAll")
    private JsonResponse showAll(HttpSession session){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        return JsonResponse.toSuccess(reformNoteService.showAll());
    }


    //查找整改通知书
    @RequestMapping("/findReformNote")
    private JsonResponse findReformNote(HttpSession session, long checkId){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        return JsonResponse.toSuccess(reformNoteService.findLabReformNoteByCheckId(checkId));
    }



    //删除整改通知书
    @RequestMapping("/deleteReformNote")
    private JsonResponse deleteReformNote(HttpSession session, long checkId){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        reformNoteService.deleteLabReformNoteByCheckId(checkId);
        return JsonResponse.toSuccess(reformNoteService.deleteLabReformNoteByCheckId(checkId));
    }
}
