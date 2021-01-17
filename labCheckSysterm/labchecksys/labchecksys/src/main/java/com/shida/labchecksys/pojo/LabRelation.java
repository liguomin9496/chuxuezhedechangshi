package com.shida.labchecksys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabRelation {

    long id;
    long lab;
    long labUnit;
    long unitManagerId;
    long unitLeaderId;
    long systemManagerId;
}
