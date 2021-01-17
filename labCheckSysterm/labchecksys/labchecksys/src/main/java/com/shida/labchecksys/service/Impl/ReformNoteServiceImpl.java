package com.shida.labchecksys.service.Impl;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.mapper.ReformNoteMapper;
import com.shida.labchecksys.pojo.ReformNote;
import com.shida.labchecksys.pojo.SpotCheck;
import com.shida.labchecksys.pojo.dto.UserMessageDto;
import com.shida.labchecksys.service.LabService;
import com.shida.labchecksys.service.ReformNoteService;
import com.shida.labchecksys.service.UserMessageService;
import com.shida.labchecksys.util.CurrentTime;
import com.shida.labchecksys.util.RoleEnum;
import com.shida.labchecksys.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ReformNoteServiceImpl implements ReformNoteService {

    @Resource
    private ReformNoteMapper reformNoteMapper;

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    LabService labService;

    private void Message(long userId, long userFromId, long roleId,long checkId) {//传递信息
        //两个id  角色ID
        String title = "实验室安全整改通知书";
        String content = "你有一个实验室安全整改通知书待查看！";
        Date currentTime = CurrentTime.getCurrentTime();
        String role = RoleEnum.getRolesList().get((int) roleId - 1);
        UserMessageDto userMessageDto = new UserMessageDto();
        userMessageDto.setUserId(userId);
        userMessageDto.setUserFromId(userFromId);
        userMessageDto.setUserFromRole(role);
        userMessageDto.setMessageContent(content);
        userMessageDto.setMessageTime(currentTime);
        userMessageDto.setMessageTitle(title);
        userMessageDto.setMessageRemark("a"+" "+checkId);//a代表整改通知书
        userMessageService.insertOneUserMessage(userMessageDto);
    }

    @Override
    public JsonResponse addReformNote(User user, SpotCheck spotCheck) {
        long userFromId =user.getUserId();;
        long roleId = user.getRoles().get(0).getRoleId();
        long userId = labService.findLabSaferIdByLabName(spotCheck.getCheckObject());
        Message(userId, userFromId, roleId,spotCheck.getId());
        ReformNote reformNote=new ReformNote();
        reformNote.setCheckId(spotCheck.getId());
        reformNote.setCheckObj(spotCheck.getCheckObject());
        reformNote.setDanger(spotCheck.getDanger());
        reformNote.setReformSuggestions(spotCheck.getSuggestions());
        reformNote.setReformTime(spotCheck.getReformTime());
        reformNoteMapper.add(reformNote);
        return JsonResponse.toSuccess(reformNote,"成功生成整改通知书");
    }

    @Override
    public JsonResponse showAll() {
        List<ReformNote>reformNotes=reformNoteMapper.showAll();
        return JsonResponse.toSuccess(reformNotes);
    }

    @Override
    public JsonResponse findLabReformNoteByCheckId(long checkId) {
        ReformNote reformNote;
        reformNote=reformNoteMapper.findLabReformNoteByCheckId(checkId);
        return JsonResponse.toSuccess(reformNote);
    }

    @Override
    public JsonResponse deleteLabReformNoteByCheckId(long checkId) {
        reformNoteMapper.deleteLabReformNoteByCheckId(checkId);
        return JsonResponse.toSuccess("删除成功");
    }

    @Override
    public JsonResponse findById(long checkId) {
        ReformNote reformNote = reformNoteMapper.findLabReformNoteByCheckId(checkId);
        return JsonResponse.toSuccess(reformNote);
    }
}
