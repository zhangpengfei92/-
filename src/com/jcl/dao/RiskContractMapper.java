package com.jcl.dao;

import com.jcl.pojo.RiskContract;
import com.jcl.pojo.RiskContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskContractMapper {
    int countByExample(RiskContractExample example);

    int deleteByExample(RiskContractExample example);

    int deleteByPrimaryKey(String contractCode);

    int insert(RiskContract record);

    int insertSelective(RiskContract record);

    List<RiskContract> selectByExample(RiskContractExample example);

    RiskContract selectByPrimaryKey(String contractCode);

    int updateByExampleSelective(@Param("record") RiskContract record, @Param("example") RiskContractExample example);

    int updateByExample(@Param("record") RiskContract record, @Param("example") RiskContractExample example);

    int updateByPrimaryKeySelective(RiskContract record);

    int updateByPrimaryKey(RiskContract record);

	List<RiskContract> selectByTime(String keywords);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-2
	 * @decribe 当第一次查询合约时，从行情中查到合约，需要保存到数据库中
	 * @param clist
	 * @return
	 */
	int insertBatchContract(List<RiskContract> clist);
}