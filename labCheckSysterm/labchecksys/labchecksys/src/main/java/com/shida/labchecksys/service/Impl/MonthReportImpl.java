package com.shida.labchecksys.service.Impl;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.mapper.HiddenDangerMapper;
import com.shida.labchecksys.mapper.MonthReportMapper;
import com.shida.labchecksys.mapper.SpotCheckMapper;
import com.shida.labchecksys.mapper.UserRepository;
import com.shida.labchecksys.pojo.HiddenDanger;
import com.shida.labchecksys.pojo.MonthReport;
import com.shida.labchecksys.pojo.SpotCheck;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.pojo.dto.UserMessageDto;
import com.shida.labchecksys.service.LabService;
import com.shida.labchecksys.service.MonthReportService;
import com.shida.labchecksys.service.UserMessageService;
import com.shida.labchecksys.service.UserService;
import com.shida.labchecksys.util.CurrentTime;
import com.shida.labchecksys.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MonthReportImpl implements MonthReportService {

    @Autowired
    MonthReportMapper monthReportMapper;

    @Autowired
    HiddenDangerMapper hiddenDangerMapper;

    @Autowired
    SpotCheckMapper spotCheckMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    LabService labService;

    @Autowired
    UserRepository userRepository;

    private void Message(long userId, long userFromId, long roleId) {//传递信息
        //两个id  角色ID
        String title = "实验室月报审核";
        String content = "你有一个实验室月报待审核！";
        Date currentTime = CurrentTime.getCurrentTime();
        String role = RoleEnum.getRolesList().get((int) roleId - 1);
        UserMessageDto userMessageDto = new UserMessageDto();
        userMessageDto.setUserId(userId);
        userMessageDto.setUserFromId(userFromId);
        userMessageDto.setUserFromRole(role);
        userMessageDto.setMessageContent(content);
        userMessageDto.setMessageTime(currentTime);
        userMessageDto.setMessageTitle(title);
        userMessageService.insertOneUserMessage(userMessageDto);
    }

    public int permission(Long roleId){
        int perm = 0;
        switch(roleId.intValue()){
            case 1: perm = 0;break;
            case 2: perm = 0;break;
            case 3: perm = 0;break;
            case 4: perm = 1;break;     //权限1:看到自己学院的，并且有提交功能
            case 5: perm = 2;break;     //权限2:看到所有学院的，并有审核功能
            case 6: perm = 3;break;     //权限3:看到所有月报信息，并审核月报，给出反馈意见
            default: perm = 0;
        }

        return perm;
    }

    @Override
    public JsonResponse showAllByPermission(User user) {
        int perm = permission(user.getRoles().get(0).getRoleId());
        if(perm == 1){
            return JsonResponse.toSuccess(monthReportMapper.showAllByDepartment(user.getDepartment()));
        }else if(perm == 2){
            return JsonResponse.toSuccess(monthReportMapper.showAllByCurrentMonth());
        }else if(perm == 3){
            return JsonResponse.toSuccess(monthReportMapper.showAll());
        }
        return JsonResponse.toFailed("操作失败，，权限不对称");
    }



    //从隐患表中提取信息
    @Override
    public void extract() {
        List<HiddenDanger> hiddenDangers = hiddenDangerMapper.selectAll();
        List<MonthReport> monthReports = monthReportMapper.selectAll();

        for(HiddenDanger hiddenDanger : hiddenDangers){

            boolean state = false;

            for(MonthReport monthReport : monthReports){
                if(hiddenDanger.getLabName().equals(monthReport.getLabName()) && hiddenDanger.getDepartment().equals(monthReport.getDepartment()) && hiddenDanger.getExistingDanger().equals(monthReport.getExistingDanger())){
                    state =true;
                    break;
                }
            }

            if(state){
                continue;
            }else{
                MonthReport monthReport = new MonthReport();
                monthReport.setDepartment(hiddenDanger.getDepartment());
                monthReport.setCheckTime(hiddenDanger.getCheckTime());
                monthReport.setLabName(hiddenDanger.getLabName());
                monthReport.setExistingDanger(hiddenDanger.getExistingDanger());
                monthReport.setRectificationMeasures(hiddenDanger.getRectificationMeasures());
                monthReport.setRefinishTime(hiddenDanger.getReFinishTime());
                monthReport.setIsFinish(hiddenDanger.getIsFinish());
                monthReport.setIsExamine(1);
                monthReport.setIsReview(1);
                monthReport.setIsSubmit(1);
                monthReport.setSuggestion("请输入处理意见");

                monthReportMapper.add(monthReport);

            }
        }

    }

    @Override
    public JsonResponse suggestion(String suggestion, User user, int id) {
        int perm = permission(user.getRoles().get(0).getRoleId());
        if(perm == 3){
            monthReportMapper.suggestion(suggestion,id);
            monthReportMapper.isReview(id);
            return JsonResponse.toSuccess("操作成功");
        }
        return JsonResponse.toFailed("操作失败，权限不对称");
    }

    @Override
    public JsonResponse isExamine(User user, int id) {
        int perm = permission(user.getRoles().get(0).getRoleId());
        if(perm == 2){
            monthReportMapper.isExamine(id);
            return  JsonResponse.toSuccess("操作成功");
        }
        return JsonResponse.toFailed("操作失败，权限不对称");
    }

    @Override
    public JsonResponse isSubmit(User user, int id,String labName) {
        int perm = permission(user.getRoles().get(0).getRoleId());
        if(perm == 1){
            long userFromId = user.getUserId();
            long userId = labService.findLeadrIdByLabName(labName);
            long roleId = user.getRoles().get(0).getRoleId();
            Message(userId, userFromId, roleId);
            monthReportMapper.isSubmit(id);
            return JsonResponse.toSuccess("操作成功");
        }
        return JsonResponse.toFailed("操作失败，权限不对称");
    }

    @Override
    public JsonResponse submitAll(User user) {
        int perm = permission(user.getRoles().get(0).getRoleId());
        if(perm == 1){
            List<MonthReport> monthReports = monthReportMapper.showAllByDepartment(user.getDepartment());
            for(MonthReport monthReport : monthReports){
                monthReportMapper.isSubmit((int)monthReport.getId());
            }

            List<User> users = userRepository.findAll();
            List<User> users1 = new ArrayList<>();
            for(User user1 : users){
                if(user1.getDepartment().equals(user.getDepartment())){
                    users1.add(user1);
                }
            }

            long userId = 0;

            for(User user1 : users1){
                System.out.println(user1);
                Long roleId = user1.getRoles().get(0).getRoleId();
                if(roleId == 5){
                    userId = user1.getUserId();
                    break;
                }
            }

            if(userId == 0){
                return JsonResponse.toFailed("无领导人");
            }
            long userFromId = user.getUserId();
            long roleId = user.getRoles().get(0).getRoleId();
            Message(userId, userFromId, roleId);
            return JsonResponse.toSuccess("操作成功");
        }
        return JsonResponse.toSuccess("操作失败，权限不对称");
    }
}
