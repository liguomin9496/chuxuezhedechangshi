package com.shida.labchecksys.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserMessageSearchCondition implements Serializable {

    //消息拥有者id
    private Long userId;

    //是否已读
    private int isRead;

    public UserMessageSearchCondition() {
    }

    public UserMessageSearchCondition(Long userId, int isRead) {
        this.userId = userId;
        this.isRead = isRead;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
}
