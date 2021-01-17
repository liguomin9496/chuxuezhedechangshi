package com.shida.labchecksys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/*
    隐患基础表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiddenDanger implements Serializable {

    private long id;        //表格序号

    private String userName;    //检查人

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkTime;     //检查时间

    private String labName;     //检查对象

    private String department;     //检查对象隶属的部门

    private String existingDanger;  //存在的隐患

    private String rectificationMeasures;  //整改措施

    private String rectificationPerson;      //整改负责人

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    //修改名字 2021-01-10 修改人：龚剑波
    private Date reFinishTime;   //整改完成时间

    private String testPerson;   //验收人

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date testTime;      //验收时间

    private int isFinish;      //代表是否解决，0代表解决了，1代表还没有解决

}
