package com.shida.labchecksys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MonthReport {

    private long id;        //表格序号

    private String department;      //所属学院

    private String labName;     //检查对象

    private Date checkTime;     //检查时间

    private String existingDanger;  //存在的隐患

    private String rectificationMeasures;  //整改措施

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date refinishTime;   //整改完成时间

    private int isFinish;       //是否完成

    private int isExamine;      //是否复核

    private int isReview;       //是否整改

    private String suggestion;     //处理意见

    private int isSubmit;       //是否提交 1就是没提交   0就是提交了
}
