package com.xianyuli.miaosha.dao;

import com.xianyuli.miaosha.domain.RushUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from rushuser where id = #{id}")
    public RushUser getUserById(@Param("id") long id);


}
