package com.shida.labchecksys.controller;


import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.DayCheck;
import com.shida.labchecksys.pojo.Role;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.service.HiddenDangerService;
import com.shida.labchecksys.service.UserService;
import com.shida.labchecksys.util.CurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/HiddenDanger/")
public class HiddenDangerController {

    public User getUser(HttpSession request) {

        User user = (User) request.getAttribute("user");
        return user;
    }

    @Autowired
    HiddenDangerService hiddenDangerService;

    @Autowired
    UserService userService;

    /**
     *对有隐患的日查表进行操作的部分
     */
    //该方法用于展示该用户需要审核的有隐患的日查记录
    @RequestMapping("showDayCheck")
    public JsonResponse showDayCheck(HttpSession session) {

        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        return hiddenDangerService.showAll(user.getRoles().get(0).getRoleId(), user);
    }

    @RequestMapping("examineDayCheck")
    public JsonResponse examineDayCheck(HttpSession session, DayCheck dayCheck) {//高权限人员审核有隐患的日查记录

        User user = getUser(session);
        String userName = user.getUserName();
        Date currentTime = CurrentTime.getCurrentTime();
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        switch (dayCheck.getStage()) {
            case 2: {
                return hiddenDangerService.updateDayCheckByLeader(user, dayCheck.getId(), dayCheck.getReformPrincipal());
            }
            case 3: {//限定到整改责任人，名字！！
                String reformPrincipal = hiddenDangerService.getReformPrincipal(dayCheck.getId());
                if (reformPrincipal.equals(user.getUserName())) {
                    return hiddenDangerService.updateDayCheckByPrincipal(user, dayCheck.getId(), dayCheck.getReformMeasure(), currentTime);
                }
                else
                    break;
            }
            case 4: {
                return hiddenDangerService.updateDayCheckByAccepter(user, dayCheck.getId(), dayCheck.getAccepter(), dayCheck.getAccResults(), currentTime);
            }
            case 5: {
                return hiddenDangerService.updateDayCheckBySchool(user, dayCheck.getId(), dayCheck.getSchoolResult(), currentTime);
            }
            default:
                return JsonResponse.toFailed("自查填报失败！");
        }
        return JsonResponse.toFailed("自查填报失败！");
    }

    /**
     *对隐患台账进行操作的部分
     */

    //根据角色权限不同，显示不同级别的隐患信息,这里的显示是显示隐患整改台账
    //没有添加用户权限判断之前已经完成了同步以及显示功能
    @RequestMapping("showAllHiddenDanger")
    public JsonResponse showAllHiddenDanger(HttpSession session){
        User user = getUser(session);
        String userName = user.getUserName();
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        Role role = user.getRoles().get(0);
        Long roleId = role.getRoleId();
        if(roleId == 3){         //3.实验室安全负责人只能看到自己的所有安全隐患并且管理
            hiddenDangerService.synchronization();
            return JsonResponse.toSuccess(hiddenDangerService.showAllByTestPerson(user.getUserName()));
        }
        if(roleId == 5 || roleId == 4){      //4 单位安全管理员 5.单位分管领导 可以查看本单位的安全隐患
            hiddenDangerService.synchronization();      //同步
            return JsonResponse.toSuccess(hiddenDangerService.showAllByDepartment(user.getDepartment()));
        }
        else if(roleId ==6 || roleId == 7){    //6.系统管理员  7.督察员    可以查看所有隐患并且管理
            hiddenDangerService.synchronization();      //同步
            return JsonResponse.toSuccess(hiddenDangerService.showAllHidden());
        }
        else{
            return JsonResponse.toFailed("权限不够，无法访问");
        }
    }

    //审核功能的点击实现,审核的是隐患台账
    @RequestMapping("/examine")
    public JsonResponse examineIsFinish(HttpSession session,int id){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        hiddenDangerService.examineIsFinish(id,user.getUserName());
        return JsonResponse.toSuccess("审核成功");
    }

    //多余的功能：根据姓名查看权限后，得到权限认可后也可以查看自己需要审核的隐患信息
    @RequestMapping("showAllByTestPerson")
    public JsonResponse showAllByTestPerson(HttpSession session){
        User user = getUser(session);
        String userName = user.getUserName();//需要权限检验
        Role role = user.getRoles().get(0);
        Long roleId = role.getRoleId();
        if (userName == null) {
            return JsonResponse.toFailed("用户未登录！");
        }
        if(roleId == 3 || roleId == 5 || roleId ==6 || roleId == 7){      //3.实验室安全负责人 5.单位分管领导 6.系统管理员  7.督察员
            return JsonResponse.toSuccess(hiddenDangerService.showAllByTestPerson(user.getUserName()));
        }else{
            return JsonResponse.toFailed("权限不够，无法访问");
        }
    }

}
