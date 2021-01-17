package com.shida.labchecksys.mapper;

import com.shida.labchecksys.pojo.Lab;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LabMapper {

    @Select("select * from lab")
    List<Lab> list();

    @Delete("delete from lab where lab_id=#{labId}")
    int delete(long labId);

    @Select("select * from lab where lab_id=#{labId}")
    List<Lab> getByLabId(long labId);

    @Select("Select lab_safer_id from lab where lab_name=#{labName}")
    long findLabSaferIdByLabName(String labName);

    @Select("select lab_name from lab where lab_safer_id=#{labSaferId}")
    String findLabNameByLabSaferId(long labSaferId);

    @Select("select lab_id from lab where lab_name=#{labName}")
    long findLabIdByLabName(String labName);


    //2021/1/6修改
    @Update("update lab set lab_safer_id=#{labSaferId},lab_user_id=#{labUserId} where lab_id=#{labId}")
    int updateByLabId(long labSaferId, String labUserId, long labId);

    @Select("select lab_safer_id from lab where lab_id=#{labId}")
    String findLabSaferIdByLabId(long labId);

    @Select("select lab_user_id from lab where lab_name=#{labName}")
    String findLabUserIdByLabName(String labName);


    /**
     *
     * 2021/1/8修改
     * 2021/1/8修改
     *
     *
     * */
    @Insert("insert into lab (lab_id,lab_name,lab_department,lab_safer_id,lab_area,lab_user_id) values(#{labId},#{labName},#{labDepartment},#{labSaferId},#{labArea},#{labUserId})")
    int add(Lab lab);

    @Update("update lab set lab_name=#{labName},lab_department=#{labDepartment},lab_safer_id=#{labSaferId},lab_area=#{labArea},lab_user_id=#{labUserId} where lab_id=#{labId}")
    int update(Lab lab);
}
