package com.shida.labchecksys.service.Impl;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.mapper.UserMessageMapper;
import com.shida.labchecksys.pojo.UserMessage;
import com.shida.labchecksys.pojo.dto.UserMessageDto;
import com.shida.labchecksys.pojo.dto.UserMessageSearchCondition;
import com.shida.labchecksys.service.UserMessageService;
import com.shida.labchecksys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Autowired
    private UserMessageMapper userMessageMapper;

    @Autowired
    private UserService userService;

    @Override
    public UserMessage getUserMessageById(Long id) {
        return id == null ? null : userMessageMapper.getUserMessageById(id);
    }

    @Override
    public UserMessageDto getUserMessageDtoById(Long id) {
        return id == null ? null : userMessageMapper.getUserMessageDtoById(id);
    }

    @Override
    public UserMessage getUserMessageByUserFromId(Long userFromId) {
        return userFromId == null ? null : userMessageMapper.getUserMessageByUserFromId(userFromId);
    }

    @Override
    public List<UserMessage> listUserMessagesByUserId(Long userId) {
        if (userId == null) {
            return new ArrayList<>();
        }
        UserMessageSearchCondition condition = new UserMessageSearchCondition();
        condition.setUserId(userId);
        return userMessageMapper.listUserMessages(condition.getUserId());
    }

    @Override
    public List<UserMessageDto> listUserMessages(UserMessageSearchCondition condition) {
        List<UserMessageDto> temp =  userMessageMapper.countUserMessagesByUserIdAndRead(condition.getUserId(),condition.getIsRead());
        for(UserMessageDto userMessageDto : temp){
            Map map = userService.findUserNameAndRoleNameByUserId(userMessageDto.getUserFromId());
            for (Object key : map.keySet()) {
                String roleName = map.get(key).toString();
                String userName = key.toString();
                userMessageDto.setUserFromRealName(userName);
                userMessageDto.setUserFromRole(roleName);
            }
        }
        return temp;
    }

    @Override
    public long updateUserMessageReadById(Long id) {
        if (id == null) {
            return 0;
        }
        return userMessageMapper.updateUserMessageReadById(id);
    }


    @Override
    public long countUserMessagesByUserIdAndRead(Long userId, int isRead) {
        if (userId == null) {
            return 0;
        }
        List<UserMessageDto> userMessages = userMessageMapper.countUserMessagesByUserIdAndRead(userId, isRead);
        long size = userMessages.size();
        return size;
    }

    @Override
    public long deleteUserMessagesById(Long id) {
        if (id == null) {
            return 0;
        }
        return userMessageMapper.deleteUserMessagesById(id);
    }

    @Override
    public JsonResponse insertOneUserMessage(UserMessage userMessage) {
        if (userMessage == null) {
            return JsonResponse.toFailed("插入失败！");
        }
        userMessageMapper.insertOneUserMessage(userMessage);
        return JsonResponse.toSuccess("插入成功！");
    }

    @Override
    public JsonResponse insertManyUserMessages(List<UserMessage> userMessages) {
        if (userMessages == null || userMessages.size() == 0) {
            return JsonResponse.toFailed("Failure");
        }
        //插入
        for (UserMessage userMessage : userMessages) {
            userMessageMapper.insertOneUserMessage(userMessage);
        }
        return JsonResponse.toSuccess("Success");
    }
}








