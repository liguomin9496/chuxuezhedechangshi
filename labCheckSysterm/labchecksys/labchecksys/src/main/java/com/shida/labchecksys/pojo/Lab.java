package com.shida.labchecksys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lab {
    private Long labId;
    private String labName;
    private String labDepartment;
    private Long labSaferId;
    private String labUserId;
    private Integer labArea;
}
