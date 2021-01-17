package com.shida.labchecksys.mapper;

import com.shida.labchecksys.pojo.MonthReport;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MonthReportMapper {

    @Select("select * from lab_month_report where is_submit=0")
    List<MonthReport> showAll();

    @Select("select * from lab_month_report")
    List<MonthReport> selectAll();

    @Delete("delete from lab_month_report where id = #{id}")
    void delete(int id);

    @Select("select * from lab_month_report order by check_time")
    List<MonthReport> showAllOrderByTime();

    @Insert("insert into lab_month_report values(null,#{department},#{labName},#{checkTime},#{existingDanger},#{rectificationMeasures},#{refinishTime},#{isFinish},#{isExamine},#{isReview},#{suggestion},#{isSubmit})")
    void add(MonthReport monthReport);

    @Select("select * from lab_month_report where DATE_FORMAT( check_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) where is_submit=0")
    List<MonthReport> showAllByCurrentMonth();

    @Select("select * from lab_month_report where DATE_FORMAT( check_time, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and department=#{department} and is_submit=1")
    List<MonthReport> showAllByDepartment(String department);

    @Update("update lab_month_report set suggestion=#{suggestion} where id=#{id}")
    void suggestion(String suggestion,int id);

    @Update("update lab_month_report set is_examine=0 where id=#{id}")
    void isExamine(int id);

    @Update("update lab_month_report set is_review=0 where id=#{id}")
    void isReview(int id);

    @Update("update lab_month_report set is_submit=0 where id=#{id}")
    void isSubmit(int id);

}
