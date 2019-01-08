package com.jcl.dao;

import com.jcl.pojo.RiskHolder;
import com.jcl.pojo.RiskHolderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskHolderMapper {
    long countByExample(RiskHolderExample example);

    int deleteByExample(RiskHolderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskHolder record);

    int insertSelective(RiskHolder record);

    List<RiskHolder> selectByExample(RiskHolderExample example);

    RiskHolder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskHolder record, @Param("example") RiskHolderExample example);

    int updateByExample(@Param("record") RiskHolder record, @Param("example") RiskHolderExample example);

    int updateByPrimaryKeySelective(RiskHolder record);

    int updateByPrimaryKey(RiskHolder record);
    
    List<RiskHolder> selectAll();
	
	List<RiskHolder> isExist(@Param(value = "subzhName")String subzh);
    
}