package com.shida.labchecksys.service.Impl;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.mapper.DayCheckMapper;
import com.shida.labchecksys.mapper.HiddenDangerMapper;
import com.shida.labchecksys.mapper.SpotCheckMapper;
import com.shida.labchecksys.mapper.UserRepository;
import com.shida.labchecksys.pojo.DayCheck;
import com.shida.labchecksys.pojo.HiddenDanger;
import com.shida.labchecksys.pojo.SpotCheck;
import com.shida.labchecksys.pojo.User;
import com.shida.labchecksys.pojo.dto.UserMessageDto;
import com.shida.labchecksys.service.HiddenDangerService;
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
public class HiddenDangerServiceImpl implements HiddenDangerService {


    @Autowired
    HiddenDangerMapper hiddenDangerMapper;

    @Autowired
    DayCheckMapper dayCheckMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    LabService labService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SpotCheckMapper spotCheckMapper;

    private void Message(long userId, long userFromId, long roleId) {//传递信息
        //两个id  角色ID
        String contenet = "你有一个实验室安全隐患待审查！";
        String title = "实验室日查安全隐患审查";
        String role = RoleEnum.getRolesList().get((int) roleId - 1);
        Date currentTime = CurrentTime.getCurrentTime();
        UserMessageDto userMessageDto = new UserMessageDto();
        userMessageDto.setUserId(userId);
        userMessageDto.setUserFromId(userFromId);
        userMessageDto.setUserFromRole(role);
        userMessageDto.setMessageTitle(title);
        userMessageDto.setMessageContent(contenet);
        userMessageDto.setMessageTime(currentTime);
        userMessageService.insertOneUserMessage(userMessageDto);
    }

    private int roleIdToStage(int roleId){
        int stage = 0;
        switch(roleId){
            case 4:
                stage = 4;
                break;
            case 5:
                stage = 2;
                break;
            case 6:
                stage = 5;
        }
        return stage;
    }

    /**
     *对有隐患的日查记录进行操作的模块
     */
    //该方法用于展示该用户需要审核的有隐患的日查记录
    @Override
    public JsonResponse showAll(long roleId, User user) {//通过消息提醒他有待审核的项目，在showAll方法里编辑记录，即日查的5个方法

        List<DayCheck> list = selectByPrincipal(user.getUserName());
        int stage = roleIdToStage((int)roleId);
        int isDanger = 1;//1是有安全隐患的记录
        if (roleId == 3) {
            //Lab服务里加一个通过实验室安全负责人ID拿到实验室的名称。
            String labName = labService.findLabNameByLabSaferId(user.getUserId());
            List<DayCheck> dayChecks = hiddenDangerMapper.showAllByLab(labName,stage,isDanger);
            dayChecks.addAll(list);
            return JsonResponse.toSuccess(dayChecks);
        } else if (roleId == 4 || roleId == 5) {
            String department = user.getDepartment();
            List<DayCheck> dayChecks = hiddenDangerMapper.showAllByDepartment(department,stage,isDanger);
            dayChecks.addAll(list);//List合并方法
            return JsonResponse.toSuccess(dayChecks);
        }
        else if( roleId == 6){
            List<DayCheck> dayChecks = hiddenDangerMapper.showAll(stage,isDanger);
            dayChecks.addAll(list);
            return JsonResponse.toSuccess(dayChecks);
        }
        return JsonResponse.toSuccess(list);
    }

    @Override
    public List<HiddenDanger> showAllByDepartment(String department) {
        return hiddenDangerMapper.selectAllByDepartment(department);
    }

    @Override
    public JsonResponse showDanger() {
        int isDanger = 1;
        List<DayCheck> danger = hiddenDangerMapper.showDanger(isDanger);
        return JsonResponse.toSuccess(danger);
    }

    @Override
    public String getReformPrincipal(long id) {
        String reformPrincipal = hiddenDangerMapper.getReformPrincipal(id);
        return reformPrincipal;
    }

