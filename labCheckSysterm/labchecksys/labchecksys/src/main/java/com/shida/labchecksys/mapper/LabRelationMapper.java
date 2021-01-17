package com.shida.labchecksys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LabRelationMapper {

    @Select("select department_leader_id from lab_relationlist where lab_id=#{labId}")
    long findLeaderId(long labId);

    @Select("select system_manager_id from lab_relationlist where lab_id=#{labId}")
    long findSysId(long labId);

}
