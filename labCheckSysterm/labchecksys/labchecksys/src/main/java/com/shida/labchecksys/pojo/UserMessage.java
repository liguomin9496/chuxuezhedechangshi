package com.shida.labchecksys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMessage {

    protected Long id;

    // 收消息用户的id
    private Long userId;

    // 发消息用户的id
    private Long userFromId;

    private String messageTitle;

    private String messageContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date messageTime;

    protected int isRead;//0是未读1是已读

    // 消息备注,为空不进行消息跳转，若不为空就进行消息跳转，特殊字符排序+消息类型的主键ID
    private String messageRemark;
}
