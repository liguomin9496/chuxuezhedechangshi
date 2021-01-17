package com.shida.labchecksys.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.SpotCheck;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.ReformNoteService;
import com.shida.labchecksys.service.SpotCheckService;
import com.shida.labchecksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/Check")
public class SpotCheckController {

    public User getUser(HttpSession request) {

        User user = (User) request.getAttribute("user");
        return user;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCurrentTime() {

        Date date = new Date();
        return date;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getReformTime(){
        Date date;
        Date date1=getCurrentTime();
        Calendar calendar=new GregorianCalendar();
        calendar.setTime(date1);
        calendar.add(calendar.DATE,7);  //日期对现在的日期加七天
        date=calendar.getTime();
        return date;
    }


    @Autowired
    SpotCheckService spotCheckService;

    @Autowired
    ReformNoteService reformNoteService;

    @Autowired
    UserService userService;


    //有危险
    //实验室抽查
    @RequestMapping("/addSpotCheck")
    public JsonResponse addSpotCheck(HttpSession session, SpotCheck spotCheck){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验，检验是否为督察员
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        Date checkTime = getCurrentTime();
        Date reformTime=getReformTime();
        int isDanger = 1;
        String department = user.getDepartment();
        Long checker = user.getUserId();
        if(spotCheck.getCheckObject()==null){
            return JsonResponse.toFailed("检查对象不能为空");
        }
        //验收人 验收结果 验收时间 以及复核结果复核时间不用填
        Integer type=1;//1是抽查 2是专项检查 3是单位检查
        return spotCheckService.addSpotCheck(checker,department,checkTime,spotCheck.getCheckObject(),spotCheck.getDanger(),spotCheck.getSuggestions(),spotCheck.getReformPrincipal(),spotCheck.getReformMeasure(),reformTime,isDanger,type);
    }

    //没有危险
    @RequestMapping("/safeSave")
    public JsonResponse safeSave(HttpSession session, String checkObject) {//需要权限检验

        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        Long checker = user.getUserId();
        String department = user.getDepartment();
        Date checkTime = getCurrentTime();
        String danger = "无安全隐患";
        String suggestions = "无整改措施";
        String reformPrincipal="无";
        String reformMeasure="无";
        Date reformTime=getCurrentTime();
        int isDanger = 0;//0是没有危险，1是有危险
        Integer type=1;//1是抽查 2是专项检查 3是单位检查
        return spotCheckService.addSpotCheck(checker, department, checkTime, checkObject, danger, suggestions,reformPrincipal,reformMeasure,reformTime,isDanger,type);
    }

    //实验室专项检查
    @RequestMapping("/addSpecialCheck")
    public JsonResponse addSpecialCheck(HttpSession session, SpotCheck spotCheck){

         User user = getUser(session);
         String userName = user.getUserName();//需要权限检验，检验是否为督察员
         if (userName == null) {
             return JsonResponse.toFailed("用户未登录！");
         }
         int isDanger = 1;
         Date checkTime = getCurrentTime();
         String department = user.getDepartment();
         Long checker = user.getUserId();
        if(spotCheck.getCheckObject()==null){
            return JsonResponse.toFailed("检查对象不能为空");
        }
         //验收人 验收结果 验收时间 以及复核结果复核时间不用填
         Integer type=2;//1是抽查 2是专项检查 3是单位检查

        return spotCheckService.addSpecialCheck(checker,department,checkTime,spotCheck.getCheckObject(),spotCheck.getDanger(),spotCheck.getSuggestions(),spotCheck.getReformPrincipal(),spotCheck.getReformMeasure(),spotCheck.getReformTime(),isDanger,type);

    }

    @RequestMapping("/specialCheckSave")
    public JsonResponse specialCheckSave(HttpSession session, String checkObject) {//需要权限检验

        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        Long checker = user.getUserId();
        String department = user.getDepartment();
        Date checkTime = getCurrentTime();
        String danger = "无安全隐患";
        String suggestions = "无整改措施";
        String reformPrincipal="无";
        String reformMeasure="无";
        Date reformTime=getCurrentTime();
        int isDanger = 0;//0是没有危险，1是有危险
        Integer type=2;//1是抽查 2是专项检查 3是单位检查
        return spotCheckService.addSpecialCheck(checker, department, checkTime, checkObject, danger, suggestions,reformPrincipal,reformMeasure,reformTime,isDanger,type);
    }

    @RequestMapping("/departmentCheck")
    public JsonResponse departmentCheck(HttpSession session, SpotCheck spotCheck){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验，检验是否为督察员
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        Date checkTime = getCurrentTime();
        int isDanger = 1;
        String department = user.getDepartment();
        Long checker = user.getUserId();
        if(spotCheck.getCheckObject()==null){
            return JsonResponse.toFailed("检查对象不能为空");
        }
        //验收人 验收结果 验收时间 以及复核结果复核时间不用填
        Integer type=3;//1是抽查 2是专项检查 3是单位检查
        return spotCheckService.addDepartmentCheck(checker,department,checkTime,spotCheck.getCheckObject(),spotCheck.getDanger(),spotCheck.getSuggestions(),spotCheck.getReformPrincipal(),spotCheck.getReformMeasure(),spotCheck.getReformTime(),isDanger,type);
    }
    @RequestMapping("/departmentCheckSave")
    public JsonResponse departmentCheckSave(HttpSession session, String checkObject) {//需要权限检验

        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        Long checker = user.getUserId();
        String department = user.getDepartment();
        Date checkTime = getCurrentTime();
        String danger = "无安全隐患";
        String suggestions = "无整改措施";
        String reformPrincipal="无";
        String reformMeasure="无";
        Date reformTime=getCurrentTime();
        int isDanger = 0;//0是没有危险，1是有危险
        Integer type=3;//1是抽查 2是专项检查 3是单位检查
        return spotCheckService.addDepartmentCheck(checker, department, checkTime, checkObject, danger, suggestions,reformPrincipal,reformMeasure,reformTime,isDanger,type);
    }

}
