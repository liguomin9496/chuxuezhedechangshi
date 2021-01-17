package com.shida.labchecksys.service;

import com.shida.labchecksys.common.JsonResponse;
import com.shida.labchecksys.pojo.UserMessage;
import com.shida.labchecksys.pojo.dto.UserMessageDto;
import com.shida.labchecksys.pojo.dto.UserMessageSearchCondition;

import java.util.List;

// 用户消息的业务接口
public interface UserMessageService {

    //根据主键id查询消息
    UserMessage getUserMessageById(Long id);

    //根据主键id查询消息传输对象，含发送者的详细信息等
    UserMessageDto getUserMessageDtoById(Long id);

    //根据用户id（发送方）查询消息
    UserMessage getUserMessageByUserFromId(Long userFromId);

    //查询属于userId的全部消息
    List<UserMessage> listUserMessagesByUserId(Long userId);

    //查询属于userId的全部已读或者未读消息
    List<UserMessageDto> listUserMessages(UserMessageSearchCondition condition);

    //根据输入id将消息标记已读
    long updateUserMessageReadById(Long id);

    //查询当前用户id下，状态为read的消息数量
    long countUserMessagesByUserIdAndRead(Long userId, int isRead);

    // 根据输入id将消息删除
    long deleteUserMessagesById(Long id);

    //添加一条消息
    JsonResponse insertOneUserMessage(UserMessage userMessage);

    JsonResponse insertManyUserMessages(List<UserMessage> userMessages);
}
