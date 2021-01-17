package com.shida.labchecksys.controller;


import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.Lab;
import com.shida.labchecksys.service.LabService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Lab")
public class LabController {

    private Integer getUserId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        Integer userId = -1;
        for (Cookie cookie : cookies) {
            if ("userId".equals(cookie.getName())) {
                userId = Integer.parseInt(cookie.getValue());
            }
        }
        return userId;
    }


    @Resource
    private LabService labService;

    @GetMapping("/Add")
    public JsonResponse addLab(HttpServletRequest request, Lab lab) {
        Integer userId = getUserId(request);//需要权限检验
        if (userId == -1) {
            return JsonResponse.toFailed("用户未登录！");
        }

        return labService.addLab(lab);
    }

    @GetMapping("/Delete")
    public JsonResponse deleteLab(HttpServletRequest request, Long labId) {

        Integer userId = getUserId(request);//需要权限检验
        if (userId == -1) {
            return JsonResponse.toFailed("用户未登录！");
        }

        return labService.deleteLab(labId);
    }

    @GetMapping("/Update")
    public JsonResponse updateLab(HttpServletRequest request, Lab lab) {
        Integer userId = getUserId(request);//需要权限检验
        if (userId == -1) {
            return JsonResponse.toFailed("用户未登录！");
        }
        return labService.updateLab(lab);
    }

    @GetMapping("/Select")
    public JsonResponse selectLab(Long labId) {
        return labService.selectLab(labId);
    }



    @GetMapping("/findleaderidbylabname")
    public long findLeaderIdByLabName(String labName) {
        return labService.findLeadrIdByLabName(labName);
    }


    /**
     *
     *
     *  labApply
     * 2021/1/6有修改
     *
     */
    //申请实验室

    @GetMapping("/Apply")
    public JsonResponse labApply(HttpServletRequest request,long labSaferId, String labUserId,long labId){
        Integer userId = getUserId(request);//需要权限检验
        if (userId == -1) {
            return JsonResponse.toFailed("用户未登录！");
        }
        return labService.labApply(labId,labUserId,labSaferId);

    }

    //查找用户id
    @GetMapping("/find")
    public JsonResponse findLabUserIdByLabName(String labName) {
        List<Long> list = labService.findLabUserIdByLabName(labName);
        System.out.println(labName);
        return JsonResponse.toSuccess(list);
    }


}
