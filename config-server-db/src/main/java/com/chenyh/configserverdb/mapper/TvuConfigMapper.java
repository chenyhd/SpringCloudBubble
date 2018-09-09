package com.chenyh.configserverdb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TvuConfigMapper {
    @Select("SELECT `KEY`, `VALUE` from PROPERTIES_${name} where PROFILE=#{profile} and LABEL=#{label}")
    List<Map<String,String>> findOne(@Param("name")String name, @Param("profile") String profile, @Param("label") String label);
}
