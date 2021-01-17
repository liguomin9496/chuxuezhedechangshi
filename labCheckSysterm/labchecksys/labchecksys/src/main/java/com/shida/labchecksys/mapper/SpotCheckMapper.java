package com.shida.labchecksys.mapper;

import com.shida.labchecksys.pojo.SpotCheck;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

//学校巡查和抽查
@Mapper
public interface SpotCheckMapper {

    @Insert("insert into spot_check(checker,department,check_time,check_object,danger,suggestions,reform_principal,reform_measure,reform_time,is_danger,type) VALUES(#{checker},#{department},#{checkTime},#{checkObject},#{danger},#{suggestions},#{reformPrincipal},#{reformMeasure},#{reformTime},#{isDanger},#{type})")
    int addSpotCheck(long checker, String department, Date checkTime, String checkObject, String danger, String suggestions,String reformPrincipal,String reformMeasure,Date reformTime, int isDanger,int type);

    @Select("select * from spot_check where id=#{checkId}")
    SpotCheck findById(long checkId);

    //2021-01-10 修改人:龚剑波
    @Select("select * from spot_check")
    List<SpotCheck> selectAll();
}
