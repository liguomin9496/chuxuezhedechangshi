package com.shida.labchecksys.mapper;

import com.shida.labchecksys.pojo.UserMessage;
import com.shida.labchecksys.pojo.dto.UserMessageDto;
import com.shida.labchecksys.pojo.dto.UserMessageSearchCondition;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//用户消息业务dao接口

@Repository
@Mapper
public interface UserMessageMapper {

    //根据主键id查询消息
    @Select("select * from user_message where id = #{id}")
    UserMessage getUserMessageById(Long id);

    //根据用户id（发送方）查询消息  用户id（发送方）
    @Select("select * from user_message where user_from_id = #{userFromId}")
    UserMessage getUserMessageByUserFromId(Long userFromId);

    // 根据拥有消息的用户的id查询消息
    @Select("select * from user_message where user_id = #{userId} and is_read = #{isRead}")
    List<UserMessage> listUserMessages(Long userId);

    //查询指定条件的消息
    @Select("select * from user_message where  user_id = #{userId} and is_read = #{isRead}")
    List<UserMessageDto> countUserMessagesByUserIdAndRead(Long userId, int isRead);


    // 根据主键id查询消息传输对象
    @Select("select * from user_message where  user_id = #{userId} and is_read = #{isRead}")
    UserMessageDto getUserMessageDtoById(Long id);

    //根据输入id将消息标记已读
    @Update("update user_message set is_read = 1 where id = #{id}")
    long updateUserMessageReadById(Long id);

    // 添加一条消息
    @Insert("insert into user_message (user_id,user_from_id,message_title,message_content,message_time,is_read,message_remark)" +
            "VALUES(#{userId},#{userFromId},#{messageTitle},#{messageContent},#{messageTime},#{isRead},#{messageRemark})")
    long insertOneUserMessage(UserMessage userMessage);

    @Delete("delete user_message where id = #{id}")
    long deleteUserMessagesById(Long id);
}
