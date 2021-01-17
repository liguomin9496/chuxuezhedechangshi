package com.shida.labchecksys.service.Impl;


import com.shida.labchecksys.mapper.DayCheckMapper;
import com.shida.labchecksys.pojo.DayCheck;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.pojo.dto.UserMessageDto;
import com.shida.labchecksys.service.DayCheckService;
import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.service.LabService;
import com.shida.labchecksys.service.UserMessageService;
import com.shida.labchecksys.service.UserService;
import com.shida.labchecksys.util.CurrentTime;
import com.shida.labchecksys.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class DayCheckServiceImpl implements DayCheckService {

    @Autowired
    DayCheckMapper dayCheckMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    LabService labService;

    private void Message(long userId, long userFromId, long roleId) {//传递信息
        //两个id  角色ID
        String title = "实验室日查安全隐患审查";
        String content = "你有一个实验室安全隐患待审查！";
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

    @Override
    public JsonResponse showSelf(long checkerId) {
        List<DayCheck> dayChecks = dayCheckMapper.showSelf(checkerId);
        return JsonResponse.toSuccess(dayChecks);
    }

    @Override
    public JsonResponse selectByCheckTime(String checkObject, Date checkTime) {
        List<DayCheck> dayChecks = dayCheckMapper.selectByCheckTime(checkObject, checkTime);
        return JsonResponse.toSuccess(dayChecks);
    }

    @Override
    public JsonResponse selectById(long id) {
        List<DayCheck> dayChecks = dayCheckMapper.selectById(id);
        return JsonResponse.toSuccess(dayChecks);
    }

    @Override
    public JsonResponse addDayCheck(User user, long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, int isDanger) {
        //先检验是否是该实验室的使用人员
        long userFromId = user.getUserId();
        if(!labService.examineLabUser(checkObject,userFromId))
            return JsonResponse.toFailed("你不是该实验室的使用人员！");
        long roleId = user.getRoles().get(0).getRoleId();
        long userId = labService.findLeadrIdByLabName(checkObject);
        Message(userId, userFromId, roleId);
        int stage = 2;
        dayCheckMapper.addDayCheck(checker, department, checkTime, checkObject, danger, suggestions, isDanger, stage);
        return JsonResponse.toSuccess("自查填报成功！");
    }

    @Override
    public JsonResponse safeSave(User user,long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, int isDanger) {
        long userFromId = user.getUserId();
        if(!labService.examineLabUser(checkObject,userFromId))
            return JsonResponse.toFailed("你不是该实验室的使用人员！");
        int stage = 6;
        dayCheckMapper.addDayCheck(checker, department, checkTime, checkObject, danger, suggestions, isDanger, stage);
        return JsonResponse.toSuccess("自查填报成功！");
    }

}
