package com.jcl.dao;

import com.jcl.pojo.RiskStock;
import com.jcl.pojo.RiskStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskStockMapper {
    long countByExample(RiskStockExample example);

    int deleteByExample(RiskStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskStock record);

    int insertSelective(RiskStock record);

    List<RiskStock> selectByExample(RiskStockExample example);

    RiskStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskStock record, @Param("example") RiskStockExample example);

    int updateByExample(@Param("record") RiskStock record, @Param("example") RiskStockExample example);

    int updateByPrimaryKeySelective(RiskStock record);

    int updateByPrimaryKey(RiskStock record);
    
    List<RiskStock> selectAll();
	
	List<RiskStock> isExist(@Param(value = "parentid")Integer parentid, @Param(value = "type")Integer type, @Param(value = "subzhName")String subzh);
	
}