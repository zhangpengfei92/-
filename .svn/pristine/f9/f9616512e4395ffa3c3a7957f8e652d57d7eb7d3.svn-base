package com.jcl.dao;

import com.jcl.pojo.ExceptOrder;
import com.jcl.pojo.ExceptOrderExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExceptOrderMapper {
	
	List<ExceptOrder> selectAll();
	
	List<ExceptOrder> isExist(@Param(value = "subzhName")String subzh);
	
    long countByExample(ExceptOrderExample example);

    int deleteByExample(ExceptOrderExample example);

    int insert(ExceptOrder record);

    int insertSelective(ExceptOrder record);

    List<ExceptOrder> selectByExample(ExceptOrderExample example);

    int updateByExampleSelective(@Param("record") ExceptOrder record, @Param("example") ExceptOrderExample example);

    int updateByExample(@Param("record") ExceptOrder record, @Param("example") ExceptOrderExample example);
}