    @Override
    public JsonResponse updateDayCheckByLeader(User user, long id, String reformPrincipal) {
        long roleId = user.getRoles().get(0).getRoleId();
        long userId = userService.findAllByUserName(reformPrincipal).get(0).getUserId();
        long userFromId = user.getUserId();
        Message(userId, userFromId, roleId);
        int stage = 3;
        hiddenDangerMapper.updateDayCheckByLeader(id, reformPrincipal, stage);
        return JsonResponse.toSuccess("自查填报成功！");
    }

    @Override
    public JsonResponse updateDayCheckByPrincipal(User user, long id, String reformMeasure, Date reform_time) {
        String checkObject = dayCheckMapper.selectById(id).get(0).getCheckObject();
        int stage = 4;
        long roleId = user.getRoles().get(0).getRoleId();
        long userId = labService.findLabSaferIdByLabName(checkObject);
        long userFromId = user.getUserId();
        Message(userId, userFromId, roleId);
        hiddenDangerMapper.updateDayCheckByPrincipal(id, reformMeasure, reform_time, stage);
        return JsonResponse.toSuccess("自查填报成功！");
    }

    @Override
    public JsonResponse updateDayCheckByAccepter(User user, long id, String accepter, String accResults, Date accTime) {
        int stage = 5;
        long roleId = user.getRoles().get(0).getRoleId();
        long userId = user.getUserId();
        String checkObject = dayCheckMapper.selectById(id).get(0).getCheckObject();
        long userFromId = labService.findSysIdByLabName(checkObject);
        Message(userId, userFromId, roleId);
        hiddenDangerMapper.updateDayCheckByAccepter(id, accepter, accResults, accTime, stage);
        return JsonResponse.toSuccess("自查填报成功！");
    }

    @Override
    public JsonResponse updateDayCheckBySchool(User user, long id, String schoolResult, Date schoolTime) {
        int stage = 6;
        hiddenDangerMapper.updateDayCheckBySchool(id, schoolResult, schoolTime, stage);
        return JsonResponse.toSuccess("自查填报成功！");
    }

    /**
     *对隐患整改台账进行操作的部分
     */

