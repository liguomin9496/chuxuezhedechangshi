package com.shida.labchecksys.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shida.labchecksys.pojo.DayCheck;
import org.apache.ibatis.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface DayCheckMapper {


    @Select("select * from day_check where checker = #{checkerId}")
    List<DayCheck> showSelf(long checkerId);

    @Select("select * from day_check where check_object = #{checkObject} and check_time = #{checkTime}")
    List<DayCheck> selectByCheckTime(String checkObject, Date checkTime);

    @Select("select * from day_check where id = #{id}")
    List<DayCheck> selectById(long id);

    @Insert("insert into day_check(checker,department,check_time,check_object,is_danger,danger,suggestions,stage) VALUES(#{checker},#{department},#{checkTime},#{checkObject},#{isDanger},#{danger},#{suggestions},#{stage})")
    int addDayCheck(long checker, String department, Date checkTime, String checkObject, String danger, String suggestions, int isDanger, int stage);

}
