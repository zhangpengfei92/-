package com.jcl.dao;

import com.jcl.pojo.FundSettlelog;
import com.jcl.pojo.FundSettlelogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundSettlelogMapper {
    long countByExample(FundSettlelogExample example);

    int deleteByExample(FundSettlelogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundSettlelog record);

    int insertSelective(FundSettlelog record);

    List<FundSettlelog> selectByExample(FundSettlelogExample example);

    FundSettlelog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundSettlelog record, @Param("example") FundSettlelogExample example);

    int updateByExample(@Param("record") FundSettlelog record, @Param("example") FundSettlelogExample example);

    int updateByPrimaryKeySelective(FundSettlelog record);

    int updateByPrimaryKey(FundSettlelog record);
    
    List<FundSettlelog> selectAll();
	
   	List<FundSettlelog> isExist(@Param(value = "title")String title);
   	
}