    @Override
    public JsonResponse synchronization() {

        List<DayCheck> dayChecks = hiddenDangerMapper.selectIsDanger();
        List<HiddenDanger> hiddenDangers = hiddenDangerMapper.selectAll();
        List<SpotCheck> spotChecks = spotCheckMapper.selectAll();

        for(DayCheck dayCheck : dayChecks) {
            int isFinish = 1;       //1代表没有解决,0代表解决了
            HiddenDanger hiddenDanger = new HiddenDanger();
            long userId = dayCheck.getChecker();
            User user = userRepository.findAllUsersByUserId(userId).get(0);

            boolean state = false;      //用布尔型判断是否重复

            //判断是否已经验收成功
            if(dayCheck.getAccResults() != null  && dayCheck.getAccepter() != null){
                isFinish = 0;
            }

            for(HiddenDanger hiddenDanger1 : hiddenDangers){
                if(dayCheck.getDanger().equals(hiddenDanger1.getExistingDanger()) && dayCheck.getCheckObject().equals(hiddenDanger1.getLabName())){
                    state = true;
                    break;
                }
            }

            //如果重复则进行下一个循环，如果每一则直接插入整改台账中
            if(state == true){
                continue;
            }else{
                hiddenDanger.setUserName(user.getUserName());
                hiddenDanger.setLabName(dayCheck.getCheckObject());
                hiddenDanger.setCheckTime(dayCheck.getCheckTime());
                hiddenDanger.setExistingDanger(dayCheck.getDanger());
                hiddenDanger.setRectificationPerson(dayCheck.getReformPrincipal());
                hiddenDanger.setRectificationMeasures(dayCheck.getReformMeasure());
                hiddenDanger.setReFinishTime(dayCheck.getReformTime());
                hiddenDanger.setTestPerson(dayCheck.getAccepter());
                hiddenDanger.setTestTime(dayCheck.getAccTime());
                hiddenDanger.setIsFinish(isFinish);
                hiddenDanger.setDepartment(dayCheck.getDepartment());

                hiddenDangerMapper.insert(hiddenDanger);       //自动放入隐患整改台账
            }

        }

        for(SpotCheck spotCheck : spotChecks){
            int isFinish = 1;
            HiddenDanger hiddenDanger = new HiddenDanger();
            long userId = spotCheck.getChecker();
            User user = userRepository.findAllUsersByUserId(userId).get(0);
            boolean state = false;      //用布尔型判断是否重复

            //判断是否已经验收成功
            if(spotCheck.getAccResults() != null  && spotCheck.getAccepter() != null){
                isFinish = 0;
            }
            for(HiddenDanger hiddenDanger1 : hiddenDangers){
                if(spotCheck.getDanger().equals(hiddenDanger1.getExistingDanger()) && spotCheck.getCheckObject().equals(hiddenDanger1.getLabName())){
                    state = true;
                    break;
                }
            }

            //如果重复则进行下一个循环，如果每一则直接插入整改台账中
            if(state == true){
                continue;
            }else{
                hiddenDanger.setUserName(user.getUserName());
                hiddenDanger.setLabName(spotCheck.getCheckObject());
                hiddenDanger.setCheckTime(spotCheck.getCheckTime());
                hiddenDanger.setExistingDanger(spotCheck.getDanger());
                hiddenDanger.setRectificationPerson(spotCheck.getReformPrincipal());
                hiddenDanger.setRectificationMeasures(spotCheck.getReformMeasure());
                hiddenDanger.setReFinishTime(spotCheck.getReformTime());
                hiddenDanger.setTestPerson(spotCheck.getAccepter());
                hiddenDanger.setTestTime(spotCheck.getAccTime());
                hiddenDanger.setIsFinish(isFinish);
                hiddenDanger.setDepartment(spotCheck.getDepartment());

                hiddenDangerMapper.insert(hiddenDanger);       //自动放入隐患整改台账
            }
        }
        return JsonResponse.toSuccess("同步成功");
    }

    //审核功能：实际上就是将is_finish从1 -> 0的过程,后续可以通过0和1进行判断是否已经完成审核
    @Override
    public JsonResponse examineIsFinish(int id, String testPerson) {

        List<HiddenDanger> hiddenDangers = hiddenDangerMapper.selectAll();
        boolean state = false;
        for(HiddenDanger hiddenDanger : hiddenDangers){
            if(hiddenDanger.getId() == id && hiddenDanger.getTestPerson().equals(testPerson)){
                hiddenDangerMapper.examineIsFinish(0,id);
                state = true;
                break;
            }
        }
        if(state = true){
            return JsonResponse.toSuccess("审核成功！");
        }else{
            return JsonResponse.toFailed("此隐患不归属于您！");
        }
    }

    @Override
    public List<DayCheck> selectByPrincipal(String principal) {
        int stage = 3;
        return hiddenDangerMapper.selectByPrincipal(principal,stage);
    }

    @Override
    public JsonResponse insert(HiddenDanger hiddenDanger) {
        hiddenDangerMapper.insert(hiddenDanger);
        return JsonResponse.toSuccess("插入成功！");
    }

    //查看所有隐患台账信息
    @Override
    public JsonResponse showAllHidden() {
        return JsonResponse.toSuccess(hiddenDangerMapper.selectAll());
    }

    @Override
    public JsonResponse update(HiddenDanger hiddenDanger) {

        return null;
    }

    //根据验收人显示他自己的所有需要验收的所有隐患信息
    @Override
    public List<HiddenDanger> showAllByTestPerson(String testPerson) {
        return hiddenDangerMapper.selectAllByTestPerson(testPerson);
    }

    @Override
    public JsonResponse delete(int id) {
        if(id < 0 || String.valueOf(id) == null){
            return JsonResponse.toFailed("id为空");
        }
        hiddenDangerMapper.delete(id);
        return JsonResponse.toSuccess("删除成功");
    }

}
