package com.shida.labchecksys.mapper;

import com.shida.labchecksys.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from lab_user where user_name=#{userName}")
    User getByUsername(String userName);

    @Select("select * from lab_user where user_name=#{userName} and password=#{passWord}")
    User login(String userName, String passWord);



    //   2021/1/5修改
    @Insert({"insert into lab_user (user_name,password,department) values(#{userName},#{passWord},#{department})"})
    int register(String userName, String passWord, String department);

    //    2021/1/5添加

    //注册用户之后注册角色信息
    @Insert("insert into user_role (user_id,role_id) values(#{userId},#{roleId})")
    int registerRole(long userId, long roleId);

    //修改roleId 从而修改用户权限
    @Update("update user_role set role_id=#{roleId} where user_id=#{userId}")
    int updateRoleId(long roleId, long userId);

}