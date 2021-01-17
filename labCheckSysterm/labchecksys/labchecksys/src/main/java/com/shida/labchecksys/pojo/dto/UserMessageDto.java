package com.shida.labchecksys.pojo.dto;


import com.shida.labchecksys.pojo.UserMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//用户消息的传输对象

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class UserMessageDto extends UserMessage {

    /**
     * 发送方的角色
     */
    private String userFromRole;

    /**
     * 发送方的姓名
     */
    private String userFromRealName;
}
