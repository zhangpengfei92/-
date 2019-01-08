package com.jcl.dao;

import com.jcl.pojo.RiskTempall;
import com.jcl.pojo.RiskTempallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskTempallMapper {
    long countByExample(RiskTempallExample example);

    int deleteByExample(RiskTempallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskTempall record);

    int insertSelective(RiskTempall record);

    List<RiskTempall> selectByExample(RiskTempallExample example);

    RiskTempall selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskTempall record, @Param("example") RiskTempallExample example);

    int updateByExample(@Param("record") RiskTempall record, @Param("example") RiskTempallExample example);

    int updateByPrimaryKeySelective(RiskTempall record);

    int updateByPrimaryKey(RiskTempall record);
    
    List<RiskTempall> selectAll();
	
	List<RiskTempall> isExist(@Param(value = "subzhName")String subzh, @Param(value = "id")Integer id);
    
}