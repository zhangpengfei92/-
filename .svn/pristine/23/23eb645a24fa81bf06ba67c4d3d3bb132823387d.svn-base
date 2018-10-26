package com.jcl.dao;

import com.jcl.pojo.RightsColumn;
import com.jcl.pojo.RightsColumnExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RightsColumnMapper {
    long countByExample(RightsColumnExample example);

    int deleteByExample(RightsColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RightsColumn record);

    int insertSelective(RightsColumn record);

    List<RightsColumn> selectByExample(RightsColumnExample example);

    RightsColumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RightsColumn record, @Param("example") RightsColumnExample example);

    int updateByExample(@Param("record") RightsColumn record, @Param("example") RightsColumnExample example);

    int updateByPrimaryKeySelective(RightsColumn record);

    int updateByPrimaryKey(RightsColumn record);
    
    List<RightsColumn> isExist(@Param(value = "columnName") String columnName);
    
}