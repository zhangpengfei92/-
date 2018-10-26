package com.jcl.dao;

import com.jcl.pojo.FundSettlelog;
import com.jcl.pojo.FundSettlelogExample;
import com.jcl.pojo.TradeParam;

import java.util.Date;
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

	Double selectSumMoney(@Param(value = "role")String role,@Param(value = "username")String username,@Param(value = "columnName")String columnName,@Param(value = "starttime")Date starttime,@Param(value = "endtime")Date endtime);

	FundSettlelog sumFundSettlelogFund(TradeParam trade);
   	
}