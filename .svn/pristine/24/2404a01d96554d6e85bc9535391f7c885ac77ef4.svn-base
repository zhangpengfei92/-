package com.jcl.dao;

import com.jcl.pojo.FundSumlog;
import com.jcl.pojo.FundSumlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundSumlogMapper {
    long countByExample(FundSumlogExample example);

    int deleteByExample(FundSumlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundSumlog record);

    int insertSelective(FundSumlog record);

    List<FundSumlog> selectByExample(FundSumlogExample example);

    FundSumlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundSumlog record, @Param("example") FundSumlogExample example);

    int updateByExample(@Param("record") FundSumlog record, @Param("example") FundSumlogExample example);

    int updateByPrimaryKeySelective(FundSumlog record);

    int updateByPrimaryKey(FundSumlog record);
    
    List<FundSumlog> selectAll();
	
   	List<FundSumlog> isExist(@Param(value = "title")String title);
   	
}