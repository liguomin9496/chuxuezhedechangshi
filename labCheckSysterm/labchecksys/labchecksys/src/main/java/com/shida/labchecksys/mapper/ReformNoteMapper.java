package com.shida.labchecksys.mapper;

import com.shida.labchecksys.pojo.ReformNote;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReformNoteMapper {

    @Select("select * from lab_reform_note")
    List<ReformNote> showAll();

    @Insert("insert into lab_reform_note (check_id,check_obj,danger,reform_suggestions,reform_time) values(#{checkId},#{checkObj},#{danger},#{reformSuggestions},#{reformTime})")
    int add(ReformNote reformNote);

    @Select("select * from lab_reform_note where check_id=#{checkId}")
    ReformNote findLabReformNoteByCheckId(long checkId);

    @Delete("delete from lab_reform_note where check_id=#{checkId}")
    String deleteLabReformNoteByCheckId(long checkId);
}
